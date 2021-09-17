package controller;

import java.sql.*;

public class Connector {
    final String DB_URL = "jdbc:mysql://localhost/athletes_data";
    final String USER = "";
    final String PASS = "";
    private Connection connection;
    private Statement statement;

    public Connector(){
        super();
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASS() {
        return PASS;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public void connect(){
        try {
            setConnection(DriverManager.getConnection(getDB_URL(), getUSER(), getPASS()));
            System.out.println("connected");
            setStatement(getConnection().createStatement());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    /*
    try {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("connected");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY);
        // Extract data from result set
        while (rs.next()) {
            // Retrieve by column name
            this.results.add(rs.getString("a_name") + " with time: " + rs.getDouble("pb"));
        }
    }
        catch (
    SQLException e) {
        e.printStackTrace();
    }
    */
}
