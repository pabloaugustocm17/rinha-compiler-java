package compiler.models;

public record Binary(
        Term lhs,
        Operator op,
        Term rhs,
        Location location
) implements Term{

    @Override
    public String toStringCompiler() {
        return null;
    }

    @Override
    public String returnTypeTerm() {
        return "binary";
    }

}
