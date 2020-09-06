/*
 * Interfaz de Operaciones DAO de un Usuario
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import pss1inventarioscunoc.backend.pojos.Usuario;

/**
 *
 * @author bryan
 */
public interface UsuarioDAO extends CRUD<Usuario>{
    /*Operaciones Especiales*/
    public Usuario buscarUsuario(String identificacion, String contrasena);
    
    
    /*Querys a utilizar*/
    public static final String CONSULTAR_USUARIO = "SELECT * FROM USUARIO WHERE id_usuario = ? AND contrasena = SHA(?)";
    //CRUD
    public static final String INSERTAR_USUARIO="INSERT INTO USUARIO VALUES(?,?,?,SHA(?),?,?,?)";
    public static final String CONSULTAR_USUARIOS="SELECT * FROM USUARIO";
    public static final String ACTUALIZAR_USUARIO="UPDATE USUARIO SET id_usuario=?, nombre=?,apellido =?,contrasena=?,estado=?,tipo=?,correoElectronico=? WHERE id_usuario=?";
}
