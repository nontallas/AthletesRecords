package controller;

import java.util.LinkedList;
import java.util.Queue;

public class Controller implements Command{
    private String gender;
    private String sport;
    private String queryType;
    private Queue<String> results = new LinkedList<>();
    private Top5Select top5Select;
    private PBSelect pbSelect;
    private RecordHolderSelect recordHolderSelect;

    public Controller() {
        super();
        setTop5Select(new Top5Select());
        setPbSelect(new PBSelect());
        setRecordHolderSelect(new RecordHolderSelect());
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Top5Select getTop5Select() {
        return top5Select;
    }

    public void setTop5Select(Top5Select top5Select) {
        this.top5Select = top5Select;
    }

    public PBSelect getPbSelect() {
        return pbSelect;
    }

    public void setPbSelect(PBSelect pbSelect) {
        this.pbSelect = pbSelect;
    }

    public RecordHolderSelect getRecordHolderSelect() {
        return recordHolderSelect;
    }

    public void setRecordHolderSelect(RecordHolderSelect recordHolderSelect) {
        this.recordHolderSelect = recordHolderSelect;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public Queue<String> getResults() {
        return results;
    }

    public void setResults(Queue<String> results) {
        this.results = results;
    }

    // TODO
    /*
    *
    * Create UI
    *
    */
    @Override
    public void execute() {
        switch (getQueryType()){
            case "top5":
                top5Select.setDistance(getSport());
                top5Select.setGender(getGender());
                top5Select.execute();
                setResults(top5Select.getResults());
                break;
            case "pb":
                pbSelect.setDistance(getSport());
                pbSelect.setGender(getGender());
                pbSelect.execute();
                setResults(pbSelect.getResults());
                break;
            case "record":
                recordHolderSelect.setDistance(getSport());
                recordHolderSelect.setGender(getGender());
                recordHolderSelect.execute();
                setResults(recordHolderSelect.getResults());
                break;
        }
    }

    public String concat(){
        String ret = "";
        while (!(getResults().isEmpty())){
            ret += getResults().remove();
            ret += "\n";
        }
        return ret;
    }
}
