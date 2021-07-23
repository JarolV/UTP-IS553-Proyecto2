/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.Cajero;
import Entidades.Cliente;
import excepcion.excepcionDatos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jarol
 */
public class ClienteDB implements ClienteDao{
    List<Cliente> datos;
    private void EscrituraArchivo(){    
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("cliente.txt");
            pw = new PrintWriter(fichero);
            for (Cliente dato : datos) {
                pw.println(dato.getNombre()+";"+dato.getCedula()+";"+dato.getCodigo()+";"+dato.getClave()+";"+dato.getFondos()+";");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    List<Cliente> lecturaArchivo(){
        List<Cliente> ClienteLista = new ArrayList<>();
        File archivoCajero = new File("cliente.txt");
        try {
            var lector = new Scanner(archivoCajero);
            while(lector.hasNextLine()){
                var campos = lector.nextLine().split(";");
                String nombre=campos[0];
                Integer cedula = Integer.valueOf(campos[1]);
                String codigo = campos[2];
                Integer clave = Integer.valueOf(campos[3]);
                Integer saldo = Integer.valueOf(campos[4]);
                Cliente cliente=new Cliente(nombre,cedula,codigo,clave,saldo);
                System.out.println(nombre+cedula+codigo+clave+saldo);
                ClienteLista.add(cliente);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CajeroDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se encontro documento");
        }
        return  ClienteLista;
    }
    public ClienteDB() {
        datos=lecturaArchivo();
    }
    @Override
    public void CrearCliente(String nombre,Integer cedula,String codigo, Integer clave)throws excepcionDatos{
        for (Cliente dato : datos) {
            if(dato.getCodigo().equals(codigo)){
                throw new excepcionDatos("Ya hay una cuenta con este numero de cuenta");
            }      
        }
        Cliente cliente=new Cliente(nombre,cedula,codigo,clave);
        datos.add(cliente); 
        EscrituraArchivo();
    }
    
    @Override
    public boolean Retirar(String codigo,Integer clave,Integer monto) throws excepcionDatos{
        for (Cliente dato : datos) {
            if (dato.getCodigo().equals(codigo)
                &&dato.getClave().equals(clave)) {
                int Ft=dato.getFondos();
                if(Ft>monto){
                    int valor=Ft-monto;
                    dato.setFondos(valor);
                    EscrituraArchivo();
                    return true;
                }
            }
        }
      throw new excepcionDatos("Error en transaccion");
    }

    @Override
    public Integer ConsultarSaldo(String codigo,Integer clave) throws excepcionDatos{
        for (Cliente dato : datos) {
            if (dato.getCodigo().equals(codigo)&&dato.getClave().equals(clave)) {
                return dato.getFondos();
            }
        }
        throw new excepcionDatos("Error en transaccion");
    }

    @Override
    public boolean AgregarSaldo(String codigo, Integer consignacion) throws excepcionDatos{
        for (Cliente dato : datos) {
            if (dato.getCodigo().equals(codigo)) {
                dato.setFondos(dato.getFondos()+consignacion);
                EscrituraArchivo();
                return true;
            }
        }
        throw new excepcionDatos("No exite ninguna cuenta con ese numero");
    }
    

    
}
