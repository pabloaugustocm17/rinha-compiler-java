package compiler.models;

public record Int(
        Integer value,
        Location location
) implements Term {


    @Override
    public String toStringCompiler() {
        return value.toString();
    }

    @Override
    public String returnTypeTerm() {
        return "int";
    }
}
