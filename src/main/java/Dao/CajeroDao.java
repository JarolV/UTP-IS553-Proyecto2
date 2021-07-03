/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.Cajero;
import excepcion.excepcion;

/**
 *
 * @author jarol
 */
public interface CajeroDao {
    void crearCajero(String codigo);
    int[] DescontarBilletes(String codigoCajero,int monto) throws excepcion;
    void AumentarBilletes(String codigoCajero,int Cant2,int Cant5,int Cant10,int Cant20,int Cant50);
}
