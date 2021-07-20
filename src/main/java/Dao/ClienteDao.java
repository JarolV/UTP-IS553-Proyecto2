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
public interface ClienteDao{
    void CrearCliente(String nombre,Integer cedula,String codigo,Integer clave) throws excepcionDatos;
    boolean Retirar(String codigo,Integer clave,Integer monto) throws excepcionDatos;
    Integer ConsultarSaldo(String codigo,Integer clave) throws excepcionDatos;
    void AgregarSaldo(String codigo,Integer consignacion);
    
}
