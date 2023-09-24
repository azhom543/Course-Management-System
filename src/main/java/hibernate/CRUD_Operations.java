package hibernate;

import java.sql.*;

public class CRUD_Operations {
    //Create
    //Read
    //Update
    //Delete
    //Abstract Class
    public void ReadEntry(Connection c, String view, String where_clause) throws SQLException {
        Statement statement = c.createStatement();
        String Query = "SELECT * FROM " + view;
        if (where_clause != null){
            Query = Query + " Where " + where_clause + ";";
        }
        System.out.println(Query);
        ResultSet resultset = statement.executeQuery(Query);
        String Results = "";
        ResultSetMetaData rsmd = resultset.getMetaData();
        while (resultset.next()){
            int i = 1;
            while (i <= rsmd.getColumnCount()){
                Results = Results + " " + resultset.getObject(i);
                i++;
            }
            Results = Results + "\n";
        }
        System.out.println(Results);
    }
    /*
    public void DeleteEntry(Connection c, String table, String where_clause){
        String Query = "DELETE FROM " + table;
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
    public void InsertEntry(Connection c, String table, String columns, String values){
        String Query = "Insert into " + table + " ( " + columns + " ) VALUES " + " ( " + values + " );";
        System.out.println(Query);
        try {
            Statement statement = c.createStatement();
            statement.executeQuery(Query);
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void UpdateEntry(Connection c, String table, String SetColumns, String where_clause){
        String Query = "UPDATE " + table + " SET " + SetColumns;
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
    }*/



}
