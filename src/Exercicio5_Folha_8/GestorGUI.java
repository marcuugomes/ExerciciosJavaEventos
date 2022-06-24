package Exercicio5_Folha_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class GestorGUI {
    private JPanel mainPanel;
    private JScrollPane presentationPanel;
    private JPanel searchPanel;
    private JPanel addPanel;
    private JPanel actionsPanel;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem menuItemOpen;
    private JMenuItem menuItemSaveAll;
    private JMenuItem menuItemSaveSelection;
    private JMenuItem menuItemExit;
    private JTextArea studentList;
    private JTextField searchField;
    private JButton searchButton;
    private ButtonGroup searchBtGroup;
    private JRadioButton nameRB;
    private JRadioButton mecRB;
    private JRadioButton evalRB;
    private JTextField mecTxt;
    private JTextField nameTxt;
    private JCheckBox finalEvalCb;
    private JButton addBt;
    private JButton removeBt;
    private JLabel nameLbl;
    private JLabel mecLbl;
    private JButton openBt;
    private JButton saveAllBt;
    private JButton exitBt;
    private JButton saveSelectionBt;
    private JFileChooser fileChooser;

    private JFrame frame;
    private Turma turma;

    public GestorGUI() {
        turma=new Turma();
        geraAlunos(10);
        setupLayout();
        frame = new JFrame("Exercicio5_Folha_8.GestorGUI");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        buildMenuBar();
        frame.setJMenuBar(menuBar);
        buildPresentationPanel();
        buildSearchPanel();
        buildAddPanel();
        buildActionsPanel();
        frame.pack();

        for (Aluno a: turma.getAlunos()) {
            studentList.append(a.infoAluno() + "\n");
        }





        fileChooser = new JFileChooser();


        this.openBt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                studentList.setText(null);
                reset();
            }
        });
        this.searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                studentList.setText(null);

                if (searchBtGroup.getSelection().getActionCommand().equals("nome")) {
                    for( Aluno a : turma.selecionarPorNome(searchField.getText())){
                        studentList.append(a.infoAluno()+"\n");
                    }
                } else if (searchBtGroup.getSelection().getActionCommand().equals("mec")) {
                    
                    for( Aluno a : turma.selecionarPorNumero(Integer.parseInt(searchField.getText()))){
                        studentList.append(a.infoAluno()+"\n");
                    }
                } else if (searchBtGroup.getSelection().getActionCommand().equals("tipo_avaliacao")) {

                    TipoAvaliacao aux = TipoAvaliacao.AV_FINAL;

                    if(searchField.equals("Avaliação Discreta")){
                        aux=TipoAvaliacao.AV_DISCRETA;
                    }else if(searchField.equals("Avaliação Final")){
                        aux=TipoAvaliacao.AV_FINAL;
                    }
                    for( Aluno a : turma.selecionarPorAvaliacao(aux)){
                        studentList.append(a.infoAluno()+"\n");
                    }
                }


            }
        });
    }

    public void reset (){
        for (Aluno a: turma.getAlunos()) {
            studentList.append(a.infoAluno() + "\n");
        }
    }
    public static void main(String[] args) {
        GestorGUI gestorGUI = new GestorGUI();

    }

    private void setupLayout() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setMinimumSize(new Dimension(400, 400));
        mainPanel.setPreferredSize(new Dimension(400, 400));

        // presentation panel
        presentationPanel = new JScrollPane();
        presentationPanel.setMinimumSize(new Dimension(260, 260));
        presentationPanel.setPreferredSize(new Dimension(260, 260));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(presentationPanel, gbc);

        // search panel
        searchPanel = new JPanel();
        searchPanel.setMinimumSize(new Dimension(140, 260));
        searchPanel.setPreferredSize(new Dimension(140, 260));
        searchPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(searchPanel, gbc);

        // add panel
        addPanel = new JPanel();
        addPanel.setMinimumSize(new Dimension(260, 140));
        addPanel.setPreferredSize(new Dimension(260, 140));
        addPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(addPanel, gbc);

        // actions panel
        actionsPanel = new JPanel();
        actionsPanel.setMinimumSize(new Dimension(140, 140));
        actionsPanel.setPreferredSize(new Dimension(140, 140));
        actionsPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(actionsPanel, gbc);
    }

    private void buildPresentationPanel() {
        // area de texto para apresentar a lista de alunos
        studentList = new JTextArea();
        studentList.setEditable(false);
        presentationPanel.setViewportView(studentList);
    }

    private void buildSearchPanel() {
        searchPanel.setLayout(new GridBagLayout());

        // input
        searchField = new JTextField();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        searchPanel.add(searchField, gbc);

        // radio buttons
        nameRB = new JRadioButton("Nome");
        nameRB.setActionCommand("nome");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        searchPanel.add(nameRB, gbc);

        mecRB = new JRadioButton("N.º Mecanográfico");
        mecRB.setActionCommand("mec");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        searchPanel.add(mecRB, gbc);

        evalRB = new JRadioButton("Tipo Avaliação");
        evalRB.setActionCommand("tipo_avaliacao");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        searchPanel.add(evalRB, gbc);

        searchBtGroup = new ButtonGroup();
        searchBtGroup.add(nameRB);
        searchBtGroup.add(mecRB);
        searchBtGroup.add(evalRB);

        // botao
        searchButton = new JButton("Procurar");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        searchPanel.add(searchButton, gbc);
    }

    private void buildAddPanel() {
        addPanel.setLayout(new GridBagLayout());

        // name label
        nameLbl = new JLabel("Nome:");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 0, 0);
        addPanel.add(nameLbl, gbc);
        // name input
        nameTxt = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 0, 10);
        addPanel.add(nameTxt, gbc);

        // nmec label
        mecLbl = new JLabel("N.ºMec.:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(6, 10, 0, 0);
        addPanel.add(mecLbl, gbc);
        // nmec input
        mecTxt = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(6, 0, 0, 10);
        addPanel.add(mecTxt, gbc);

        // final eval check
        finalEvalCb = new JCheckBox("Avaliação Final");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(6, 10, 0, 0);
        addPanel.add(finalEvalCb, gbc);

        // add button
        addBt = new JButton("Adicionar");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(6, 10, 10, 0);
        addPanel.add(addBt, gbc);

        // remove button
        removeBt = new JButton("Remover");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(6, 0, 10, 10);
        addPanel.add(removeBt, gbc);
    }

    private void buildActionsPanel() {
        actionsPanel.setLayout(new GridBagLayout());

        // add button
        openBt = new JButton();
        openBt.setText("Abrir");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 10, 0, 0);
        actionsPanel.add(openBt, gbc);

        // save all button
        saveAllBt = new JButton();
        saveAllBt.setText("Gravar todos");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(8, 10, 0, 0);
        actionsPanel.add(saveAllBt, gbc);

        // save selection button
        saveSelectionBt = new JButton();
        saveSelectionBt.setText("Gravar seleção");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(4, 10, 0, 0);
        actionsPanel.add(saveSelectionBt, gbc);

        // exit button
        exitBt = new JButton();
        exitBt.setText("Sair");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(12, 10, 0, 0);
        actionsPanel.add(exitBt, gbc);
    }

    private void buildMenuBar() {
        menuBar = new JMenuBar();
        menuFile = new JMenu("Ficheiro");
        menuItemOpen = new JMenuItem("Abrir");
        menuItemSaveAll = new JMenuItem("Gravar todos");
        menuItemSaveSelection = new JMenuItem("Gravar selecção");
        menuItemExit = new JMenuItem("Sair");
        menuFile.add(menuItemOpen);
        menuFile.addSeparator();
        menuFile.add(menuItemSaveAll);
        menuFile.add(menuItemSaveSelection);
        menuFile.addSeparator();
        menuFile.add(menuItemExit);
        menuBar.add(menuFile);
    }

    private void geraAlunos(int nAlunos) {
        Random r = new Random();

        String[] nomesProprios = {"Maria", "Ana", "Beatriz", "Matilde", "Leonor", "Sandra", "Carla", "Sónia", "Inês",
                "Catarina", "Mariana", "Sara", "Susana", "Paula", "Cláudia", "Patrícia", "Sílvia", "Andreia", "Joana",
                "Cátia", "Sara", "Tânia", "Liliana", "Daniela", "Diana", "Carolina", "Sofia", "Francisca", "João",
                "Tiago", "Diogo", "Martim", "Rodrigo", "Afonso", "Santiago", "Francisco", "José", "Nuno", "Pedro",
                "Paulo", "Rui", "Luís", "Carlos", "António", "Ricardo", "Bruno", "André", "Miguel", "Tomás", "Duarte",
                "Gabriel", "Eduardo", "Filipe", "Jorge", "Dinis", "Hugo"};
        String[] apelidos = {"Silva", "Santos", "Ferreira", "Pereira", "Oliveira", "Costa", "Rodrigues", "Martins",
                "Jesus", "Sousa", "Fernandes", "Gonçalves", "Gomes", "Lopes", "Marques", "Alves", "Almeida", "Ribeiro",
                "Pinto", "Carvalho", "Teixeira", "Moreira", "Correia", "Mendes", "Nunes", "Soares", "Vieira", "Monteiro",
                "Cardoso", "Rocha", "Raposo", "Neves", "Coelho", "Cruz", "Cunha", "Pires", "Ramos", "Reis", "Simões"};

        for (int i = 0; i < nAlunos; i++) {
            String nomeProprio = nomesProprios[r.nextInt(nomesProprios.length)];
            String apelido = apelidos[r.nextInt(apelidos.length)];

            int nmec = r.nextInt((99999 - 10000) + 1) + 10000;

            // escolher aleatoriamente o tipo de avaliacao, por exemplo algo como
            TipoAvaliacao ta = TipoAvaliacao.AV_FINAL;
            if (r.nextDouble() > 0.5) {
                ta = TipoAvaliacao.AV_DISCRETA;
            }

            // criar o aluno e adiciona-lo a uma turma ?
            turma.addAluno(nomeProprio,nmec,ta);
        }
    }

    private static void printCol(ArrayList<Aluno> c) {

        for( int i=0;i<c.size();i++){
            System.out.println(c.get(i).infoAluno());
        }
    }
}
