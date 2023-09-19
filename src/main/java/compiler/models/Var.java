package compiler.models;

public record Var(
        String text,
        Location location
) implements Term {



    @Override
    public String toStringCompiler() {
        return this.text;
    }

    @Override
    public String returnTypeTerm() {
        return "var";
    }
}
