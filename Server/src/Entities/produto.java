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

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import Services.utilidades;

        
public class produto implements Serializable{
    private int idProduto;
    private String nome;
    private float preco;
    private int qtdProduto;
    private boolean envio = false;
    
    //Construtor padrão
    public void produto(){
        
    }
    
  
    public void setIdProduto(int IDProduto){
        this.idProduto = IDProduto;
    }
    
    public void setNome(String Nome){
        this.nome = Nome;
    }
    
    public void setPreco(float Preco){
        this.preco = Preco;
    }
    
    public void setQtdProduto(int QtdProduto){
        this.qtdProduto = QtdProduto;
    }
    
    public void setEnvio(boolean Envio){
        this.envio = Envio;
    }
    
    public int getIdProduto(){
        return this.idProduto;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public float getPreco(){
        return this.preco;
    }
    
    public int getQtdProduto(){
        return this.qtdProduto;
    }
    
    public boolean getEnvio(){
        return this.envio;
    }
    
    utilidades utils = new utilidades();
    
    //Metodo para retornar os dados da compra
    public String getDados(){
        return ("\nID: "+getIdProduto()+"\nNome: "+getNome()+"\nPreco: R$"+getPreco()+ "\nQuantidade: "+getQtdProduto());
    }

    //Metodo criado pelo proprio java, ignorar.
    public void envio(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Metodo para ser sobrescrito pelas classes filhas.
    public void trataEnvio(){
        
    }
    
}