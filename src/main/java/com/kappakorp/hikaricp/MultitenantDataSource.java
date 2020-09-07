package com.kappakorp.hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;

public class MultitenantDataSource extends AbstractRoutingDataSource {

    protected DataSource determineTargetDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/elevate");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("simurg");

        DataSource dataSource = new HikariDataSource(hikariConfig);

        if (dataSource == null) {
            throw new IllegalStateException("Cannot determine target DataSource for lookup key [" + hikariConfig.getDataSource().toString() + "]");
        }
        return dataSource;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return "aa";
        /*ServletRequestAttributes attr =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String pathInfo = attr.getRequest().getRequestURI();
        System.out.println("Conf: "+pathInfo.substring(4, 6));
        return pathInfo.substring(4, 6);*/
    }
}
