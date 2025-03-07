
package conecctionjdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConecctionJDBC {

    public static void main(String[] args) {
            String usuario = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/shirt_com";
            Connection conexion;
            Statement statement;
            ResultSet rs;
            
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            
            //Consulta a la DB
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {                
                System.out.println(rs.getString("nombre_cliente"));
            }
            
            //state datos
            statement.execute("INSERT INTO `clientes`(`nombre_cliente`, `direccion`, `correo`, `telefono`) VALUES ('Manuel','barrio laureles','[manuel14@gmail.com','72548895')");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {                
                System.out.println(rs.getString("nombre_cliente")+" "+rs.getString("telefono"));
            }
            
            //Actualizacion de datos
            statement.execute("UPDATE `clientes` SET `nombre_cliente`='Miguel',`direccion` = 'Kennedy',`correo` = 'miguekhernesto67@gmail.com',`telefono` = '26635547' WHERE `clientes`.`id_cliente` = 2; ");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {                
                System.out.println(rs.getString("nombre_cliente")+" "+rs.getString("telefono"));
            }
        
            //Eliminar datos
         statement.execute("DELETE FROM `CLIENTES` WHERE `id_cliente`= 5 ");
         System.out.println("");
         rs = statement.executeQuery("SELECT * FROM clientes");
         while (rs.next()) {                
                System.out.println(rs.getString("nombre_cliente")+" "+rs.getString("telefono"));
            } 
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConecctionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
