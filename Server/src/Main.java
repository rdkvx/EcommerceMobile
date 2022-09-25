/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entities.compra;
import Entities.produto;
import Entities.venda;
import Entities.funcionario;
import Services.utilidades;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;

/**
 *
 * @author Rodrigo Soares
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        utilidades utils = new utilidades();
        Scanner input = new Scanner(System.in);
        int op;
        
        

        ArrayList<venda> produtos = new ArrayList(); //LISTA QUE PERSISTIRÁ TODOS OS PRODUTOS CADASTRADOS.
        ArrayList<venda> vendas = new ArrayList(); //LISTA QUE PERSISTIRÁ TODAS AS COMPRAS E VENDAS CADASTRADAS.
        ArrayList<funcionario> funcionarios = new ArrayList(); //LISTA QUE PERSISTIRÁ TODOS OS FUNCIONARIOS.
        
       
       do{
          try { 
           //MENU INICIAL DO SISTEMA
           utils.limpatela();
           System.out.println("\nE-COMMERCE TA AV2 TURMA 162\n");
           System.out.println("SELECIONE UMA OPCAO ABAIXO");
           System.out.println("[1] - PAINEL COMPRADOR");
           System.out.println("[2] - PAINEL VENDEDOR");
           System.out.println("[0] - SAIR");
           System.out.print("OPCAO: ");
                       
           op = Integer.parseInt(input.next());
           
           } catch (NumberFormatException e) {
                   utils.mensagemErro();
                   op = 9;
           }
           switch(op){
          
            case 1: 
                //operação compra.
                int opcp;
                do{
                    try {
                    //MENU DO COMPRADOR
                    utils.limpatela();
                    System.out.println("\nPAINEL COMPRADOR\n");
                    System.out.println("[1] - COMPRAR");
                    System.out.println("[2] - CHECAR ENVIO");
                    System.out.println("[3] - LISTAR TODOS OS PRODUTOS");
                    System.out.println("[0] - VOLTAR");
                    System.out.print("OPCAO: ");
                    opcp = Integer.parseInt(input.next());
                    
                } catch (Exception e) {
                    utils.mensagemErro();
                    opcp = 9;
                }
                
                switch(opcp){
                    case 1: 
                        
                        //MENU DE COMPRA
                        
                        utils.limpatela();
                        int qtdProduto;
                        System.out.println("\nPAINEL DE COMPRAS\n");
                        System.out.println("INFORME O NOME EXATO DO PRODUTO");
                        System.out.print("NOME DO PRODUTO: ");
                        input.nextLine();
                        String nmvnd1 = input.nextLine();
                        venda vnd = new venda();
                        
                        //METODO PARA VERIFICAR SE O PRODUTO JÁ ESTÁ CADASTRADO OU NÃO
                        int indicevnd1 = vnd.verificaProduto(produtos, nmvnd1); 
                        
                        //CASO O METODO RETORNE -1, O PRODUTO BUSCADO NÃO FOI CADASTRADO
                        if(indicevnd1 == -1){
                        
                            System.out.println("PRODUTO NÃO CADASTRADO, VERIFIQUE O NOME E TENTE NOVAMENTE");
                            System.in.read();
                        }
                        
                        //CASO O MÉTODO RETORNE QUALQUER OUTRO VALOR, O SISTEMA DA PROCEDIMENTO NO PROCESSO DE COMPRA.
                        else{
                            int opconfirma = 0;
                            try {
                                System.out.println("\nPRODUTO ENCONTRADO<<<<<<<<<<<<<<<");
                                System.out.println(""+produtos.get(indicevnd1).getDados());
                                System.in.read();
                                System.out.print("INFORME A QUANTIDADE: ");
                                qtdProduto = Integer.parseInt(input.next());
                            } catch (NumberFormatException e) {
                                //utils.mensagemErro();
                                qtdProduto = -1;
                            }
                            
                            //VERIFICAÇÃO PARA SABER SE EXISTE A QUANTIDADE SOLICITADA EM ESTOQUE.
                            if(produtos.get(indicevnd1).getQtdProduto() >= qtdProduto && qtdProduto >0){
                                
                                do{
                                    try {
                                        System.out.println("\nTOTAL DA COMPRA: "+produtos.get(indicevnd1).getPreco() * qtdProduto);
                                        System.out.println("\nDESEJA CONFIRMAR A COMPRA?");
                                        System.out.println("[1] - CONFIRMAR");
                                        System.out.println("[2] - CANCELAR");
                                        System.out.print("OPCAO: ");
                                        opconfirma = Integer.parseInt(input.next());
                                    } catch (Exception e) {
                                        utils.mensagemErro();
                                        opconfirma = 2;
                                    }
                                
                                switch(opconfirma){
                                    case 1: 
                                        //BAIXA NO ESTOQUE.
                                        produtos.get(indicevnd1).setQtdProduto(produtos.get(indicevnd1).getQtdProduto() - qtdProduto);
                                        
                                        System.out.println("\nCOMPRA EFETUADA!");
                                        System.out.println("VERIFIQUE O STATUS DE ENVIO DO PRODUTO NO MENU [1] - PAINEL COMPRADOR > [2] - CHECAR ENVIO\n");
                                        System.in.read();
                                        opconfirma = 0;
                                        venda vnd1temp = new venda();
                                        vnd1temp.setIdProduto(produtos.get(indicevnd1).getIdProduto());
                                        vnd1temp.setNome(produtos.get(indicevnd1).getNome());
                                        vnd1temp.setPreco(produtos.get(indicevnd1).getPreco()*qtdProduto);
                                        vnd1temp.setQtdProduto(qtdProduto);
                                        
                                        //REGISTRA A COMPRA.
                                        vendas.add(vnd1temp);
                                        break;
                                        
                                    case 2: 
                                        System.out.println("OPERAÇÃO CANCELADA\n");
                                        System.in.read();
                                        opconfirma = 0;
                                        break;
                                    default:
                                        System.out.println("INFORME UMA OPCAO VÁLIDA!\n");
                                            
                                }
                                }while(opconfirma != 0);
                            }
                            else if(qtdProduto == -1){
                                utils.mensagemErro();
                                System.in.read();
                            }
                            else{
                                System.out.println("INFELIZMENTE NÃO TEMOS A QUANTIDADE SOLICITADA.");
                                System.out.println("VERIFIQUE A QUANTIDADE DISPONIVEL E TENTE NOVAMENTE!");
                                System.in.read();
                            }
                        }
                    break;
                    
                    case 2: 
                        //MENU PARA SABER SE O PRODUTO JÁ FOI ENVIADO OU NÃO.
                        utils.limpatela();
                        System.out.println("\nPAINEL DE ENVIO\n");
                        compra cpra = new compra();
                        cpra.verificaEnvio(vendas);
                        System.in.read();
                    break;
                    
                    case 3:
                        //MENU PARA VERIFICAR TODOS OS PRODUTOS DISPONIVEIS PARA COMPRA
                        utils.limpatela();
                        System.out.println("\nPRODUTOS DISPONIVEIS PARA COMPRA");
                        for(int i=0; i< produtos.size(); i++){
                        System.out.println(""+produtos.get(i).getDados()); 
                        }
                        System.in.read();  
                        break;
                    
                    case 0:
                        System.out.println("VOLTANDO...");
                    break;
                    
                    default:
                        utils.exibirDefault();
                        break;
                }
                }while(opcp != 0);
                 break;
                   
            case 2:
                int token;
                if(funcionarios.size() <= 0){
                    int opfuncionario;
                    do{
                        try {
                            utils.limpatela();
                            System.out.println("SOMENTE FUNCIONARIOS PODEM ACESSAR O PAINEL DE VENDAS!");
                            System.out.println("CASO VOCE SEJA FUNCIONARIO, REALIZE O CADASTRO AGORA.");
                            System.out.println("[1] - CADASTRAR");
                            System.out.println("[0] - VOLTAR");
                            System.out.print("OPCAO: ");
                            opfuncionario = Integer.parseInt(input.next());
                        } catch (Exception e) {
                            utils.mensagemErro();
                            opfuncionario = 0;
                            System.in.read();
                        }
                        
                        
                        
                     switch(opfuncionario){
                         case 1: 
                                funcionario f = new funcionario();
                                f.cadastroFuncionario();
                                
                         
                                if(f.getNome() != null){
                                    funcionarios.add(f);
                                    utils.limpatela();
                                    System.out.println("\nFUNCIONARIO >>>"+f.getNome().toUpperCase()+"<<< CADASTRADO COM SUCESSO\n");
                                    System.out.println("UTILIZE SEU EMAIL PARA ACESSAR O PAINEL DE VENDAS.");
                                    System.in.read();
                                    opfuncionario = 0;
                                }
                                else{
                                    System.out.println("VERIFIQUE OS DADOS CADASTRADOS");
                                    opfuncionario = 0;
                                }
                                
                             break;
                         case 0: 
                             break;
                         default: 
                                System.out.println("ESCOLHA UMA OPCAO VALIDA!");
                                System.in.read();
                             break;
                     }
                    
                    }while(opfuncionario != 0);
                }
                
                else if(funcionarios.size() > 0){
                    String emailtemp;
                    utils.limpatela();
                    System.out.println("INFORME O SEU E-MAIL PARA ACESSAR O PAINEL DE VENDAS");
                    System.out.print("ACESSO: ");
                    input.nextLine();
                    emailtemp = input.nextLine();
                    
                    funcionario f = new funcionario();
                    token = f.getindiceFuncionario(funcionarios, emailtemp);
                    
                    if(token == -1){
                        utils.limpatela();
                        System.out.println("FUNCIONARIO NAO ENCONTRADO");
                        System.in.read();
                    }
                    
                    else{
                
                //OPeracao Painel Venda
                int oppv; 
                venda vnd = new venda();
                    
                    do{
                        try {
                      //MENU DE VENDAS  
                     utils.limpatela();
                     System.out.println("\n>>>PAINEL DO VENDEDOR<<<\n");
                     System.out.println("LOGADO COMO: "+funcionarios.get(token).getNome().toUpperCase());
                     System.out.println("\n[1] - CADASTRAR PRODUTO");
                     System.out.println("[2] - REMOVER PRODUTO");
                     System.out.println("[3] - VENDAS EFETUADAS");
                     System.out.println("[4] - PRODUTOS A ENVIAR");
                     System.out.println("[5] - CADASTRAR NOVO FUNCIONARIO");
                     System.out.println("[0] - VOLTAR");
                     System.out.print("Opcao: ");
                     oppv = Integer.parseInt(input.next());
                                                 
                     } catch (Exception e) {
                         utils.mensagemErro();
                         oppv = 9;
                        }
                     //produto vnd1 = new produto();
                     venda vnd1 = new venda();
                    switch(oppv){
                        case 1: 
                            //MÉTODO PARA CADASTRAR PRODUTOS
                            vnd1.cadastroProduto();
                            
                            //MÉTODO PARA VERIFICAR SE O PRODUTO JÁ FOI CADASTRADO OU NÃO
                            int cdindice = vnd1.getIndice(produtos, vnd1.getIdProduto());
                            if(cdindice >=0){
                                System.out.println("ERRO, ID JA CADASTRADO");
                                System.in.read();
                            }
                            else if(vnd1.getIdProduto() <= -1 || vnd1.getPreco() <= 0 || vnd1.getQtdProduto() <= 0){
                                System.out.println("ERRO AO CADASTRAR, VERIFIQUE OS DADOS CADASTRADOS");
                                System.in.read();
                            }
                            else{
                                //REGISTRA O ITEM NO SISTEMA.
                                 produtos.add(vnd1);
                                 utils.limpatela();
                                 System.out.println("\nCADASTRADO COM SUCESSO!");
                                 
                                 //EXIBE O ULTIMO ITEM CADASTRADO
                                 System.out.println(produtos.get(produtos.size()-1).getDados());
                                 System.in.read();
                            }
                          
                        break;
                        
                        case 2: 
                            int codProduto;
                            try {
                                utils.limpatela();
                                System.out.println(">>>REMOVER PRODUTO<<<");
                                System.out.print("\nINFORME O CODIGO DO PRODUTO: ");
                                codProduto = Integer.parseInt(input.next());
                            } catch (Exception e) {
                                utils.mensagemErro();
                                codProduto = -1;
                            }
                           
                           //PROCURA NA LISTA DE PRODUTOS REGISTRADOS SE O CÓDIGO DIGITADO ESTÁ CADASTRADO E SALVA O INDICE DA LISTA NA VARIAVEL.
                           int rmindice = vnd1.getIndice(produtos, codProduto);
                           
                           //CASO NÃO ENCONTRE O CÓDIGO, O INDICE SERÁ -1 E O SISTEMA RETORNARÁ UM ERRO DE PRODUTO NÃO ENCONTRADO.
                           if(rmindice == -1){
                               System.out.println("PRODUTO NAO ENCONTRADO! VERIFIQUE O CÓDIGO E TENTE NOVAMENTE");
                               System.in.read();
                           }
                           
                           //CASO ENCONTRE O CÓDIGO DIGITADO, O SISTEMA IRÁ REMOVER O PRODUTO SOLICITADO E RETORNARÁ UMA MENSAGEM AO USUÁRIO.
                           else{
                               produtos.get(rmindice).removerProduto(produtos, rmindice);
                               System.out.println("O PRODUTO FOI REMOVIDO COM SUCESSO!");
                               System.in.read();
                           }
                         
                           break;
                            
                        case 3:
                            utils.limpatela();
                            System.out.println("VENDAS EFETUADAS");
                            
                            //LISTA TODAS AS COMPRAS (E VENDAS) REALIZADAS.
                            vnd.relatorioVendas(vendas);
                            
                            System.in.read();
                            break;
                            
                        case 4: 
                            utils.limpatela();
                            System.out.println("PRODUTOS A ENVIAR");
                            
                            //LISTA TODOS OS PRODUTOS QUE ESTÃO PENDENTES DE ENVIO.
                            vnd.trataEnvio(vendas);
                            break;
                            
                        case 5: 
                            funcionario f1 = new funcionario();
                                f1.cadastroFuncionario();
                                int validaEmail = f1.getindiceFuncionario(funcionarios, f1.getEmail());
                                
                                if(f1.getNome() != null && validaEmail == -1){
                                    funcionarios.add(f1);
                                    System.out.println("\nFUNCIONARIO >>>"+f1.getNome().toUpperCase()+"<<< CADASTRADO COM SUCESSO\n");
                                    System.out.println("UTILIZE SEU EMAIL PARA ACESSAR O PAINEL DE VENDAS.");
                                    System.in.read();
                                }
                                else{
                                    utils.limpatela();
                                    System.out.println("E-MAIL JA CADASTRADO OU DADOS DIGITADOS ERRADO.");
                                    System.in.read();
                                }
                            break;
                        case 0:
                            
                            break;
                        default: 
                           utils.exibirDefault();
                            break;
                    }
                    
                    }while(oppv != 0);
                    }
            break; 
                }
            case 0:
                   utils.limpatela();
                   System.out.print("(｡◕‿◕｡)");
                   
                   System.out.println("\nObrigado por usar o sistema! \n");
                   break;
            default:
                utils.exibirDefault();
           }
       }while(op != 0);
    }
}
