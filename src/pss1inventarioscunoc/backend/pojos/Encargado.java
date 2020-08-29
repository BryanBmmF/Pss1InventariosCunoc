/*
 * Objeto de negocio Encargado
 */
package pss1inventarioscunoc.backend.pojos;

/**
 *
 * @author bryan
 */
public class Encargado {
    
    private long id;
    private String nombre;
    private String apellido;
    private String cargo;
    private String division;
    private String estado;

    public Encargado(long id, String nombre, String apellido, String cargo, String division,
            String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.division = division;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
