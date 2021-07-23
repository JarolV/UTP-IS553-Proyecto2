/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Dao.CajeroDB;
import Dao.CajeroDao;
import Dao.CajeroMemoria;
import Dao.ClienteDB;
import Dao.ClienteDao;
import Dao.ClienteMemoria;
import excepcion.excepcionDatos;

/**
 *
 * @author jarol
 */
public class Facade{
    private final CajeroDao cajeroDao;
    private final ClienteDao clienteDao;

    public Facade(){
        cajeroDao =new CajeroDB();
        clienteDao= new ClienteDB();
    }
    public void CrearCajeroFacade(String codigo){
        cajeroDao.crearCajero(codigo);
    }
    public Integer[] retiroCompleto(String codigoCajero,Integer monto,String codigo,Integer clave) throws excepcionDatos {
        if(clienteDao.Retirar(codigo, clave,monto)){
            try {
                return cajeroDao.DescontarBilletes(codigoCajero,monto);
            } catch (excepcionDatos ex) {
                clienteDao.AgregarSaldo(codigo, monto);
                throw new excepcionDatos(ex.getMessage());
            }  
        }
        return null;
    }
    public void AumentarBilletesFacade(String codigoCajero,Integer Cant2,Integer Cant5,Integer Cant10,Integer Cant20,Integer Cant50) {
        cajeroDao.AumentarBilletes(codigoCajero, Cant2, Cant5, Cant10, Cant20, Cant50);
    }
    public void CrearClienteFacade(String nombre,Integer cedula,String codigo,Integer clave) throws excepcionDatos {
        clienteDao.CrearCliente(nombre,cedula,codigo, clave);
    }
    public Integer ConsultarSaldoClienteFacade(String codigo,Integer clave) throws excepcionDatos{
        return clienteDao.ConsultarSaldo(codigo, clave);
    }
    public boolean ConsignarFacade(String codigo,Integer consignacion) throws excepcionDatos {
        return clienteDao.AgregarSaldo(codigo, consignacion);
    }
    public Integer[] cantidadBilletesCajero(String codigoCajero){
        return cajeroDao.cantidadbilletes(codigoCajero);
    }
    public String[] cajeros(){
        return cajeroDao.listaCajeros();
    }
}
