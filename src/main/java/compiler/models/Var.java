package compiler.models;

public class Var implements Term {

    private final String text;
    private final Location location;

    public Var(String text, Location location) {
        this.text = text;
        this.location = location;
    }

    @Override
    public String toStringCompiler() {
        return this.text;
    }
}
