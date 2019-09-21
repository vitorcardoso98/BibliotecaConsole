package modelo;

public class Livro {

    private int id;
    private String isbn;
    private String titulo;
    private String autor;
    private int ano;
    private String editora;
    private int qtdeExemplares;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getQtdeExemplares() {
        return qtdeExemplares;
    }

    public void setQtdeExemplares(int qtdeExemplares) {
        this.qtdeExemplares = qtdeExemplares;
    }

}
