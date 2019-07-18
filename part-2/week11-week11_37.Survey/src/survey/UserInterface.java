package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        container.add(new JLabel("Are you?"));
        
        JCheckBox yesBox = new JCheckBox("Yes!");
        JCheckBox noBox = new JCheckBox("No!");
        
        container.add(yesBox);
        container.add(noBox);
    
        container.add(new JLabel("Why?"));
    
        JRadioButton noReasonButton = new JRadioButton("No reason.");
        JRadioButton funButton = new JRadioButton("Because it is fun!");
    
    
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(noReasonButton);
        buttonGroup.add(funButton);
    
        container.add(noReasonButton);
        container.add(funButton);
    
        JButton doneButton = new JButton("Done!");
        container.add(doneButton);
    }

    public JFrame getFrame() {
        return frame;
    }
}
