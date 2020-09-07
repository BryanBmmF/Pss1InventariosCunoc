/*
 * Clase principal del sistema
 */
package pss1inventarioscunoc;

import pss1inventarioscunoc.backend.pojos.Inventario;
import pss1inventarioscunoc.frontend.sesion.VentanaSesion;



/**
 *
 * @author bryan
 */
public class Pss1InventariosCunoc {

    public static Inventario inventario;
    /**
     * @param args the command line arguments
     */

    public static Inventario inventario;
        /*IMPORTANTE, ACTUALIZAR LA BD: campos num de tablas DONACION Y TRASLADO  a autoincrement*/
    public static void main(String[] args) {
        VentanaSesion ventanaLogin = new VentanaSesion();
        ventanaLogin.setVisible(true);

    }

    public static Inventario getInventario() {
        return inventario;
    }

    public static void setInventario(Inventario inventario) {
        Pss1InventariosCunoc.inventario = inventario;
    }

}
