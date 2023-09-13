package factories;

import models.Location;

public class LocationFactory {
    
    public static Location _createLocation(Integer start, Integer end, String filename){
        return new Location(start, end, filename);
    }

}
