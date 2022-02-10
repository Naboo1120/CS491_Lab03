import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempConverter extends JFrame{
    private JPanel panel1;
    private JTextField tempField1;
    private JComboBox tempBox1;
    private JTextField tempField2;
    private JButton clear;
    private JButton calculate;
    private JComboBox tempBox2;
    private JLabel panelLabel;

    public TempConverter(String TempConverter){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp1 = tempBox1.getSelectedItem().toString();
                String temp2 = tempBox2.getSelectedItem().toString();

                if(tempField1.getText() == null || tempField2.getText() == null){
                    tempField1.setText("Please Clear");
                    tempField2.setText("Try Again");
                }
                if(temp1.equals("Fahrenheit") & temp2.equals("Celsius")){
                    //Grabs Text, Converts to Double
                    double tempF = Double.parseDouble(tempField1.getText());

                    //Calculates F to C
                    tempField1.setText(String.valueOf(tempF));
                    tempField2.setText(String.valueOf(((tempF-32)*5)/9));
                }
                if(temp1.equals("Celsius") & temp2.equals("Fahrenheit")){
                    //Grabs Text, Converts to Double
                    double tempC = Double.parseDouble(tempField1.getText());

                    //Calculates C to F
                    tempField1.setText(String.valueOf(tempC));
                    tempField2.setText(String.valueOf(((tempC*9)/5)+32));

                }
                if(temp1.equals(temp2)){
                    String tempF = tempField1.getText();
                    String tempC = tempField1.getText();
                    tempField1.setText(tempF);
                    tempField2.setText(tempC);
                }

            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempField1.setText(null);
                tempField2.setText(null);
            }
        });
    }

    public static void main(String args[]){
        JFrame frame = new TempConverter("Temperature Converter");
        frame.setVisible(true);
    }
}
