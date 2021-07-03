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
    public int [] retiroCompleto(String codigoCajero,int monto,String codigo,int clave) throws excepcion {
        if(clienteDao.Retirar(codigo, clave, monto)){
            return cajeroDao.DescontarBilletes(codigoCajero, monto);
        }
        return null;
    }
    public void AumentarBilletesFacade(String codigoCajero,int Cant2,int Cant5,int Cant10,int Cant20,int Cant50) {
        cajeroDao.AumentarBilletes(codigoCajero, Cant2, Cant5, Cant10, Cant20, Cant50);
    }
    public void CrearClienteFacade(String codigo,int clave) {
        clienteDao.CrearCliente(codigo, clave);
    }
    public int ConsultarSaldoClienteFacade(String codigo,int clave){
        return clienteDao.ConsultarSaldo(codigo, clave);
    }
    public void ConsignarFacade(String codigo,int consignacion) {
        clienteDao.AgregarSaldo(codigo, consignacion);
    }
    
    
}
