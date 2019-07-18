package noticeboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventListener implements ActionListener {
    private JTextField text;
    private JLabel label;
    
    public ActionEventListener(JTextField text, JLabel label) {
        this.text = text;
        this.label = label;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.label.setText(this.text.getText());
        this.text.setText("");
    }
}
