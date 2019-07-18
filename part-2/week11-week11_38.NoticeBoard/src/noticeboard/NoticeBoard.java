package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new GridLayout(3, 1));
        
        JTextField text = new JTextField("");
        JButton copy = new JButton("Copy!");
        JLabel label = new JLabel();
    
        ActionEventListener listener = new ActionEventListener(text, label);
        copy.addActionListener(listener);
        
        container.add(text);
        container.add(copy);
        container.add(label);
    }
}
