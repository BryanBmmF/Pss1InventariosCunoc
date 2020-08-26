/*
 * Implementacion de clase Proveedor
 */
package pss1inventarioscunoc.backend.dao.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pss1inventarioscunoc.backend.bd.Conexion;
import pss1inventarioscunoc.backend.dao.interfaces.ProveedorDAO;
import pss1inventarioscunoc.backend.pojos.Proveedor;

/**
 *
 * @author bryan
 */
public class ImplementacionProveedor implements ProveedorDAO {

    private PreparedStatement prepStatement;
    private ResultSet result;
    private List listaProveedores = new ArrayList();

    @Override
    public boolean registrar(Proveedor model) {

        try {
            prepStatement = Conexion.getConexion().prepareStatement(INSERTAR_PROVEEDOR);
            prepStatement.setString(1, model.getNombreDeProveedor());
            prepStatement.setString(2, model.getNit());
            prepStatement.setString(3, model.getDireccion());
            prepStatement.setString(4, model.getDescripcion());
            if (model.getCorreoElectronico() != null) {
                prepStatement.setString(5, model.getCorreoElectronico());
            } else {
                prepStatement.setString(5, "");
            }
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Proveedor> recuperarLista(char estado) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(BUSCAR_PROVEEDORES);
            result = prepStatement.executeQuery();
            while (result.next()) {
                proveedores.add(new Proveedor(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return proveedores;
    }

    @Override
    public boolean actualizar(Proveedor model, String temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Proveedor model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Devuelve los proveedores que contengan el valor de la variable 'nombre'
     *
     * @param nombre
     * @return
     */
    @Override
    public ArrayList<Proveedor> buscarProveedoresPorNombre(String nombre) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(BUSQUEDA_POR_NOMBRE);
            prepStatement.setString(1, "%" + nombre + "%");
            result = prepStatement.executeQuery();
            while (result.next()) {
                proveedores.add(new Proveedor(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return proveedores;
    }

    /**
     * Devuelve los proveedores que contengan el valor de la variable
     * 'direccion'
     *
     * @param direccion
     * @return
     */
    @Override
    public ArrayList<Proveedor> buscarProveedoresPorDireccion(String direccion) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(BUSQUEDA_POR_DIRECCION);
            prepStatement.setString(1, "%" + direccion + "%");
            result = prepStatement.executeQuery();
            while (result.next()) {
                proveedores.add(new Proveedor(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return proveedores;
    }

    /**
     * Devuelve los proveedores que contengan el valor de la variable
     * 'descripcion'
     *
     * @param descripcion
     * @return
     */
    @Override
    public ArrayList<Proveedor> buscarProveedorPorDescripcion(String descripcion) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(BUSQUEDA_POR_DESCRIPCION);
            prepStatement.setString(1, "%" + descripcion + "%");
            result = prepStatement.executeQuery();
            while (result.next()) {
                proveedores.add(new Proveedor(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return proveedores;
    }

    /**
     * Permite modificar un proveedor ya existente,
     * regresa null, si existiese un error
     * @param proveedor
     * @return 
     */
    @Override
    public boolean modificarProveedor(Proveedor proveedor) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(MODIFICAR_PROVEEDOR);
            prepStatement.setString(1, proveedor.getNombreDeProveedor());
            prepStatement.setString(2, proveedor.getNit());
            prepStatement.setString(3, proveedor.getDireccion());
            prepStatement.setString(4, proveedor.getDescripcion());
            prepStatement.setString(5, proveedor.getCorreoElectronico());
            prepStatement.setInt(6, proveedor.getIdProveedor());
            System.out.println(prepStatement);
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
