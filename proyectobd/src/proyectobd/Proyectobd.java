import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Proyectobd {
public static void main(String[] args){ try {
// cadena de conexion
String url = "jdbc:mysql://localhost:3306/prueba"; String username = "root";
String password = "";
Connection connection = (Connection) DriverManager.getConnection(url, username, password);
Statement sentencia = (Statement) connection.createStatement();
sentencia.executeUpdate("insert into cliente values(123,'Panamericana S.A','Cra 34 # 10- 26',2222222)");
sentencia.executeUpdate("insert into cliente values(456,'Xerox de Colombia','Ave Dorado # 85- 24',3333333)");
System.out.println("Registros insertados en la Base de datos"); System.out.println(" ");
Statement statement = (Statement) connection.createStatement(); System.out.println("Consulta de todos los registros en la Base de datos"); System.out.println(" ");
ResultSet rs = statement.executeQuery("SELECT * FROM cliente"); while (rs.next()) {
int id = rs.getInt("icliente");
String nombre = rs.getString("nom_cliente");
String direccion = rs.getString("dir_cliente");
String telefono = rs.getString("tel_cliente");
System.out.println(String.format("%d, %s, %s, %s", id, nombre, direccion, telefono));
}
// Consulta de un registro determinado
System.out.println("Consulta de un registro X ");
System.out.println(" ");
ResultSet rs1 = statement.executeQuery("SELECT * FROM cliente WHERE icliente=123"); while (rs1.next()) {
int id = rs1.getInt("icliente");
String nombre = rs1.getString("nom_cliente");
String direccion = rs1.getString("dir_cliente");
String telefono = rs1.getString("tel_cliente");
System.out.println(String.format("%d, %s, %s, %s", id, nombre, direccion, telefono));
}
// Actualizacion de un registro determinado
System.out.println("Actualizacion de un registro X ");
ResultSet rs2 = statement.executeQuery("SELECT * FROM cliente WHERE icliente=123"); while (rs2.next()) {
 //Se trata de un insert en la base de datos. Para ello es necesario contar con dos
 //objetos Connection y ResultSet.
int id = rs2.getInt("icliente"); // se obtiene su id
// se actualiza el registro en el campo del telefono
sentencia.executeUpdate("UPDATE cliente SET tel_cliente='88888888' WHERE icliente="+id);
}
// Consulta del registro actualizado
ResultSet rs3 = statement.executeQuery("SELECT * FROM cliente WHERE icliente=123"); System.out.println("Consulta del registro actualizado ");
System.out.println(" ");
while (rs3.next()) {
int id = rs3.getInt("icliente");
String nombre = rs3.getString("nom_cliente");
String direccion = rs3.getString("dir_cliente");
String telefono = rs3.getString("tel_cliente");
System.out.println(String.format("%d, %s, %s, %s", id, nombre, direccion, telefono));
}
rs.close(); rs1.close(); rs2.close(); statement.close(); connection.close();
} catch (SQLException ex) { System.out.println(ex);
}
} }    