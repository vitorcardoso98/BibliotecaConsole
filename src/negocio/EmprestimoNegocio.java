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
    
    EmprestimoBD emprestimoBD = new EmprestimoBD();
    
    UsuarioBD usuarioBD = new UsuarioBD();
    
    LivroBD livroBD = new LivroBD();
    
    public void registrarEmprestimo(){
        
        Emprestimo emprestimo = new Emprestimo();
        
        System.out.println("Informe o cpf do usuário:");
        Usuario usuario = usuarioBD.getUsuarioCPF(leitor.nextLine());
        usuario.setId(usuario.getId());
        
        System.out.println("Informe o ISBN do livro:");
        Livro livro = livroBD.getLivroISBN(leitor.nextLine());
        livro.setId(livro.getId());
        
        Calendar dataAtual = Calendar.getInstance();
        emprestimo.setDataEmpretimo(dataAtual);
              
        Calendar dataDevolucao = Calendar.getInstance();
        dataDevolucao.add(Calendar.DATE, +10);
        emprestimo.setDataDevolucao(dataDevolucao);
        
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        
        
        emprestimoBD.inserir(emprestimo);
        
        livroBD.alterar(livro, "Empréstimo");
    }
    
    public void registrarDevolucao(){
        System.out.println("Digite o Id do empréstimo:");
        int idEmprestimo = leitor.nextInt();
        
        //limpando o buffer
        leitor.nextLine();
        
        Emprestimo emprestimo = emprestimoBD.getEmprestimo(idEmprestimo);
        
        livroBD.alterar(emprestimo.getLivro(), "devolução");
        emprestimoBD.excluir(idEmprestimo);
    }
    
    public boolean verificarUsuarioPossuiEmprestimo(String cpf){
        Usuario usuario = usuarioBD.getUsuarioCPF(cpf);
        if(emprestimoBD.verificarEmprestimo(usuario.getId())==true){
            System.err.println("Atenção! Este usuário já possui empréstimo ativo");
            return true;
        }else{
            return false;
        }
        
    }
}
