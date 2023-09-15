package compiler.models;

public class Binary implements Term{

    private final Term lhs;
    private final Operator op;
    private final Term rhs;
    private final Location location;
    private Term value_operator;

    public Binary(Term lhs, Operator op, Term rhs, Location location) {
        this.lhs = lhs;
        this.op = op;
        this.rhs = rhs;
        this.location = location;
    }

    @Override
    public String toStringCompiler() {
        return null;
    }
}
