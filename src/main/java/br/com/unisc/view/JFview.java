package br.com.unisc.view;

import br.com.unisc.entities.Cidade;
import br.com.unisc.entities.Estado;
import br.com.unisc.services.CidadeService;
import br.com.unisc.services.EstadoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class JFview extends JFrame {

  private List<Estado> estados;
  private EstadoService estadoService;
  private CidadeService cidadeService;
  private List<Cidade> cidades;
  private Estado estadoSelecionado;
  private Cidade cidadeSelecionada;


  private JPanel JComboBoxPanel;
  private JLabel labUf;
  private JComboBox<Estado> comboUF;
  private JLabel labCidade;
  private JComboBox<Cidade> comboCidades;

  private JPanel JInfoPanel;
  private JPanel jpUfMedias;
  private JLabel labUfMedias;

  private JPanel jpAux1;
  private JLabel labUfSaude;
  private JTextField txtUfSaudeMedia;
  private JPanel jpAux2;

  private JPanel jpAux3;
  private JLabel labUfeducacao;
  private JTextField txtUfEducacaoMedia;
  private JLabel labUfRenda;
  private JTextField txtUfRendaMedia;

  private JPanel jpAux4;
  private JLabel labUfIfdm;
  private JTextField txtUfIfdmMedia;
  private JPanel jpCidadesMedias;
  private JLabel labCidadesMedias;

  private JPanel jpAux5;
  private JLabel labMunicipioSaude;
  private JTextField txtMunicipioSaudeMedia;

  private JPanel jpAux6;
  private JLabel labMunicipioEducacao;
  private JTextField txtMunicipioEducacaoMedia;

  private JPanel jpAux7;
  private JLabel labMunicipioRenda;
  private JTextField txtMunicipioRendaMedia;

  private JPanel jpAux8;
  private JLabel labMunicipioIfdm;
  private JTextField txtMunicipioIfdmMedia;

  private JPanel jpAux9;
  private JLabel labRankNacional;
  private JTextField txtRankNacional;

  private JPanel jpAux10;
  private JLabel labRankEst;
  private JTextField txtRankEst;

  public JFview() {
    estadoService = new EstadoService();
    cidadeService = new CidadeService();
    estados = estadoService.listarEstados();
    initComponents();
    populateMedias();
  }
  private void initComponents() {
    setTitle("Índice FIRJAN de Desenvolvimento Municipal");
    setSize(800, 400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout(5, 5));

    JComboBoxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
    labUf = new JLabel("UF");
    comboUF = new JComboBox<>(estados.toArray(new Estado[0]));
    labCidade = new JLabel("Cidade");
    comboCidades = new JComboBox<>();

    comboUF.addActionListener(this::handleComboUfAction);
    comboCidades.addActionListener(this::handleComboCidadeAction);

    Dimension comboSize = new Dimension(200, 20);
    comboUF.setPreferredSize(comboSize);
    comboCidades.setPreferredSize(comboSize);

    JComboBoxPanel.add(labUf);
    JComboBoxPanel.add(comboUF);
    JComboBoxPanel.add(labCidade);
    JComboBoxPanel.add(comboCidades);

    JInfoPanel = new JPanel(new GridLayout(1, 2, 10, 0));

    jpUfMedias = new JPanel();
    jpUfMedias.setLayout(new BoxLayout(jpUfMedias, BoxLayout.Y_AXIS));
    jpUfMedias.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    labUfMedias  = new JLabel("Média da UF selecionada:");
    labUfMedias.setAlignmentX(Component.LEFT_ALIGNMENT);

    jpAux1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    labUfSaude = new JLabel("Saúde:");
    txtUfSaudeMedia = new JTextField(10);
    txtUfSaudeMedia.setEditable(false);
    jpAux1.add(labUfSaude);
    jpAux1.add(txtUfSaudeMedia);

    jpAux2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    labUfeducacao = new JLabel("Educação:");
    txtUfEducacaoMedia = new JTextField(10);
    txtUfEducacaoMedia.setEditable(false);
    jpAux2.add(labUfeducacao);
    jpAux2.add(txtUfEducacaoMedia);

    jpAux3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    labUfRenda = new JLabel("Renda:");
    txtUfRendaMedia = new JTextField(10);
    txtUfRendaMedia.setEditable(false);
    jpAux3.add(labUfRenda);
    jpAux3.add(txtUfRendaMedia);

    jpAux4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    labUfIfdm = new JLabel("IFDM:");
    txtUfIfdmMedia = new JTextField(10);
    txtUfIfdmMedia.setEditable(false);
    jpAux4.add(labUfIfdm);
    jpAux4.add(txtUfIfdmMedia);

    jpUfMedias.add(labUfMedias);
    jpUfMedias.add(Box.createRigidArea(new Dimension(0, 5)));
    jpUfMedias.add(jpAux1);
    jpUfMedias.add(jpAux2);
    jpUfMedias.add(jpAux3);
    jpUfMedias.add(jpAux4);

    jpCidadesMedias = new JPanel();
    jpCidadesMedias.setLayout(new BoxLayout(jpCidadesMedias, BoxLayout.Y_AXIS));
    jpCidadesMedias.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    labCidadesMedias = new JLabel("Média da cidade selecionada:");
    labCidadesMedias.setAlignmentX(Component.LEFT_ALIGNMENT);

    jpAux5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    labMunicipioSaude = new JLabel("Saúde Município:");
    txtMunicipioSaudeMedia = new JTextField(10);
    txtMunicipioSaudeMedia.setEditable(false);
    jpAux5.add(labMunicipioSaude);
    jpAux5.add(txtMunicipioSaudeMedia);

    jpAux6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    labMunicipioEducacao = new JLabel("Educação Município:");
    txtMunicipioEducacaoMedia = new JTextField(10);
    txtMunicipioEducacaoMedia.setEditable(false);
    jpAux6.add(labMunicipioEducacao);
    jpAux6.add(txtMunicipioEducacaoMedia);

    jpAux7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    labMunicipioRenda = new JLabel("Renda Município:");
    txtMunicipioRendaMedia = new JTextField(10);
    txtMunicipioRendaMedia.setEditable(false);
    jpAux7.add(labMunicipioRenda);
    jpAux7.add(txtMunicipioRendaMedia);

    jpAux8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    labMunicipioIfdm = new JLabel("IFDM Município:");
    txtMunicipioIfdmMedia = new JTextField(10);
    txtMunicipioIfdmMedia.setEditable(false);
    jpAux8.add(labMunicipioIfdm);
    jpAux8.add(txtMunicipioIfdmMedia);

    jpAux9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    labRankNacional = new JLabel("Rank Nacional:");
    txtRankNacional = new JTextField(10);
    txtRankNacional.setEditable(false);
    jpAux9.add(labRankNacional);
    jpAux9.add(txtRankNacional);

    jpAux10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    labRankEst = new JLabel("Rank Estadual:");
    txtRankEst = new JTextField(10);
    txtRankEst.setEditable(false);
    jpAux10.add(labRankEst);
    jpAux10.add(txtRankEst);

    jpCidadesMedias.add(labCidadesMedias);
    jpCidadesMedias.add(Box.createRigidArea(new Dimension(0, 5)));
    jpCidadesMedias.add(jpAux5);
    jpCidadesMedias.add(jpAux6);
    jpCidadesMedias.add(jpAux7);
    jpCidadesMedias.add(jpAux8);
    jpCidadesMedias.add(jpAux9);
    jpCidadesMedias.add(jpAux10);

    JInfoPanel.add(jpUfMedias);
    JInfoPanel.add(jpCidadesMedias);
    add(JComboBoxPanel, BorderLayout.CENTER);
    add(JInfoPanel, BorderLayout.SOUTH);

    pack();
    setVisible(true);
  }

  private void handleComboUfAction(ActionEvent e) {
      populateMedias();
  }

  private void handleComboCidadeAction(ActionEvent e) {
    cidadeSelecionada = (Cidade) comboCidades.getSelectedItem();
    if(cidadeSelecionada == null) {
      return;
    }
    cidadeSelecionada = cidadeService.buscarCidade(cidadeSelecionada.getId());
    populateCidadeMedias();
  }

  private void populateMedias() {
    estadoSelecionado = (Estado) comboUF.getSelectedItem();
    if (estadoSelecionado != null) {
      txtUfSaudeMedia.setText(String.valueOf(estadoSelecionado.getMediaIfdmSaude()));
      txtUfEducacaoMedia.setText(String.valueOf(estadoSelecionado.getMediaIfdmEducacao()));
      txtUfRendaMedia.setText(String.valueOf(estadoSelecionado.getMediaIfdmRenda()));
      txtUfIfdmMedia.setText(String.valueOf(estadoSelecionado.getMediaIfdmGeral()));
    }
    cidades = cidadeService.listarCidade(estadoSelecionado.getId());
    comboCidades.removeAllItems();
    for (Cidade cidade : cidades) {
      comboCidades.addItem(cidade);
    }
  }
  private void populateCidadeMedias() {
    if (cidadeSelecionada != null) {
      txtMunicipioSaudeMedia.setText(String.valueOf(cidadeSelecionada.getMediaIfdmSaude()));
      txtMunicipioEducacaoMedia.setText(String.valueOf(cidadeSelecionada.getMediaIfdmEducacao()));
      txtMunicipioRendaMedia.setText(String.valueOf(cidadeSelecionada.getMediaIfdmRenda()));
      txtMunicipioIfdmMedia.setText(String.valueOf(cidadeSelecionada.getMediaIfdmGeral()));
      txtRankNacional.setText(String.valueOf(cidadeSelecionada.getRankingNacional()));
      txtRankEst.setText(String.valueOf(cidadeSelecionada.getRankingEstadual()));
    }
  }
}
