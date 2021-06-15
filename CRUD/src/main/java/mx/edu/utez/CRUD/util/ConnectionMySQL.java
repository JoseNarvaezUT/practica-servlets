package mx.edu.utez.CRUD.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {


    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection("jdbc:mysql://localhost:3308/crud","root","root");
    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ConnectionMySQL.class);
        try {
            logger.info("Abriendo conexión");
            Connection con = ConnectionMySQL.getConnection();
            logger.info("Conexion establecida");
            con.close();
            logger.info("Conexion finalizada");
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}

