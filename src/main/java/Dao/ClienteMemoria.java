/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import excepcion.excepcion;

/**
 *
 * @author jarol
 */
public class ClienteMemoria implements ClienteDao{
    List<Cliente> datos;

    public ClienteMemoria() {
        datos=new ArrayList<>();
    }
    @Override
    public void CrearCliente(String nombre,Integer cedula,String codigo, Integer clave) {
        Cliente cliente=new Cliente(nombre,cedula,codigo,clave);
        datos.add(cliente);     
    }
    
    @Override
    public boolean Retirar(String codigo,Integer clave,Integer monto) throws excepcion{
        for (Cliente dato : datos) {
            if (dato.getCodigo().equals(codigo)
                &&dato.getClave().equals(clave)) {
                int Ft=dato.getFondos();
                if(Ft>monto){
                    int valor=Ft-monto;
                    dato.setFondos(valor);
                    return true;
                }
            }
        }
      throw new excepcion("No hay dinero suficiente en su cuenta");
    }

    @Override
    public Integer ConsultarSaldo(String codigo,Integer clave) {
        for (Cliente dato : datos) {
            if (dato.getCodigo().equals(codigo)&&dato.getClave().equals(clave)) {
                return dato.getFondos();
            }
        }
        return 0;
    }

    @Override
    public void AgregarSaldo(String codigo, Integer consignacion) {
        for (Cliente dato : datos) {
            if (dato.getCodigo().equals(codigo)) {
                dato.setFondos(dato.getFondos()+consignacion);
            }
        }
    }

    

}
