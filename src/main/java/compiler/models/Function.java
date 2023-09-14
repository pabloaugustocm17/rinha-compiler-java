package compiler.models;

import java.util.LinkedList;

public class Function implements Term {
    private LinkedList<Parameter> parameters;
    private Term value;
    private Location location;

    public Function(LinkedList<Parameter> parameters, Term value, Location location) {
        this.parameters = parameters;
        this.value = value;
        this.location = location;
    }

    @Override
    public String toStringCompiler() {
        return null;
    }
}
