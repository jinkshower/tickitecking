package com.laydowncoding.tickitecking.global.config;

import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

@Configuration
public class DataSourceConfig {

    private static final String SOURCE_SERVER = "SOURCE";
    private static final String REPLICA_SERVER = "REPLICA";

    @Bean
    @Qualifier(SOURCE_SERVER)
    @ConfigurationProperties(prefix = "spring.datasource.source")
    public DataSource sourceDataSource() {
        return DataSourceBuilder.create()
            .build();
    }

    @Bean
    @Qualifier(REPLICA_SERVER)
    @ConfigurationProperties(prefix = "spring.datasource.replica")
    public DataSource replicaDataSource() {
        return DataSourceBuilder.create()
            .build();
    }

    @Bean
    public DataSource routingDataSource(
        @Qualifier(SOURCE_SERVER) DataSource sourceDataSource, // (1)
        @Qualifier(REPLICA_SERVER) DataSource replicaDataSource
    ) {
        RoutingDataSource routingDataSource = new RoutingDataSource(); // (2)

        HashMap<Object, Object> dataSourceMap = new HashMap<>(); // (3)
        dataSourceMap.put("source", sourceDataSource);
        dataSourceMap.put("replica", replicaDataSource);

        routingDataSource.setTargetDataSources(dataSourceMap); // (4)
        routingDataSource.setDefaultTargetDataSource(sourceDataSource); // (5)

        return routingDataSource;
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        DataSource determinedDataSource = routingDataSource(sourceDataSource(), replicaDataSource());
        return new LazyConnectionDataSourceProxy(determinedDataSource);
    }
}
