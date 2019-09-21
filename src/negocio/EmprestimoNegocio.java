package negocio;

import bd.EmprestimoBD;
import bd.LivroBD;
import bd.UsuarioBD;
import java.util.Calendar;
import java.util.Scanner;
import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;

public class EmprestimoNegocio {

    Scanner leitor = new Scanner(System.in);
    
    //Obejetos de acesso aos métodos que controlam o banco
    EmprestimoBD emprestimoBD = new EmprestimoBD();
    UsuarioBD usuarioBD = new UsuarioBD();
    LivroBD livroBD = new LivroBD();
    
    //Método para registrar um empréstimo
    public void registrarEmprestimo(){
        
        Emprestimo emprestimo = new Emprestimo();
        
        //Solicita o cpf do livro cadastrado
        System.out.println("Informe o cpf do usuário:");
        Usuario usuario = usuarioBD.getUsuarioCPF(leitor.nextLine());
        usuario.setId(usuario.getId());
        
        //Solicita o ISBN do livro cadastrado
        System.out.println("Informe o ISBN do livro:");
        Livro livro = livroBD.getLivroISBN(leitor.nextLine());
        livro.setId(livro.getId());
        
        //Pega a data atual do sistema e seta o atributo de data de empréstimo
        Calendar dataAtual = Calendar.getInstance();
        emprestimo.setDataEmpretimo(dataAtual);
        
        //Pega a data atual do sistema e acrescenta um prazo de 10 dias de devolução
        Calendar dataDevolucao = Calendar.getInstance();
        dataDevolucao.add(Calendar.DATE, +10);
        emprestimo.setDataDevolucao(dataDevolucao);
        
        //Seta o usuário e o livro correspondente às informações de cpf e isbn digitadas
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        
        //Invoca o método de inserir um empréstimo no banco
        emprestimoBD.inserir(emprestimo);
        
        livroBD.alterar(livro, "Empréstimo");
    }
    
    //Método que registra uma devolução
    public void registrarDevolucao(){
        
        //Solicita o id (identificador) do empréstimo
        System.out.println("Digite o Id do empréstimo:");
        int idEmprestimo = leitor.nextInt();
        
        //limpando o buffer
        leitor.nextLine();
        
        //Recupera o empréstimo do banco
        Emprestimo emprestimo = emprestimoBD.getEmprestimo(idEmprestimo);
        
        //Aumenta um exemplar do livro disponível
        livroBD.alterar(emprestimo.getLivro(), "devolução");
        
        //Exclui o empréstimo do cadastro
        emprestimoBD.excluir(idEmprestimo);
    }
    
    //Método se o usuário possui empréstimo ativo
    public boolean verificarUsuarioPossuiEmprestimo(String cpf){
        //Recupera o usuário cadastrado através do seu cpf
        Usuario usuario = usuarioBD.getUsuarioCPF(cpf);
        
        //Verifica se o cpf está cadastrado no banco
        if(emprestimoBD.verificarEmprestimo(usuario.getId())==true){
            System.err.println("Atenção! Este usuário já possui empréstimo ativo");
            return true;
        }else{
            return false;
        } 
    }
}
