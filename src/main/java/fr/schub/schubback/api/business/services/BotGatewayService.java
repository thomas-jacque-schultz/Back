package fr.schub.schubback.api.business.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import fr.schub.schubback.api.config.BotFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

@Service
public class BotGatewayService {

    private static final Logger log = LoggerFactory.getLogger(BotGatewayService.class);

    private final BotFeignClient botFeignClient;
    private final ObjectMapper objectMapper;

    public BotGatewayService(BotFeignClient botFeignClient, ObjectMapper objectMapper) {
        this.botFeignClient = botFeignClient;
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<byte[]> getGamingServers(@Nullable String authorization) {
        try {
            return ResponseEntity.ok(botFeignClient.getGamingServers(authorization));
        } catch (FeignException ex) {
            return toFeignError(ex);
        } catch (Exception ex) {
            return botUnreachable(ex);
        }
    }

    public ResponseEntity<byte[]> getPublicGamingServersStatus() {
        try {
            return ResponseEntity.ok(botFeignClient.getPublicGamingServersStatus());
        } catch (FeignException ex) {
            return toFeignError(ex);
        } catch (Exception ex) {
            return botUnreachable(ex);
        }
    }

    public ResponseEntity<byte[]> getGamingServerById(@Nullable String authorization, String id) {
        try {
            return ResponseEntity.ok(botFeignClient.getGamingServerById(authorization, id));
        } catch (FeignException ex) {
            return toFeignError(ex);
        } catch (Exception ex) {
            return botUnreachable(ex);
        }
    }

    public ResponseEntity<byte[]> createGamingServer(@Nullable String authorization, @Nullable byte[] body) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(botFeignClient.createGamingServer(authorization, parseBody(body)));
        } catch (FeignException ex) {
            return toFeignError(ex);
        } catch (Exception ex) {
            return botUnreachable(ex);
        }
    }

    public ResponseEntity<byte[]> updateGamingServer(@Nullable String authorization, String id, @Nullable byte[] body) {
        try {
            return ResponseEntity.ok(botFeignClient.updateGamingServer(authorization, id, parseBody(body)));
        } catch (FeignException ex) {
            return toFeignError(ex);
        } catch (Exception ex) {
            return botUnreachable(ex);
        }
    }

    public ResponseEntity<byte[]> subscribeChannels(@Nullable String authorization, @Nullable byte[] body) {
        try {
            return ResponseEntity.ok(botFeignClient.subscribeChannels(authorization, parseBody(body)));
        } catch (FeignException ex) {
            return toFeignError(ex);
        } catch (Exception ex) {
            return botUnreachable(ex);
        }
    }

    public ResponseEntity<byte[]> executeGamingServerCommand(@Nullable String authorization,
                                                              String commandName,
                                                              @Nullable byte[] body) {
        try {
            return ResponseEntity.ok(botFeignClient.executeGamingServerCommand(authorization, commandName, parseBody(body)));
        } catch (FeignException ex) {
            return toFeignError(ex);
        } catch (Exception ex) {
            return botUnreachable(ex);
        }
    }

    public ResponseEntity<byte[]> getGuildsChannels(@Nullable String authorization) {
        try {
            return ResponseEntity.ok(botFeignClient.getGuildsChannels(authorization));
        } catch (FeignException ex) {
            return toFeignError(ex);
        } catch (Exception ex) {
            return botUnreachable(ex);
        }
    }

    private Object parseBody(@Nullable byte[] body) {
        if (body == null || body.length == 0) {
            return Collections.emptyMap();
        }

        try {
            return objectMapper.readValue(body, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception ignored) {
            try {
                return objectMapper.readValue(body, Object.class);
            } catch (Exception ex) {
                return new String(body, StandardCharsets.UTF_8);
            }
        }
    }

    @SuppressWarnings("null")
    private ResponseEntity<byte[]> toFeignError(FeignException ex) {
        HttpStatus status = HttpStatus.resolve(ex.status());
        HttpStatus safeStatus = status != null ? status : HttpStatus.BAD_GATEWAY;
        byte[] responseBody = ex.responseBody().map(buffer -> {
            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
            return bytes;
        }).orElseGet(() -> "{\"error\":\"Bot request failed\"}".getBytes(StandardCharsets.UTF_8));

        return ResponseEntity.status(safeStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseBody);
    }

    @SuppressWarnings("null")
    private ResponseEntity<byte[]> botUnreachable(Exception ex) {
        log.error("[BotGatewayService] Bot unreachable: {}", ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"error\":\"Bot unreachable\"}".getBytes(StandardCharsets.UTF_8));
    }
}
