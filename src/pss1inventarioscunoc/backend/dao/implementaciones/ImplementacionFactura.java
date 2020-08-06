/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.backend.dao.implementaciones;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Result;
import pss1inventarioscunoc.backend.bd.Conexion;
import pss1inventarioscunoc.backend.dao.interfaces.FacturaDAO;
import pss1inventarioscunoc.backend.pojos.Factura;

/**
 *
 * @author jesfrin
 */
public class ImplementacionFactura implements FacturaDAO {

    private PreparedStatement prepStatement;
    private Result result;

    @Override
    public boolean registrar(Factura model) {
        try {
            prepStatement = Conexion.getConexion().prepareStatement(INSERTAR_FACTURA);
            prepStatement.setInt(1, model.getIdProveedor());
            prepStatement.setInt(2, model.getNumeroFactura());
            prepStatement.setTimestamp(3, model.getFecha());
            prepStatement.setString(4, model.getDescripcion());
            prepStatement.setDouble(5, model.getValor());
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Factura> recuperarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Factura model, String temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Factura model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
