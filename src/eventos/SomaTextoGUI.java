package eventos;

// Notas para resolução
// sendo e um evento do teclado, o codigo ascii do caractere digitado é obtido por
// int code = e.getKeyCode();

// quando code está entre '0' e '9', foi pressionado um dígito
// para saber a que dígito corresponde code, de modo a somar, podemos usar
// Character.getNumericValue(e.getKeyChar())

// quando code está entre 'A' e 'Z' ou entre 'a' e 'z', pressionada uma letra; podemos ignorar os restantes caracteres
// neste caso soma-se o próprio valor de code

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SomaTextoGUI {
    private JPanel panel;
    JTextField jtfInput = new JTextField(20);
    JLabel num = new JLabel("num");
    JLabel alfa = new JLabel("alfa");
    JLabel numChar = new JLabel("numChar");
    JButton click = new JButton("Calcula");

    public static void main (String[] args) {
        JFrame frame = new JFrame("Soma Texto");
        frame.setContentPane(new SomaTextoGUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public SomaTextoGUI() {
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(click);
        panel.add(jtfInput);
        panel.add(num);
        panel.add(alfa);
        panel.add(numChar);

        jtfInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {


                char[] aux = jtfInput.getText().toCharArray();

                int aux2 = 0;

                for (int i = 0; i < aux.length; i++) {

                    if ((aux[i]>=65 && aux[i] <=90) || (aux[i]>=97 && aux[i]<=122)){
                        aux2 += aux[i];
                    }


                }
                alfa.setText("" + aux2);
            }
        });

        click.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                numChar.setText("" + jtfInput.getText().length());
            }
        });

    }
}
