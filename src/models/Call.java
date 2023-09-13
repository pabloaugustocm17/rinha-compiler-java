package models;

import java.util.LinkedList;

public class Call implements Term{
    
    private String kind;
    private Term callee;
    private LinkedList<Term> arguments;
    private Location location;

}
