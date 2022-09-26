package com.example.javae_commerce.Services;

import com.example.javae_commerce.Entities.compra;
import com.example.javae_commerce.Entities.produto;
import com.example.javae_commerce.Entities.venda;

import java.util.ArrayList;

/**
 *
 * @author digof
 */
public class compraServices {
    // metodo retorna uma compra para ser adicionada na lista de vendas
    public venda comprar(ArrayList<venda> produtos,String nmProduto, int qtdProduto){
        venda vendaNova = new venda();

        int indiceVnd1 = vendaNova.verificaProduto(produtos, nmProduto);
        if (indiceVnd1 == -1){
            return vendaNova;
        }
        if (qtdProduto <= 0){
            return vendaNova;
        }
        if(produtos.get(indiceVnd1).getQtdProduto() >= qtdProduto && qtdProduto >0){
            produtos.get(indiceVnd1).setQtdProduto(produtos.get(indiceVnd1).getQtdProduto() - qtdProduto);

            vendaNova.setIdProduto(produtos.get(indiceVnd1).getIdProduto());
            vendaNova.setNome(produtos.get(indiceVnd1).getNome());
            vendaNova.setPreco(produtos.get(indiceVnd1).getPreco()*qtdProduto);
            vendaNova.setQtdProduto(qtdProduto);

            return vendaNova;
        }

        return vendaNova;
    }

    // retorna um array com os status de envio das compras
    public ArrayList<String> verificaEnvio(ArrayList<com.example.javae_commerce.Entities.venda> vendas){
        compra cpra = new compra();
        return cpra.verificaEnvio(vendas);
    }

    // retorna um array com as informacoes de todos os produtos
    public ArrayList<String> listaProdutos(ArrayList<produto> produtos){
        ArrayList<String> listaProduto = new ArrayList<String>();

        for(int i=0; i< produtos.size(); i++){
            listaProduto.add(""+produtos.get(i).getDados());
        }

        return listaProduto;
    }

}