package fr.schub.schubback.api.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "botClient", url = "${bot.base-url}", configuration = BotFeignConfig.class)
public interface BotFeignClient {

    @GetMapping("/gaming-server")
    byte[] getGamingServers(@RequestHeader(value = "Authorization", required = false) String authorization);

    @GetMapping("/gaming-server/public-status")
    byte[] getPublicGamingServersStatus();

    @GetMapping("/gaming-server/{id}")
    byte[] getGamingServerById(@RequestHeader(value = "Authorization", required = false) String authorization,
                               @PathVariable("id") String id);

    @PostMapping("/gaming-server")
    byte[] createGamingServer(@RequestHeader(value = "Authorization", required = false) String authorization,
                              @RequestBody Object body);

    @PutMapping("/gaming-server/{id}")
    byte[] updateGamingServer(@RequestHeader(value = "Authorization", required = false) String authorization,
                              @PathVariable("id") String id,
                              @RequestBody Object body);

    @PostMapping("/gaming-server/subscribe-channels")
    byte[] subscribeChannels(@RequestHeader(value = "Authorization", required = false) String authorization,
                             @RequestBody Object body);

    @PostMapping("/gaming-server/command/{commandName}")
    byte[] executeGamingServerCommand(@RequestHeader(value = "Authorization", required = false) String authorization,
                                      @PathVariable("commandName") String commandName,
                                      @RequestBody Object body);

    @GetMapping("/discord/guilds/channels")
    byte[] getGuildsChannels(@RequestHeader(value = "Authorization", required = false) String authorization);
}
