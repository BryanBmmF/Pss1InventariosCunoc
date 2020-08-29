/*
 * Interfaz de Encargado DAO
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import java.util.List;
import pss1inventarioscunoc.backend.pojos.Encargado;

/**
 *
 * @author bryan
 */
public interface EncargadoDAO extends CRUD<Encargado>{
    
    public List<String> recuperarListaCargos();
    public List<String> recuperarListaDivisiones();
    public static final String INSERTAR_ENCARGADO="INSERT INTO ENCARGADO (id_encargado,nombre,"
            + "apellido,cargo,division,estado) VALUES(?,?,?,?,?,?)";
    public static final String CONSULTAR_ENCARGADOS="SELECT * FROM ENCARGADO";
    public static final String ACTUALIZAR_ENCARGADO="UPDATE ENCARGADO SET nombre = ?, "
            + "apellido = ?, cargo = ?, division = ?, estado = ? WHERE id_encargado = ?";
    public static final String CONSULTAR_CARGOS = "SELECT cargo FROM ENCARGADO GROUP BY cargo";
    public static final String CONSULTAR_DIVISIONES = "SELECT division FROM ENCARGADO GROUP BY division";
    
}
