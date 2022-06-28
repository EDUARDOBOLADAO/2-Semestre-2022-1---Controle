/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Cleber Feitosa
 */
public class ConnectorFactory {

    public Connection getConnection() {
	
        try {
            //-- Faculdade: jdbc:mysql://127.0.0.1:3306/BDVENDAS?useTimezone=true&serverTimezone=UTC
            //-- Casa: jdbc:mysql://servidor:3307/BDVENDAS?useTimezone=true&serverTimezone=UTC
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BDVENDAS?useTimezone=true&serverTimezone=UTC", "teste", "123");

        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }

    }

   

}
