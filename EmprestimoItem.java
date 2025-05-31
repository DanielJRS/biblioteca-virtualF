package br.com.bpkedu.library_spring_webmvc.domain;

import jakarta.persistence.*;

@Entity
public class EmprestimoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_livro_off")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "id_livro_of")
    private Emprestimo emprestimo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }


}
