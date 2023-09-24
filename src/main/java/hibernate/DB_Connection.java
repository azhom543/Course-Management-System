package hibernate;


import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {
    private Connection connection = null;
    private String url;
    private String username;
    private String password;
    public Connection DB_Connection(String url,String username,String password)
    {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
            return this.connection;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public void ConnectionClose(Connection c){
        try {
            c.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
