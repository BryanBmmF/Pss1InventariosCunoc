/*
 * Implementacion de clase Inventario
 */
package pss1inventarioscunoc.backend.dao.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pss1inventarioscunoc.backend.bd.Conexion;
import pss1inventarioscunoc.backend.controladores.ControladorInventario;
import pss1inventarioscunoc.backend.dao.interfaces.InventarioDAO;
import pss1inventarioscunoc.backend.pojos.Bien;
import pss1inventarioscunoc.backend.pojos.Inventario;

/**
 *
 * @author bryan
 */
public class ImplementacionInventario implements InventarioDAO {

    private PreparedStatement prepStatement;
    private ResultSet result;

    @Override
    public boolean registrar(Inventario model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inventario> recuperarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Inventario model, String temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Inventario model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Inventario buscarInventario() {
        Inventario inventarioEncontrado;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_INVENTARIO);
            prepStatement.setInt(1, 1);
            result = prepStatement.executeQuery();
            result.next();
            inventarioEncontrado = new Inventario(result.getInt(1), result.getTimestamp(2), result.getString(3), result.getString(4), result.getTimestamp(5));
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return inventarioEncontrado;
    }

    /**
     * Permite asociar un bien con su inventario
     *
     * @param bien
     * @return
     */
    @Override
    public boolean insertarRegistroBienInventario(Bien bien) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(INSERTAR_REGISTRO_BIEN_INVENTARIO);
            prepStatement.setInt(1, ControladorInventario.INVENTARIO_CONTABILIDAD.getNumero());
            prepStatement.setString(2, bien.getCur());
            System.out.println(prepStatement.toString() );
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

    }

    /**
     * Se consulta el total de inventario activo, -1 si existiera error
     *
     * @param inventario
     * @return
     */
    @Override
    public double consultarTotalDeInventarioActivo(Inventario inventario) {
        double valorTotal = -1;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_TOTAL_DE_INVENTARIO);
            prepStatement.setString(1, "1");
            prepStatement.setInt(2, inventario.getNumero());
            System.out.println(prepStatement.toString());
            result = prepStatement.executeQuery();
            while (result.next()) {
                valorTotal = result.getDouble(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return valorTotal;
    }
/**
 * Se consulta el total de inventario de baja, -1 si existiera error
 * @param inventario
 * @return 
 */
    @Override
    public double consultarTotalDeInventarioDeBaja(Inventario inventario) {
        double valorTotal = -1;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_TOTAL_DE_INVENTARIO);
            prepStatement.setString(1, "0");
            prepStatement.setInt(2, inventario.getNumero());
            result = prepStatement.executeQuery();
            while (result.next()) {
                valorTotal = result.getDouble(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return valorTotal;
    }
}
