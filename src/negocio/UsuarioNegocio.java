package negocio;

import bd.UsuarioBD;
import java.util.Scanner;
import modelo.Usuario;

public class UsuarioNegocio {
    
    //Instância da classe usuário que permite acesso aos métodos
    UsuarioBD usuarioBD = new UsuarioBD();
    
    Scanner leitor = new Scanner(System.in);
    
    //Método para cadastrar um usuário
    public void cadastrarUsuario(){
        
        //Cria um ainstânica da classe usuário
        Usuario usuario = new Usuario();
        
        //Seta os atributos do objeto usuário
        System.out.println("Digite o cpf do usuário:");
        usuario.setCpf(leitor.nextLine());
        System.out.println("Digite o nome do usuário:");
        usuario.setNome(leitor.nextLine());
        System.out.println("Digite o telefone do usuário:");
        usuario.setTelefone(leitor.nextLine());
        System.out.println("Digite o endereço do usuário:");
        usuario.setEndereco(leitor.nextLine());
        System.out.println("Digite o e-mail do usuário:");
        usuario.setEmail(leitor.nextLine());
        
        //Chama o método da classe UsuarioBD, responsável por inserir um usuário no banco
        usuarioBD.inserir(usuario);  
    }
    
    //Exibe dados de um usuário
    public void exibirDadosUsuario(Usuario usuario){
        System.out.println("Id: "+usuario.getId());
        System.out.println("Nome: "+usuario.getNome());
        System.out.println("CPF: "+usuario.getCpf());
        System.out.println("Telefone: "+usuario.getTelefone());
        System.out.println("E-mail: "+usuario.getEmail());
    }
    
    //Consulta o usuário pelo CPF
    public void consultarUsuarioCPF(){
        System.out.println("Informe o número do CPF do usuário que você deseja concultar:");
        Usuario usuario = usuarioBD.getUsuarioCPF(leitor.nextLine());
        exibirDadosUsuario(usuario);
    }
    
    //Consulta se há um usuário cadastrado com o CPF especificado
    public boolean verificarUsuarioCPFCadastrado(String cpf){
        //Consulta o cpf do usuário
        Usuario usuario = usuarioBD.getUsuarioCPF(cpf);
        
        //Se o CPF passado já constar no banco, retorna verdadeiro
        if(cpf.equalsIgnoreCase(usuario.getCpf())){
            System.err.println("Atenção! Usuário já cadastrado");
            return true;
        }else{
            return false;
        }
    }
}