package controller;

import java.sql.*;
import java.util.LinkedList;
import java.util.Queue;

public class PBSelect implements Command{
    private Queue<String> results = new LinkedList<>();
    private Connector connector = new Connector();
    private String gender;
    private String distance;
    private final String CONDITIONS = "group by athletes.a_name";


    public PBSelect(){
        super();
    }

    public Queue<String> getResults() {
        return results;
    }

    public void setResults(Queue<String> results) {
        this.results = results;
    }

    public Connector getConnector() {
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getCONDITIONS() {
        return CONDITIONS;
    }

    @Override
    public void execute() {
        final String QUERY = "select athletes.a_name, min(events.e_time) as time" +
                "from athletes inner join events on athletes.a_id = events.e_athlete " + getCONDITIONS();

        try {
            getConnector().connect();
            ResultSet rs = getConnector().getStatement().executeQuery(QUERY);
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
//                System.out.println(rs.getString("a_name") + " with time: " + rs.getDouble("time"));
                this.results.add(rs.getString("a_name") + " with time: " + rs.getDouble("time"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
    * final String PB = "select athletes.a_name, min(events.e_time) as time " +
                "from athletes inner join events on athletes.a_id = events.e_athlete group by athletes.a_name";
    * final String Top5 = "select athletes.a_name, min(events.e_time) as time" +
                "from athletes inner join events on athletes.a_id = events.e_athlete " +
                "where events.e_sport = '400' group by athletes.a_name order by events.e_time limit 5;";
    * final String RecordHolder = "select athletes.a_name, min(events.e_time) as time" +
                "from athletes inner join events on athletes.a_id = events.e_athlete " +
                "where events.e_sport = '400';";
* */