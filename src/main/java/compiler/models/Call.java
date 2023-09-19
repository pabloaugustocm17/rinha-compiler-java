package compiler.models;

import java.util.LinkedList;


public record Call(
        Term callee,
        LinkedList<Term> arguments,
        Location location
) implements Term {


    @Override
    public String toStringCompiler() {
        return null;
    }

    @Override
    public String returnTypeTerm() {
        return "call";
    }
}
