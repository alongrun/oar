package org.oar.module.config;

import fastfish.mini.sns.bootmodules.config.apollo.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.consul.ConsulProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author hjc
 */
@Configuration

public class ConsulConfig {
    @Autowired
    private ServerConfig serverConfig;
    @Bean
    @RefreshScope


   // @ConfigurationProperties("spring.cloud.consul")
    public ConsulProperties consulProperties() throws MalformedURLException {

        System.out.println("consule:"+serverConfig.getConsul());
        String consulServer="http://10.3.13.58:8011";

        //serverConfig.getConsul();
        ConsulProperties properties = new ConsulProperties();



            URL url = new URL(consulServer);
            properties.setHost(url.getHost());
            properties.setPort(url.getPort());


        properties.setEnabled(true);
        return properties;
    }
   /* @Bean
    //@RefreshScope
    @ConfigurationProperties("spring.cloud.consul.discovery")
    public ConsulDiscoveryProperties consulDiscoveryProperties()

    {
        InetUtils utils=new InetUtils(new InetUtilsProperties());
        ConsulDiscoveryProperties properties = new ConsulDiscoveryProperties(utils);
        properties.setServiceName("godmainn");
        properties.setHealthCheckInterval("5s");
        properties.setEnabled(true);
        return properties;
    }*/
}
















