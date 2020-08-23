/*
 * Clase principal del sistema
 */
package pss1inventarioscunoc;

import java.sql.Timestamp;
import java.util.ArrayList;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import pss1inventarioscunoc.backend.controladores.ControladorBien;
import pss1inventarioscunoc.backend.controladores.ControladorFactura;
import pss1inventarioscunoc.backend.controladores.ControladorInventario;
import pss1inventarioscunoc.backend.controladores.ControladorLogIngreso;
import pss1inventarioscunoc.backend.controladores.ControladorProveedor;
import pss1inventarioscunoc.backend.controladores.ControladorUser;
import pss1inventarioscunoc.backend.enums.TipoDeBien;
import pss1inventarioscunoc.backend.pojos.Bien;
import pss1inventarioscunoc.backend.pojos.Factura;
import pss1inventarioscunoc.backend.pojos.Inventario;
import pss1inventarioscunoc.backend.pojos.LogIngreso;
import pss1inventarioscunoc.backend.pojos.Proveedor;
import pss1inventarioscunoc.backend.pojos.Usuario;
import pss1inventarioscunoc.frontend.vistas.VentanaInicio;
import pss1inventarioscunoc.frontend.sesion.VentanaRegistro;
import pss1inventarioscunoc.frontend.sesion.VentanaSesion;

/**
 *
 * @author bryan
 */
public class Pss1InventariosCunoc {

    /**
     * @param args the command line arguments
     */
    public static Inventario inventario;
    public static void main(String[] args) {
        /*IMPORTANTE, ACTUALIZAR LA BD: campos num de tablas DONACION Y TRASLADO  a autoincrement*/

        //NO ELIMINAR-> ES EL INVENTARIO
        ControladorInventario con = new ControladorInventario();
        inventario = con.buscarInventario();
        VentanaSesion ventanaLogin = new VentanaSesion();
        ventanaLogin.setVisible(true);
       
//
//        //Recuperacion de Inventarios
//        ControladorInventario crIn = new ControladorInventario();
//        crIn.buscarInventario();
//        System.out.println(ControladorInventario.INVENTARIO_CONTABILIDAD);
//
//        //Ingreso de proveedores
//      ControladorProveedor crPro = new ControladorProveedor();
//        //boolean in=crPro.registrar(new Proveedor("Los emparedados", "776589-10", "Zona 25", "Venta de comida", "losEMparedados.com"));
//        //crPro.registrar(new Proveedor("Intelaf", "776589-8", "Zona 8 -25", "Venta de tecnologia", "intelaf.com"));
//        //System.out.println("ProveedorInsertado:"+in);
//
//        //Modificando un Proveedor
//         crPro.modificarProveedor(new Proveedor(1, "Nombre cambio", "7777441", "Direccion cambio", "descripcion cambio", "correo@cambio"));

//        //Listado de proveedores
//        System.out.println("BUSQUEDA DE TODOS LOS PROVEEDORS");
//        for (Proveedor proveedor : crPro.buscarProveedores()) {
//            System.out.println(proveedor);
//        }
//
//        //Filtrado de proveedores por nombre
//        System.out.println("\n\n\nBUSCANDO POR NOMBRE:" + "lucitas");
//        for (Proveedor proveedor : crPro.buscarProveedoresPorNombre("lucitas")) {
//            System.out.println(proveedor);
//        }
//        //Filtrado de proveedores por direccion
//        //Filtrado de proveedores por nombre
//        System.out.println("\n\n\nBUSCANDO POR DIRECCION:" + "8");
//        for (Proveedor proveedor : crPro.buscarProveedoresPorDireccion("8")) {
//            System.out.println(proveedor);
//        }
//        //Filtrado de proveedores por descripcion
//        System.out.println("\n\n\nBUSCANDO POR DESCRIPCION:" + "Muebles");
//        Proveedor prov = null;
//        for (Proveedor proveedor : crPro.buscarProveedoresPorDescripcion("Muebles")) {
//            System.out.println(proveedor);
//            prov = proveedor;
//        }
//        //08/08/20  
//        //Ingreso de facturas
//        System.out.println("Ingresando factura");
//        ControladorFactura crFactura = new ControladorFactura();
//        boolean fac = crFactura.registrar(new Factura(prov.getIdProveedor(), 2, new Timestamp(System.currentTimeMillis()), "COmpra de materiales", 58.5));
//        System.out.println("FACTURA INSERTADA:" + fac);
//
//        //Busqueda de facturas
//        System.out.println("Buscando TODAS las facturas");
//        for (Factura factura : crFactura.buscarFacturas()) {
//            System.out.println(factura);
//        }
//
//        //Buscando factura por proveedor
//        System.out.println("------------------------------FACTURA POR PROVEEDOR: LAS-----------------------");
//        for (Factura factura : crFactura.buscarFacturas("Los")) {
//            System.out.println(factura);
//        }
//
//        //Timestamp = java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0");
//        Timestamp fechaInicial = Timestamp.valueOf("2020-08-06 00:00:00");
//        Timestamp fechaFinal = Timestamp.valueOf("2020-08-09 00:00:00");
//
//        //Buscando facturas por fecha
//        System.out.println("\n\n\n-----------------------------FACTURAAS ENTRE LAS FECHAS: '2020-08-06 00:00:00' AND '2020-09-08 00:00:00'------------");
//        for (Factura factura : crFactura.buscarFacturas(fechaInicial, fechaFinal)) {
//            System.out.println(factura);
//        }
        //Ingreso de bienes;
//        //Bien normal
        //       ControladorBien crBien = new ControladorBien();
//        crBien.registrarBien(new Bien("curpk1", 1, "Procencia", '1', "Primer bien prueba", TipoDeBien.COMPRA, 589.25, "Ciencias de la ingenieria"));
//        //Bien por donacion
//        crBien.registrarBien(new Bien("curpk2", 1, "Procencia2", '1', "Segun bien prueba", TipoDeBien.DONACION, 1000.25, "Mi division", 12, "punto", 10));
//        //Bien por traslado
//        crBien.registrarBien(new Bien("curpk3", 1, "Procedencia2", '1', "Otra descripcion", TipoDeBien.TRASLADO, 125.99, "Mo otra division", new Timestamp(System.currentTimeMillis()), '1', "Seccion", "Persona"));
//        crBien.registrarBien(new Bien("curpk4", 1, "Procencia", '1', "Primer bien prueba", TipoDeBien.COMPRA, 589.25, "Ciencias de la ingenieria"));
//        //Bien por donacion
//        crBien.registrarBien(new Bien("curpk5", 1, "Procencia2", '1', "Segun bien prueba", TipoDeBien.DONACION, 1000.25, "Mi division", 12, "punto", 10));
//        //Bien por traslado
//        crBien.registrarBien(new Bien("curpk6", 1, "Procedencia2", '1', "Otra descripcion", TipoDeBien.TRASLADO, 125.99, "Mo otra division", new Timestamp(System.currentTimeMillis()), '1', "Seccion", "Persona"));
//        crBien.registrarBien(new Bien("curpk7", 1, "Procencia", '1', "Primer bien prueba", TipoDeBien.COMPRA, 589.25, "Ciencias de la ingenieria"));
//        //Bien por donacion
//        crBien.registrarBien(new Bien("curpk8", 1, "Procencia2", '1', "Segun bien prueba", TipoDeBien.DONACION, 1000.25, "Mi division", 12, "punto", 10));
//        //Bien por traslado
//        crBien.registrarBien(new Bien("curpk9", 1, "Procedencia2", '1', "Otra descripcion", TipoDeBien.TRASLADO, 125.99, "Mo otra division", new Timestamp(System.currentTimeMillis()), '1', "Seccion", "Persona"));
//    
//        
        //Consulta de bienes 
//        System.out.println("-------------------------------BIENES POR COMPRA-----------------------------");
//        for (Bien bien : crBien.consultarBienCompra()) {
//            System.out.println(bien);
//        }
//
//        for (Bien bien : crBien.consultarBienes()) {
//            System.out.println(bien);
//        }
        //Trasladando un bien ya existente
        //     crBien.trasladarBien("curpk3", new Timestamp(System.currentTimeMillis()), "1", "Seccion jsjsjs", "Otra persona");
   
    
    }
    
    
    /*
   
DELIMITER $$ 
CREATE PROCEDURE actualizar_bien_compra (IN cur_antiguo VARCHAR(45), IN cur_nuevo VARCHAR(45), IN id_factura INTEGER,
	IN proced VARCHAR(45), IN est CHAR(1), IN descrip VARCHAR(70), IN tip VARCHAR(30), IN val DOUBLE, IN divis VARCHAR(70), IN inventario INTEGER)
BEGIN 
		-- hacemos el delete del registro de en inventario
        DELETE FROM REGISTRO_BIEN_INVENTARIO WHERE cur_bien=cur_antiguo;
        
		-- hacemos el update
        UPDATE BIEN SET cur = cur_nuevo, id_Factura=id_factura,Procedencia=proced,estado = est,Descripcion=descrip
			,tipo=tip,valor=val,division=divis WHERE cur=cur_antiguo; 
        
        -- insertamos nuevamente el registro en inventario
        INSERT INTO REGISTRO_BIEN_INVENTARIO VALUES(inventario,cur_nuevo);
 
END$$ 
DELIMITER ;


DELIMITER $$ 
CREATE PROCEDURE actualizar_bien_donacion (IN cur_antiguo VARCHAR(45), IN cur_nuevo VARCHAR(45), IN id_factura INTEGER,
	IN proced VARCHAR(45), IN est CHAR(1), IN descrip VARCHAR(70), IN tip VARCHAR(30), IN val DOUBLE, IN divis VARCHAR(70),
		IN correlativ INTEGER, IN punt VARCHAR(45), IN num_acta INTEGER,  IN inventario INTEGER)
BEGIN 
		-- hacemos el delete del registro de en inventario
        DELETE FROM REGISTRO_BIEN_INVENTARIO WHERE cur_bien=cur_antiguo;
        
        -- hacemos el delete del registro en donacion
        DELETE FROM DONACION WHERE cur_bien=cur_antiguo;
        
		-- hacemos el update
        UPDATE BIEN SET cur = cur_nuevo, id_Factura=id_factura,Procedencia=proced,estado = est,Descripcion=descrip
			,tipo=tip,valor=val,division=divis WHERE cur=cur_antiguo; 
        
        -- insertamos nuevamente el registro en inventario
        INSERT INTO REGISTRO_BIEN_INVENTARIO VALUES(inventario,cur_nuevo);
        
        -- insertamos nuevamente el registro en donacion
        INSERT INTO DONACION VALUES(null,correlativ,punt,num_acta,cur_nuevo);
 
END$$ 
DELIMITER ;


DELIMITER $$ 
CREATE PROCEDURE actualizar_bien_traslado (IN cur_antiguo VARCHAR(45), IN cur_nuevo VARCHAR(45), IN id_factura INTEGER,
	IN proced VARCHAR(45), IN est CHAR(1), IN descrip VARCHAR(70), IN tip VARCHAR(30), IN val DOUBLE, IN divis VARCHAR(70),
		IN fech TIMESTAMP, IN autoriz CHAR(1), IN secc VARCHAR(45), IN encargado VARCHAR(45),   IN inventario INTEGER)
BEGIN 
		-- hacemos el delete del registro de en inventario
        DELETE FROM REGISTRO_BIEN_INVENTARIO WHERE cur_bien=cur_antiguo;
        
        -- hacemos el delete del registro en donacion
        DELETE FROM TRASLADO WHERE cur_bien=cur_antiguo;
        
		-- hacemos el update
        UPDATE BIEN SET cur = cur_nuevo, id_Factura=id_factura,Procedencia=proced,estado = est,Descripcion=descrip
			,tipo=tip,valor=val,division=divis WHERE cur=cur_antiguo; 
        
        -- insertamos nuevamente el registro en inventario
        INSERT INTO REGISTRO_BIEN_INVENTARIO VALUES(inventario,cur_nuevo);
        
        -- insertamos nuevamente el registro en donacion
        INSERT INTO TRASLADO VALUES(null,cur_nuevo,fech,autoriz,secc,encargado);
 
END$$ 
DELIMITER ;
    
    */

    public static Inventario getInventario() {
        return inventario;
    }

    public static void setInventario(Inventario inventario) {
        Pss1InventariosCunoc.inventario = inventario;
    }
    
    

}
