package dev.lightfoot.kerberospostgresclient.data;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.postgresql.api.PostgresqlConnection;
import io.r2dbc.postgresql.client.SSLMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    PostgresqlConnectionConfiguration connectionConfiguration() {
        return PostgresqlConnectionConfiguration.builder()
                .applicationName("sam-client")
                .database("defaultdb")
                //.sslCert("/certs/client.root.crt")
                //.sslKey(new ClassPathResource("client.root.key").getURL())
                //.sslKey("/certs/client.root.key.pk8")
                .sslRootCert("/certs/ca.crt")
                .sslMode(SSLMode.VERIFY_FULL)
                .host("lb")
                .username("roach")
                //.password(null)
                .port(26257)
                .build();
    }

    @Bean
    PostgresqlConnectionFactory postgresqlConnectionFactory(PostgresqlConnectionConfiguration configuration) {
        return new PostgresqlConnectionFactory(configuration);
    }

    @Bean
    PostgresqlConnection postgresqlConnection(PostgresqlConnectionFactory factory) {
        return factory.create().block();
    }

}
