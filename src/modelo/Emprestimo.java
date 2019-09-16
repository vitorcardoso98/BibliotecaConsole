package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Emprestimo {
    
    private List<Livro> livros;
    private Usuario usuario;
    private Calendar dataEmpretimo;
    private Calendar dataDevolucao;
    
    public Emprestimo(){
        this.livros = new ArrayList();
    }
    
    public void addLivro(Livro livro){
        livros.add(livro);
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
