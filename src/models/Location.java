package models;

public class Location {
    
    private Integer start;
    private Integer end;
    private String filename;

    public Location(Integer start, Integer end, String filename){
        this.start = start;
        this.end = end;
        this.filename = filename;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    public String getFilename() {
        return filename;
    }

    

}
