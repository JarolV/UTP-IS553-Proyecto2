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
    void CrearCliente(String codigo,int clave);
    boolean Retirar(String codigo,int clave,int monto) throws excepcion;
    int ConsultarSaldo(String codigo,int clave);
    void AgregarSaldo(String codigo,int consignacion);
    
}
