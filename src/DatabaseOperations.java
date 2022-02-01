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
            return false;
        }
    }
    public boolean insertToDatabase(String value1,String value2){
        try{
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO voting_results values(?,?,?)");
            stmt.setInt(1,i++);
            stmt.setString(2,value1);
            stmt.setString(3,value2);
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
    public String[] votingResults(){
        try {
            String voteForCandidate1="0";
            String voteForCandidate2="0";
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select results_for_candidate1 as cand1,results_for_candidate2 as cand2 from voting_results where id=(Select max(id) from voting_results)");
            while (rs.next()){
                voteForCandidate1=rs.getString("cand1");
                voteForCandidate2=rs.getString("cand2");

            }
            return new String[]{voteForCandidate1,voteForCandidate2};
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
