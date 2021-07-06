/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.Cliente;
import excepcion.excepcion;

/**
 *
 * @author jarol
 */
public interface ClienteDao {
    void CrearCliente(String nombre,Integer cedula,String codigo,Integer clave);
    boolean Retirar(String codigo,Integer clave,Integer monto) throws excepcion;
    Integer ConsultarSaldo(String codigo,Integer clave);
    void AgregarSaldo(String codigo,Integer consignacion);
    
}
