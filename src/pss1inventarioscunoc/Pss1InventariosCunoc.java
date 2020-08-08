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
        System.out.println("\n\n\nBUSCANDO POR NOMBRE:" + "lucitas");
        for (Proveedor proveedor : crPro.buscarProveedoresPorNombre("lucitas")) {
            System.out.println(proveedor);
        }
        //Filtrado de proveedores por direccion
        //Filtrado de proveedores por nombre
        System.out.println("\n\n\nBUSCANDO POR DIRECCION:" + "8");
        for (Proveedor proveedor : crPro.buscarProveedoresPorDireccion("8")) {
            System.out.println(proveedor);
        }
        //Filtrado de proveedores por descripcion
        System.out.println("\n\n\nBUSCANDO POR DESCRIPCION:" + "Muebles");
        Proveedor prov = null;
        for (Proveedor proveedor : crPro.buscarProveedoresPorDescripcion("Muebles")) {
            System.out.println(proveedor);
            prov = proveedor;
        }

        //Ingreso de facturas
        System.out.println("Ingresando factura");
        ControladorFactura crFactura = new ControladorFactura();
        boolean fac = crFactura.registrar(new Factura(prov.getIdProveedor(), 2, new Timestamp(System.currentTimeMillis()), "COmpra de materiales", 58.5));
        System.out.println("FACTURA INSERTADA:" + fac);

        //Busqueda de facturas
        System.out.println("Buscando TODAS las facturas");
        for (Factura factura : crFactura.buscarFacturas()) {
            System.out.println(factura);
        }

        //Buscando factura por proveedor
        System.out.println("------------------------------FACTURA POR PROVEEDOR: LAS-----------------------");
        for (Factura factura : crFactura.buscarFacturas("Los")) {
            System.out.println(factura);
        }

        //Timestamp = java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0");
        Timestamp fechaInicial = Timestamp.valueOf("2020-08-06 00:00:00");
        Timestamp fechaFinal = Timestamp.valueOf("2020-08-09 00:00:00");

        //Buscando facturas por fecha
        System.out.println("\n\n\n-----------------------------FACTURAAS ENTRE LAS FECHAS: '2020-08-06 00:00:00' AND '2020-09-08 00:00:00'------------");
        for (Factura factura : crFactura.buscarFacturas(fechaInicial, fechaFinal)) {
            System.out.println(factura);
        }
    }

}
