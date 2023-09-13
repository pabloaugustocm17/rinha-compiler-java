package compiler.models;

public class Bool implements Term {
    private byte value;
    private Location location;

    @Override
    public String toStringCompiler() {
        return value == 0 ? "false" : "true";
    }
}
