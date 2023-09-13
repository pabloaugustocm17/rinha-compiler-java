package models;

public class If implements Term{
    private String kind;
    private Term condition;
    private Term then;
    private Term otherwise;
    private Location location;
}
