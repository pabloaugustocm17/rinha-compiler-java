package compiler.models;

public class Binary implements Term{

    private Term lhs;
    private Operator op;
    private Term rhs;
    private Location location;

    @Override
    public String toStringCompiler() {
        return null;
    }
}
