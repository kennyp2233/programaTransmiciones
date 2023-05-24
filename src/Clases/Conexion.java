/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "M4t1451609200201*";
    private static final String url = "jdbc:mysql://localhost:3306/transmisionesaduaneras";

    public Conexion() {
        conn = null;
        
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                //System.out.println("Conexion establecida");
                conn.setAutoCommit(false);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error al conectar" + e);
        }
    }
    
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql) ;
    }
      

    public void commit() {
        try {
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void rollback(){
        try {
            conn.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertarGuiaHija(String traderAssignedReferenceID, int masterLandingBillSequenceNumeric, int guiaHija, String AWB, String fecha) {
        try {
            Connection connection = (Connection) this;
            Statement statement = connection.createStatement();

            StringBuilder insertMadreQuery = new StringBuilder();
            insertMadreQuery.append("CAll InsertarGuiaHija(");
            insertMadreQuery.append(guiaHija);
            insertMadreQuery.append(", '");
            insertMadreQuery.append(traderAssignedReferenceID);
            insertMadreQuery.append("', '");
            insertMadreQuery.append(masterLandingBillSequenceNumeric);
            insertMadreQuery.append("', '");
            insertMadreQuery.append(AWB);
            insertMadreQuery.append("', '");
            insertMadreQuery.append(fecha); 
            insertMadreQuery.append("');");

            int resultado = statement.executeUpdate(insertMadreQuery.toString());
            System.out.println(resultado);

            //String insertMadreQuery = "CALL InsertarGuiaHija()";
            //idGuiaMadre = resultSet.getInt("id");
//            // Verificar si existe una guía madre con los mismos valores
//            String selectQuery = "SELECT id FROM guiasmadres WHERE traderAssignedReferenceID = ? AND masterLandingBillSequenceNumeric = ?";
//            statement = connection.prepareStatement(selectQuery);
//            statement.setString(1, traderAssignedReferenceID);
//            statement.setInt(2, masterLandingBillSequenceNumeric);
//            ResultSet resultSet = statement.executeQuery();
//
//            int idGuiaMadre;
//            if (resultSet.next()) {
//                // Si ya existe una guía madre, obtener su identificador
//                idGuiaMadre = resultSet.getInt("id");
//            } else {
//                // Si no existe una guía madre, insertar una nueva fila en la tabla "guias_madre"
//                String insertMadreQuery = "INSERT INTO guiasmadres (traderAssignedReferenceID, masterLandingBillSequenceNumeric) VALUES (?, ?)";
//                statement = connection.prepareStatement(insertMadreQuery, Statement.RETURN_GENERATED_KEYS);
//                statement.setString(1, traderAssignedReferenceID);
//                statement.setInt(2, masterLandingBillSequenceNumeric);
//                statement.executeUpdate();
//
//                // Obtener el identificador de la guía madre generada
//                ResultSet generatedKeys = statement.getGeneratedKeys();
//                if (generatedKeys.next()) {
//                    idGuiaMadre = generatedKeys.getInt(1);
//                } else {
//                    // Manejar el error si no se pudo obtener el identificador de la guía madre generada
//                    throw new SQLException("No se pudo obtener el identificador de la guía madre generada");
//                }
//            }
//
//            // Insertar una nueva fila en la tabla "guias_hija" con los datos de la guía hija
//            String insertHijaQuery = "INSERT INTO guiashijas (idGuiaMadre) VALUES (?)";
//            statement = connection.prepareStatement(insertHijaQuery);
//            statement.setInt(1, idGuiaMadre);
//            //statement.setString(2, otroValorCampoHija);
//            statement.executeUpdate();
//
//            // Cerrar la conexión y liberar recursos
//            statement.close();
//            connection.close();
        } catch (SQLException e) {
        }
    }

    //------------------------GETTERS Y SETTERS------------------------

    public static Connection getConnection() {
        return conn;
    }

    public void desconectar() {
        conn = null;
        if (conn == null) {
            //System.out.println("Conexion terminada");
        }
    }


}


//    static Connection con = null;
//    private static Statement st;
//
//    public Conexion() {
//
//    }
//    
//
//    //SIRVE PARA REALIZAR LA CONEXION HACIA LA BASE DE DATOS.
//    public static Connection getConexion() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/transmisionesaduaneras";
//            String user = "root";
//            String password = "";
//            con = DriverManager.getConnection(url, user, password);
//            st = con.createStatement();
//            System.out.println("bien");
//            return con;
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println("mal");
//            JOptionPane.showMessageDialog(null, "NO FUE POSIBLE CONECTARSE \n " + e);
//            return null;
//        }
//    }
//
//    public static Statement getStatement() throws SQLException {
//        Statement retorno;
//        retorno = getConexion().createStatement();
//        return retorno;
//    }
//
//    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
//        PreparedStatement ps = getConexion().prepareStatement(sql);
//        return ps;
//    }
//
//    public static ResultSet getResultSet(String sql) throws SQLException {
//        ResultSet rs = null;
//        rs = getStatement().executeQuery(sql);
//        return rs;
//    }
//
//    public static void Cerrar(Connection cn) throws SQLException {
//        cn.close();
//    }
//
//    public static void Cerrar(PreparedStatement ps) throws SQLException {
//        ps.close();
//    }
//
//    public static void Cerrar(ResultSet rs) throws SQLException {
//        rs.close();
//    }
//
//    
//
//    public static Connection getCon() {
//        return con;
//    }
//
//    public static void setCon(Connection con) {
//        Conexion.con = con;
//    }
//
//    public static Statement getSt() {
//        return st;
//    }
//
//    public static void setSt(Statement st) {
//        Conexion.st = st;
//    }
//
//    
//    
//}
