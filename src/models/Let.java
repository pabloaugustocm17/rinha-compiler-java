package models;

public class Let implements Term{
    
    private String kind;
    private Parameter name;
    private Term value;
    private Term next;
    private Location location;
}
