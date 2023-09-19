package compiler.models;

public record Str(
        String value,
        Location location
) implements Term {



    @Override
    public String toStringCompiler() {
        return this.value;
    }

    @Override
    public String returnTypeTerm() {
        return "string";
    }
}
