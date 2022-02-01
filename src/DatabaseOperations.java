import java.sql.*;

public class DatabaseOperations {
    final String URL="jdbc:mysql://localhost:3306/mydatabase";
    final String username="root";
    final String password="mysql@123";
    private Connection conn;
    static int i,j;

    public boolean connectToDatabase(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(URL,username,password);
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }
    public boolean insertToDatabase(String roll_no,String name,String school_name,int standard,int maths,int science,int english,int hindi,int computer){
        try{
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO student_data values(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,roll_no);
            stmt.setString(2,name);
            stmt.setString(3,school_name);
            stmt.setInt(4,standard);
            stmt.setInt(5,maths);
            stmt.setInt(6,science);
            stmt.setInt(7,english);
            stmt.setInt(8,hindi);
            stmt.setInt(9,computer);
            int i=stmt.executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean storeRegisteredRecords(String first,String last, String username, String staffId, String password){
        try {
            PreparedStatement stmt;
            stmt = conn.prepareStatement("INSERT INTO registered_values values(?,?,?,?,?,?)");
            stmt.setInt(1,j++);
            stmt.setString(2,first);
            stmt.setString(3,last);
            stmt.setString(4,username);
            stmt.setString(5,staffId);
            stmt.setString(6,password);
            int i=stmt.executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean checkForLogin(String username,String password){
        try {
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select username,password from registered_values");
            while(rs.next()){
                if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))){
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public String[] studentResults(String roll_no){
        String sql_stmt;
        try {
            String roll="",name="",school="";
            int standard=0,maths=0,science=0,english=0,hindi=0,computer=0;
            Statement stmt=conn.createStatement();
            sql_stmt="Select * from student_data where roll_no='"+roll_no+"'";
            ResultSet rs=stmt.executeQuery(sql_stmt);
            while (rs.next()){
                roll=rs.getString(1);
                name=rs.getString(2);
                school=rs.getString(3);
                standard=rs.getInt(4);
                maths=rs.getInt(5);
                science=rs.getInt(6);
                english=rs.getInt(7);
                hindi=rs.getInt(8);
                computer=rs.getInt(9);
            }
            return new String[]{roll,name,school,Integer.toString(standard),Integer.toString(maths),
                    Integer.toString(science),Integer.toString(english),Integer.toString(hindi),Integer.toString(computer)};
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new String[]{"1000","1000"};
        }
    }
    public boolean closeDatabase(){
        try {
            conn.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
