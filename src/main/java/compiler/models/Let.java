package compiler.models;

public record Let(Parameter name,
                  Term value,
                  Term next,
                  Location location
) implements Term {


    @Override
    public String toStringCompiler() {
        return value.toStringCompiler();
    }

    @Override
    public String returnTypeTerm() {
        return "let";
    }
}
