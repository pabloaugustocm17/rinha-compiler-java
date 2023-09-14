package compiler.factories;

import compiler.models.Location;
import compiler.models.Parameter;

import java.util.HashMap;

public class ParameterFactory implements Factory{

    @Override
    public Object _create(HashMap<String, Object> arguments) {
        return new Parameter((String) arguments.get("text"), (Location) arguments.get("location"));
    }

    public static Parameter _createParameter(String text, Location location){
        return new Parameter(text, location);
    }
}
