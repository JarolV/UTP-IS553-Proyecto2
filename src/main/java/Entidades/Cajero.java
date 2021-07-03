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
public class Cajero {
    private String codigoCajero;
    private boolean estado;
    private int dosmil;
    private int cincomil;
    private int diezmil;
    private int veintemil;
    private int cincuentamil;

    public Cajero() {
    }

    public Cajero(String codigoCajero) {
        this.codigoCajero = codigoCajero;
    }
    

    public Cajero(String codigoCajero, boolean estado, int dosmil, int cincomil, int diezmil, int veintemil, int cincuentamil) {
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

    public int getDosmil() {
        return dosmil;
    }

    public void setDosmil(int dosmil) {
        this.dosmil = dosmil;
    }

    public int getCincomil() {
        return cincomil;
    }

    public void setCincomil(int cincomil) {
        this.cincomil = cincomil;
    }

    public int getVeintemil() {
        return veintemil;
    }

    public void setVeintemil(int veintemil) {
        this.veintemil = veintemil;
    }

    public int getCincuentamil() {
        return cincuentamil;
    }

    public void setCincuentamil(int cincuentamil) {
        this.cincuentamil = cincuentamil;
    }

    public int getDiezmil() {
        return diezmil;
    }

    public void setDiezmil(int diezmil) {
        this.diezmil = diezmil;
    }

    @Override
    public String toString() {
        return "Cajero{" + "codigoCajero=" + codigoCajero + ", estado=" + estado + ", dosmil=" + dosmil + ", cincomil=" + cincomil + ", diezmil=" + diezmil + ", veintemil=" + veintemil + ", cincuentamil=" + cincuentamil + '}';
    }
    
    
}
