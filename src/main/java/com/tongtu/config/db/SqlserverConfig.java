package com.tongtu.config.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySources({
        @PropertySource("classpath:static/persistence-multiple-db.properties"),
        @PropertySource("classpath:static/hibernate.properties")
})
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "sqlserverEntityManagerFactory",
        basePackages = {"com.tongtu.repository.sqlserver"}
)
public class SqlserverConfig {
    @Autowired
    private Environment env;
    @Bean(name = "sqlserverDataSource")
    @ConfigurationProperties(prefix = "sqlserver.datasource")
    public DataSource dataSource() {
        return  DataSourceBuilder.create().build();
    }


    @Bean(name = "sqlserverEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    sqlserverEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("sqlserverDataSource") DataSource dataSource
    ) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean=builder
                .dataSource(dataSource)
                .packages("com.tongtu.bean.sqlserver")
                .persistenceUnit("sqlserver")
                .build();
        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.dialect",
                env.getProperty("sqlserver.hibernate.dialect"));
        properties.put("showSql",
                env.getProperty("spring.jpa.show-sql"));
        localContainerEntityManagerFactoryBean.setJpaPropertyMap(properties);
        return localContainerEntityManagerFactoryBean;
    }


    @Bean(name = "sqlservertransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("sqlserverEntityManagerFactory") EntityManagerFactory
                    entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
