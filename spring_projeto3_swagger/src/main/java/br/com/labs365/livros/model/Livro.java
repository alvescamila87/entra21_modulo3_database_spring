package br.com.labs365.livros.model;

public class Livro {

    private Integer id;
    private String titulo;
    private String isbn;
    private Integer ano;
    private String autor;

    public Livro(Integer id, String titulo, String isbn, Integer ano, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.ano = ano;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
