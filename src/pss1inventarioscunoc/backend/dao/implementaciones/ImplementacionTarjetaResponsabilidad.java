/*
 * Implementacion de clase Tarjeta de Responsabilidad
 */
package pss1inventarioscunoc.backend.dao.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import pss1inventarioscunoc.backend.bd.Conexion;
import pss1inventarioscunoc.backend.dao.interfaces.TarjetaResponsabilidadDAO;
import pss1inventarioscunoc.backend.pojos.TarjetaResponsabilidad;

/**
 *
 * @author bryan
 */
public class ImplementacionTarjetaResponsabilidad implements TarjetaResponsabilidadDAO{

    private PreparedStatement prepStatement;
    private ResultSet result;
    private List listaRecuperacion = new ArrayList();
    
    @Override
    public boolean registrar(TarjetaResponsabilidad model) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(INSERTAR_TARJETA);
            prepStatement.setTimestamp(1, model.getFechaApertura());
            prepStatement.setString(2, model.getDescripcion());
            prepStatement.setLong(3, model.getNoFactura());
            prepStatement.setTimestamp(4, model.getFechaFactura());
            prepStatement.setString(5, model.getCurBien());
            prepStatement.setLong(6, model.getIdResponsable());
            prepStatement.setLong(7, model.getIdProveedor());
            prepStatement.executeUpdate();
            prepStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<TarjetaResponsabilidad> recuperarLista() {
        List<TarjetaResponsabilidad> tarjetas = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_TARJETAS);
            result=prepStatement.executeQuery();
            while(result.next()){
                tarjetas.add(new TarjetaResponsabilidad(result.getLong(1), result.getTimestamp(2), 
                        result.getString(3), result.getLong(4), result.getString(5), 
                        result.getTimestamp(6), result.getString(7), result.getString(8), 
                        result.getLong(9), result.getString(10), result.getLong(11)));
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImplementacionUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return tarjetas;
        }
        return tarjetas;
    }

    @Override
    public boolean actualizar(TarjetaResponsabilidad model, String temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(TarjetaResponsabilidad model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrarConOrdenCompra(TarjetaResponsabilidad model) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(INSERTAR_TARJETA_ORDEN_COMPRA);
            prepStatement.setTimestamp(1, model.getFechaApertura());
            prepStatement.setString(2, model.getDescripcion());
            prepStatement.setLong(3, model.getNoFactura());
            prepStatement.setTimestamp(4, model.getFechaFactura());
            prepStatement.setString(5, model.getNoOrdenCompra());
            prepStatement.setString(6, model.getCurBien());
            prepStatement.setLong(7, model.getIdResponsable());
            prepStatement.setLong(8, model.getIdProveedor());
            prepStatement.executeUpdate();
            prepStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
