package compiler.models;

public record If(
        Term condition,
        Term then,
        Term otherwise,
        Location location
) implements Term, Executor {


    @Override
    public String toStringCompiler() {
        return null;
    }

    @Override
    public String returnTypeTerm() {
        return "if";
    }

    @Override
    public byte _execute() {
        return 0;
    }

}
