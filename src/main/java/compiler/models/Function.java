package compiler.models;

import java.util.LinkedList;

public class Function implements Term {
    private LinkedList<Parameter> parameters;
    private Term value;
    private Location location;

    @Override
    public String toStringCompiler() {
        return null;
    }
}
