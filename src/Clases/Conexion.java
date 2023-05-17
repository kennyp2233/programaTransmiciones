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

    static Connection con = null;
    static Statement st;

    //SIRVE PARA REALIZAR LA CONEXION HACIA LA BASE DE DATOS.
    public static Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/transmiciones";
            String user = "root";
            String password = "$2112rbAV";
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            System.out.println("bien");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("mal");
            JOptionPane.showMessageDialog(null, "NO FUE POSIBLE CONECTARSE \n " + e);
            return null;
        }
    }

    public static Statement getStatement() throws SQLException {
        Statement st = null;
        st = getConexion().createStatement();
        return st;
    }

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        PreparedStatement ps = getConexion().prepareStatement(sql);
        return ps;
    }

    public static ResultSet getResultSet(String sql) throws SQLException {
        ResultSet rs = null;
        rs = getStatement().executeQuery(sql);
        return rs;
    }

    public static void Cerrar(Connection cn) throws SQLException {
        cn.close();
    }

    public static void Cerrar(PreparedStatement ps) throws SQLException {
        ps.close();
    }

    public static void Cerrar(ResultSet rs) throws SQLException {
        rs.close();
    }

    public void insertarGuiaHija(String traderAssignedReferenceID, int masterLandingBillSequenceNumeric, int guiaHija, String AWB) {
        try {
            Connection connection = this.getConexion();
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
            insertMadreQuery.append("')");

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
            e.printStackTrace();
        }
    }

}
