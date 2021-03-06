/*
 * Clase de implementación de LogIngreso
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
import pss1inventarioscunoc.backend.bd.Conexion;
import pss1inventarioscunoc.backend.controladores.ControladorLogIngreso;
import pss1inventarioscunoc.backend.dao.interfaces.LogIngresoDAO;
import pss1inventarioscunoc.backend.pojos.LogIngreso;

/**
 *
 * @author jesfrin
 */
public class ImplementacionLogIngreso implements LogIngresoDAO {

    private PreparedStatement prepStatement;
    private ResultSet result;
    private List listaRecuperacion = new ArrayList();

    /**
     * Registra un LOG_INGRESO
     * @param model
     * @return 
     */
    @Override
    public boolean registrar(LogIngreso model) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(INGRESO_LOG);
            prepStatement.setTimestamp(1, model.getFecha());
            prepStatement.setString(2, model.getTipo());
            prepStatement.setString(3, model.getIdUsuario());
            prepStatement.setString(4, model.getDeescripcion());
            System.out.println(prepStatement.toString());
            prepStatement.executeUpdate();
            prepStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<LogIngreso> recuperarLista(char estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(LogIngreso model, String temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(LogIngreso model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * Busqueda del ultimo id del log de Ingreso
 * retorna -1 si existe un error
 * @return 
 */
    @Override
    public int busquedaDeLogEvento() {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(BUSQUEDA_ID);
            result=prepStatement.executeQuery();
            result.next();
            return result.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public ArrayList<String> buscarLogEvento() {
        ArrayList<String> logs = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(COSULTAR_LOG_EVENTO);
            prepStatement.setInt(1, ControladorLogIngreso.LOG_DE_SESION.getId());
            result=prepStatement.executeQuery();
            while(result.next()){
                logs.add(result.getString(1));
            }
            prepStatement.close();
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return logs;
    }

}
