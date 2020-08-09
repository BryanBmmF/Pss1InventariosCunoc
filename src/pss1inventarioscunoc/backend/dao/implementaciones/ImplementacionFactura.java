/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.backend.dao.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Result;
import pss1inventarioscunoc.backend.bd.Conexion;
import pss1inventarioscunoc.backend.dao.interfaces.FacturaDAO;
import pss1inventarioscunoc.backend.pojos.Factura;

/**
 *
 * @author jesfrin
 */
public class ImplementacionFactura implements FacturaDAO {

    private PreparedStatement prepStatement;
    private ResultSet result;

    /**
     * Registra una factura, regresa fals si existio error
     *
     * @param model
     * @return
     */
    @Override
    public boolean registrar(Factura model) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(INSERTAR_FACTURA);
            prepStatement.setInt(1, model.getIdProveedor());
            prepStatement.setInt(2, model.getNumeroFactura());
            prepStatement.setTimestamp(3, model.getFecha());
            prepStatement.setString(4, model.getDescripcion());
            prepStatement.setDouble(5, model.getValor());
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Recupera la lista de facturas, regresa null si hubo error
     *
     * @return
     */
    @Override
    public List<Factura> recuperarLista() {
        ArrayList<Factura> facturas = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(BUSCAR_FACTURA);
            result = prepStatement.executeQuery();
            while (result.next()) {
                facturas.add(new Factura(result.getInt(1), result.getInt(2), result.getInt(3), result.getTimestamp(4), result.getString(5), result.getDouble(6), result.getString(7)));
            }
            prepStatement.close();
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return facturas;
    }

    @Override
    public boolean actualizar(Factura model, String temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Factura model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Devuelve las facturas que coincidan con 'nombreProveedor', null si existio algun error
     * @param nombreProveedor
     * @return 
     */
    @Override
    public ArrayList<Factura> buscarFacturaPorProveedor(String nombreProveedor) {
        ArrayList<Factura> facturas = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(BUSCAR_FACTURA_POR_PROVEEDOR);
            prepStatement.setString(1, "%" + nombreProveedor + "%");
            result = prepStatement.executeQuery();
            while (result.next()) {
                facturas.add(new Factura(result.getInt(1), result.getInt(2), result.getInt(3), result.getTimestamp(4), result.getString(5), result.getDouble(6), result.getString(7)));
            }
            prepStatement.close();
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return facturas;
    }

    /**
     * Devuelve las facturas que esten en el rango de fechas especificadas, null si existio algun error
     * @param fechaInicial
     * @param fechaFinal
     * @return 
     */
    @Override
    public ArrayList<Factura> buscarFacturaPorFecha(Timestamp fechaInicial, Timestamp fechaFinal) {
        ArrayList<Factura> facturas = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(BUSCAR_FACTURA_POR_FECHA);
            prepStatement.setTimestamp(1, fechaInicial);
            prepStatement.setTimestamp(2, fechaFinal);
            result = prepStatement.executeQuery();
            while (result.next()) {
                facturas.add(new Factura(result.getInt(1), result.getInt(2), result.getInt(3), result.getTimestamp(4), result.getString(5), result.getDouble(6), result.getString(7)));
            }
            prepStatement.close();
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return facturas;
    }

}
