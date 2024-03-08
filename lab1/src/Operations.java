import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Operations {
    public static void main(String[] args) {

    }
    static void update(String whatToUpdate , String newUpdateValue , int enterID){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceJava", "root", "rajeevIsGod");


            String updateQuery = "UPDATE notes_app SET " + whatToUpdate + " = ? WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(updateQuery);


            preparedStatement.setString(1, newUpdateValue);
            preparedStatement.setInt(2, enterID);


            int rowAffected = preparedStatement.executeUpdate();

            System.out.println(rowAffected + " rows affected");

            preparedStatement.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    static void insert(String title , String description){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceJava", "root", "rajeevIsGod");

            // Use PreparedStatement to create a parameterized query
            String insertQuery = "INSERT INTO notes_app (title, description) VALUES (?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);

            // Set the values for the placeholders
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);

            // Execute the insert
            int rowAffected = preparedStatement.executeUpdate();

            System.out.println(rowAffected + " rows affected");

            preparedStatement.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    static void delete(int enterID){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceJava", "root", "rajeevIsGod");
            Statement st = con.createStatement();

            // Use the parameterized query to delete a specific record by ID
            int rowAffected = st.executeUpdate("DELETE FROM notes_app WHERE id = " + enterID);

            System.out.println(rowAffected + " rows affected");

            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    static void showTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceJava", "root", "rajeevIsGod");
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM notes_app" );

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("title");
                String address = resultSet.getString("description");

                System.out.println("\n ID: " + id + "\n Title: " + name + "\n Address: " + address);
                System.out.println();
                System.out.println();
            }

            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
