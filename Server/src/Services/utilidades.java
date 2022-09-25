/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.io.IOException;

/**
 *
 * @author Rodrigo Soares
 */
public class utilidades {
    
    //método para limpar a tela do console.
    public void limpatela(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                );
    }
    
    //método para exibir mensagem de erro no try catch
    public void mensagemErro(){
        System.out.println("\nERRO! UTILIZE UM VALOR NUMERICO. ");
    }
    
    //método para exibir o default do switch case
    public void exibirDefault() throws IOException{
                   
                   System.out.println("\nOPCAO INVALIDA!");
                   System.out.println("INFORME UMA DAS OPCOES ABAIXO!");
                   System.in.read();
                   limpatela();
    }
    
    //método para exibir erro ao tentar cadastrar com tipo de dado errado
    public void erroCadastro(){
        System.out.println("\nERRO! VERIFIQUE OS DADOS CADASTRADOS");
    }
    
}
