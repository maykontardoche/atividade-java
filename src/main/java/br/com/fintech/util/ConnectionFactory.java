package br.com.fintech.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class ConnectionFactory {
    private static final String PROPS = "/application.properties";
    private static String url;
    private static String user;
    private static String password;

    static {
        try (InputStream in = ConnectionFactory.class.getResourceAsStream(PROPS)) {
            Properties props = new Properties();
            props.load(in);
            url      = props.getProperty("jdbc.url");
            user     = props.getProperty("jdbc.user");
            password = props.getProperty("jdbc.password");
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            throw new ExceptionInInitializerError("Erro ao carregar propriedades: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
