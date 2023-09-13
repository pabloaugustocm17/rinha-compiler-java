package compiler.models;

public class Let implements Term {
    private Parameter name;
    private Term value;
    private Term next;
    private Location location;

    @Override
    public String toStringCompiler() {
        return value.toStringCompiler();
    }
}
