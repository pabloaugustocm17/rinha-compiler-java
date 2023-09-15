package compiler.models;

import java.util.LinkedList;

public class Call implements Term {
    private Term callee;
    private LinkedList<Term> arguments;
    private Location location;

    public Call(Term callee, LinkedList<Term> arguments, Location location) {
        this.callee = callee;
        this.arguments = arguments;
        this.location = location;
    }

    @Override
    public String toStringCompiler() {
        return null;
    }
}
