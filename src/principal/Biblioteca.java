package principal;

import java.util.Scanner;
import negocio.EmprestimoNegocio;
import negocio.LivroNegocio;
import negocio.UsuarioNegocio;

public class Biblioteca {

    public static void main(String[] args) {

        //Instânica da classe LivroNegócio que permite acessar seus métodos
        LivroNegocio livroNegocio = new LivroNegocio();

        //Instância da classe UsuárioNegocio que permite acessar seus métodos
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
        
        EmprestimoNegocio emprestimoNegocio = new EmprestimoNegocio();
        
        //Objeto Scanner que permite a leitura de dados do teclado
        Scanner leitor = new Scanner(System.in);

        //Variável para controle das opções do menu
        int op = 0;

        //Laço de repetição do menu
        do {
            //Menu
            System.out.println("OLÁ, SEJA BEM-VINDO ao e-Biblioteca");
            System.out.println("----------MENU----------");
            System.out.println("1 - CADASTRAR USUÁRIO");
            System.out.println("2 - CADASTRAR LIVRO");
            System.out.println("3 - REGISTRAR EMPRÉSTIMO");
            System.out.println("4 - REGISTRAR DEVOLUÇÃO");
            System.out.println("5 - CONSULTAR LIVRO PELO ISBN");
            System.out.println("6 - CONSULTAR LIVRO PELO TÍTULO");
            System.out.println("7 - CONSULTAR USUÁRIO PELO CPF");
            System.out.println("0 - SAIR");

            op = leitor.nextInt();

            switch (op) {
                case 1:
                    //Limpando buffer do teclado
                    leitor.nextLine();
                    
                    //Solicita a verificação de CPF do usuário
                    System.out.println("Digite o cpf do usuário para verificação:");
                    String cpf = leitor.nextLine();
                    if (usuarioNegocio.verificarUsuarioCPFCadastrado(cpf) == false) {
                        usuarioNegocio.cadastrarUsuario();
                        break;
                    } else {
                        break;
                    }
                case 2:
                    //Limpando buffer do teclado
                    leitor.nextLine();
                    
                    //Solicita a verificação do ISBN do livro
                    System.out.println("Digite o ISBN do livro para verificação:");
                    String isbn = leitor.nextLine();
                    if (livroNegocio.verificarISBNLivroCadastrado(isbn) == false) {
                        livroNegocio.cadastrarLivro();
                        break;
                    } else {
                        break;
                    }
                case 3:
                    //Limpando buffer do teclado
                    leitor.nextLine();
                    
                    System.out.println("Digite o cpf do usuário para verificação");
                    String cpf_1 = leitor.nextLine();
                    if(emprestimoNegocio.verificarUsuarioPossuiEmprestimo(cpf_1)==false){
                        emprestimoNegocio.registrarEmprestimo();
                        break;
                    }else{
                        break;
                    }                   
                case 4:
                    emprestimoNegocio.registrarDevolucao();
                    break;
                case 5:
                    livroNegocio.consultaLivroISBN();
                    break;
                case 6:
                    livroNegocio.consultaLivroTitulo();
                    break;
                case 7:
                    usuarioNegocio.consultarUsuarioCPF();
                    break;

            }
        } while (op != 0);
    }
}
