package ru.tfoms.tfomsapp.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

//@Configuration
public class DBService {

    private DriverManagerDataSource ConnectDB(String driver, String url, String user, String password) throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    //@Bean("kms")
    public DataSource ConnectToKMS() throws SQLException {
        return ConnectDB(
                "com.microsoft.sqlserver.jdbc.SQLServerDriver",
                "jdbc:sqlserver://srz\\srz;databaseName=FMS_new",
                "expert",
                "123"
                );
    }

    //@Bean("postgres")
    public DataSource ConnectToPostgres() throws SQLException {
        return ConnectDB(
                "org.postgresql.Driver",
                "jdbc:postgresql://192.168.2.157/pg_tfomsapp",
                "mcherchesov",
                "123"
        );
    }
}
