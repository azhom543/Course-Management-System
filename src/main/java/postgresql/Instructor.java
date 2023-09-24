package postgresql;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class Instructor {
    private UUID id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String title;

    private String tableName = "Instructor";
    public Instructor(UUID id, String first_name, String last_name, String email, String phone, String title){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getTitle() {
        return title;
    }

    public Instructor() {
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", title='" + title + '\'' +
                '}';
    }


    public String ViewInstructorDetails(@NotNull Connection c, String where_clause) throws SQLException {
        String generatedResults = " ";
        Statement statement = c.createStatement();
        String Query = "SELECT * FROM " + tableName;
        if (where_clause != null){
            Query = Query + " Where " + where_clause + ";";
        }
        System.out.println(Query);
        ResultSet resultset = statement.executeQuery(Query);
        while (resultset.next()) {
            this.id = UUID.fromString(resultset.getString(1));
            this.first_name = resultset.getString(2);
            this.last_name = resultset.getString(3);
            this.phone = resultset.getString(4);
            this.email = resultset.getString(5);
            this.title = resultset.getString(6);
            generatedResults = generatedResults + "\n" + this.toString();
        }
        return generatedResults;
    }

    public void RemoveInstructor(@NotNull Connection c, String where_clause){
        String Query = "DELETE FROM " + tableName;
        if (where_clause != null){
            Query = Query + " Where " + where_clause + ";";
        }
        System.out.println(Query);
        try {
            Statement statement = c.createStatement();
            statement.executeUpdate(Query);
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void AddInstructor(@NotNull Connection c, String columns, String values){
        String Query = "Insert into " + tableName + " ( " + columns + " ) VALUES " + " ( " + values + " );";
        System.out.println(Query);
        try {
            Statement statement = c.createStatement();
            statement.executeQuery(Query);
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void UpdateInstructorDetails(Connection c, String SetColumns, String where_clause){
        String Query = "UPDATE " + tableName + " SET " + SetColumns;
        if (where_clause != null){
            Query = Query + " Where " + where_clause + ";";
        }
        System.out.println(Query);
        try {
            Statement statement = c.createStatement();
            statement.executeQuery(Query);
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
