/*
 * Clase de implementación de un usuario
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
import pss1inventarioscunoc.backend.dao.interfaces.UsuarioDAO;
import pss1inventarioscunoc.backend.pojos.Usuario;

/**
 *
 * @author bryan
 */
public class ImplementacionUsuario implements UsuarioDAO {

    private PreparedStatement prepStatement;
    private ResultSet result;
    private List listaRecuperacion = new ArrayList();

    @Override
    public boolean registrar(Usuario model) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(INSERTAR_USUARIO);
            prepStatement.setString(1, model.getId_usuario());
            prepStatement.setString(2, model.getNombre());
            prepStatement.setString(3, model.getApellido());
            prepStatement.setString(4, model.getContrasena());
            prepStatement.setString(5, model.getEstado());
            prepStatement.setString(6, model.getTipo());
            prepStatement.setString(7, model.getCorreoElectronico());
            prepStatement.executeUpdate();
            prepStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Usuario> recuperarLista(char estado) {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_USUARIOS);
            result=prepStatement.executeQuery();
            while(result.next()){
                if (!result.getString(1).equalsIgnoreCase("superU")) { // no se carga el super usuario
                    usuarios.add(new Usuario(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
                }
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ImplementacionUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public boolean actualizar(Usuario model, String temp) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(ACTUALIZAR_USUARIO);
            prepStatement.setString(1, model.getId_usuario());
            prepStatement.setString(2, model.getNombre());
            prepStatement.setString(3, model.getApellido());
            prepStatement.setString(4, model.getContrasena());
            prepStatement.setString(5, model.getEstado());
            prepStatement.setString(6, model.getTipo());
            prepStatement.setString(7, model.getCorreoElectronico());
            prepStatement.setString(8, temp);
            prepStatement.executeUpdate();
            prepStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(Usuario model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscarUsuario(String identificacion, String contrasena){
        Usuario usuarioEncontrado=null;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_USUARIO);
            prepStatement.setString(1, identificacion);
            prepStatement.setString(2, contrasena);
            result=prepStatement.executeQuery();
            result.next();
            usuarioEncontrado = new Usuario(result.getString(1), result.getString(2), result.getString(3), contrasena, result.getString(5), result.getString(6), result.getString(7));
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            //ex.printStackTrace();
            return null;
        }
        return usuarioEncontrado;
        
    }
    
}
