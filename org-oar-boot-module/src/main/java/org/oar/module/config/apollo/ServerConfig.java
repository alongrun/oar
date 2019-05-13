package fastfish.mini.sns.bootmodules.config.apollo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data

public class ServerConfig
{
    @Value("${consule:http://10.3.13.58:8011 }")
    private String Consul;





}

