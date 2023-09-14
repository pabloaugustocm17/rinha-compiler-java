package compiler.factories;

import compiler.models.Function;
import compiler.models.Location;
import compiler.models.Parameter;
import compiler.models.Term;

import java.util.LinkedList;

public class FunctionFactory {

    public static Function _createFunction(LinkedList<Parameter> parameters, Term value, Location location){
        return new Function(parameters, value, location);
    }
}
