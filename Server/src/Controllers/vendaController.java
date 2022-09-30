/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.util.ArrayList;
import Services.compraServices;
import java.io.IOException;

/**
 *
 * @author digof
 */
public class vendaController {
    public String efetuaVendaController(String nmProduto, int qtdProduto, ArrayList<Entities.venda> vendas, ArrayList<Entities.venda> produtos) throws IOException{
    
        Entities.produto produto = new Entities.produto();
        Services.vendaServices vndService = new Services.vendaServices();

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
    
    public ArrayList<String> verificaEnvioController(ArrayList<Entities.venda> vendas){
        compraServices cpra = new compraServices();
        ArrayList<String> comprasEfetuadas = new ArrayList<String>();
        comprasEfetuadas = cpra.verificaEnvio(vendas);
        
        return comprasEfetuadas;
    }
    
    public ArrayList<String> listaProdutos(ArrayList<Entities.venda> produtos){
        ArrayList<String> produtosDisponiveis = new ArrayList<String>();
        for(int i=0; i< produtos.size(); i++){
            produtosDisponiveis.add(""+produtos.get(i).getDados()); 
        }
        
        return produtosDisponiveis;
    }
}
