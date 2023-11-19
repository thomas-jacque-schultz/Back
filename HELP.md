# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/#build-image)
* [Spring Integration AMQP Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/amqp.html)
* [Spring Integration JDBC Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/jdbc.html)
* [Spring Integration JPA Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/jpa.html)
* [Spring Integration Test Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/testing.html)
* [Spring Integration Mail Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/mail.html)
* [Spring Integration Security Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/security.html)
* [Spring Integration HTTP Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/http.html)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#howto.data-access.exposing-spring-data-repositories-as-rest)
* [Spring Batch](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#howto.batch)
* [OAuth2 Authorization Server](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#web.security.oauth2.authorization-server)
* [OAuth2 Resource Server](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#web.security.oauth2.server)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#web.security)
* [Spring Session](https://docs.spring.io/spring-session/reference/)
* [OAuth2 Client](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#web.security.oauth2.client)
* [Docker Compose Support](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#features.docker-compose)
* [Spring Integration](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#messaging.spring-integration)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#web)
* [Java Mail Sender](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#io.email)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#appendix.configuration-metadata.annotation-processor)
* [Spring for RabbitMQ](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#messaging.amqp)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#data.sql.jdbc)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Creating a Batch Service](https://spring.io/guides/gs/batch-processing/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Integrating Data](https://spring.io/guides/gs/integration/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)

### Docker Compose support

This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* postgres: [`postgres:latest`](https://hub.docker.com/_/postgres)
* rabbitmq: [`rabbitmq:latest`](https://hub.docker.com/_/rabbitmq)

Please review the tags of the used images and set them to the same as you're running in production.

