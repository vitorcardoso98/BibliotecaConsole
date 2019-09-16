package negocio;

import bd.LivroBD;
import java.util.Scanner;
import modelo.Livro;

public class LivroNegocio {
    
    Scanner leitor = new Scanner(System.in);
    
    public void cadastrarLivro(){
        
        //criando uma instância de livro
        Livro livro = new Livro();
        
        //criando uma instância da classe de bd do livro
        LivroBD livroBD = new LivroBD();
        
        //populando os atributos de livro
        System.out.println("Digite o ISBN do livro");
        livro.setIsbn(leitor.nextLine());
        System.out.println("Digite o título do livro");
        livro.setTitulo(leitor.nextLine());
        System.out.println("Digite o nome do autor do livro");
        livro.setAutor(leitor.nextLine());
        System.out.println("Digite o nome da editora do livro");
        livro.setEditora(leitor.nextLine());
        System.out.println("Digite o ano de publicação do livro");
        livro.setAno(leitor.nextInt());
        System.out.println("Digite a quantidade de exemplares");
        livro.setQtdeExemplares(leitor.nextInt());
        
        //chamando o método de inserir livro
        livroBD.inserir(livro);
    }
    
    public Livro consultaLivroISBN(String isbn){
        //recebe o resultado da consulta ao método de consultar livro
        Livro livro = null;
        //retorna o livro
        return livro;
    }
    
}
