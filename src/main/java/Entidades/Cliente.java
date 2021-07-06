/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author jarol
 */
public class Cliente {
    private String nombre;
    private Integer cedula;
    private String codigo;
    private Integer clave;
    private Integer fondos;

    public Cliente() {
    }
    
    public Cliente(String nombre, Integer cedula, String codigo, Integer clave) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.codigo = codigo;
        this.clave = clave;
        this.fondos=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public Integer getFondos() {
        return fondos;
    }

    public void setFondos(Integer fondos) {
        this.fondos = fondos;
    }

    
    
}
