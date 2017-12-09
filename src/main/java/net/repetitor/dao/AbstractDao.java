package net.repetitor.dao;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Volodymyr Burtsev at 09.12.2017 0:03
 */
public abstract class AbstractDao {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/hmarka?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String name = "root";
    private static final String password = "120378";

    private static DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(name);
        dataSource.setPassword(password);
        return dataSource;
    }

    protected Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}