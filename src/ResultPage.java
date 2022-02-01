import javax.swing.*;

public class ResultPage {
    JFrame f;
    private JPanel mainPanel;
    ResultPage(){
        f = new JFrame("Dashboard Form");
        f.setContentPane(mainPanel);
        f.setSize(500, 500);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }
}
