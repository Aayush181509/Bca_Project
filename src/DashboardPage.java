import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardPage {
    String search;
    JFrame f;
    DatabaseOperations db;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JButton doneButton;
    private JPanel mainPanel;
    private JButton searchForResultButton;
    private JTextField textField10;

    DashboardPage() {
        db = new DatabaseOperations();
        f = new JFrame("Dashboard Form");
        f.setContentPane(mainPanel);
        f.setSize(500, 500);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(db.connectToDatabase()){
                    if(db.insertToDatabase(textField1.getText().toString(),textField2.getText().toString(),textField3.getText().toString(),
                            Integer.parseInt(textField4.getText()),Integer.parseInt(textField5.getText()),Integer.parseInt(textField6.getText()),
                            Integer.parseInt(textField7.getText()),Integer.parseInt(textField8.getText()),Integer.parseInt(textField9.getText()))) {
                        JOptionPane.showMessageDialog(f,"Data stored successfully");
                    }
                }
        }
    });
        searchForResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search=textField10.getText();
                new StudentResult(search);
            }
        });
    }
}

