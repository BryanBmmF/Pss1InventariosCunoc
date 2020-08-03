/*
 * Clase controlador de LogIngreso
 */
package pss1inventarioscunoc.backend.controladores;

import pss1inventarioscunoc.backend.dao.implementaciones.ImplementacionLogIngreso;
import pss1inventarioscunoc.backend.dao.interfaces.LogIngresoDAO;
import pss1inventarioscunoc.backend.pojos.LogIngreso;

/**
 *
 * @author jesfrin
 */
public class ControladorLogIngreso {
    
    public static LogIngreso LOG_DE_SESION;
    private LogIngresoDAO log;
    
    public ControladorLogIngreso(){
        log = new ImplementacionLogIngreso();
    }
    
    /**
     * Permite el registro de un log Ingreso al sistema
     * @param logINgreso
     * @return 
     */
    public boolean registrar(LogIngreso logINgreso){
        boolean registro=log.registrar(logINgreso);
        //Busqueda de id de log anterior
        ControladorLogIngreso.LOG_DE_SESION.setId(this.buscarIdLogINgreso());
        return registro;
        
    }
    
    /**
     * Busca el id del ultimo Log de Ingreso creado
     * Devuelve -1si existiese un error
     * @return 
     */
    public int buscarIdLogINgreso(){
        return log.busquedaDeLogEvento();
    }
    
}
