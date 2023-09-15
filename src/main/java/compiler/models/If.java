package compiler.models;

public class If implements Term, Executor {
    private Term condition;
    private Term then;
    private Term otherwise;
    private Location location;

    public If(Term condition, Term then, Term otherwise, Location location) {
        this.condition = condition;
        this.then = then;
        this.otherwise = otherwise;
        this.location = location;
    }

    @Override
    public String toStringCompiler() {
        return null;
    }

    @Override
    public byte _execute() {
        return 0;
    }
}
