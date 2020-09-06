/*
 * Implementacion de clase Inventario
 */
package pss1inventarioscunoc.backend.dao.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pss1inventarioscunoc.backend.bd.Conexion;
import pss1inventarioscunoc.backend.controladores.ControladorInventario;
import pss1inventarioscunoc.backend.dao.interfaces.InventarioDAO;
import pss1inventarioscunoc.backend.enums.TipoDeBien;
import pss1inventarioscunoc.backend.pojos.Bien;
import pss1inventarioscunoc.backend.pojos.Inventario;

/**
 *
 * @author bryan
 */
public class ImplementacionInventario implements InventarioDAO {

    private PreparedStatement prepStatement;
    private ResultSet result;

    @Override
    public boolean registrar(Inventario model) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(INSERTAR_INVENTARIO);
            prepStatement.setTimestamp(1, model.getFechaInicio());
            prepStatement.setString(2, model.getDescripcion());
            prepStatement.setString(3, model.getUnidadAcademica());
            prepStatement.setTimestamp(4, model.getFechaFinalizacion());
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * SE RECUPERAN TODOS LOS INVENTARIOS CREADOS
     *
     * @return
     */
    @Override
    public List<Inventario> recuperarLista(char estado) {
        LinkedList<Inventario> lista = new LinkedList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(RECUPERAR_INVENTARIOS);
            result = prepStatement.executeQuery();
            while (result.next()) {
                lista.add(new Inventario(result.getInt(1), result.getTimestamp(2), result.getString(3), result.getString(4), result.getTimestamp(5)));
            }
            prepStatement.close();
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return lista;
    }

    /**
     * Permite actualizar los elementos de un inventario
     *
     * @param model
     * @param temp
     * @return
     */
    @Override
    public boolean actualizar(Inventario model, String temp) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(MODIFICAR_INVENTARIO);
            prepStatement.setTimestamp(1, model.getFechaInicio());
            prepStatement.setString(2, model.getDescripcion());
            prepStatement.setString(3, model.getUnidadAcademica());
            prepStatement.setTimestamp(4, model.getFechaFinalizacion());
            prepStatement.setInt(5, model.getNumero());
            prepStatement.executeUpdate();
            prepStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean eliminar(Inventario model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Inventario buscarInventario() {
        Inventario inventarioEncontrado;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_INVENTARIO);
            prepStatement.setInt(1, 1);
            result = prepStatement.executeQuery();
            result.next();
            inventarioEncontrado = new Inventario(result.getInt(1), result.getTimestamp(2), result.getString(3), result.getString(4), result.getTimestamp(5));
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return inventarioEncontrado;
    }

    /**
     * Permite asociar un bien con su inventario
     *
     * @param bien
     * @return
     */
    @Override
    public boolean insertarRegistroBienInventario(Bien bien) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(INSERTAR_REGISTRO_BIEN_INVENTARIO);
            prepStatement.setInt(1, ControladorInventario.INVENTARIO_ACTUAL.getNumero());
            prepStatement.setString(2, bien.getCur());
            System.out.println("Bien_Inventario:\n\n" + prepStatement.toString() + "\n" + "\n");
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

    }

    /**
     * Se consulta el total de inventario activo, -1 si existiera error
     *
     * @param inventario
     * @return
     */
    @Override
    public double consultarTotalDeInventarioActivo(Inventario inventario) {
        double valorTotal = -1;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_TOTAL_DE_INVENTARIO);
            prepStatement.setString(1, "1");
            prepStatement.setInt(2, inventario.getNumero());
            System.out.println(prepStatement.toString());
            result = prepStatement.executeQuery();
            while (result.next()) {
                valorTotal = result.getDouble(1);
            }
            prepStatement.close();
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return valorTotal;
    }

    /**
     * Se consulta el total de inventario de baja, -1 si existiera error
     *
     * @param inventario
     * @return
     */
    @Override
    public double consultarTotalDeInventarioDeBaja(Inventario inventario) {
        double valorTotal = -1;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_TOTAL_DE_INVENTARIO);
            prepStatement.setString(1, "0");
            prepStatement.setInt(2, inventario.getNumero());
            result = prepStatement.executeQuery();
            while (result.next()) {
                valorTotal = result.getDouble(1);
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return valorTotal;
    }

    /**
     * Suma todos los bienes activos de algun inventario
     *
     * @param numeroDeInventario
     * @return
     */
    @Override
    public int sumarTodosLosBienesActivosDeInventario(int numeroDeInventario) {
        int total = 0;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(SUMA_DE_BIENES_ACTIVOS_DE_INVENTARIO);
            prepStatement.setInt(1, numeroDeInventario);
            result = prepStatement.executeQuery();
            while (result.next()) {
                total = result.getInt(1);
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return total;
    }

    /**
     * Suma todos los bienes de baja de algun inventario
     *
     * @param numeroDeInventario
     * @return
     */
    @Override
    public int sumarTodosLosBienesDeBajaDeUnInventario(int numeroDeInventario) {
        int total = 0;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(SUMA_DE_BIENES_DE_BAJA_DE_INVENTARIO);
            prepStatement.setInt(1, numeroDeInventario);
            result = prepStatement.executeQuery();
            while (result.next()) {
                total = result.getInt(1);
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return total;
    }

    /**
     * Suma los bienes del tipo que se especifique y de un inventario especifico
     *
     * @param numeroDeInventario
     * @param tipo
     * @return
     */
    @Override
    public int sumarBienesActivosPorTipo(int numeroDeInventario, TipoDeBien tipo) {
        int total = 0;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(SUMA_DE_BIENES_DE_INVENTARIO);
            prepStatement.setInt(1, 1);
            prepStatement.setString(2, tipo.toString().toLowerCase());
            prepStatement.setInt(3, numeroDeInventario);
            result = prepStatement.executeQuery();
            while (result.next()) {
                total = result.getInt(1);
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return total;
    }

    /**
     * Suma los bienes del tipo que se especifique y de un inventario especifico
     *
     * @param numeroDeInventario
     * @param tipo
     * @return
     */
    @Override
    public int sumarBienesDeBajaPorTipo(int numeroDeInventario, TipoDeBien tipo) {
        int total = 0;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(SUMA_DE_BIENES_DE_INVENTARIO);
            prepStatement.setInt(1, 0);
            prepStatement.setString(2, tipo.toString().toLowerCase());
            prepStatement.setInt(3, numeroDeInventario);
            result = prepStatement.executeQuery();
            while (result.next()) {
                total = result.getInt(1);
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return total;
    }

    @Override
    public LinkedList<Inventario> buscarInventariosPorDescripcion(String descripcion) {
        LinkedList<Inventario> listaDeInventarios = new LinkedList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(BUSQUEDA_DE_INVENTARIO_POR_DESCRIPCION);
            prepStatement.setString(1, "%"+descripcion+"%");
            System.out.println(prepStatement.toString());
            result = prepStatement.executeQuery();
            while (result.next()) {
                listaDeInventarios.add(new Inventario(result.getInt(1), result.getTimestamp(2), result.getString(3), result.getString(4), result.getTimestamp(5)));
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaDeInventarios;
    }

    @Override
    public LinkedList<Inventario> buscarInventarioPorFecha(Timestamp fechaInicio, Timestamp fechaFinal) {
        LinkedList<Inventario> listaDeInventarios = new LinkedList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(BUSQUEDA_DE_INVENTARIO_POR_FECHAS);
            prepStatement.setTimestamp(1, fechaInicio);
            prepStatement.setTimestamp(2, fechaFinal);
            result = prepStatement.executeQuery();
            while (result.next()) {
                listaDeInventarios.add(new Inventario(result.getInt(1), result.getTimestamp(2), result.getString(3), result.getString(4), result.getTimestamp(5)));
            }
            result.close();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaDeInventarios;
    }

}
