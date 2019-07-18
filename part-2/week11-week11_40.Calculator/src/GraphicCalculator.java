
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class GraphicCalculator implements Runnable {
    private JFrame frame;
    private Calculator calc;
    
    private JTextField resultsField;
    private JTextField inputField;
    
    private JPanel buttonPanel;
    private JButton plusButton;
    private JButton minusButton;
    private JButton zeroButton;
    
    @Override
    public void run() {
        calc = new Calculator();
        
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        container.setLayout(new GridLayout(3, 1));
        
        resultsField = new JTextField("0");
        resultsField.setEnabled(false);
        
        inputField = new JTextField();
        
        container.add(resultsField);
        container.add(inputField);
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        
        plusButton = new JButton("+");
        plusButton.addActionListener(new PlusActionListener(this));
        minusButton = new JButton("-");
        minusButton.addActionListener(new MinusActionListener(this));
        zeroButton = new JButton("Z");
        zeroButton.setEnabled(false);
        zeroButton.addActionListener(new ZeroActionListener(this));
        
        buttonPanel.add(plusButton);
        buttonPanel.add(minusButton);
        buttonPanel.add(zeroButton);
        
        container.add(buttonPanel);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public Calculator getCalc() {
        return calc;
    }
    
    public JButton getPlusButton() {
        return plusButton;
    }
    
    public JButton getMinusButton() {
        return minusButton;
    }
    
    public JButton getZeroButton() {
        return zeroButton;
    }
    
    public JTextField getInputField() {
        return inputField;
    }
    
    public JTextField getResultsField() {
        return resultsField;
    }
}
