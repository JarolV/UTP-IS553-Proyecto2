 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Entidades.Cajero;
import excepcion.excepcion;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author jarol
 */
public class CajeroMemoria implements CajeroDao{
    
    List<Cajero> datos;
    
    public CajeroMemoria() {
        datos=new ArrayList<>();
    }
    
    @Override
    public void crearCajero(String codigo) {
       Cajero cajero=new Cajero(codigo);
       datos.add(cajero);
    }

    private Integer disponible(Cajero cajero){
        Integer total=cajero.getCincuentamil()*50000+cajero.getVeintemil()*20000+cajero.getDiezmil()*10000+cajero.getCincomil()*5000
                +cajero.getDosmil()*2000;
        return total;
       
    }
    @Override
    public Integer[] DescontarBilletes(String codigoCajero,Integer monto) throws excepcion{
        Integer[] billetes=new Integer[5];
        for(int i=0;i<=4;i++) {
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
                      throw new excepcion("No se puede realizar la operacion");
                  }  
                  cajeroEditar.setCincuentamil(cajeroEditar.getCincuentamil()-cant50);
                  cajeroEditar.setVeintemil(cajeroEditar.getVeintemil()-cant20);
                  cajeroEditar.setDiezmil(cajeroEditar.getDiezmil()-cant10);
                  cajeroEditar.setCincomil(cajeroEditar.getCincomil()-cant5);
                  cajeroEditar.setDosmil(cajeroEditar.getDosmil()-cant2);
              }else{
                 throw new excepcion("No hay suficientes billetes");
              }
            }
        } 
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
            }
        }
    }

  
    
}
