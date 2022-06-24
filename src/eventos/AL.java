package eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class AL extends Listeners {
    private JPanel panel;
    TextField text = new TextField(20);
    Button b, c;
    private int numClicks = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("My first window");
        frame.setContentPane(new AL().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public AL() {
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        b = new Button("Click me");
        c = new Button("mamas");
        panel.add(b);
        panel.add(c);
        panel.add(text);
        b.addMouseListener(new Listeners(){
            @Override
            public void mouseClicked(MouseEvent e) {
                numClicks+=1;
                text.setText(""+numClicks);
            }
        });
    }

}
