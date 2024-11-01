
package models;

import java.io.Serializable;

public class Cliente implements Serializable{
    private int idCliente;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private double saldo;

    public Cliente(){
        
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public Cliente(String nombre, String apellido, String email, String telefono, double saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    public Cliente(int idCliente, String nombre, String apellido, String email, String telefono, double saldo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    public int getIdCliente() {
        return idCliente;
    }
    
    public Cliente validarFormulario() throws IllegalArgumentException{
        String regexNombre = "([A-Za-Z])";
        String regexApellido = "([A-Za-Z])";
        String regexEmail = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$";
        String regexTelefono = "(\\+54|0)?\\d{10}";
        
        if(getNombre().isEmpty() || !getNombre().matches(regexNombre)){
            throw new IllegalArgumentException("Error en el nombre");
        }    
        if(getApellido().isEmpty() || !getApellido().matches(regexApellido)){
            throw  new IllegalArgumentException("Error en el apellido");
        }
        if(getEmail().isEmpty() || !getEmail().matches(regexEmail)){
            throw new IllegalArgumentException("Error en el email");
        }
        if(getTelefono().isEmpty() || !getTelefono().matches(regexTelefono)){
            throw new IllegalArgumentException("Error en el telefono");
        }
        if( getSaldo() < 0){
            throw new IllegalArgumentException("Error en el saldo, debe ser mayor a 0");
        }
        return this;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + ", saldo=" + saldo + '}';
    }
    
    
    
}
