package compiler.models;

public class Tuple implements Term {

    private final String kind = "tuple";
    private Term first;
    private Term second;
    private Location location;

    @Override
    public String toStringCompiler() {
        return null;
    }
}
