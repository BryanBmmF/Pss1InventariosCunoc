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
            prepStatement.setString(2, model.getNombre());
            prepStatement.setString(3, model.getApellido());
            prepStatement.setString(4, model.getCargo());
            prepStatement.setString(5, model.getDivision());
            prepStatement.executeUpdate();
            prepStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Encargado> recuperarLista() {
        List<Encargado> encargados = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_ENCARGADOS);
            result=prepStatement.executeQuery();
            while(result.next()){
                encargados.add(new Encargado(result.getLong(1), result.getString(2), 
                        result.getString(3), result.getString(4), result.getString(5)));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Encargado model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
