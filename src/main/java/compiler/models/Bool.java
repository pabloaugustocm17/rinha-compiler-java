package compiler.models;

public record Bool(byte value, Location location) implements Term {


    @Override
    public String toStringCompiler() {
        return value == 0 ? "false" : "true";
    }

    @Override
    public String returnTypeTerm() {
        return "bool";
    }
}
