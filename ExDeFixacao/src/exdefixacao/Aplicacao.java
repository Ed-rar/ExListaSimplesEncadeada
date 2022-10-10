/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exdefixacao;

/**
 *
 * @author eduardo.raribeiro
 */

public class Aplicacao {
    public static void main(String[] args) {
        
        System.out.println("==============Inserir objeto na lista===============");      
        Produto prod1 = new Produto("Odisseia de Homero", 29.9d, "Livro");
        Metodos.inserir(prod1);
        Produto prod2 = new Produto("Nintendo Switch", 3000.00d, "Eletrônicos");
        Metodos.inserir(prod2);
        Produto prod3 = new Produto("Frigideira", 49.9d, "Cozinha");
        Metodos.inserir(prod3);
        
        System.out.println("=========Quantidade de itens da lista===================");
        System.out.println(Metodos.contarItem());
        
        System.out.println("\n============Pesquisar por id (no exemplo id=3)=============");
        System.out.println(Metodos.pesquisarPorId(3));
        
        System.out.println("\n======Pesquisar por id e retornar a posição na lista(no exemplo id=3)======");
        System.out.println(Metodos.pesquisarPorIdPosicao(3));
        
        System.out.println("\n============Remover por id (no exemplo id=3)=============");
        System.out.println(Metodos.remover(3));

        System.out.println("\n==========Atualizar preço por id (29.9 para 35.5)======================");
        System.out.println(Metodos.atualizarPrecoPorId(1, 35.5d));
        
        System.out.println("\n=============Pesquisar preço total da lista=============");
        System.out.println(Metodos.contarPrecoTotal());
        
        System.out.println("\n=============Desconto por categoria(no exemplo: Eletrônicos)=============");
        System.out.println("Nintendo Switch, valor R$3000.00 após desconto de R$300.00");
        System.out.println(Metodos.descontoPorCateg("Eletrônicos", 300.0d));
        
        System.out.println("\n=============Relatório com dados de produtos=============");
        Metodos.exibir();
    }
}
