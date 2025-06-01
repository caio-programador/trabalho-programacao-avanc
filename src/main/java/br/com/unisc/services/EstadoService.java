package br.com.unisc.services;

import br.com.unisc.configs.DBConnection;
import br.com.unisc.entities.Estado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoService {
  private DBConnection connection;

  public EstadoService() {
    this.connection = new DBConnection();
  }

  public List<Estado> listarEstados() {
    String query = """
                SELECT \
                    e.id AS estado_id, \
                    e.sigla AS sigla_estado, \
                    e.nome AS nome_estado, \
                    AVG(CASE WHEN ti.nome = 'IFDM Geral' THEN i.ifdm END) AS ifdm_geral, \
                    AVG(CASE WHEN ti.nome = 'IFDM Educação' THEN i.ifdm END) AS ifdm_educacao, \
                    AVG(CASE WHEN ti.nome = 'IFDM Saúde' THEN i.ifdm END) AS ifdm_saude, \
                    AVG(CASE WHEN ti.nome = 'IFDM Emprego&Renda' THEN i.ifdm END) AS ifdm_emprego \
                FROM tb_info i \
                JOIN tb_cidade c ON i.cidade_id = c.id \
                JOIN tb_estado e ON c.estado_id = e.id \
                JOIN tb_tipo_info ti ON i.tipo_id = ti.id \
                GROUP BY e.id, e.nome \
                ORDER BY e.nome; """;
    try(PreparedStatement st = connection.getConnection().prepareStatement(query)) {
      try(ResultSet rs = st.executeQuery()) {
        if(rs.next()) {
          List<Estado> estados = new ArrayList<>();
          do {
            Long id = rs.getLong("estado_id");
            String sigla = rs.getString("sigla_estado");
            String nome = rs.getString("nome_estado");
            Double mediaIfdmGeral = rs.getDouble("ifdm_geral");
            Double mediaIfdmEducacao = rs.getDouble("ifdm_educacao");
            Double mediaIfdmSaude = rs.getDouble("ifdm_saude");
            Double mediaIfdmRenda = rs.getDouble("ifdm_emprego");

            Estado estado = new Estado(id, sigla, nome, mediaIfdmSaude, mediaIfdmEducacao, mediaIfdmRenda, mediaIfdmGeral);
            estados.add(estado);
          } while(rs.next());
          return estados;
        }{
          return null;
        }
      }
    } catch (SQLException e) {;
      e.printStackTrace();
      return null;
    }
  }
  public Estado buscarEstadoPorId(Long id) {
    String query = """
                SELECT *
                FROM tb_estado
                WHERE id=?
                """;
    try (PreparedStatement st = connection.getConnection().prepareStatement(query)) {
      st.setLong(1, id);
      try (ResultSet rs = st.executeQuery()) {
        if (rs.next()) {
          Long estadoId = rs.getLong("id");
          String sigla = rs.getString("sigla");
          String nome = rs.getString("nome");

          return new Estado(estadoId, sigla, nome);
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
