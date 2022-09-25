/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Rodrigo Soares
 */
import java.io.Serializable;
import java.util.*;
import Entities.venda;


public class compra extends produto implements Serializable{
    
    
    //construtor padrão
    public compra(){
           
    }
    
    //Método para verificar se o produto já foi enviado ou não. Utilizado no menu do COMPRADOR, sobrescrevendo o método da classe mae
    public ArrayList<String> verificaEnvio(ArrayList<venda>compras){
        ArrayList<String> enviados = new ArrayList<String>();
            
        for(int i = 0; i < compras.size(); i++){
            if(compras.get(i).getEnvio() == false){
                enviados.add(""+compras.get(i).getNome()+": ENVIO PENDENTE");
            }else{
                enviados.add(""+compras.get(i).getNome()+": ENVIO REALIZADO");
            }
        }
        return enviados;
    }
    
}
