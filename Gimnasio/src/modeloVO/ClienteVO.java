/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

import java.util.Date;

/**
 *
 * @author Claudia
 */
public class ClienteVO {
    
     String nombre;
    String apellido;
    String cedula;
    String direccion;
    String telefono;
    Date fechaIngreso;
    
    public ClienteVO() {
        this.nombre= "";
        this.apellido = "";
    this.cedula = "";
    this.direccion = "";
    this.telefono = "";
   this.fechaIngreso = new Date();
        
    }

    @Override
    public String toString() {
        return "ClienteVO{" + "nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", direccion=" + direccion + ", telefono=" + telefono + ", fechaIngreso=" + fechaIngreso + '}';
    }

    public ClienteVO(String nombre, String apellido, String cedula, String direccion, String telefono, Date fechaIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    
}
