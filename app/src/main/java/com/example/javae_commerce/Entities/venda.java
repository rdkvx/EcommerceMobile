package com.example.javae_commerce.Entities;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class venda extends produto implements Serializable {

    com.example.javae_commerce.Services.utilidades utils = new com.example.javae_commerce.Services.utilidades();

    //Construtor padrão
    public venda(){

    }

    //Método para enviar o produto, utilizado no menu de VENDAS, sobrescrevendo o da classe mae.
    public void trataEnvio(ArrayList<venda> produtos) throws IOException{
        Scanner input = new Scanner(System.in);
        int opte = 0;

        for(int i = 0; i<produtos.size(); i++){
            if(produtos.get(i).getEnvio() == false){
                do{
                    try {
                        System.out.println("\nDESEJA ENVIAR O "+produtos.get(i).getNome()+" AGORA?");
                        System.out.println("[1] - SIM");
                        System.out.println("[2] - NAO");
                        System.out.print("OPCAO: ");
                        opte = Integer.parseInt(input.next());
                    } catch (Exception e) {
                        opte = 2;
                    }


                    switch(opte){
                        case 1:
                            produtos.get(i).setEnvio(true);
                            System.out.println("\nENVIO REALIZADO COM SUCESSO\n");
                            System.in.read();
                            opte = 2;
                            break;
                        case 2:
                            System.out.println("\nENVIO NAO REALIZADO\n");
                            System.in.read();
                            break;
                        default:
                            System.out.println("\nINFORME UMA OPCAO VáLIDA!");
                            System.in.read();
                            break;
                    }
                }while(opte != 2);
            }
            else{
                System.out.println(""+produtos.get(i).getNome()+" ENVIADO ANTERIORMENTE");
                System.in.read();
                opte = 2;
            }


        }
    }

    //Método para verificar quais os produtos já foram vendidos e o total do valor arrecadado.
    public void relatorioVendas(ArrayList<venda> produtos){
        float total = 0;
        for(int i = 0; i<produtos.size(); i++){
            System.out.println(""+produtos.get(i).getDadosVendas());
            total = total + (produtos.get(i).getPreco());
        }
        System.out.println("\nTOTAL DE VENDAS: R$"+total);
    }

    //Método para cadastrar produtos
    public void cadastroProduto() throws IOException{

        Scanner input = new Scanner(System.in);
        System.out.println("\n>>>CADASTRO DE PRODUTO<<<");

        System.out.print("NOME: ");
        setNome(input.nextLine());

        try {
            System.out.print("CODIGO: ");
            setIdProduto(Integer.parseInt(input.nextLine()));
        }
        catch(NumberFormatException e){
            utils.mensagemErro();
            setIdProduto(-1);
            System.in.read();
        }
        if(getIdProduto() != -1){
            try {
                System.out.print("PRECO: ");
                setPreco(Float.parseFloat(input.next()));
            }
            catch(NumberFormatException e){
                utils.mensagemErro();
                setIdProduto(-1);
                System.in.read();
            }
            if(getIdProduto() != -1){
                try {
                    System.out.print("QUANTIDADE: ");
                    setQtdProduto(Integer.parseInt(input.next()));
                }
                catch (Exception e) {
                    utils.mensagemErro();
                    setIdProduto(-1);
                    System.in.read();
                }
            }
        }
    }

    //Metodo para verificar se o produto está cadastrado na base, buscando pelo indice.
    public int getIndice(ArrayList<venda> produtos, int id){
        for(int i = 0; i < produtos.size(); i++){
            if(produtos.get(i).getIdProduto() == id){
                return i;
            }
        }
        return -1;
    }

    //Metodo para verificar se o produto está cadastrado na base, utilizado para realizar a COMPRA.
    public int verificaProduto(ArrayList<venda> produtos, String pdtnome){
        for(int i=0; i<produtos.size(); i++){
            if(produtos.get(i).getNome().equals(pdtnome)){
                return i;
            }
        }
        return -1;
    }

    //Metodo para remover um produto
    public void removerProduto(ArrayList<venda> produtos, int indice){
        produtos.remove(indice);
    }

    //Metodo para retornar os dados totais de venda
    public String getDadosVendas(){
        return ("\nID: "+getIdProduto()+"\nNOME: "+getNome()+"\nQUANTIDADE VENDIDA: "+getQtdProduto()+"\nTOTAL: R$"+getPreco());
    }
}
