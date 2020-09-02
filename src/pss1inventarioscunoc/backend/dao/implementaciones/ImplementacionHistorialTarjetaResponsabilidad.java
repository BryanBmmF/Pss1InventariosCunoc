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
import pss1inventarioscunoc.backend.dao.interfaces.HistorialTarjetaResponsabilidadDAO;
import pss1inventarioscunoc.backend.pojos.HistorialTarjetaResponsabilidad;
import pss1inventarioscunoc.backend.pojos.TarjetaResponsabilidad;

/**
 *
 * @author bryan
 */
public class ImplementacionHistorialTarjetaResponsabilidad implements HistorialTarjetaResponsabilidadDAO{

    private PreparedStatement prepStatement;
    private ResultSet result;
    private List listaRecuperacion = new ArrayList();
    
    @Override
    public boolean registrar(HistorialTarjetaResponsabilidad model) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(INSERTAR_HISTORIAL_TARJETA);
            prepStatement.setLong(1, model.getIdTarjetaResponsabilidad());
            prepStatement.setTimestamp(2, model.getFechaModificacion());
            prepStatement.setLong(3, model.getIdResponsable());
            prepStatement.setLong(4, model.getIdProveedor());
            prepStatement.setString(5, model.getEstado());
            prepStatement.setLong(6, model.getNoFactura());
            prepStatement.executeUpdate();
            prepStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<HistorialTarjetaResponsabilidad> recuperarLista(char estado) {
        List<HistorialTarjetaResponsabilidad> historialTarjetas = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_HISTORIAL_TARJETAS);
            result=prepStatement.executeQuery();
            while(result.next()){
                historialTarjetas.add(new HistorialTarjetaResponsabilidad(result.getLong(1), 
                        result.getLong(2), result.getTimestamp(3), result.getLong(4), 
                        result.getLong(5), result.getString(6), result.getLong(7)));
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImplementacionUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return historialTarjetas;
        }
        return historialTarjetas;
    }

    @Override
    public boolean actualizar(HistorialTarjetaResponsabilidad model, String temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(HistorialTarjetaResponsabilidad model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
