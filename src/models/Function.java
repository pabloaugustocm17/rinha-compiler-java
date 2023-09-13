package models;

import java.util.LinkedList;

public class Function implements Term{
    
    private String kind;
    private LinkedList<Parameter> parameters;
    private Term value;
    private Location location;

}
