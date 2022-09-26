package com.example.javae_commerce.Services;

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
    public String mensagemErro(){
      return ("\nERRO! UTILIZE UM VALOR NUMERICO. ");
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