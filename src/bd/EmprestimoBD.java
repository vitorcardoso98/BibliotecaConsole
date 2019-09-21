package bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;

public class EmprestimoBD {

    private Connection connection;

    public EmprestimoBD() {
        connection = Conexao.getConnection();
    }

    public void inserir(Emprestimo emprestimo) {

        String sql = "INSERT INTO emprestimos (idUsuario, idLivro, dataEmprestimo, dataDevolucao) VALUES (?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, emprestimo.getUsuario().getId());
            stmt.setInt(2, emprestimo.getLivro().getId());
            stmt.setDate(3, new Date(emprestimo.getDataEmpretimo().getTimeInMillis()));
            stmt.setDate(4, new Date(emprestimo.getDataDevolucao().getTimeInMillis()));

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        
        ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
        
        String sql = "SELECT * FROM emprestimos";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Emprestimo emprestimo = new Emprestimo();
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("idUsuario"));
                
                Livro livro = new Livro();
                livro.setId(rs.getInt("idLivro"));
                
                emprestimo.setUsuario(usuario);
                emprestimo.setLivro(livro);
                
                emprestimos.add(emprestimo);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return emprestimos;
    }
    
    public Emprestimo getEmprestimo(int idEmprestimo) {
        
        String sql = "SELECT * FROM emprestimos WHERE idEmprestimo=?";
        
        Emprestimo emprestimo = new Emprestimo();
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idEmprestimo);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("idUsuario"));
                
                Livro livro = new Livro();
                livro.setId(rs.getInt("idLivro"));
                
                emprestimo.setUsuario(usuario);
                emprestimo.setLivro(livro);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return emprestimo;
    }
    
    public boolean verificarEmprestimo(int idUsuario) {
        
        String sql = "SELECT * FROM emprestimos WHERE idUsuario=?";
        
        Emprestimo emprestimo = new Emprestimo();
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public void excluir(int idEmprestimo){
        String sql = "DELETE FROM emprestimos WHERE idEmprestimo=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idEmprestimo);
            
            stmt.execute();
            stmt.close();;
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
