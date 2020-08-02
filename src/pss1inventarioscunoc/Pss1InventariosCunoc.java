/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc;

import java.sql.Timestamp;
import java.util.ArrayList;
import pss1inventarioscunoc.backend.controladores.ControladorLogIngreso;
import pss1inventarioscunoc.backend.controladores.ControladorUser;
import pss1inventarioscunoc.backend.pojos.LogIngreso;
import pss1inventarioscunoc.backend.pojos.Usuario;

/**
 *
 * @author bryan
 */
public class Pss1InventariosCunoc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Creacion e insercion de usuarios
        ControladorUser contrUser = new ControladorUser();
        //contrUser.registrar(new Usuario("juanPerez", "Juan", "Perez", "1234", "estadoJ", Usuario.USUARIO_NORMAL, "jperez@gmail.com"));
        //contrUser.registrar(new Usuario("JosePedro", "Jose", "Pedro", "1234", "estadoJ", Usuario.USUARIO_NORMAL, "josePedrogmail.com"));
        
        //Busqueda de usuario INDIVIDUAL
        Usuario usuarioLogueado;
        usuarioLogueado=contrUser.buscarUsuario("juanPerez", "1234");
        ControladorUser.USUARIO_LOGUEADO=usuarioLogueado;//Se guarda el usuario logueado
        System.out.println(usuarioLogueado);
        
        //Busqueda de usuarios del SISTEMA
        ArrayList<Usuario> usuarios=(ArrayList<Usuario>)contrUser.busquedaUsuarios();
        System.out.println("USUARIOS EN EL SISTEMA");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
        
        //Registro de logIngreso
        ControladorLogIngreso controladorLog = new ControladorLogIngreso();
        ControladorLogIngreso.LOG_DE_SESION = new LogIngreso( new Timestamp(System.currentTimeMillis()), "1", ControladorUser.USUARIO_LOGUEADO.getId_usuario(), "Inicio de sesion");
        controladorLog.registrar(ControladorLogIngreso.LOG_DE_SESION);
        System.out.println("ID de log:"+ControladorLogIngreso.LOG_DE_SESION.getId());

    }

}
