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
    
    public List<Usuario> busquedaUsuarios(){
        return usuarioDao.recuperarLista();
    }


}
