import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {
    DatabaseOperations db;
    JFrame f;
    private JPanel mainPanel;
    private JTextField usernameField;
    private JLabel username;
    private JLabel password;
    private JPasswordField passwordField;
    private JButton loginButton;

    LoginPage(){
        db=new DatabaseOperations();
        f=new JFrame("Login Form");
        f.setContentPane(mainPanel);
        f.setSize(500,500);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(db.connectToDatabase()){
                    if(db.checkForLogin(usernameField.getText().toString(),passwordField.getText().toString())){
                        f.dispose();
                        db.closeDatabase();
                        new DashboardPage();
                    }else{

                        JOptionPane.showMessageDialog(f,"Invalid Username and Password");
                    }
                }


            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

