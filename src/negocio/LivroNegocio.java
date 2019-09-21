package negocio;

import bd.LivroBD;
import java.util.Scanner;
import modelo.Livro;

public class LivroNegocio {
    
    Scanner leitor = new Scanner(System.in);
    
    //criando uma instância da classe de bd do livro
    LivroBD livroBD = new LivroBD();
    
    public void cadastrarLivro(){
        
        //criando uma instância de livro
        Livro livro = new Livro();
        
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
    
    //Recebe um objeto do livro e exibe os valores dos seus atributos
    public void exibirDadosLivro(Livro livro){
        System.out.println("Id: "+livro.getId());
        System.out.println("ISBN: "+livro.getIsbn());
        System.out.println("Tíulo: "+livro.getTitulo());
        System.out.println("Autor: "+livro.getAutor());
        System.out.println("Ano: "+livro.getAno());
        System.out.println("Editora: "+livro.getEditora());
        System.out.println("Qtde. Exemplares: "+livro.getQtdeExemplares());
    }
    
    //Pesquisa um livro por parte do título
    public void consultaLivroTitulo(){
        System.out.println("Informe o título do livro ou parte dele que deseja consultar:");
        Livro livro = livroBD.getLivroTitulo(leitor.nextLine());
        exibirDadosLivro(livro);
    }
    
    //Pesquisa um livro pelo ISBN
    public void consultaLivroISBN(){
        System.out.println("Informe o ISBN do livro deseja consultar:");
        Livro livro = livroBD.getLivroISBN(leitor.nextLine());
        exibirDadosLivro(livro);
    }
    
    //Consulta se há um livro cadastrado com o ISBN especificado
    public boolean verificarISBNLivroCadastrado(String isbn){
        
        //Consulta o ISBN do livro
        Livro livro = livroBD.getLivroISBN(isbn);
        
        //Verifica se o ISBN passado já consta no sistema
        if(isbn.equalsIgnoreCase(livro.getIsbn())){
            System.err.println("Atenção! Livro já cadastrado");
            return true;
        }else{
            return false;
        }
    }
    
}
