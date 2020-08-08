/*
 * Implementacion de la clase Bien 
 */
package pss1inventarioscunoc.backend.dao.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pss1inventarioscunoc.backend.bd.Conexion;
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

    @Override
    public boolean registrar(Bien model) {
        try {
            //Registro de bien
            prepStatement = Conexion.getConexion().prepareStatement(REGISTRAR_BIEN);
            prepStatement.setString(1, model.getCur());
            prepStatement.setInt(2, model.getIdFactura());
            prepStatement.setString(3, model.getProcedencia());
            prepStatement.setString(4, String.valueOf(model.getEstado()));
            prepStatement.setString(5, model.getDescripcion());
            prepStatement.setString(6, model.getTipo().toString());
            prepStatement.setDouble(7, model.getValor());
            prepStatement.setString(8, model.getDivision());
            System.out.println(prepStatement.toString());
            prepStatement.executeUpdate();
            prepStatement.close();
            if (model.getTipo() == TipoDeBien.TRASLADO) {
                prepStatement = Conexion.getConexion().prepareStatement(REGISTRAR_BIEN_TRASLADO);
                prepStatement.setString(1, model.getCur());
                prepStatement.setTimestamp(2, model.getFecha());
                prepStatement.setString(3,String.valueOf(model.getAutorizacion()));
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
        }
        return true;
    }

    @Override
    public List<Bien> recuperarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Bien model, String temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Bien model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
