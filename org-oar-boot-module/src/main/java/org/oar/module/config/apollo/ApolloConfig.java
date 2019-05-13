package org.oar.module.config.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author hjc
 */
@Configuration
public class ApolloConfig {
    @Bean
    public ServerConfig javaConfigBean() {
        return new ServerConfig();
    }
}