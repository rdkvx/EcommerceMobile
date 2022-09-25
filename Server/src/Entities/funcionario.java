/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import java.util.*;
import Services.utilidades;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Rodrigo Soares
 */

//classe funcionario implementando interface pessoa
public class funcionario implements pessoa {

    private String email;
    private String nome;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    //Construtor padrão
    public funcionario(){
         
    }
    
    //método para auxiliar na validação do cadastro do funcionário.
    public int getindiceFuncionario(ArrayList<funcionario> funcionarios, String email){
           for(int i = 0; i < funcionarios.size(); i++){
           if(funcionarios.get(i).getEmail().equals(email)){
                return i;
            }
        }
        return -1;
    }

    //método vindo da interface pessoa, utilizada para cadastrar novos funcionarios
    @Override
    public void cadastroFuncionario(){
        Scanner input = new Scanner(System.in);
        utilidades utils = new utilidades();
        utils.limpatela();
        System.out.println("CADASTRO DE FUNCIONARIOS\n\n");
        
         try {
            System.out.print("INFORME SEU EMAIL: ");
             setEmail(input.nextLine());
             if(!getEmail().contains("@")){
                 System.out.println("INFORME UM EMAIL VALIDO!");
                 System.in.read();
             }
             else{
                System.out.print("INFORME SEU NOME: ");
                setNome(input.nextLine());
             }
             
        } catch (InputMismatchException e) {
            System.out.print("TIPO DE DADO INVALIDO");
            
        } catch (IOException ex) {
            Logger.getLogger(funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
