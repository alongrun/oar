package fastfish.mini.sns.bootmodules.config.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource(value={"classpath:/db.properties"})
public class DataSourceConfig {

    @Bean(name = "entplatform")
    @ConfigurationProperties(prefix = "datasource.entplatform" )
    public DataSource entplatform() {
        return DataSourceBuilder.create().build();
    }

//    @Bean(name = "entplatformdev")
//    @ConfigurationProperties(prefix = "spring.datasource.entplatformdev" )
//    public DataSource entplatformdev() {
//        return DataSourceBuilder.create().build();
//    }

//    @Bean(name = "cloud")
//    @ConfigurationProperties(prefix = "spring.datasource.cloud" )
//    public DataSource cloud() {
//        return DataSourceBuilder.create().build();
//    }

    @Bean(name = "wechat")
    @ConfigurationProperties(prefix = "datasource.wechat" )
    public DataSource wechat() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(entplatform());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap();
        dsMap.put("entplatform", entplatform());
//        dsMap.put("entplatformdev", entplatformdev());
//        dsMap.put("cloud", cloud());
        dsMap.put("wechat", wechat());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

    /**
     * 配置@Transactional注解事物
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}