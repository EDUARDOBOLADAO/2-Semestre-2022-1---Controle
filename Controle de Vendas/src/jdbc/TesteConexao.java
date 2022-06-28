/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleber Feitosa
 */
public class TesteConexao {
    public static void main(String[] args) {
        
         try {
             
             new ConnectorFactory().getConnection();
             JOptionPane.showMessageDialog(null, "Conectado com sucesso!");             
         } catch (Exception erro) {
              JOptionPane.showMessageDialog(null, "Ops aconteceu o erro: "  + erro);    
         }
         
         
     }

}
