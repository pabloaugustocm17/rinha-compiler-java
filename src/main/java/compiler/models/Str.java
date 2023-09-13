package compiler.models;

public class Str implements Term {
    private final String value;
    private final Location location;

    public Str(String value, Location location) {
        this.value = value;
        this.location = location;
    }

    @Override
    public String toStringCompiler() {
        return this.value;
    }
}
