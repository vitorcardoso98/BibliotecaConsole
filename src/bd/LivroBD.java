package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Livro;

public class LivroBD {

    private Connection connection;

    public LivroBD() {
        connection = Conexao.getConnection();
    }
    
    //Método para inserir livro no banco
    public void inserir(Livro livro) {
        
        //Script sql para inserir livro
        String sql = "INSERT INTO livros (titulo, isbn, autor, editora, ano, qtdeExemplares) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getIsbn());
            stmt.setString(3, livro.getAutor());
            stmt.setString(4, livro.getEditora());
            stmt.setInt(5, livro.getAno());
            stmt.setInt(6, livro.getQtdeExemplares());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    //Método que recupera livro do banco pelo ISBN
    public Livro getLivroISBN(String isbn) {

        Livro livro = new Livro();

        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM livros WHERE isbn=?");
            stmt.setString(1, isbn);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setEditora(rs.getString("editora"));
                livro.setIsbn(rs.getString("isbn"));
                livro.setAno(rs.getInt("ano"));
                livro.setQtdeExemplares(rs.getInt("qtdeExemplares"));

            }

            stmt.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return livro;
    }
    
    //Método que recupera um livro por parte do seu título
    public Livro getLivroTitulo(String titulo) {

        Livro livro = new Livro();

        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM livros WHERE titulo LIKE ?");
            stmt.setString(1, "%" + titulo + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setEditora(rs.getString("editora"));
                livro.setIsbn(rs.getString("isbn"));
                livro.setAno(rs.getInt("ano"));
                livro.setQtdeExemplares(rs.getInt("qtdeExemplares"));

            }

            stmt.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return livro;
    }
    
    //Método que altera a quantidade dos exemplares de acordo com o empréstimo ou devolução
    public void alterar(Livro livro, String opcao) {

        if (opcao.equalsIgnoreCase("empréstimo")) {
            String sql = "UPDATE livros SET qtdeExemplares = qtdeExemplares-1 WHERE id=?";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setInt(1, livro.getId());

                stmt.execute();
                stmt.close();

            } catch (SQLException e) {
                System.out.println(e);
            }
        }else{
            String sql = "UPDATE livros SET qtdeExemplares = qtdeExemplares+1 WHERE id=?";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setInt(1, livro.getId());

                stmt.execute();
                stmt.close();

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
