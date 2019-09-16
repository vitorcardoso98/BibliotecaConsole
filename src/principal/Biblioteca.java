package principal;

import java.util.Scanner;
import negocio.LivroNegocio;

public class Biblioteca {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.println("OLÁ, SEJA BEM-VINDO e-Biblioteca");
        System.out.println("----------MENU----------");
        System.out.println("1 - CADASTRAR USUÁRIO");
        System.out.println("2 - CADASTRAR LIVRO");
        System.out.println("3 - REGISTRAR EMPRÉSTIMO");
        System.out.println("4 - REGISTRAR DEVOLUÇÃO");
        System.out.println("5 - CONSULTAR LIVRO PELO ISBN");
        System.out.println("6 - CONSULTAR LIVRO PELO TÍTULO");
        System.out.println("7 - SAIR");

        int opcao = leitor.nextInt();

        switch (opcao) {
            case 1:
                LivroNegocio livroNegocio = new LivroNegocio();
                livroNegocio.cadastrarLivro();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
                      
        }
    }
}
