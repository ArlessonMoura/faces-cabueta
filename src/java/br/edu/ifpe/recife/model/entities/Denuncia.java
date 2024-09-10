
package br.edu.ifpe.recife.model.entities;


import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jeron
 */

@Entity
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(length = 10, nullable = false)
    private String turno;

    @Lob
    private String descricao;

    @Column(length = 150, nullable = false)
    private Estudante denunciante;

    @Column
    private List<Estudante> denunciados;




    public int getCodigo() {
    return codigo;
    }

    public Date getData() {
    return data;
    }

    public String getTurno() {
    return turno;
    }

    public String getDescricao() {
    return descricao;
    }

    public Estudante getDenunciante() {
    return denunciante;
    }

    public List<Estudante> getDenunciados() {
    return denunciados;
    }

    public void setCodigo(int codigo) {
    this.codigo = codigo;
    }

    public void setData(Date data) {
    this.data = data;
    }

    public void setTurno(String turno) {
    this.turno = turno;
    }

    public void setDescricao(String descricao) {
    this.descricao = descricao;
    }

    public void setDenunciante(Estudante denunciante) {
    this.denunciante = denunciante;
    }

    public void setDenunciados(List<Estudante> denunciados) {
        this.denunciados = denunciados;
    }
}


