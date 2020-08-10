/*
 * Controlador de Bienes
 */
package pss1inventarioscunoc.backend.controladores;

import java.sql.Timestamp;
import java.util.ArrayList;
import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionBien;
import pss1inventarioscunoc.backend.dao.interfaces.BienDAO;
import pss1inventarioscunoc.backend.pojos.Bien;

/**
 *
 * @author bryan
 */
public class ControladorBien {
    
    private BienDAO bienDao;
    
    public ControladorBien(){
        bienDao = new ImplementacionBien();
    }
    
    /**
     * Registra un bien, ya se de compra,de traslado o de donacion
     * devuelve false si no lo ha insertado
     * @param bien
     * @return 
     */
    public boolean registrarBien(Bien bien){ 
        return bienDao.registrar(bien);
    }
    
    /**
     * Regresa todos los bienes del sistema
     * @return 
     */
    public ArrayList<Bien> consultarBienes(){
        return (ArrayList<Bien>)bienDao.recuperarLista();
    }
    
    /**
     * Regresa todos los bienes por DONACION del sistema,
     * null si existiera un error
     * @return 
     */
    public ArrayList<Bien> consultarBienDonacion(){
        return (ArrayList<Bien>)bienDao.consultarBienDonacion();
    }

    /**
     * Regresa todos los bienes por TRASLADO del sistema,
     * null si existiera un error
     * @return 
     */
    public ArrayList<Bien> consultarBienTraslado(){
        return (ArrayList<Bien>)bienDao.consultarBienTraslado();
    }
   /**
     * Regresa todos los bienes por COMPRA del sistema,
     * null si existiera un error
     * @return 
     */
    public ArrayList<Bien> consultarBienCompra(){
        return (ArrayList<Bien>)bienDao.consultarBienCompra();
    }
    /**
     * Se traslada un bien ya existente
     * @param cur
     * @param fecha
     * @param autorizacion
     * @param seccion
     * @param persona_que_recibio
     * @return 
     */
    public boolean trasladarBien(String cur, Timestamp fecha, String autorizacion, String seccion, String persona_que_recibio){
        return bienDao.trasladarBien(cur, fecha, autorizacion, seccion, persona_que_recibio);
    }
}
