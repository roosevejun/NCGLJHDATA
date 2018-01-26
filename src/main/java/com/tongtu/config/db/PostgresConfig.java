package com.tongtu.config.db;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
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
        entityManagerFactoryRef = "postgresEntityManagerFactory",
        transactionManagerRef = "postgresTransactionManager",
        basePackages = {"com.tongtu.repository.postgres"}
)
public class PostgresConfig {
    @Autowired
    private Environment env;

    @Primary
    @Bean(name = "postgresDataSource")
    @ConfigurationProperties(prefix = "postgresql.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "postgresEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    postgresEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("postgresDataSource") DataSource dataSource
    ) {
          LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = builder
                .dataSource(dataSource)
                .packages("com.tongtu.bean.postgres")
                .persistenceUnit("postgres")
                .build();
        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.dialect",
                env.getProperty("postgis.jpa.properties.hibernate.dialect"));
        properties.put("showSql",
                env.getProperty("spring.jpa.show-sql"));
        localContainerEntityManagerFactoryBean.setJpaPropertyMap(properties);
        return localContainerEntityManagerFactoryBean;
    }

    @Primary
    @Bean(name = "postgresTransactionManager")
    public PlatformTransactionManager postgresTransactionManager(
            @Qualifier("postgresEntityManagerFactory") EntityManagerFactory
                    barEntityManagerFactory
    ) {
        return new JpaTransactionManager(barEntityManagerFactory);
    }
}
