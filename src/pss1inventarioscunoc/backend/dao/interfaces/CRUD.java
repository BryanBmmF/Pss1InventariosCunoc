/*
 * Interfaz Generica para realizar operaciones básicas sobre un modelo
 */
package pss1inventarioscunoc.backend.dao.interfaces;

import java.util.List;

/**
 *
 * @author bryan
 * @param <Modelo>
 */
public interface CRUD <Modelo>{
        public boolean registrar(Modelo model);
        public List<Modelo> recuperarLista(char estado);
        public boolean actualizar(Modelo model,String temp);
        public boolean eliminar(Modelo model);
}
