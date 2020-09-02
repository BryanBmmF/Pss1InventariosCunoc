/*
 * Clase principal del sistema
 */
package pss1inventarioscunoc;

import pss1inventarioscunoc.frontend.sesion.VentanaSesion;

/**
 *
 * @author bryan
 */
public class Pss1InventariosCunoc {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        /*IMPORTANTE, ACTUALIZAR LA BD: campos num de tablas DONACION Y TRASLADO  a autoincrement*/

        VentanaSesion ventanaLogin = new VentanaSesion();
        ventanaLogin.setVisible(true);

    }
    
}
