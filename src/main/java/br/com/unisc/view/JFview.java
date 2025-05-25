package br.com.unisc.view;

import javax.swing.*;
import java.awt.*;

public class JFview extends JFrame {

    JFview() {

        setTitle("Índice FIRJAN de Desenvolvimento Municipal");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        JPanel JPtop = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JButton btnImport = new JButton("Import");
        JButton btnApurarMedias = new JButton("Apurar medias");
        JPtop.add(btnImport);
        JPtop.add(btnApurarMedias);

        JPanel JPmid = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JLabel labUf = new JLabel("UF");
        JComboBox<String> comboUF = new JComboBox<>();
        JLabel labCidade = new JLabel("Cidade");
        JComboBox<String> comboCidades = new JComboBox<>();
        JPmid.add(labUf);
        JPmid.add(comboUF);
        JPmid.add(labCidade);
        JPmid.add(comboCidades);

        JPanel JPbottom = new JPanel(new GridLayout(1, 2, 10, 0));

        JPanel jpUfMedias = new JPanel();
        jpUfMedias.setLayout(new BoxLayout(jpUfMedias, BoxLayout.Y_AXIS));
        jpUfMedias.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labUfMedias  = new JLabel("Média da UF selecionada:");
        JLabel labUfSaude = new JLabel("Saude");
        JLabel labUfeducacao = new JLabel("Educacao");
        JLabel labUfRenda = new JLabel("Frenda");
        JLabel labUfIfdm = new JLabel("IFDM");
        JTextField txtUfSaudeMedia = new JTextField();
        JTextField txtUfEducacaoMedia = new JTextField();
        JTextField txtUfRendaMedia = new JTextField();
        JTextField txtUfIfdmMedia = new JTextField();

        JLabel labCidadesMedias  = new JLabel("Média da cidade selecionada:");
        JLabel labMunicipioSaude  = new JLabel("Municipio Saude");
        JLabel labMunicipioEducacao = new JLabel("Municipio Educacao");
        JLabel labMunicipioRenda = new JLabel("Municipior enda");
        JLabel labMunicipioIfdm = new JLabel("Municipio IFDM");
        JLabel labRankNacional  = new JLabel("Rank Nacional");
        JLabel labRankEst  = new JLabel("Rank Est");
        JTextField txtMunicipioSaudeMedia = new JTextField();
        JTextField txtMunicipioEducacaoMedia = new JTextField();
        JTextField txtMunicipioRendaMedia = new JTextField();
        JTextField txtMunicipioIfdmMedia = new JTextField();
        JTextField txtRankNacional  = new JTextField();
        JTextField txtRankEst  = new JTextField();

        JPbottom.add(labUfMedias);
        JPbottom.add(labUfSaude);
        JPbottom.add(txtUfSaudeMedia);
        JPbottom.add(labUfeducacao);
        JPbottom.add(txtUfEducacaoMedia);
        JPbottom.add(labUfRenda);
        JPbottom.add(txtUfRendaMedia);
        JPbottom.add(labUfIfdm);
        JPbottom.add(txtUfIfdmMedia);

        JPbottom.add(labCidadesMedias);
        JPbottom.add(labMunicipioSaude);
        JPbottom.add(txtMunicipioSaudeMedia);
        JPbottom.add(labMunicipioEducacao);
        JPbottom.add(txtMunicipioEducacaoMedia);
        JPbottom.add(labMunicipioRenda);
        JPbottom.add(txtMunicipioRendaMedia);
        JPbottom.add(labMunicipioIfdm);
        JPbottom.add(txtMunicipioIfdmMedia);
        JPbottom.add(labRankNacional);
        JPbottom.add(txtRankNacional);
        JPbottom.add(labRankEst);
        JPbottom.add(txtRankEst);




        add(JPtop);
        add(JPmid);
        add(JPbottom);
        setVisible(true);
    }

    public static void main(String[] args) {

        JFview frame = new JFview() ;
        frame.setVisible(true);

    }

}
