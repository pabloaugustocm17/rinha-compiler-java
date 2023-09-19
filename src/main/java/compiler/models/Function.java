package compiler.models;

import java.util.LinkedList;

public record Function(LinkedList<Parameter> parameters,
                       Term value,
                       Location location
) implements Term {


    @Override
    public String toStringCompiler() {
        return null;
    }

    @Override
    public String returnTypeTerm() {
        return "function";
    }
}
