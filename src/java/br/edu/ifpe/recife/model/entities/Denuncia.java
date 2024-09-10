public class Denuncia {
  private int codigo;
  private Date data;
  private String turno;
  private String descricao;
  private Estudante denunciante;
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


