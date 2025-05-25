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
            JButton btnImport = new JButton("Importar");
            JButton btnApurarMedias = new JButton("Apurar médias");

            Dimension ButtonsSize = new Dimension(150, 50);
            btnImport.setPreferredSize(ButtonsSize);
            btnApurarMedias.setPreferredSize(ButtonsSize);

            JPtop.add(btnImport);
            JPtop.add(btnApurarMedias);

            JPanel JPmid = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
            JLabel labUf = new JLabel("UF");
            JComboBox<String> comboUF = new JComboBox<>();
            JLabel labCidade = new JLabel("Cidade");
            JComboBox<String> comboCidades = new JComboBox<>();

            Dimension comboSize = new Dimension(200, 20);
            comboUF.setPreferredSize(comboSize);
            comboCidades.setPreferredSize(comboSize);

            JPmid.add(labUf);
            JPmid.add(comboUF);
            JPmid.add(labCidade);
            JPmid.add(comboCidades);

            JPanel JPbottom = new JPanel(new GridLayout(1, 2, 10, 0));

            JPanel jpUfMedias = new JPanel();
            jpUfMedias.setLayout(new BoxLayout(jpUfMedias, BoxLayout.Y_AXIS));
            jpUfMedias.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel labUfMedias  = new JLabel("Média da UF selecionada:");
            labUfMedias.setAlignmentX(Component.LEFT_ALIGNMENT);

            JPanel jpAux1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel labUfSaude = new JLabel("Saúde:");
            JTextField txtUfSaudeMedia = new JTextField(10);
            jpAux1.add(labUfSaude);
            jpAux1.add(txtUfSaudeMedia);

            JPanel jpAux2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel labUfeducacao = new JLabel("Educação:");
            JTextField txtUfEducacaoMedia = new JTextField(10);
            jpAux2.add(labUfeducacao);
            jpAux2.add(txtUfEducacaoMedia);

            JPanel jpAux3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel labUfRenda = new JLabel("Renda:"); // Corrected typo "Frenda"
            JTextField txtUfRendaMedia = new JTextField(10);
            jpAux3.add(labUfRenda);
            jpAux3.add(txtUfRendaMedia);

            JPanel jpAux4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel labUfIfdm = new JLabel("IFDM:");
            JTextField txtUfIfdmMedia = new JTextField(10);
            jpAux4.add(labUfIfdm);
            jpAux4.add(txtUfIfdmMedia);

            jpUfMedias.add(labUfMedias);
            jpUfMedias.add(Box.createRigidArea(new Dimension(0, 5)));
            jpUfMedias.add(jpAux1);
            jpUfMedias.add(jpAux2);
            jpUfMedias.add(jpAux3);
            jpUfMedias.add(jpAux4);

            JPanel jpCidadesMedias = new JPanel();
            jpCidadesMedias.setLayout(new BoxLayout(jpCidadesMedias, BoxLayout.Y_AXIS));
            jpCidadesMedias.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel labCidadesMedias = new JLabel("Média da cidade selecionada:");
            labCidadesMedias.setAlignmentX(Component.LEFT_ALIGNMENT);

            JPanel jpAux5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel labMunicipioSaude = new JLabel("Saúde Município:");
            JTextField txtMunicipioSaudeMedia = new JTextField(10);
            jpAux5.add(labMunicipioSaude);
            jpAux5.add(txtMunicipioSaudeMedia);

            JPanel jpAux6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel labMunicipioEducacao = new JLabel("Educação Município:");
            JTextField txtMunicipioEducacaoMedia = new JTextField(10);
            jpAux6.add(labMunicipioEducacao);
            jpAux6.add(txtMunicipioEducacaoMedia);

            JPanel jpAux7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel labMunicipioRenda = new JLabel("Renda Município:"); // Corrected typo "Municipior enda"
            JTextField txtMunicipioRendaMedia = new JTextField(10);
            jpAux7.add(labMunicipioRenda);
            jpAux7.add(txtMunicipioRendaMedia);

            JPanel jpAux8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel labMunicipioIfdm = new JLabel("IFDM Município:");
            JTextField txtMunicipioIfdmMedia = new JTextField(10);
            jpAux8.add(labMunicipioIfdm);
            jpAux8.add(txtMunicipioIfdmMedia);

            JPanel jpAux9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel labRankNacional = new JLabel("Rank Nacional:");
            JTextField txtRankNacional = new JTextField(10);
            jpAux9.add(labRankNacional);
            jpAux9.add(txtRankNacional);

            JPanel jpAux10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel labRankEst = new JLabel("Rank Estadual:");
            JTextField txtRankEst = new JTextField(10);
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

            JPbottom.add(jpUfMedias);
            JPbottom.add(jpCidadesMedias);

            add(JPtop, BorderLayout.NORTH);
            add(JPmid, BorderLayout.CENTER);
            add(JPbottom, BorderLayout.SOUTH);

            pack();
            setVisible(true);
        }

        public static void main(String[] args) {

            JFview frame = new JFview() ;
            frame.setVisible(true);

        }

    }
