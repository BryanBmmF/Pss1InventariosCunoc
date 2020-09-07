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
import pss1inventarioscunoc.frontend.encargados.ValidacionEncargados;
import pss1inventarioscunoc.frontend.sesion.*;
import pss1inventarioscunoc.backend.enums.GrupoVista;
import pss1inventarioscunoc.backend.enums.Vista;
import pss1inventarioscunoc.frontend.encargados.AsignacionEncargados;
import pss1inventarioscunoc.frontend.tarjetasresponsabilidad.*;
import pss1inventarioscunoc.frontend.vistas.*;
import pss1inventarioscunoc.frontend.vistas.bienes.*;
import pss1inventarioscunoc.frontend.vistas.facturas.*;
import pss1inventarioscunoc.frontend.vistas.inventarios.InventarioPanel;
import pss1inventarioscunoc.frontend.vistas.proveedores.*;

/**
 *
 * @author fabricio
 */
public class ControladorVistas {

    public static GrupoVista DEFAULT_GROUP = GrupoVista.ENCARGADOS;
    private ValidacionEncargados manejoEncargados = null;
    private ModificarProveedorJDialog modificarProveedorJDialog = null;
    private VentanaInicio ventanaInicio = null;
    private VentanaRegistro ventanaRegistro = null;
    private VentanaSesion ventanaSesion = null;
    private BienesJPanel1 bienesJPanel1 = null;
    private ConsultaBienes consultaBienes = null;
    private PanelBajaBienes bajaBienes = null;
    private ReporteDeBiens reporteBienes = null;
    private FacturasJPanel facturasJPanel = null;
    private ListadoDeFacturasJDialog listadoDeFacturasJDialog = null;
    private ListadoDeProveedoresJDialog listadoDeProveedoresJDialog = null;
    private ProveedorJPanel proveedorJPanel = null;
    private AsignacionEncargados asignacionEncargados = null;
    private reporteTarjetasResponsabilidad repoTarjetasResponsabilidad = null;
    private InventarioPanel inventarioPanel = null;
    private ReporteBienesTipo reporteBienesTipo = null;
    private ModificacionTarjetaResponsabilidad modificacionTarjeta = null;
    private ReporteBienesEncargado reporteBienesEncargado = null;
    private VentanaUsuarios manejoUsuarios = null;
    private reporteHistorialTarjetasResponsabilidad reporteHistorialTarjetas = null;

    public ControladorVistas() {
        this.manejoEncargados = new ValidacionEncargados();
        this.bienesJPanel1 = new BienesJPanel1();
        this.consultaBienes = new ConsultaBienes();
        this.bajaBienes = new PanelBajaBienes();
        this.reporteBienes = new ReporteDeBiens();
        this.facturasJPanel = new FacturasJPanel();
        this.proveedorJPanel = new ProveedorJPanel();
        this.asignacionEncargados = new AsignacionEncargados();
        this.repoTarjetasResponsabilidad = new reporteTarjetasResponsabilidad();
        this.inventarioPanel = new InventarioPanel();
        this.reporteBienesTipo = new ReporteBienesTipo();
        this.modificacionTarjeta = new ModificacionTarjetaResponsabilidad();
        this.reporteBienesEncargado = new ReporteBienesEncargado();
        this.manejoUsuarios = new VentanaUsuarios();
        this.reporteHistorialTarjetas = new reporteHistorialTarjetasResponsabilidad();
    }

    public void insertIntoInicioDefaultGrupoVista(VentanaInicio vi) {
        this.setPaneToTabbedPaneVentanaInicio(vi, DEFAULT_GROUP);
    }
  
    public void setPaneToTabbedPaneVentanaInicio(VentanaInicio vi, GrupoVista gv) {
        vi.getVentanaPrincipal().removeAll();
        if (0 == modificacionTarjeta.getVista().getGrupo().compareTo(gv)) {
            vi.getVentanaPrincipal().add(modificacionTarjeta);
        }
        if (0 == asignacionEncargados.getVista().getGrupo().compareTo(gv)) {
            vi.getVentanaPrincipal().add(asignacionEncargados);
        }
        if (0 == manejoEncargados.getVista().getGrupo().compareTo(gv)) {
            vi.getVentanaPrincipal().add(manejoEncargados);
        }
        if (0 == consultaBienes.getVista().getGrupo().compareTo(gv)) {
            vi.getVentanaPrincipal().add(consultaBienes);
        }
        if (0 == proveedorJPanel.getVista().getGrupo().compareTo(gv)) {
            vi.getVentanaPrincipal().add(proveedorJPanel);
        }
        if (0 == facturasJPanel.getVista().getGrupo().compareTo(gv)) {
            vi.getVentanaPrincipal().add(facturasJPanel);
        }
        //if (0 == bienesJPanel1.getVista().getGrupo().compareTo(gv)) {
        //    vi.getVentanaPrincipal().add(bienesJPanel1);
        //}
        if (0 == bajaBienes.getVista().getGrupo().compareTo(gv)) {
            vi.getVentanaPrincipal().add(bajaBienes);
        }
        if (0 == repoTarjetasResponsabilidad.getVista().getGrupo().compareTo(gv)) {
            vi.getVentanaPrincipal().add(repoTarjetasResponsabilidad);
        }
        if (0 == inventarioPanel.getVista().getGrupo().compareTo(gv)) {
            vi.getVentanaPrincipal().add(inventarioPanel);
        }
        if (0 == reporteBienes.getVista().getGrupo().compareTo(gv)) {
            vi.getVentanaPrincipal().add(reporteBienes);
        }
        if (0 == reporteBienesTipo.getVista().getGrupo().compareTo(gv)) {
            vi.getVentanaPrincipal().add(reporteBienesTipo);
        }
        if (0 == reporteBienesEncargado.getVista().getGrupo().compareTo(gv)) {
            vi.getVentanaPrincipal().add(reporteBienesEncargado);
        }
        if (0 == manejoUsuarios.getVista().getGrupo().compareTo(gv)) {
            vi.getVentanaPrincipal().add(manejoUsuarios);
        if (0 == reporteHistorialTarjetas.getVista().getGrupo().compareTo(gv)) {
            vi.getVentanaPrincipal().add(reporteHistorialTarjetas);
        }

    }

    /**
     * Coloca en el Tabbed pane las clases relacionadas a encargados
     *
     * @param vi
     */
    public void encargadosButtonVentanaInicio(VentanaInicio vi) {
        this.setPaneToTabbedPaneVentanaInicio(vi, GrupoVista.ENCARGADOS);
    }

    /**
     * Coloca en el Tabbed pane las clases relacionadas a reportes
     *
     * @param vi
     */
    public void reportesButtonVentanaInicio(VentanaInicio vi) {
        this.setPaneToTabbedPaneVentanaInicio(vi, GrupoVista.REPORTES);
    }

    /**
     * Coloca en el Tabbed pane las clases relacionadas a bienes
     *
     * @param vi
     */
    public void bienesButtonVentanaInicio(VentanaInicio vi) {
        this.setPaneToTabbedPaneVentanaInicio(vi, GrupoVista.BIENES);
    }

    /**
     * Coloca en el Tabbed pane las clases relacionadas a tarjetas de
     * responsabilidad
     *
     * @param vi
     */
    public void tarjetasRespButtonVentanaInicio(VentanaInicio vi) {
        this.setPaneToTabbedPaneVentanaInicio(vi, GrupoVista.TARJETAS_RESPONSABILIDAD);
    }

    /**
     * Coloca en el Tabbed pan las clases relacionadas a Inventario
     *
     * @param vi
     */
    public void inventarioButtonVentanaInicio(VentanaInicio vi) {
        this.setPaneToTabbedPaneVentanaInicio(vi, GrupoVista.INVENTARIOS);
    }
    
    /**
     * Coloca en el Tabbed pan las clases relacionadas a Usuarios
     *
     * @param vi
     */
    public void usuariosButtonVentanaInicio(VentanaInicio vi) {
        this.setPaneToTabbedPaneVentanaInicio(vi, GrupoVista.USUARIOS);
    }

}
