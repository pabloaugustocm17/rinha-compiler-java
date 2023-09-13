package models;

import factories.LocationFactory;

public class Print implements Executor{
    
    private String kind;
    private Term value;
    private Location location;

    public Print(String kind, Term value, Integer start, Integer end, String filename){
        this.kind = kind;
        this.value = value;
        this.location = LocationFactory._createLocation(start, end, filename);
    }

    public String getKind() {
        return kind;
    }

    public Term getValue() {
        return value;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public byte _executor() {
        
        System.out.println(this.getValue());

        return 0;
    }

    

}
