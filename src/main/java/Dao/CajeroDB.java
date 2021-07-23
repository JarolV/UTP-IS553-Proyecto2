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
public class CajeroDB implements CajeroDao{
    List<Cajero> datos;
    private void EscrituraArchivo(){    
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter("cajero.txt");
            pw = new PrintWriter(fichero);
            for (Cajero dato : datos) {
                pw.println(dato.getCodigoCajero()+";"+dato.getDosmil()+";"+dato.getCincomil()+";"+dato.getDiezmil()+";"+dato.getVeintemil()+";"+dato.getCincuentamil()+";");
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
    List<Cajero> lecturaArchivo(){
        List<Cajero> cajeroLista = new ArrayList<>();
        File archivoCajero = new File("cajero.txt");
        try {
            var lector = new Scanner(archivoCajero);
            while(lector.hasNextLine()){
                var campos = lector.nextLine().split(";");
                String codigo=campos[0];
                Integer dosmil = Integer.valueOf(campos[1]);
                Integer cincomil = Integer.valueOf(campos[2]);
                Integer diezmil = Integer.valueOf(campos[3]);
                Integer veintemil = Integer.valueOf(campos[4]);
                Integer cincuentamil = Integer.valueOf(campos[5]);
                Cajero cajero=new Cajero(codigo,true,dosmil,cincomil,diezmil,veintemil,cincuentamil);
                System.out.println(codigo+dosmil+cincomil+diezmil+veintemil+cincuentamil);
                cajeroLista.add(cajero);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CajeroDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se encontro documento");
        }
        return  cajeroLista;
    }
     public CajeroDB(){
        datos=lecturaArchivo();
    }
    @Override
    public void crearCajero(String codigo) {
       Cajero cajero=new Cajero(codigo);
       datos.add(cajero);
       EscrituraArchivo();
    }

    private Integer disponible(Cajero cajero){
        Integer total=cajero.getCincuentamil()*50000+cajero.getVeintemil()*20000+cajero.getDiezmil()*10000+cajero.getCincomil()*5000
                +cajero.getDosmil()*2000;
        return total;
       
    }
    @Override
    public Integer[] DescontarBilletes(String codigoCajero,Integer monto) throws excepcionDatos{
        Integer[] billetes=new Integer[5];
        for(int i=0;i<5;i++) {
            billetes[i] = 0;
        }
        
        for(Cajero cajeroEditar:datos){
            if (cajeroEditar.getCodigoCajero().equals(codigoCajero)) {
              if(monto<disponible(cajeroEditar)){
                  Integer cant50=monto/50000;
                  if(cant50>=1&&cant50<=cajeroEditar.getCincuentamil()){
                      billetes[0]=cant50;
                      monto=monto-cant50*50000;
                  }
                  Integer cant20=monto/20000;
                  if(cant20>=1&&cant20<=cajeroEditar.getVeintemil()){
                     billetes[1]=cant20;
                     monto=monto-cant20*20000;
                  }
                  Integer cant10=monto/10000;
                  if(cant10>=1&&cant10<=cajeroEditar.getDiezmil()){
                     billetes[2]=cant10;
                     monto=monto-cant10*10000;
                  }
                  Integer cant5=monto/5000;
                  if(cant5>=1&&cant5<=cajeroEditar.getCincomil()){
                     billetes[3]=cant5;
                     monto=monto-cant5*5000;
                  }
                  Integer cant2=monto/2000;
                  if(cant2>=1&&cant2<=cajeroEditar.getDosmil()){
                     billetes[4]=cant2;
                     monto=monto-cant2*2000;
                  }
                  if(monto!=0){
                      throw new excepcionDatos("No se puede realizar la operacion");
                  }  
                  cajeroEditar.setCincuentamil(cajeroEditar.getCincuentamil()-cant50);
                  cajeroEditar.setVeintemil(cajeroEditar.getVeintemil()-cant20);
                  cajeroEditar.setDiezmil(cajeroEditar.getDiezmil()-cant10);
                  cajeroEditar.setCincomil(cajeroEditar.getCincomil()-cant5);
                  cajeroEditar.setDosmil(cajeroEditar.getDosmil()-cant2);
              }else{
                 throw new excepcionDatos("No hay suficientes billetes");
              }
            }
        } 
        EscrituraArchivo();
        return billetes;
    }
    
    

    @Override
    public void AumentarBilletes(String codigoCajero, Integer Cant2, Integer Cant5, Integer Cant10, Integer Cant20, Integer Cant50) {
           for(Cajero cajeroEditar:datos){
            if (cajeroEditar.getCodigoCajero().equals(codigoCajero)) {
                cajeroEditar.setDosmil(cajeroEditar.getCincomil()+Cant2);
                cajeroEditar.setCincomil(cajeroEditar.getCincomil()+Cant5);
                cajeroEditar.setDiezmil(cajeroEditar.getDiezmil()+Cant10);
                cajeroEditar.setVeintemil(cajeroEditar.getVeintemil()+Cant20);
                cajeroEditar.setCincuentamil(cajeroEditar.getCincuentamil()+Cant50);
                EscrituraArchivo();
            }
        }
    }

    @Override
    public Integer[] cantidadbilletes(String codigoCajero) {
        Integer[] billetes=new Integer[5];
        for(int i=0;i<5;i++) {
            billetes[i] = 0;
        }
        for(Cajero cajeroEditar:datos){
               billetes[0]=cajeroEditar.getCincuentamil();
               billetes[1]=cajeroEditar.getVeintemil();
               billetes[2]=cajeroEditar.getDiezmil();
               billetes[3]=cajeroEditar.getCincomil();
               billetes[4]=cajeroEditar.getDosmil();
              }
        return billetes;
    }

    @Override
    public String[] listaCajeros() {
        String[] cajeros=new String[datos.size()];
        Integer i=0;
        for (Cajero cajero : datos) {
            cajeros[i]=cajero.getCodigoCajero();
            i++;
        }
        return cajeros;
    }

}
