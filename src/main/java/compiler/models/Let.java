package compiler.models;

public class Let implements Term {
    private final Parameter name;
    private final Term value;
    private final Term next;
    private final Location location;

    public Let(Parameter name, Term value, Term next, Location location) {
        this.name = name;
        this.value = value;
        this.next = next;
        this.location = location;
    }

    @Override
    public String toStringCompiler() {
        return value.toStringCompiler();
    }
}
