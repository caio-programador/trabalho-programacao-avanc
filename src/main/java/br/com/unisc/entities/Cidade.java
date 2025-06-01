package br.com.unisc.entities;

public class Cidade {
  private Long id;
  private String nome;
  private Estado estado;
  private Double mediaIfdmSaude;
  private Double mediaIfdmEducacao;
  private Double mediaIfdmRenda;
  private Double mediaIfdmGeral;
  private int rankingNacional;
  private int rankingEstadual;

  public Cidade(Long id, String nome, Estado estado,
                Double mediaIfdmSaude, Double mediaIfdmEducacao,
                Double mediaIfdmRenda, Double mediaIfdmGeral,
                int rankingNacional, int rankingEstadual) {
    this.id = id;
    this.nome = nome;
    this.estado = estado;
    this.mediaIfdmSaude = mediaIfdmSaude;
    this.mediaIfdmEducacao = mediaIfdmEducacao;
    this.mediaIfdmRenda = mediaIfdmRenda;
    this.mediaIfdmGeral = mediaIfdmGeral;
    this.rankingNacional = rankingNacional;
    this.rankingEstadual = rankingEstadual;
  }

  public Cidade(Long id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
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

  public int getRankingNacional() {
    return rankingNacional;
  }

  public void setRankingNacional(int rankingNacional) {
    this.rankingNacional = rankingNacional;
  }

  public int getRankingEstadual() {
    return rankingEstadual;
  }

  public void setRankingEstadual(int rankingEstadual) {
    this.rankingEstadual = rankingEstadual;
  }

  @Override
  public String toString() {
    return nome;
  }
}
