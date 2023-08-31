import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Java_Calci {

    private double currentValue = 0.0;
    private char currentOperator = ' ';
    private JPanel Java_Calculator;
    private JTextField textDisplay;
    private JButton btnThree;
    private JButton btnDivide;
    private JButton btnMultiply;
    private JButton btnMinus;
    private JButton btnFour;
    private JButton btnSeven;
    private JButton btnPoint;
    private JButton btnTwo;
    private JButton btnOne;
    private JButton btnFive;
    private JButton btnEight;
    private JButton btnZero;
    private JButton btnPlus;
    private JButton btnSix;
    private JButton btnNine;
    private JButton btnClear;
    private JButton btnEquals;
    private JButton btnSquare;
    private JButton btnRoot;
    private JButton btnDelete;


    // Helper method to handle performing the previous operation
    private void performPreviousOperation() {
        if (currentOperator != ' ') {
            double newValue = Double.parseDouble(textDisplay.getText());
            switch (currentOperator) {
                case '+':
                    currentValue += newValue;
                    break;
                case '-':
                    currentValue -= newValue;
                    break;
                case '*':
                    currentValue *= newValue;
                    break;
                case '/':
                    currentValue /= newValue;
                    break;
            }
            textDisplay.setText(Double.toString(currentValue));
        } else {
            currentValue = Double.parseDouble(textDisplay.getText());
            textDisplay.setText("");
        }
    }

    public Java_Calci(){
        btnOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnOneText = textDisplay.getText() + btnOne.getText();
                textDisplay.setText(btnOneText);

            }
        });
        btnTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnTwoText = textDisplay.getText() + btnTwo.getText();
                textDisplay.setText(btnTwoText);

            }
        });
        btnThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnThreeText = textDisplay.getText() + btnThree.getText();
                textDisplay.setText(btnThreeText);

            }
        });
        btnFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnFourText = textDisplay.getText() + btnFour.getText();
                textDisplay.setText(btnFourText);

            }
        });
        btnFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnFiveText = textDisplay.getText() + btnFive.getText();
                textDisplay.setText(btnFiveText);

            }
        });
        btnSix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnSixText = textDisplay.getText() + btnSix.getText();
                textDisplay.setText(btnSixText);

            }
        });
        btnSeven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnSevenText = textDisplay.getText() + btnSeven.getText();
                textDisplay.setText(btnSevenText);

            }
        });
        btnEight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnEightText = textDisplay.getText() + btnEight.getText();
                textDisplay.setText(btnEightText);

            }
        });
        btnNine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnNineText = textDisplay.getText() + btnNine.getText();
                textDisplay.setText(btnNineText);

            }
        });
        btnZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnZeroText = textDisplay.getText() + btnZero.getText();
                textDisplay.setText(btnZeroText);

            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                tot2=0;
                currentValue=0;
                currentOperator=' ';
                textDisplay.setText("");
            }
        });
        btnPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textDisplay.getText().equals("")){
                    textDisplay.setText("0.");
                }
                else if(textDisplay.getText().contains(".")){
                    btnPoint.setEnabled(false);
                }
                else {
                    String btnPointText = textDisplay.getText() + btnPoint.getText();
                    textDisplay.setText(btnPointText);
                }
                btnPoint.setEnabled(true);
            }
        });
        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performPreviousOperation();
                currentOperator = '+';
            }
        });

        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performPreviousOperation();
                currentOperator = '-';
            }
        });

        btnMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performPreviousOperation();
                currentOperator = '*';
            }
        });

        btnDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performPreviousOperation();
                currentOperator = '/';
            }
        });
        btnEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentOperator != ' ') {
                    double newValue = Double.parseDouble(textDisplay.getText());
                    switch (currentOperator) {
                        case '+':
                            currentValue += newValue;
                            break;
                        case '-':
                            currentValue -= newValue;
                            break;
                        case '*':
                            currentValue *= newValue;
                            break;
                        case '/':
                            currentValue /= newValue;
                            break;
                    }
                    textDisplay.setText(Double.toString(currentValue));
                    currentOperator = ' ';
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = textDisplay.getText();
                if (!currentText.isEmpty()) {
                    textDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });
        btnRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textDisplay.getText());
                double result = Math.sqrt(value);
                textDisplay.setText(Double.toString(result));
            }
        });
        btnSquare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textDisplay.getText());
                double result = value * value;
                textDisplay.setText(Double.toString(result));
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Java_Calci");
        frame.setContentPane(new Java_Calci().Java_Calculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
