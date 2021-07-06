/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Dao.CajeroDao;
import Dao.CajeroMemoria;
import Dao.ClienteDao;
import Dao.ClienteMemoria;
import Entidades.Cliente;
import excepcion.excepcion;

/**
 *
 * @author jarol
 */
public class Facade{
    private final CajeroDao cajeroDao;
    private final ClienteDao clienteDao;

    public Facade(){
        cajeroDao =new CajeroMemoria();
        clienteDao= new ClienteMemoria();
    }
    public void CrearCajeroFacade(String codigo){
        cajeroDao.crearCajero(codigo);
    }
    public Integer[] retiroCompleto(String codigoCajero,Integer monto,String codigo,Integer clave) throws excepcion {
        if(clienteDao.Retirar(codigo, clave, monto)){
            return cajeroDao.DescontarBilletes(codigoCajero, monto);
        }
        return null;
    }
    public void AumentarBilletesFacade(String codigoCajero,Integer Cant2,Integer Cant5,Integer Cant10,Integer Cant20,Integer Cant50) {
        cajeroDao.AumentarBilletes(codigoCajero, Cant2, Cant5, Cant10, Cant20, Cant50);
    }
    public void CrearClienteFacade(String nombre,Integer cedula,String codigo,Integer clave) {
        clienteDao.CrearCliente(nombre,cedula,codigo, clave);
    }
    public Integer ConsultarSaldoClienteFacade(String codigo,Integer clave){
        return clienteDao.ConsultarSaldo(codigo, clave);
    }
    public void ConsignarFacade(String codigo,Integer consignacion) {
        clienteDao.AgregarSaldo(codigo, consignacion);
    }
    
    
}
