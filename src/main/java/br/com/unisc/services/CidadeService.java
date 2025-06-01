package br.com.unisc.services;

import br.com.unisc.configs.DBConnection;
import br.com.unisc.entities.Cidade;
import br.com.unisc.entities.Estado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeService {
  private DBConnection connection;
  private EstadoService estadoService;

  public CidadeService() {
    this.connection = new DBConnection();
    estadoService = new EstadoService();
  }

  public List<Cidade> listarCidade(Long estadoId) {
    String query = """
                SELECT
                    c.id AS cidade_id,
                    c.nome_cidade
                FROM tb_cidade c
                WHERE c.estado_id = ?;
                """;
    try(PreparedStatement st = connection.getConnection().prepareStatement(query)) {
      st.setLong(1, estadoId);
      try(ResultSet rs = st.executeQuery()) {
        if(rs.next()) {
          List<Cidade> cidades = new ArrayList<>();
          do {
            Long id = rs.getLong("cidade_id");
            String nome = rs.getString("nome_cidade");

            Cidade cidade = new Cidade(id, nome);
            cidades.add(cidade);
          } while(rs.next());
          return cidades;
        } else {
          return null;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public Cidade buscarCidade(Long id) {
    String query = """
                SELECT
                    c.id AS cidade_id,
                    c.nome_cidade,
                    e.id AS estado_id,
                    AVG(CASE WHEN ti.nome = 'IFDM Geral' THEN i.ifdm END) AS ifdm_geral,
                    AVG(CASE WHEN ti.nome = 'IFDM Educação' THEN i.ifdm END) AS ifdm_educacao,
                    AVG(CASE WHEN ti.nome = 'IFDM Saúde' THEN i.ifdm END) AS ifdm_saude,
                    AVG(CASE WHEN ti.nome = 'IFDM Emprego&Renda' THEN i.ifdm END)AS ifdm_emprego,
                
                    ROUND(AVG(i.ranking_estado)) AS media_ranking_estado,
                    ROUND(AVG(i.ranking)) AS media_ranking_nacional
                
                FROM tb_info i
                JOIN tb_cidade c ON i.cidade_id = c.id
                JOIN tb_estado e ON c.estado_id = e.id
                JOIN tb_tipo_info ti ON i.tipo_id = ti.id
                WHERE c.id = ?
                GROUP BY c.id, c.nome_cidade, e.nome
                ORDER BY e.nome, c.nome_cidade;
                """;
    try (PreparedStatement st = connection.getConnection().prepareStatement(query)) {
      st.setLong(1, id);
      try (ResultSet rs = st.executeQuery()) {
        if (rs.next()) {
          Long cidadeId = rs.getLong("cidade_id");
          String nomeCidade = rs.getString("nome_cidade");
          Long estadoId = rs.getLong("estado_id");
          Double mediaIfdmGeral = rs.getDouble("ifdm_geral");
          Double mediaIfdmEducacao = rs.getDouble("ifdm_educacao");
          Double mediaIfdmSaude = rs.getDouble("ifdm_saude");
          Double mediaIfdmRenda = rs.getDouble("ifdm_emprego");
          int rankingNacional = rs.getInt("media_ranking_nacional");
          int rankingEstadual = rs.getInt("media_ranking_estado");
          Estado estado = estadoService.buscarEstadoPorId(estadoId);
          return new Cidade(cidadeId, nomeCidade, estado, mediaIfdmSaude, mediaIfdmEducacao, mediaIfdmRenda, mediaIfdmGeral, rankingNacional, rankingEstadual);
        } else {
          return null;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
}
