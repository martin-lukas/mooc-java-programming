import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZeroActionListener implements ActionListener {
    private GraphicCalculator graphCalc;
    
    public ZeroActionListener(GraphicCalculator graphCalc) {
        this.graphCalc = graphCalc;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Calculator calc = graphCalc.getCalc();
        JTextField input = graphCalc.getInputField();
        JTextField result = graphCalc.getResultsField();
        
        calc.reset();
        result.setText("" + calc.getValue());
        input.setText("");
        if (result.getText().equals("0")) {
            graphCalc.getZeroButton().setEnabled(false);
        } else {
            graphCalc.getZeroButton().setEnabled(true);
        }
    }
}
