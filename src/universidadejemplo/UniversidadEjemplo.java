
package universidadejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Raven
 */
public class UniversidadEjemplo {

    
    public static void main(String[] args) {
        
        try {
            
            //cargar Driver
            Class.forName("org.mariadb.jdbc.Driver");
            //conectar a la base de datos
          Connection con= DriverManager.getConnection("jdbc:mariadb://localhost:3306/universidadulp","root", "");
          
          //--------------------------------------------------------------
         /* //c)insertar 3 alumnos
          
          String sql="INSERT INTO alumnno(dni, apellido, nombre, fechaNacimiento, estado) "
                  + "VALUES (32156478,'Russo','Daniela','1997-02-13',1),(30753125,'Castro','Belen','1980-05-04',1),(33456743,'Lopez','Eugenia','1996-09-15',1)";
          PreparedStatement ps= con.prepareStatement(sql);
          int registro= ps.executeUpdate(); //verificacion por consola
            System.out.println(registro);*/
          
              
          //--------------------------------------------------------------
          /*//d)insertar 4 materias
          
          String sql= "INSERT INTO materia (nombre, año, estado) VALUES ('Matematica',1 ,1),('Lengua',2 ,1),('Cs.Naturales',2 ,1),('Geografia',3 ,1)";
          PreparedStatement ps=con.prepareStatement(sql);
          int registro=ps.executeUpdate();
           System.out.println(registro); // verificando por consola */
          
           //--------------------------------------------------------------
         /* //e) Inscribir a los 3 alumnos en 2 materias cada uno.
          
          String sql="INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES (8,1,1),(7,1,2),(6,2,4),(5,2,1),(8,3,3),(4,3,2)";
          PreparedStatement ps=con.prepareStatement(sql);
          int registro= ps.executeUpdate();
          System.out.println(registro); // verificando por consola*/
         
          //--------------------------------------------------------------
         /* //f) Listar los datos de los alumnos con calificaciones superiores a 8.
          
          String sql="SELECT * FROM inscripcion JOIN alumno ON(alumno.idAlumno=inscripcion.idAlumno) WHERE nota >= 8";
          PreparedStatement ps=con.prepareStatement(sql);
          ResultSet resul=ps.executeQuery();
          
          while(resul.next()){
              
              System.out.println("ID "+ resul.getInt("idAlumno"));
              System.out.println("DNI "+ resul.getInt("dni"));
              System.out.println("APELLIDO "+resul.getString("apellido"));
              System.out.println("NOMBRE "+resul.getString("nombre"));
              System.out.println("F.NAC "+ resul.getDate("fechaNacimiento"));
              System.out.println("ESTADO "+ resul.getBoolean("estado"));
              
              
          }*/
         
         //--------------------------------------------------------------
        /* //g) Desinscribir un alumno de una de la materias.
         
         String sql="DELETE FROM inscripcion WHERE idInscripto=5 ";
         PreparedStatement ps=con.prepareStatement(sql);
         int registro=ps.executeUpdate();
            System.out.println(registro);*/
          
         } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null, "Error de carga de Driver"+ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion a la base de datos"+ex.getMessage());
        }
        
        
        
        //probando si esto esta subiendo bien
        
    }
    
}
