/*
 * Controlador de reportes
 */
package pss1inventarioscunoc.backend.controladores;

import java.util.Map;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import pss1inventarioscunoc.backend.bd.Conexion;

/**
 *
 * @author bryan
 */
public class ControladorReporte {
    
    private JasperPrint jasperPrintWindow;
    private JasperViewer jasperViewer;

    public ControladorReporte(String rutaReporte,String titulo, Map<String,Object> map) throws JRException {
        
        this.jasperPrintWindow = JasperFillManager.fillReport(
                rutaReporte, map,Conexion.getConexion());
        this.jasperViewer = new JasperViewer(jasperPrintWindow, false); //false para no cerrar ventana principal alcerrar el jasperviewer
        this.jasperViewer.setTitle(titulo);
        this.jasperViewer.setIconImage((new ImageIcon(getClass().getResource("/pss1inventarioscunoc/frontend/media/employees.png")).getImage())); 
    }
    
    public void visualizarReporte(){
        this.jasperViewer.setVisible(true);
    }

    public JasperPrint getJasperPrintWindow() {
        return jasperPrintWindow;
    }

    public void setJasperPrintWindow(JasperPrint jasperPrintWindow) {
        this.jasperPrintWindow = jasperPrintWindow;
    }

    public JasperViewer getJasperViewer() {
        return jasperViewer;
    }

    public void setJasperViewer(JasperViewer jasperViewer) {
        this.jasperViewer = jasperViewer;
    }
    
    
    
    
    
}
