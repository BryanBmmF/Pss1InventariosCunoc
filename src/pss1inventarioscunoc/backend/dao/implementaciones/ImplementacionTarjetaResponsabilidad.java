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
            prepStatement.setString(8, model.getEstado());
            System.out.println("\n\nRegistro de Tarjeta de responsabilidad:"+prepStatement.toString()+"\n\n");
            prepStatement.executeUpdate();
            prepStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<TarjetaResponsabilidad> recuperarLista(char estado) {
        List<TarjetaResponsabilidad> tarjetas = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_TARJETAS);
            result=prepStatement.executeQuery();
            while(result.next()){
                tarjetas.add(new TarjetaResponsabilidad(result.getLong(1), result.getTimestamp(2), 
                        result.getString(3), result.getLong(4), result.getString(5), 
                        result.getTimestamp(6), result.getString(7), result.getString(8), 
                        result.getLong(9), result.getString(10), result.getLong(11), result.getString(12)));
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
        try {
            prepStatement = Conexion.getConexion().prepareStatement(ACTUALIZAR_TARJETA);
            prepStatement.setLong(1, model.getIdResponsable());
            prepStatement.setLong(2, model. getIdProveedor());
            prepStatement.setLong(3, model.getNoFactura());
            prepStatement.setString(4, model.getEstado());
            prepStatement.setLong(5, model.getId());
            prepStatement.executeUpdate();
            prepStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
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
            prepStatement.setString(9, model.getEstado());
            prepStatement.executeUpdate();
            prepStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public int recuperarNumeroTarjetasPorEncargado(String idEncargado){
        int numeroTarjetas = 0;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_NUMERO_TARJETAS_ENCARGADO);
            prepStatement.setString(1, idEncargado);
            result=prepStatement.executeQuery();
            while(result.next()){
                numeroTarjetas = result.getInt(1);
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ImplementacionUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return numeroTarjetas;
    }
    
    @Override
    public List<TarjetaResponsabilidad> recuperarListaTarjetasEncargado(String idEncargado){
        List<TarjetaResponsabilidad> tarjetas = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_TARJETAS_POR_ENCARGADO);
            prepStatement.setString(1, idEncargado);
            result=prepStatement.executeQuery();
            while(result.next()){
                tarjetas.add(new TarjetaResponsabilidad(result.getLong(1), result.getTimestamp(2), 
                        result.getString(3), result.getLong(4), result.getString(5), 
                        result.getTimestamp(6), result.getString(7), result.getString(8), 
                        result.getLong(9), result.getString(10), result.getLong(11), result.getString(12)));
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
    public TarjetaResponsabilidad recuperarTarjetaBien(String cur) {
        TarjetaResponsabilidad tarjeta = null;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_TARJETA_BIEN);
            prepStatement.setString(1, cur);
            result=prepStatement.executeQuery();
            while(result.next()){
                tarjeta= new TarjetaResponsabilidad(result.getLong(1), result.getTimestamp(2), 
                        result.getString(3), result.getLong(4), result.getString(5), 
                        result.getTimestamp(6), result.getString(7), result.getString(8), 
                        result.getLong(9), result.getString(10), result.getLong(11), result.getString(12));
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ImplementacionUsuario.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return tarjeta;
    }

@Override
    public List<TarjetaResponsabilidad> recuperarLista(String estado) {
        List<TarjetaResponsabilidad> tarjetas = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_TARJETAS_ESTADO);
            prepStatement.setString(1, estado);
            result=prepStatement.executeQuery();
            while(result.next()){
                tarjetas.add(new TarjetaResponsabilidad(result.getLong(1), result.getTimestamp(2), 
                        result.getString(3), result.getLong(4), result.getString(5), 
                        result.getTimestamp(6), result.getString(7), result.getString(8), 
                        result.getLong(9), result.getString(10), result.getLong(11), result.getString(12)));
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
    
}
