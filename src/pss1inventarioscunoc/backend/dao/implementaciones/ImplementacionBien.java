/*
 * Implementacion de la clase Bien 
 */
package pss1inventarioscunoc.backend.dao.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pss1inventarioscunoc.Pss1InventariosCunoc;
import pss1inventarioscunoc.backend.bd.Conexion;
import pss1inventarioscunoc.backend.controladores.ControladorBien;
import pss1inventarioscunoc.backend.controladores.ControladorInventario;
import pss1inventarioscunoc.backend.dao.interfaces.BienDAO;
import pss1inventarioscunoc.backend.enums.TipoDeBien;
import pss1inventarioscunoc.backend.pojos.Bien;

/**
 *
 * @author bryan
 */
public class ImplementacionBien implements BienDAO {

    private PreparedStatement prepStatement;
    private ResultSet result;

    /**
     * Ingresa un bien que si posee factura
     * @param model
     * @throws SQLException 
     */
    private void insertarBienConFactura(Bien model) throws SQLException {
        prepStatement = Conexion.getConexion().prepareStatement(REGISTRAR_BIEN);
        prepStatement.setString(1, model.getCur());
        prepStatement.setInt(2, model.getIdFactura());
        prepStatement.setString(3, model.getProcedencia());
        prepStatement.setString(4, String.valueOf(model.getEstado()));
        prepStatement.setString(5, model.getDescripcion());
        prepStatement.setString(6, model.getTipo().toString());
        prepStatement.setDouble(7, model.getValor());
        prepStatement.setString(8, model.getDivision());
        //System.out.println(prepStatement.toString());
        prepStatement.executeUpdate();
        prepStatement.close();

    }
    /**
     * Ingresa un bien que no tiene factura
     * @param model
     * @throws SQLException 
     */
    private void insertarBinSinFactura(Bien model) throws SQLException {
        prepStatement = Conexion.getConexion().prepareStatement(REGISTRAR_BIEN_SIN_FACTURA);
        prepStatement.setString(1, model.getCur());
        prepStatement.setString(2, model.getProcedencia());
        prepStatement.setString(3, String.valueOf(model.getEstado()));
        prepStatement.setString(4, model.getDescripcion());
        prepStatement.setString(5, model.getTipo().toString());
        prepStatement.setDouble(6, model.getValor());
        prepStatement.setString(7, model.getDivision());
        //System.out.println(prepStatement.toString());
        prepStatement.executeUpdate();
        prepStatement.close();

    }

    /**
     * Se registra un bien
     *
     * @param model
     * @return
     */
    @Override
    public boolean registrar(Bien model) {
        try {
            //Registro de bien
            if (model.getIdFactura() == ControladorBien.ID_FACTURA_INEXISTENTE) {
                insertarBinSinFactura(model);
            } else {
                insertarBienConFactura(model);
            }
            if (model.getTipo() == TipoDeBien.TRASLADO) {
                prepStatement = Conexion.getConexion().prepareStatement(REGISTRAR_BIEN_TRASLADO);
                prepStatement.setString(1, model.getCur());
                prepStatement.setTimestamp(2, model.getFecha());
                prepStatement.setString(3, String.valueOf(model.getAutorizacion()));
                prepStatement.setString(4, model.getSeccion());
                prepStatement.setString(5, model.getPersonaQueRecibio());
                System.out.println(prepStatement.toString());
                prepStatement.executeUpdate();
                prepStatement.close();
            } else if (model.getTipo() == TipoDeBien.DONACION) {
                prepStatement = Conexion.getConexion().prepareStatement(REGISTRAR_BIEN_DONACION);
                prepStatement.setInt(1, model.getCorrelativo());
                prepStatement.setString(2, model.getPunto());
                prepStatement.setInt(3, model.getNumeroActa());
                prepStatement.setString(4, model.getCur());
                System.out.println(prepStatement.toString());
                prepStatement.executeUpdate();
                prepStatement.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Se devuelven todos los bienes
     *
     * @param estado
     * @return
     */
    @Override
    public List<Bien> recuperarLista(char estado) {
        
        /* para pruebas
        bienes.add(new Bien("cur6pk6",3,"Procedencia3",'1',"descripcion",TipoDeBien.COMPRA,200,"Ciencias Economicas"));
        bienes.add(new Bien("cur6pk6",3,"Procedencia3",'1',"descripcion",TipoDeBien.COMPRA,200,"Ciencias Economicas"));
        bienes.add(new Bien("cur6pk6",3,"Procedencia3",'1',"descripcion",TipoDeBien.COMPRA,200,"Ciencias Economicas"));
        bienes.add(new Bien("cur6pk6",3,"Procedencia3",'1',"descripcion",TipoDeBien.COMPRA,200,"Ciencias Economicas"));
        bienes.add(new Bien("cur6pk6",3,"Procedencia3",'1',"descripcion",TipoDeBien.COMPRA,200,"Ciencias Economicas"));
        bienes.add(new Bien("cur6pk6",3,"Procedencia3",'1',"descripcion",TipoDeBien.COMPRA,200,"Ciencias Economicas"));
        bienes.add(new Bien("cur6pk6",3,"Procedencia3",'1',"descripcion",TipoDeBien.COMPRA,200,"Ciencias Economicas"));
        */
        ArrayList<Bien> bienes = new ArrayList<>();
        ResultSet resAux;
        PreparedStatement prepAux;
        Bien bien;
        TipoDeBien tipo;
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_TODOS_LOS_BIENES);
            prepStatement.setString(1, String.valueOf(estado)); //enviando estado
            result = prepStatement.executeQuery();
            while (result.next()) {
                //Busco el tipo de bien    
                if (result.getString("tipo").equalsIgnoreCase(TipoDeBien.DONACION.toString())) {
                    tipo = TipoDeBien.DONACION;
                } else if (result.getString("tipo").equalsIgnoreCase(TipoDeBien.TRASLADO.toString())) {
                    tipo = TipoDeBien.TRASLADO;
                } else {
                    tipo = TipoDeBien.COMPRA;
                }
                //Lleno el bien
                bien = new Bien(result.getString(1), result.getInt(2), result.getString(3), result.getString(4).charAt(0), result.getString(5), tipo, result.getDouble(7), result.getString(8));
                if (tipo == TipoDeBien.DONACION) {
                    prepAux = Conexion.getConexion().prepareStatement(CONSULTAR_BIEN_DONACION_POR_CUR);
                    prepAux.setString(1, result.getString("cur"));
                    resAux = prepAux.executeQuery();
                    resAux.next();
                    //Le seteo las partes de donacion
                    bien.setCorrelativo(resAux.getInt(1));
                    bien.setPunto(resAux.getString(2));
                    bien.setNumeroActa(resAux.getInt(3));
                    prepAux.close();
                    resAux.close();
                } else if (tipo == TipoDeBien.TRASLADO) {
                    prepAux = Conexion.getConexion().prepareStatement(CONSULTAR_BIEN_TRASLADO_POR_CUR);
                    prepAux.setString(1, result.getString("cur"));
                    resAux = prepAux.executeQuery();
                    resAux.next();
                    //Le seteo las partes de TRASLADO
                    bien.setFecha(resAux.getTimestamp(1));
                    bien.setAutorizacion(resAux.getString(2).charAt(0));
                    bien.setSeccion(resAux.getString(3));
                    bien.setPersonaQueRecibio(resAux.getString(4));
                    prepAux.close();
                    resAux.close();
                }
                bienes.add(bien);
            }
            prepStatement.close();
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        
        return bienes;
    }
     /**
     * Se actualiza un bien
     *
     * @param model, tempCur
     * @return boolean
     */
    @Override
    public boolean actualizar(Bien model, String tempCur) {
        try {
            
            if (model.getTipo() == TipoDeBien.TRASLADO) {
                prepStatement = Conexion.getConexion().prepareStatement(ACTUALIZAR_BIEN_TRASLADO);
                prepStatement.setString(1, tempCur);
                prepStatement.setString(2, model.getCur());
                prepStatement.setInt(3, model.getIdFactura());
                prepStatement.setString(4, model.getProcedencia());
                prepStatement.setString(5, String.valueOf(model.getEstado()));
                prepStatement.setString(6, model.getDescripcion());
                prepStatement.setString(7, model.getTipo().toString());
                prepStatement.setDouble(8, model.getValor());
                prepStatement.setString(9, model.getDivision());
                prepStatement.setTimestamp(10, model.getFecha());
                prepStatement.setString(11, String.valueOf(model.getAutorizacion()));
                prepStatement.setString(12, model.getSeccion());
                prepStatement.setString(13, model.getPersonaQueRecibio());
                prepStatement.setInt(14, ControladorInventario.INVENTARIO_ACTUAL.getNumero());
                System.out.println(prepStatement.toString());
                prepStatement.executeUpdate();
                prepStatement.close();
            } else if (model.getTipo() == TipoDeBien.DONACION) {
                prepStatement = Conexion.getConexion().prepareStatement(ACTUALIZAR_BIEN_DONACION);
                prepStatement.setString(1, tempCur);
                prepStatement.setString(2, model.getCur());
                prepStatement.setInt(3, model.getIdFactura());
                prepStatement.setString(4, model.getProcedencia());
                prepStatement.setString(5, String.valueOf(model.getEstado()));
                prepStatement.setString(6, model.getDescripcion());
                prepStatement.setString(7, model.getTipo().toString());
                prepStatement.setDouble(8, model.getValor());
                prepStatement.setString(9, model.getDivision());
                prepStatement.setInt(10, model.getCorrelativo());
                prepStatement.setString(11, model.getPunto());
                prepStatement.setInt(12, model.getNumeroActa());
                prepStatement.setInt(13, ControladorInventario.INVENTARIO_ACTUAL.getNumero());
                System.out.println(prepStatement.toString());
                prepStatement.executeUpdate();
                prepStatement.close();
            } else if (model.getTipo() == TipoDeBien.COMPRA) {
                    prepStatement = Conexion.getConexion().prepareStatement(ACTUALIZAR_BIEN);
                    prepStatement.setString(1, tempCur);
                    prepStatement.setString(2, model.getCur());
                    prepStatement.setInt(3, model.getIdFactura());
                    prepStatement.setString(4, model.getProcedencia());
                    prepStatement.setString(5, String.valueOf(model.getEstado()));
                    prepStatement.setString(6, model.getDescripcion());
                    prepStatement.setString(7, model.getTipo().toString());
                    prepStatement.setDouble(8, model.getValor());
                    prepStatement.setString(9, model.getDivision());
                    prepStatement.setInt(10, ControladorInventario.INVENTARIO_ACTUAL.getNumero());
                    //System.out.println(prepStatement.toString());
                    prepStatement.executeUpdate();
                    prepStatement.close();
            }
        } catch (SQLException ex) {
            //ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(Bien model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Devuelve los bienes de donacion, null si existiera error
     *
     * @param estado
     * @return
     */
    @Override
    public ArrayList<Bien> consultarBienDonacion(char estado) {
        ArrayList<Bien> bienes = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_BIEN_POR_DONACION);
            prepStatement.setString(1, String.valueOf(estado)); //enviando estado
            result = prepStatement.executeQuery();
            while (result.next()) {
                bienes.add(new Bien(result.getString(1), result.getInt(2), result.getString(3), result.getString(4).charAt(0), result.getString(5), TipoDeBien.DONACION, result.getDouble(7), result.getString(8), result.getInt(10), result.getString(11), result.getInt(12)));
            }
            prepStatement.close();
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return bienes;
    }

    /**
     * Devuelve los bienes de traslado,null si existiera error
     *
     * @param estado
     * @return
     */
    @Override
    public ArrayList<Bien> consultarBienTraslado(char estado) {
        ArrayList<Bien> bienes = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_BIEN_POR_TRASLADO);
            prepStatement.setString(1, String.valueOf(estado)); //enviando estado
            result = prepStatement.executeQuery();
            while (result.next()) {
                bienes.add(new Bien(result.getString(1), result.getInt(2), result.getString(3), result.getString(4).charAt(0), result.getString(5), TipoDeBien.TRASLADO, result.getDouble(7), result.getString(8), result.getTimestamp(11), result.getString(12).charAt(0), result.getString(13), result.getString(14)));
            }
            prepStatement.close();
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return bienes;
    }

    @Override
    public ArrayList<Bien> consultarBienCompra(char estado) {
        ArrayList<Bien> bienes = new ArrayList<>();
        try {
            prepStatement = Conexion.getConexion().prepareStatement(CONSULTAR_BIEN_POR_COMPRA);
            prepStatement.setString(1, String.valueOf(estado)); //enviando estado
            result = prepStatement.executeQuery();
            while (result.next()) {
                bienes.add(new Bien(result.getString(1), result.getInt(2), result.getString(3), result.getString(4).charAt(0), result.getString(5), TipoDeBien.COMPRA, result.getDouble(7), result.getString(8)));
            }
            prepStatement.close();
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return bienes;
    }

    /**
     * Se ingresa un traslado, y se desactiva el anterior
     *
     * @param cur
     * @param fecha
     * @param autorizacion
     * @param seccion
     * @param persona_que_recibio
     * @return
     */
    @Override
    public boolean trasladarBien(String cur, Timestamp fecha, String autorizacion, String seccion, String persona_que_recibio) {
        try {
            //Se descativa el traslado
            prepStatement = Conexion.getConexion().prepareStatement(DESACTIVAR_TRASLADO);
            prepStatement.setString(1, cur);
            prepStatement.executeUpdate();
            //Se ingresa el nuevo traslado
            prepStatement = Conexion.getConexion().prepareStatement(TRASLADAR_BIEN);
            prepStatement.setString(1, cur);
            prepStatement.setTimestamp(2, fecha);
            prepStatement.setString(3, autorizacion);
            prepStatement.setString(4, seccion);
            prepStatement.setString(5, persona_que_recibio);
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
