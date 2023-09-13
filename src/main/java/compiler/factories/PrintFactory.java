package compiler.factories;

import compiler.models.Location;
import compiler.models.Print;
import compiler.models.Term;

import java.util.HashMap;

public class PrintFactory implements Factory{

    @Override
    public Object _create(HashMap<String, Object> arguments) {
        return new Print((Term) arguments.get("value"), (Location) arguments.get("location"));
    }
}
