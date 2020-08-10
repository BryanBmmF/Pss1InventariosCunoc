/*
 * Clase principal del sistema
 */
package pss1inventarioscunoc;

import java.sql.Timestamp;
import java.util.ArrayList;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import pss1inventarioscunoc.backend.controladores.ControladorFactura;
import pss1inventarioscunoc.backend.controladores.ControladorInventario;
import pss1inventarioscunoc.backend.controladores.ControladorLogIngreso;
import pss1inventarioscunoc.backend.controladores.ControladorProveedor;
import pss1inventarioscunoc.backend.controladores.ControladorUser;
import pss1inventarioscunoc.backend.pojos.Factura;
import pss1inventarioscunoc.backend.pojos.LogIngreso;
import pss1inventarioscunoc.backend.pojos.Proveedor;
import pss1inventarioscunoc.backend.pojos.Usuario;
import pss1inventarioscunoc.frontend.vistas.VentanaInicio;
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

//        VentanaInicio ventanaInicio = new VentanaInicio(); ventanaInicio.setVisible(true);
        VentanaSesion ventanaLogin = new VentanaSesion();
        ventanaLogin.setVisible(true);
        
        //Recuperacion de Inventarios
        ControladorInventario crIn = new ControladorInventario();
        crIn.buscarInventario();
        System.out.println(ControladorInventario.INVENTARIO_CONTABILIDAD);
        
        //Ingreso de proveedores
        ControladorProveedor crPro = new ControladorProveedor();
        //boolean in=crPro.registrar(new Proveedor("Los emparedados", "776589-10", "Zona 25", "Venta de comida", "losEMparedados.com"));
        //crPro.registrar(new Proveedor("Intelaf", "776589-8", "Zona 8 -25", "Venta de tecnologia", "intelaf.com"));
        //System.out.println("ProveedorInsertado:"+in);

        //Listado de proveedores
        System.out.println("BUSQUEDA DE TODOS LOS PROVEEDORS");
        for (Proveedor proveedor : crPro.buscarProveedores()) {
            System.out.println(proveedor);
        }
        
        //Filtrado de proveedores por nombre
        System.out.println("\n\n\nBUSCANDO POR NOMBRE:"+"lucitas");
        for (Proveedor proveedor : crPro.buscarProveedoresPorNombre("lucitas")) {
            System.out.println(proveedor);
        }
        //Filtrado de proveedores por direccion
                //Filtrado de proveedores por nombre
        System.out.println("\n\n\nBUSCANDO POR DIRECCION:"+"8");
        for (Proveedor proveedor : crPro.buscarProveedoresPorDireccion("8")) {
            System.out.println(proveedor);
        }
        //Filtrado de proveedores por descripcion
        System.out.println("\n\n\nBUSCANDO POR DESCRIPCION:"+"Muebles");
        Proveedor prov =null;
        for (Proveedor proveedor : crPro.buscarProveedoresPorDescripcion("Muebles")) {
            System.out.println(proveedor);
            prov=proveedor;
        }
    
        //Ingreso de facturas
        System.out.println("Ingresando factura");
        ControladorFactura crFactura = new ControladorFactura();
        boolean fac=crFactura.registrar(new Factura(prov.getIdProveedor(), 1, new Timestamp(System.currentTimeMillis()), "COmpra de materiales", 58.5));
        System.out.println("FACTURA INSERTADA:"+fac);
    }

}
