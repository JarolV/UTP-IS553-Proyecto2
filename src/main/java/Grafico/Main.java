/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;

import Facade.Facade;
import excepcion.excepcion;

/**
 *
 * @author jarol
 */
public class Main {
    public static void main(String[] args) throws excepcion {
        Facade prueb=new Facade();
        prueb.CrearClienteFacade("jarol",1234);
        prueb.CrearCajeroFacade("1");
        prueb.AumentarBilletesFacade("1", 10, 10, 10, 10, 10);
        prueb.ConsignarFacade("jarol",1200000);
        System.out.println(prueb.ConsultarSaldoClienteFacade("jarol",1234));
        int[] billetes=new int[5];
        try {
            billetes = prueb.retiroCompleto("1",1250000,"jarol",1234);
            for (int i = 0; i < billetes.length; i++) {
                System.out.println(billetes[i]);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        System.out.println("hola");
    }
    
}
