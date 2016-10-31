package com.rti.bugtracker;

import oracle.jdbc.pool.OracleDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by gschuell on 10/14/16.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.rti.bugtracker")
@EntityScan(basePackages = {"com.rti.bugtracker"})
@EnableJpaRepositories(basePackages = {"com.rti.bugtracker"})
@EnableSpringDataWebSupport
@EnableTransactionManagement
public class ApplicationConfiguration {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${amrdcissues.username}")
    private String amrdcIssuesUsername;

    @Value("${amrdcissues.password}")
    private String amrdcissuesPassword;

    @Value("${amrdcissues.url}")
    private String amrdcIssuesUrl;

    @Value("${tower.username}")
    private String towerUsername;

    @Value("${tower.password}")
    private String towerPassword;

    @Value("${tower.url}")
    private String towerUrl;



    @Bean
    public EntityManagerFactory entityManagerFactory() throws SQLException {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
       // vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setGenerateDdl(false);

        log.info("Now we have DataSource ==> " + amrIssuesDataSource());
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.rti.bugtracker");
        factory.setDataSource(amrIssuesDataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    /*
    @Bean
    @ConfigurationProperties("amrdcissues")
            public DataSource amrIssuesDataSource() {
                return DataSourceBuilder.create().build();
            }
*/
    @Bean
    @Primary
    @ConfigurationProperties("amrdcissues")
    DataSource amrIssuesDataSource() throws SQLException {

        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser(amrdcIssuesUsername);
        dataSource.setPassword(amrdcissuesPassword);
        dataSource.setURL(amrdcIssuesUrl);
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        log.info("Created dataSource [{}]", dataSource);
        log.info("URL used is [{}], username is [{}] and password is [{}]", amrdcIssuesUrl,
                amrdcIssuesUsername, amrdcissuesPassword);
        return dataSource;
    }

    @Bean
    @ConfigurationProperties("tower")
    DataSource towerDataSource() throws SQLException {

        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser(towerUsername);
        dataSource.setPassword(towerPassword);
        dataSource.setURL(towerUrl);
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        log.info("Created dataSource [{}]", dataSource);
        log.info("URL used is [{}], username is [{}] and password is [{}]", towerUrl,
                towerUsername, towerPassword);
        return dataSource;
    }



}
