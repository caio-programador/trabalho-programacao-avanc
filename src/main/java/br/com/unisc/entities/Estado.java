package br.com.unisc.entities;

public class Estado {
    private int id;
    private String sigla;
    private String nome;
    private Double mediaIfdmSaude;
    private Double mediaIfdmEducacao;
    private Double mediaIfdmRenda;
    private Double mediaIfdmGeral;

    public Estado(int id, String sigla, String nome,
                  Double mediaIfdmSaude, Double mediaIfdmEducacao,
                  Double mediaIfdmRenda, Double mediaIfdmGeral) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
        this.mediaIfdmSaude = mediaIfdmSaude;
        this.mediaIfdmEducacao = mediaIfdmEducacao;
        this.mediaIfdmRenda = mediaIfdmRenda;
        this.mediaIfdmGeral = mediaIfdmGeral;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMediaIfdmSaude() {
        return mediaIfdmSaude;
    }

    public void setMediaIfdmSaude(Double mediaIfdmSaude) {
        this.mediaIfdmSaude = mediaIfdmSaude;
    }

    public Double getMediaIfdmEducacao() {
        return mediaIfdmEducacao;
    }

    public void setMediaIfdmEducacao(Double mediaIfdmEducacao) {
        this.mediaIfdmEducacao = mediaIfdmEducacao;
    }

    public Double getMediaIfdmRenda() {
        return mediaIfdmRenda;
    }

    public void setMediaIfdmRenda(Double mediaIfdmRenda) {
        this.mediaIfdmRenda = mediaIfdmRenda;
    }

    public Double getMediaIfdmGeral() {
        return mediaIfdmGeral;
    }

    public void setMediaIfdmGeral(Double mediaIfdmGeral) {
        this.mediaIfdmGeral = mediaIfdmGeral;
    }
}
