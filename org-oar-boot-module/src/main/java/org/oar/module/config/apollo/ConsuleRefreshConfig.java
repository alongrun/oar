package org.oar.module.config.apollo;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import fastfish.mini.sns.bootmodules.config.ConsulConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsuleRefreshConfig {

    @Autowired
    private ConsulConfig consulConfig;

    @ApolloConfigChangeListener
    public void onChang(ConfigChangeEvent evt)
    {

       // consulConfig.refresh("spring.cloud.consul");
    }
}
