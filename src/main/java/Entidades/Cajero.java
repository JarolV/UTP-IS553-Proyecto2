/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jarol
 */
@Entity
@Table(name ="cajero")
public class Cajero implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="codigoCajero")
    private String codigoCajero;
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "cant2mil")
    private Integer dosmil;
    @Column(name = "cant5mil")
    private Integer cincomil;
    @Column(name = "cant10mil")
    private Integer diezmil;
    @Column(name = "cant20mil")
    private Integer veintemil;
    @Column(name = "cant50mil")
    private Integer cincuentamil;

    public Cajero() {
    }

    public Cajero(String codigoCajero) {
        this.codigoCajero = codigoCajero;
        this.estado = true;
        this.dosmil = 0;
        this.cincomil = 0;
        this.diezmil = 0;
        this.veintemil = 0;
        this.cincuentamil = 0;
    }
    

    public Cajero(String codigoCajero, boolean estado, Integer dosmil, Integer cincomil, Integer diezmil, Integer veintemil, Integer cincuentamil) {
        this.codigoCajero = codigoCajero;
        this.estado = estado;
        this.dosmil = dosmil;
        this.cincomil = cincomil;
        this.diezmil = diezmil;
        this.veintemil = veintemil;
        this.cincuentamil = cincuentamil;
    }

    public String getCodigoCajero() {
        return codigoCajero;
    }

    public void setCodigoCajero(String codigoCajero) {
        this.codigoCajero = codigoCajero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getDosmil() {
        return dosmil;
    }

    public void setDosmil(Integer dosmil) {
        this.dosmil = dosmil;
    }

    public Integer getCincomil() {
        return cincomil;
    }

    public void setCincomil(Integer cincomil) {
        this.cincomil = cincomil;
    }

    public Integer getDiezmil() {
        return diezmil;
    }

    public void setDiezmil(Integer diezmil) {
        this.diezmil = diezmil;
    }

    public Integer getVeintemil() {
        return veintemil;
    }

    public void setVeintemil(Integer veintemil) {
        this.veintemil = veintemil;
    }

    public Integer getCincuentamil() {
        return cincuentamil;
    }

    public void setCincuentamil(Integer cincuentamil) {
        this.cincuentamil = cincuentamil;
    }
    
    
}
