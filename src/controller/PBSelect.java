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
        try {
            if (getGender().equals("male") || getGender().equals("female")){
                String QUERY = "select athletes.a_name, min(events.e_time) as time " +
                        "from athletes inner join events on athletes.a_id = events.e_athlete " +
                        "where events.e_sport = '" + getDistance() + "' and athletes.a_sex = '" +
                        getGender() + "' "+ getCONDITIONS();
                getConnector().connect();
                ResultSet rs = getConnector().getStatement().executeQuery(QUERY);
                while (rs.next()) {
                    this.results.add(rs.getString("a_name") + " with time: " + rs.getDouble("time"));
                }
            }
            else {
                String QUERY = "select athletes.a_name, min(events.e_time) as time " +
                        "from athletes inner join events on athletes.a_id = events.e_athlete " +
                        "where events.e_sport = '" + getDistance() + "' " + getCONDITIONS();
                getConnector().connect();
                ResultSet rs = getConnector().getStatement().executeQuery(QUERY);
                while (rs.next()) {
                    this.results.add(rs.getString("a_name") + " with time: " + rs.getDouble("time"));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
