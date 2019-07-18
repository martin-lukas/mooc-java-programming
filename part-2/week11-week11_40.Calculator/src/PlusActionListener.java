import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlusActionListener implements ActionListener {
    private GraphicCalculator graphCalc;
    
    public PlusActionListener(GraphicCalculator graphCalc) {
        this.graphCalc = graphCalc;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Calculator calc = graphCalc.getCalc();
        JTextField input = graphCalc.getInputField();
        JTextField result = graphCalc.getResultsField();
        try {
            int value = Integer.parseInt(input.getText());
            calc.plus(value);
            result.setText("" + calc.getValue());
        } catch (Exception ex) {
            System.err.println("Not a number.");
            
        }
        input.setText("");
        if (result.getText().equals("0")) {
            graphCalc.getZeroButton().setEnabled(false);
        } else {
            graphCalc.getZeroButton().setEnabled(true);
        }
    }
}
