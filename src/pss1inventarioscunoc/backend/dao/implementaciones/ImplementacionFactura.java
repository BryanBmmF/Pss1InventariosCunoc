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
            prepStatement = Conexion.getConexion().prepareStatement(INSERTAR_FACTURA_SIN_PROVEEDOR);
            prepStatement.setInt(1, model.getIdProveedor());
            prepStatement.setInt(2, model.getNumeroFactura());
            prepStatement.setTimestamp(3, model.getFecha());
            prepStatement.setString(4, model.getDescripcion());
            prepStatement.setDouble(5, model.getValor());
            System.out.println("FACTURA:\n" + prepStatement.toString() + "\n");
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
    public List<Factura> recuperarLista(char estado) {
        ArrayList<Factura> facturas = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(BUSCAR_FACTURA);
            result = prepStatement.executeQuery();
            while (result.next()) {
                if(!result.getString(5).equalsIgnoreCase("FACTURA_UNICA_PREDETERMINADA")) {
                    facturas.add(new Factura(result.getInt(1), result.getInt(2), result.getInt(3), result.getTimestamp(4), result.getString(5), result.getDouble(6), result.getString(7)));
                }
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
     * Devuelve las facturas que coincidan con 'nombreProveedor', null si
     * existio algun error
     *
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
                if(!result.getString(5).equalsIgnoreCase("FACTURA_UNICA_PREDETERMINADA")) {
                    facturas.add(new Factura(result.getInt(1), result.getInt(2), result.getInt(3), result.getTimestamp(4), result.getString(5), result.getDouble(6), result.getString(7)));
                }
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
     * Busca una factura por su propio id
     *
     * @param id
     * @return
     */
    @Override
    public Factura buscarFacturaPorId(int idFactura) {
        Factura factura = null;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(BUSCAR_FACTURA_POR_ID);
            prepStatement.setInt(1, idFactura);
            result = prepStatement.executeQuery();
            while (result.next()) {
                factura = new Factura(result.getInt(1),result.getInt(2), result.getInt(3),
                        result.getTimestamp(4), result.getString(5), result.getDouble(6));
            }
            System.out.println("\n\nFACTURA:"+prepStatement.toString());
            prepStatement.close();
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return factura;
    }

    /**
     * Devuelve las facturas que esten en el rango de fechas especificadas, null
     * si existio algun error
     *
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
            System.out.println(prepStatement.toString());
            result = prepStatement.executeQuery();
            while (result.next()) {
                if(!result.getString(5).equalsIgnoreCase("FACTURA_UNICA_PREDETERMINADA")) {
                    facturas.add(new Factura(result.getInt(1), result.getInt(2), result.getInt(3), result.getTimestamp(4), result.getString(5), result.getDouble(6), result.getString(7)));
                }
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
     * Se registra una factura que posee proveedor
     *
     * @param model
     * @return
     */
    @Override
    public boolean registrarFacturaConProveedor(Factura model) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(INSERTAR_FACTURA_CON_PROVEEDOR);
            prepStatement.setInt(1, model.getIdProveedor());
            prepStatement.setInt(2, model.getNumeroFactura());
            prepStatement.setTimestamp(3, model.getFecha());
            prepStatement.setString(4, model.getDescripcion());
            prepStatement.setDouble(5, model.getValor());
            System.out.println("FACTURA:\n" + prepStatement.toString() + "\n");
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Se registra una factura que no posee proveedor
     *
     * @param model
     * @return
     */
    @Override
    public boolean registrarFacturaSinProveedor(Factura model) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(INSERTAR_FACTURA_SIN_PROVEEDOR);
            prepStatement.setInt(1, model.getNumeroFactura());
            prepStatement.setTimestamp(2, model.getFecha());
            prepStatement.setString(3, model.getDescripcion());
            prepStatement.setDouble(4, model.getValor());
            System.out.println("FACTURA:\n" + prepStatement.toString() + "\n");
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Permite actualizar todos los parametros de una factura, incluyendo el
     * proveedor
     *
     * @param factura
     * @return
     */
    @Override
    public boolean actualizarFacturaYSuProveedor(Factura factura) {

        try {
            prepStatement = Conexion.getConexion().prepareStatement(MODIFICAR_FACTURA);
            prepStatement.setInt(1, factura.getNumeroFactura());
            prepStatement.setTimestamp(2, factura.getFecha());
            prepStatement.setString(3, factura.getDescripcion());
            prepStatement.setDouble(4, factura.getValor());
            prepStatement.setInt(5, factura.getIdProveedor());
            prepStatement.setInt(6, factura.getIdFactura());
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Permite actualizar una factura que al ingresar a la tabla no tendra
     * proveedor
     *
     * @param factura
     * @return
     */
    @Override
    public boolean actualizarFacturaQuitandoProveedor(Factura factura) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(MODIFICAR_FACTURA_ELIMINANDO_PROVEEDOR);
            prepStatement.setInt(1, factura.getNumeroFactura());
            prepStatement.setTimestamp(2, factura.getFecha());
            prepStatement.setString(3, factura.getDescripcion());
            prepStatement.setDouble(4, factura.getValor());
            prepStatement.setInt(5, factura.getIdFactura());
            System.out.println(prepStatement.toString());
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Factura buscarFacturaPorDescripcion(String desc) {
        Factura fac=null;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(BUSCAR_FACTURA_POR_DESCRIPCION);
            prepStatement.setString(1,desc);
            result = prepStatement.executeQuery();
            while(result.next()){
                fac = new Factura(result.getInt(1), result.getInt(2), result.getInt(3), result.getTimestamp(4), result.getString(5), result.getDouble(6), result.getString(7));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fac;
    }
}
