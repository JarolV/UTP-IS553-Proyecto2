/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import excepcion.excepcionDatos;

/**
 *
 * @author jarol
 */
public class ClienteDB implements ClienteDao{

    @Override
    public void CrearCliente(String nombre, Integer cedula, String codigo, Integer clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Retirar(String codigo, Integer clave, Integer monto) throws excepcionDatos {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer ConsultarSaldo(String codigo, Integer clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AgregarSaldo(String codigo, Integer consignacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
