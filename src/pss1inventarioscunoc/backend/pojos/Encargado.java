/*
 * Objeto de negocio Encargado
 */
package pss1inventarioscunoc.backend.pojos;

/**
 *
 * @author bryan
 */
public class Encargado {
    
    private int id;
    private String nombre;
    private String apellido;
    private String cargo;
    private String division;

    public Encargado(int id, String nombre, String apellido, String cargo, String division) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
}
