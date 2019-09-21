package modelo;

import java.util.Calendar;

public class Emprestimo {
    
    private int id;
    private Livro livro;
    private Usuario usuario;
    private Calendar dataEmpretimo;
    private Calendar dataDevolucao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Calendar getDataEmpretimo() {
        return dataEmpretimo;
    }

    public void setDataEmpretimo(Calendar dataEmpretimo) {
        this.dataEmpretimo = dataEmpretimo;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }  
}
