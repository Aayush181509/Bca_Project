public class Main {
    static boolean value;
    public static void main(String[] args) {
        System.out.println("Hello");
        DatabaseOperations db=new DatabaseOperations();
        value=db.connectToDatabase();
        System.out.println(db.insertToDatabase("181509","Aayush","Ncit",5,89,90,87,86,99));
        db.closeDatabase();
    }
}
