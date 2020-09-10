/*
 * Implementacion de clase Encargado
 */
package pss1inventarioscunoc.backend.dao.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pss1inventarioscunoc.backend.bd.Conexion;
import pss1inventarioscunoc.backend.dao.interfaces.EncargadoDAO;
import pss1inventarioscunoc.backend.pojos.Encargado;

/**
 *
 * @author bryan
 */
public class ImplementacionEncargado implements EncargadoDAO{

    private PreparedStatement prepStatement;
    private ResultSet result;
    
    @Override
    public boolean registrar(Encargado model) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(INSERTAR_ENCARGADO);
            prepStatement.setLong(1, model.getId());
            prepStatement.setString(2, model.getRegistro());
            prepStatement.setString(3, model.getNombre());
            prepStatement.setString(4, model.getApellido());
            prepStatement.setString(5, model.getCargo());
            prepStatement.setString(6, model.getDivision());
            prepStatement.setString(7, model.getEstado());
            System.out.println(prepStatement.toString());
            prepStatement.executeUpdate();
            prepStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean registrarPredeterminado(Encargado model){
        try {
            prepStatement = Conexion.getConexion().prepareStatement(INSERTAR_ENCARGADO_PREDETERMINADO);
            prepStatement.setLong(1, model.getId());
            prepStatement.executeUpdate();
            prepStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Encargado> recuperarLista(char estado) {
        List<Encargado> encargados = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_ENCARGADOS);
            result=prepStatement.executeQuery();
            while(result.next()){
                encargados.add(new Encargado(result.getLong(1), result.getString(2), 
                        result.getString(3), result.getString(4), result.getString(5),
                        result.getString(6), result.getString(7)));
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ImplementacionUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return encargados;
        }
        return encargados;
    }
    
    @Override
    public Encargado recuperarPredeterminado(char estado){
        Encargado predeterminado = null;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_ENCARGADO_PREDETERMINADO);
            result=prepStatement.executeQuery();
            while(result.next()){
                predeterminado = new Encargado(result.getLong(1), result.getString(2), 
                        result.getString(3), result.getString(4), result.getString(5),
                        result.getString(6),result.getString(7));
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ImplementacionUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return predeterminado;
    }
    
    @Override
    public List<Encargado> recuperarListaByState(String state) {
        List<Encargado> encargados = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_ENCARGADOS_POR_ESTADO);
            prepStatement.setString(1, state);
            result = prepStatement.executeQuery();
            while (result.next()) {
                encargados.add(new Encargado(result.getLong(1), result.getString(2),
                        result.getString(3), result.getString(4), result.getString(5),
                        result.getString(6), result.getString(7)));
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ImplementacionUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return encargados;
        }
        return encargados;
    }
    
    @Override
    public boolean actualizar(Encargado model, String temp) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(ACTUALIZAR_ENCARGADO);
            prepStatement.setString(1, model.getRegistro());
            prepStatement.setString(2, model.getNombre());
            prepStatement.setString(3, model.getApellido());
            prepStatement.setString(4, model.getCargo());
            prepStatement.setString(5, model.getDivision());
            prepStatement.setString(6, model.getEstado());
            prepStatement.setLong(7, model.getId());
            prepStatement.executeUpdate();
            prepStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean actualizarPredeterminado(Encargado model, String temp){
        try {
            prepStatement = Conexion.getConexion().prepareStatement(ACTUALIZAR_ENCARGADO_PREDETERMINADO);
            prepStatement.setLong(1, model.getId());
            prepStatement.setString(2, temp);
            prepStatement.executeUpdate();
            prepStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(Encargado model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param model
     * @param temp
     * @return 
     */
    @Override
    public List<String> recuperarListaCargos() {
        List<String> cargos = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_CARGOS);
            result=prepStatement.executeQuery();
            while(result.next()){
                cargos.add(result.getString(1));
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ImplementacionUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return cargos;
        }
        return cargos;
    }

    @Override
    public List<String> recuperarListaDivisiones() {
        List<String> cargos = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_DIVISIONES);
            result=prepStatement.executeQuery();
            while(result.next()){
                cargos.add(result.getString(1));
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ImplementacionUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return cargos;
        }
        return cargos;
    }
    
}
