package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;

public class UsuarioBD {
    
    private Connection connection;

    public UsuarioBD() {
        connection = Conexao.getConnection();
    }
    
    //Método respon´savel por inserir um usuário no banco
    public void inserir(Usuario usuario){
        
        //Script sql para inserir um usuário
        String sql = "INSERT INTO usuarios (nome, cpf, telefone, email, endereco) VALUES (?,?,?,?,?)";

        try {
            //Prepara o script de inserção no banco
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            //Seta os atributos da instrução sql
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getEndereco());
            
            //Executa a inserção no banco
            stmt.execute();
            //Fecha a conexao
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    //Pega um usuário específico armazenado no banco
    public Usuario getUsuarioCPF(String cpf){
        
        //Instância da classe usuário
        Usuario usuario = new Usuario();
        
        //Instrução sql para selecionar um usuário pelo cpf
        String sql = "SELECT * FROM usuarios WHERE cpf=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cpf);
            
            //Executa a consulta e o resultado é armazenado
            ResultSet rs = stmt.executeQuery();
            
            //Setando atributos do objeto com os resultados da consulta
            while(rs.next()){
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setEmail(rs.getString("email"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setTelefone(rs.getString("telefone"));
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return usuario;
    }
}
