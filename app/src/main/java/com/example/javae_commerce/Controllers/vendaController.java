package com.example.javae_commerce.Controllers;

import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author digof
 */
public class vendaController {
    public String efetuaVendaController(String nmProduto, int qtdProduto, ArrayList<com.example.javae_commerce.Entities.venda> vendas, ArrayList<com.example.javae_commerce.Entities.venda> produtos) throws IOException{

        com.example.javae_commerce.Entities.produto produto = new com.example.javae_commerce.Entities.produto();
        com.example.javae_commerce.Services.vendaServices vndService = new com.example.javae_commerce.Services.vendaServices();

        produto.setNome(nmProduto);

        try {
            if (qtdProduto < 1){
                return "QUANTIDADE INVALIDA";
            }

        } catch (NumberFormatException e) {
            qtdProduto = -1;
        }

        produto.setQtdProduto(qtdProduto);

        String vendaConcluida = vndService.cadastroProduto(produto, vendas, produtos);

        return vendaConcluida;
    }

    public ArrayList<String> verificaEnvioController(ArrayList<com.example.javae_commerce.Entities.venda> vendas){
        com.example.javae_commerce.Services.compraServices cpra = new com.example.javae_commerce.Services.compraServices();
        ArrayList<String> comprasEfetuadas = new ArrayList<String>();
        comprasEfetuadas = cpra.verificaEnvio(vendas);

        return comprasEfetuadas;
    }

    public ArrayList<String> listaProdutos(ArrayList<com.example.javae_commerce.Entities.venda> produtos){
        ArrayList<String> produtosDisponiveis = new ArrayList<String>();
        for(int i=0; i< produtos.size(); i++){
            produtosDisponiveis.add(""+produtos.get(i).getDados());
        }

        return produtosDisponiveis;
    }
}
