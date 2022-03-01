package ru.tfoms.tfomsapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        basePackages = "ru.tfoms.tfomsapp.repo.pg",
        entityManagerFactoryRef = "PGEntityManager",
        transactionManagerRef = "PGTransactionManager")
public class PGDBConfig {

    @Autowired
    private Environment env;

    @Primary
    @Bean
    public DataSource PGDataSource() throws SQLException {
        return ConnectDB();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean PGEntityManager() throws SQLException {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(PGDataSource());
        em.setPackagesToScan(
                "ru.tfoms.tfomsapp.domain.pg", "ru.tfoms.tfomsapp.repo.pg");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        Properties properties = new Properties();
        properties.setProperty("spring.jpa.database-platform", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("spring.jpa.hibernate.ddl-auto", "update");

        em.setJpaProperties(properties);

        return em;
    }

    @Primary
    @Bean
    public PlatformTransactionManager PGTransactionManager() throws SQLException {
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                PGEntityManager().getObject());
        return transactionManager;
    }

    private DataSource ConnectDB() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");

        //        dataSource.setUrl("jdbc:postgresql://localhost/ukizi");
        //        dataSource.setUsername("hardy");
        //        dataSource.setPassword("Zaq1@wsx");

        dataSource.setUrl("jdbc:postgresql://192.168.2.157/pg_tfomsapp");
        dataSource.setUsername("mcherchesov");
        dataSource.setPassword("123");
        return dataSource;
    }
}