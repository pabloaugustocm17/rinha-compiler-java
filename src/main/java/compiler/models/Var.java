package compiler.models;

public class Var implements Term {

    private final String kind = "var";
    private String text;
    private Location location;

    @Override
    public String toStringCompiler() {
        return this.text;
    }
}
