/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.backend.controladores;

import java.awt.Component;
import java.util.LinkedList;
import java.util.List;
import pss1inventarioscunoc.frontend.vistas.proveedores.ModificarProveedorJDialog;
import pss1inventarioscunoc.frontend.encargados.ManejoEncargados;
import pss1inventarioscunoc.frontend.sesion.*;
import pss1inventarioscunoc.backend.enums.GrupoVista;
import pss1inventarioscunoc.backend.enums.Vista;
import pss1inventarioscunoc.frontend.encargados.AsignacionEncargados;
import pss1inventarioscunoc.frontend.tarjetasresponsabilidad.reporteTarjetasResponsabilidad;
import pss1inventarioscunoc.frontend.vistas.*;
import pss1inventarioscunoc.frontend.vistas.bienes.*;
import pss1inventarioscunoc.frontend.vistas.facturas.*;
import pss1inventarioscunoc.frontend.vistas.proveedores.*;

/**
 *
 * @author fabricio
 */
public class ControladorVistas {
    
    public static GrupoVista defaultGroup = GrupoVista.ENCARGADOS;
    private ManejoEncargados manejoEncargados = null;
    private ModificarProveedorJDialog modificarProveedorJDialog = null;
    private VentanaInicio ventanaInicio = null;
    private VentanaRegistro ventanaRegistro = null;
    private VentanaSesion ventanaSesion = null;
    private BienesJPanel1 bienesJPanel1 = null;
    private ConsultaBienes consultaBienes = null;
    private ReporteDeBiens reporteBienes = null;
    private FacturasJPanel facturasJPanel = null;
    private ListadoDeFacturasJDialog listadoDeFacturasJDialog = null;
    private ListadoDeProveedoresJDialog listadoDeProveedoresJDialog = null;
    private ProveedorJPanel proveedorJPanel = null;
    private AsignacionEncargados asignacionEncargados = null;
    private reporteTarjetasResponsabilidad repoTarjetasResponsabilidad = null;

    public ControladorVistas() {
        this.manejoEncargados = new ManejoEncargados();
        this.bienesJPanel1 = new BienesJPanel1();
        this.consultaBienes = new ConsultaBienes();
        this.reporteBienes = new ReporteDeBiens();
        this.facturasJPanel = new FacturasJPanel();
        this.proveedorJPanel = new ProveedorJPanel();
        this.asignacionEncargados = new AsignacionEncargados();
        this.repoTarjetasResponsabilidad = new reporteTarjetasResponsabilidad();
    }
    
    public void insertIntoInicioDefaultGrupoVista(VentanaInicio vi){
        this.setPaneToTabbedPaneVentanaInicio(vi, defaultGroup);
    }
    
    public void setPaneToTabbedPaneVentanaInicio(VentanaInicio vi, GrupoVista gv){
        vi.getVentanaPrincipal().removeAll();
        if(0 == manejoEncargados.getVista().getGrupo().compareTo(gv)){
            vi.getVentanaPrincipal().add(manejoEncargados);
        }
        if (0 == bienesJPanel1.getVista().getGrupo().compareTo(gv)){
            vi.getVentanaPrincipal().add(bienesJPanel1);
        }
        if (0 == facturasJPanel.getVista().getGrupo().compareTo(gv)){
            vi.getVentanaPrincipal().add(facturasJPanel);
        }
        if (0 == proveedorJPanel.getVista().getGrupo().compareTo(gv)){
            vi.getVentanaPrincipal().add(proveedorJPanel);
        }
        if (0 == asignacionEncargados.getVista().getGrupo().compareTo(gv)){
            vi.getVentanaPrincipal().add(asignacionEncargados);
        }
        if (0 == repoTarjetasResponsabilidad.getVista().getGrupo().compareTo(gv)){
            vi.getVentanaPrincipal().add(repoTarjetasResponsabilidad);
        }
        if (0 == consultaBienes.getVista().getGrupo().compareTo(gv)){
            vi.getVentanaPrincipal().add(consultaBienes);
        }
        if (0 == reporteBienes.getVista().getGrupo().compareTo(gv)){
            vi.getVentanaPrincipal().add(reporteBienes);
        }
    }
    
    /**
     * Coloca en el Tabbed pane las clases relacionadas a encargados
     * @param vi 
     */
    public void encargadosButtonVentanaInicio(VentanaInicio vi){
        this.setPaneToTabbedPaneVentanaInicio(vi, GrupoVista.ENCARGADOS);
    }
    
    /**
     * Coloca en el Tabbed pane las clases relacionadas a reportes
     * @param vi 
     */
    public void reportesButtonVentanaInicio(VentanaInicio vi){
        this.setPaneToTabbedPaneVentanaInicio(vi, GrupoVista.REPORTES);
    }
    
    /**
     * Coloca en el Tabbed pane las clases relacionadas a bienes
     * @param vi 
     */
    public void bienesButtonVentanaInicio(VentanaInicio vi){
        this.setPaneToTabbedPaneVentanaInicio(vi, GrupoVista.BIENES);
    }
    
    /**
     * Coloca en el Tabbed pane las clases relacionadas a tarjetas de responsabilidad
     * @param vi 
     */
    public void tarjetasRespButtonVentanaInicio(VentanaInicio vi){
        this.setPaneToTabbedPaneVentanaInicio(vi, GrupoVista.TARJETAS_RESPONSABILIDAD);
    }
    
}
