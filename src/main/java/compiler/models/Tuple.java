package compiler.models;

public record Tuple(
        Term first,
        Term second,
        Location location
) implements Term {


    @Override
    public String toStringCompiler() {
        return null;
    }

    @Override
    public String returnTypeTerm() {
        return "tuple";
    }
}
