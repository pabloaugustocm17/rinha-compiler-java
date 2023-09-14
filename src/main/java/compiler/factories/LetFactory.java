package compiler.factories;

import compiler.models.Let;
import compiler.models.Location;
import compiler.models.Parameter;
import compiler.models.Term;

public class LetFactory{

    public static Let _createLet(Parameter name, Term value, Term next, Location location){
        return new Let(name, value, next, location);
    }

}
