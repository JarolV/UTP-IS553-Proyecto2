/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import excepcion.excepcion;

/**
 *
 * @author jarol
 */
public class CajeroDB implements CajeroDao{

    @Override
    public void crearCajero(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer[] DescontarBilletes(String codigoCajero, Integer monto) throws excepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AumentarBilletes(String codigoCajero, Integer Cant2, Integer Cant5, Integer Cant10, Integer Cant20, Integer Cant50) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
