package compiler.factories;

import compiler.models.Location;
import compiler.models.Str;

import java.util.HashMap;

public class StrFactory implements Factory{


    @Override
    public Object _create(HashMap<String, Object> arguments) {
        return new Str((String) arguments.get("value"), (Location) arguments.get("location"));
    }
}
