package compiler.models;

public class Location {
    
    private final String start;
    private final String end;
    private final String filename;

    public Location(String start, String end, String filename){
        this.start = start;
        this.end = end;
        this.filename = filename;
    }
}
