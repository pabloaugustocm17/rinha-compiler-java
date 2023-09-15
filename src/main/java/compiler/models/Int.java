package compiler.models;

public class Int implements Term {
    private final Integer value;
    private final Location location;

    @Override
    public String toStringCompiler() {
        return value.toString();
    }

    public Int(Integer value, Location location) {
        this.value = value;
        this.location = location;
    }
}
