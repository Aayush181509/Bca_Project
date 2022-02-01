import javax.swing.*;

public class ResultPage {
    JFrame f;
    DatabaseOperations db;
    private JPanel mainPanel;
    private JLabel standard;
    private JLabel school;
    private JLabel roll_no;
    private JLabel name;
    private JLabel maths;
    private JLabel science;
    private JLabel english;
    private JLabel hindi;
    private JLabel computer;
    String[] values;
    ResultPage(String search){
        db=new DatabaseOperations();
        f = new JFrame("Dashboard Form");
        f.setContentPane(mainPanel);
        f.setSize(500, 500);
        if(db.connectToDatabase()){
            values=db.studentResults(search);
            name.setText(values[1]);
            standard.setText(values[3]);
            school.setText(values[2]);
            roll_no.setText(values[0]);
            maths.setText(values[4]);
            science.setText(values[5]);
            english.setText(values[6]);
            hindi.setText(values[7]);
            computer.setText(values[8]);
        }

        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

    }
}
