package postgresql;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.UUID;

public class Courses {
    private UUID course_id;
    private String course_name;
    private Date start_date;
    private Date end_date;
    private String level;
    private boolean is_started;
    private UUID instructor_id;

    private String tableName = "Courses";
    public Courses(UUID course_id, String course_name, Date start_date, Date end_date, String level, boolean is_started, UUID instructor_id) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.level = level;
        this.is_started = is_started;
        this.instructor_id = instructor_id;
    }

    public Courses() {
    }

    @Override
    public String toString() {
        return "Courses{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", level='" + level + '\'' +
                ", is_started=" + is_started +
                ", instructor_id=" + instructor_id +
                '}';
    }

    public String ViewCourseDetails(@NotNull Connection c, String where_clause) throws SQLException {
        String generatedResults = " ";
        Statement statement = c.createStatement();
        String Query = "SELECT * FROM " + tableName;
        if (where_clause != null){
            Query = Query + " Where " + where_clause + ";";
        }
        System.out.println(Query);
        ResultSet resultset = statement.executeQuery(Query);
        while (resultset.next()) {
            this.course_id = UUID.fromString(resultset.getString(1));
            this.course_name = resultset.getString(2);
            this.start_date = resultset.getTimestamp(3);
            this.end_date = resultset.getTimestamp(4);
            this.level = resultset.getString(5);
            this.is_started = resultset.getBoolean(6);
            this.instructor_id = UUID.fromString(resultset.getString(7));
            generatedResults = generatedResults + "\n" + this.toString();
        }
        return generatedResults;
    }

    public void RemoveCourse(@NotNull Connection c, String where_clause){
        String Query = "DELETE FROM " + tableName;
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

    public void AddCourse(@NotNull Connection c, String columns, String values){
        String Query = "Insert into " + tableName + " ( " + columns + " ) VALUES " + " ( " + values + " );";
        System.out.println(Query);
        try {
            Statement statement = c.createStatement();
            statement.executeQuery(Query);
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void UpdateCourseDetails(Connection c, String SetColumns, String where_clause){
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
