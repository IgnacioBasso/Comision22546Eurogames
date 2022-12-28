package data;

import static data.Conexion.*;
import static data.Conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Eurogame;


public class EurogameDAO {

    private static final String SQL_SELECT = "SELECT * FROM juegos";
    private static final String SQL_SELECT_BY_ID = "SELECT idEurogame, nombre, editor, cantidadJugadores, minutosJuego, edadMinima, precio, cantidad FROM juegos WHERE idEurogame = ?";

    private static final String SQL_INSERT = "INSERT INTO juegos(nombre, editor, cantidadJugadores, minutosJuego, edadMinima, precio, cantidad) VALUES(?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE juegos SET nombre = ?, editor = ?, cantidadJugadores = ?, minutosJuego = ?, edadMinima = ?, precio = ?, cantidad = ? WHERE idEurogame = ?";

    private static final String SQL_DELETE = "DELETE FROM juegos WHERE idEurogame = ?";

    public List<Eurogame> seleccionar() throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Eurogame eurogame = null;
        List<Eurogame> eurogames = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idEurogame = rs.getInt(1);
                String nombre = rs.getString("nombre");
                String editor = rs.getString("editor");
                String cantidadJugadores = rs.getString("cantidadJugadores");
                int minutosJuego = rs.getInt("minutosJuego");
                int edadMinima = rs.getInt("edadMinima");
                double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");

                eurogame = new Eurogame(idEurogame, nombre, editor, cantidadJugadores, minutosJuego, edadMinima, precio, cantidad);

                eurogames.add(eurogame);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return eurogames;
    }

    public int insertar(Eurogame eurogame) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, eurogame.getNombre());
            stmt.setString(2, eurogame.getEditor());
            stmt.setString(3, eurogame.getCantidadJugadores());
            stmt.setInt(4, eurogame.getMinutosJuego());
            stmt.setInt(5, eurogame.getEdadMinima());
            stmt.setDouble(6, eurogame.getPrecio());
            stmt.setInt(7, eurogame.getCantidad());            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EurogameDAO.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int actualizar(Eurogame eurogame) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);            
            stmt.setString(1, eurogame.getNombre());
            stmt.setString(2, eurogame.getEditor());
            stmt.setString(3, eurogame.getCantidadJugadores());
            stmt.setInt(4, eurogame.getMinutosJuego());
            stmt.setInt(5, eurogame.getEdadMinima());
            stmt.setDouble(6, eurogame.getPrecio());
            stmt.setInt(7, eurogame.getCantidad());
            stmt.setInt(8, eurogame.getIdEurogame());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int eliminar(int idEurogame) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();

            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, idEurogame);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public Eurogame seleccionarPorID(int id) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Eurogame eurogame = null;

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEurogame = rs.getInt("idEurogame");
                String nombre = rs.getString("nombre");
                String editor = rs.getString("editor");
                String cantidadJugadores = rs.getString("cantidadJugadores");
                int minutosJuego = rs.getInt("minutosJuego");
                int edadMinima = rs.getInt("edadMinima");
                double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");

                eurogame = new Eurogame(idEurogame,nombre, editor, cantidadJugadores, minutosJuego, edadMinima, precio, cantidad);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return eurogame;
    }

}
