package com.example.javae_commerce.Services;

import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author digof
 */
public class vendaServices {
    utilidades utils = new utilidades();

    //Function para enviar o produto, utilizado no menu de VENDAS, sobrescrevendo o da classe mae.
    public String trataEnvio(ArrayList<com.example.javae_commerce.Entities.venda> produtos, int opte) throws IOException{
        for(int i = 0; i<produtos.size(); i++){
            if(produtos.get(i).getEnvio() == false){
                try {
                    switch(opte){
                        case 1:
                            produtos.get(i).setEnvio(true);
                            return "ENVIO REALIZADO COM SUCESSO";
                        case 2:
                            return "ENVIO NAO REALIZADO";

                        default:
                            return "INFORME UMA OPCAO VáLIDA!";
                    }
                } catch (Exception e) {
                    return "OPCAO INVALIDA";
                }
            }
            else{
                return " ENVIADO ANTERIORMENTE";
            }
        }
        return "PRODUTO NAO ENCONTRADO";
    }

    //Function para verificar quais os produtos já foram vendidos e o total do valor arrecadado.
    public String relatorioVendas(ArrayList<com.example.javae_commerce.Entities.venda> produtos){
        float total = 0;
        for(int i = 0; i<produtos.size(); i++){
            total = total + (produtos.get(i).getPreco());
        }
        return "TOTAL DE VENDAS: R$"+total;
    }

    //Método para cadastrar produtos
    public String cadastroProduto(com.example.javae_commerce.Entities.produto produto , ArrayList<com.example.javae_commerce.Entities.venda> vendas,  ArrayList<com.example.javae_commerce.Entities.venda> produtos) throws IOException{
        com.example.javae_commerce.Entities.venda vnd = new com.example.javae_commerce.Entities.venda();

        //METODO PARA VERIFICAR SE O PRODUTO JÁ ESTÁ CADASTRADO OU NÃO
        int indicevnd1 = vnd.verificaProduto(produtos, produto.getNome());

        //CASO O METODO RETORNE -1, O PRODUTO BUSCADO NÃO FOI CADASTRADO
        if(indicevnd1 == -1){
            return ("PRODUTO NÃO CADASTRADO, VERIFIQUE O NOME E TENTE NOVAMENTE");
        }
        if(produtos.get(indicevnd1).getQtdProduto() >= produto.getQtdProduto() && produto.getQtdProduto() >0){

            try{
                //BAIXA NO ESTOQUE.
                produtos.get(indicevnd1).setQtdProduto(produtos.get(indicevnd1).getQtdProduto() - produto.getQtdProduto());
                com.example.javae_commerce.Entities.venda vnd1temp = new com.example.javae_commerce.Entities.venda();
                vnd1temp.setIdProduto(produtos.get(indicevnd1).getIdProduto());
                vnd1temp.setNome(produtos.get(indicevnd1).getNome());
                vnd1temp.setPreco(produtos.get(indicevnd1).getPreco()*produto.getQtdProduto());
                vnd1temp.setQtdProduto(produto.getQtdProduto());

                //REGISTRA A COMPRA.
                vendas.add(vnd1temp);
            }catch(Exception e){
                return "erro";
            }
        }else{
            return ("INFELIZMENTE NÃO TEMOS A QUANTIDADE SOLICITADA.");
        }
        return "COMPRA REALIZADA COM SUCESSO";
    }
}
