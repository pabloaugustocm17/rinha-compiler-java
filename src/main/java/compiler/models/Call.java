package compiler.models;

import java.util.LinkedList;

public class Call implements Term {
    private Term callee;
    private LinkedList<Term> arguments;
    private Location location;

    @Override
    public String toStringCompiler() {
        return null;
    }
}
