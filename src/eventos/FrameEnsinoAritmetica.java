package eventos;

import javax.swing.*;
import java.awt.event.KeyAdapter;

public class FrameEnsinoAritmetica extends JFrame {
    private JPanel mainPanel;
    private JLabel problema;
    private JTextField resultado;

    public FrameEnsinoAritmetica (){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        mainPanel.addKeyListener(new KeyAdapter() {
        });
    }

    public static void main(String[] args) {
        JFrame frame= new FrameEnsinoAritmetica();
        frame.setVisible(true);
    }
}
