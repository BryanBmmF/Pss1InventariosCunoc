/*
 * Clase controlador de un usuario
 */
package pss1inventarioscunoc.backend.controladores;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionUsuario;
import pss1inventarioscunoc.backend.dao.interfaces.UsuarioDAO;
import pss1inventarioscunoc.backend.pojos.Usuario;

/**
 *
 * @author bryan
 */
public class ControladorUser {

    public static Usuario USUARIO_LOGUEADO;
    private UsuarioDAO usuarioDao;
    //Vista del cliente

    public ControladorUser() {
        usuarioDao = new ImplementacionUsuario();
    }

    /**
     * Permite el ingreso de un Usuario a la base de datos
     *
     * @param usuario
     */
    public void registrar(Usuario usuario) {
        if (usuarioDao.registrar(usuario)) {
            JOptionPane.showMessageDialog(null, "Usuario registrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido registrar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Permite buscar un usuario en especifico. Si el usuario no es encontrado
     * retornara NULL
     *
     * @param identificacion
     * @param contrasena
     * @return
     */
    public Usuario buscarUsuario(String identificacion, String contrasena) {
        return usuarioDao.buscarUsuario(identificacion, contrasena);
    }
    /**
     * Devuelve todos los usuarios en la base de datos
     * @return 
     */
    public List<Usuario> busquedaUsuarios(){
        return usuarioDao.recuperarLista();
    }
    
    /**
     * Permite validar los campos y las contraseñas ingresadas
     *
     * @param nombre
     * @param user
     * @param correo
     * @param pass1
     * @param pass2
     * @return boolean
     */
    public boolean verificarRegistro(String nombre, String user, String correo, String pass1, String pass2) {
        if (verificarCampos(nombre, user, correo, pass1, pass2)) {
            if (pass1.equals(pass2)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas ingresadas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios, porfavor completelos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    /**
     * Permite validar los campos solicitados para el registro.Si no se completa un campo retornara false
     *
     * @param campo1
     * @param campo2
     * @param campo3
     * @param campo4
     * @param campo5
     * @return boolean
     */
    public boolean verificarCampos(String campo1, String campo2, String campo3, String campo4, String campo5) {
        return !(campo1.isEmpty() ||campo2.isEmpty() || campo3.isEmpty() || campo4.isEmpty() || campo5.isEmpty());
    }
    


}
