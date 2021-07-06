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
    Integer[] DescontarBilletes(String codigoCajero,Integer monto) throws excepcion;
    void AumentarBilletes(String codigoCajero,Integer Cant2,Integer Cant5,Integer Cant10,Integer Cant20,Integer Cant50);
}
