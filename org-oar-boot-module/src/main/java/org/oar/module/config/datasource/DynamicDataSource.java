package fastfish.mini.sns.bootmodules.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource
{
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("DynamicDataSource:" + DataSourceContextHolder.getDataSource());
        return DataSourceContextHolder.getDataSource();
    }
}
