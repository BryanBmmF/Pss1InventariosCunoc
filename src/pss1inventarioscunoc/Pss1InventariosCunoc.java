/*
 * Clase principal del sistema
 */
package pss1inventarioscunoc;

import java.sql.Timestamp;
import java.util.ArrayList;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import pss1inventarioscunoc.backend.controladores.ControladorLogIngreso;
import pss1inventarioscunoc.backend.controladores.ControladorUser;
import pss1inventarioscunoc.backend.pojos.LogIngreso;
import pss1inventarioscunoc.backend.pojos.Usuario;
import pss1inventarioscunoc.frontend.vistas.VentanaRegistro;
import pss1inventarioscunoc.frontend.vistas.VentanaSesion;

/**
 *
 * @author bryan
 */
public class Pss1InventariosCunoc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        VentanaSesion ventanaLogin = new VentanaSesion();
        ventanaLogin.setVisible(true);

    }

}
