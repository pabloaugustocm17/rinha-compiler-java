package compiler.factories;

import com.fasterxml.jackson.databind.JsonNode;
import compiler.models.Location;

public class LocationFactory {

    public static Location _createLocationByNode(JsonNode location_node){

        String start = location_node.get("start").toString();
        String end = location_node.get("end").toString();
        String filename = location_node.get("filename").textValue();

        return new Location(start, end, filename);

    }

}
