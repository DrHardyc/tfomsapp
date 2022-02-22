package ru.tfoms.tfomsapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

//@Configuration
//@EnableJpaRepositories(
//        basePackages = "ru.tfoms.tfomsapp.repo.KMS",
//        entityManagerFactoryRef = "KMSEntityManager",
//        transactionManagerRef = "KMSTransactionManager")
public class KMSDBConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource KMSDataSource() {
        return ConnectDB();
    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean KMSEntityManager()  {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(KMSDataSource());
//        em.setPackagesToScan(
//                new String[] { "ru.tfoms.tfomsapp.domain.KMS" });
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto",
//                env.getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.dialect",
//                env.getProperty("hibernate.dialect"));
//        em.setJpaPropertyMap(properties);
//
//        return em;
//    }

//    @Bean
//    public PlatformTransactionManager KMSTransactionManager() {
//        JpaTransactionManager transactionManager
//                = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(
//                KMSEntityManager().getObject());
//        return transactionManager;
//    }

    private DataSource ConnectDB() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        dataSource.setUrl("jdbc:sqlserver://srz\\srz;databaseName=FMS_new");
//        dataSource.setUsername("expert");
//        dataSource.setPassword("123");
        dataSource.setUrl("jdbc:sqlserver://localhost;databaseName=ukizi");
        dataSource.setUsername("hardy");
        dataSource.setPassword("Zaq1@wsx");


        return dataSource;
    }
}
