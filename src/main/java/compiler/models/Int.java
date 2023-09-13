package compiler.models;

public class Int implements Term {
    private Integer value;
    private Location location;

    @Override
    public String toStringCompiler() {
        return value.toString();
    }
}
