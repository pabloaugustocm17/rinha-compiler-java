package compiler.models;

public class If implements Term {
    private Term condition;
    private Term then;
    private Term otherwise;
    private Location location;

    @Override
    public String toStringCompiler() {
        return null;
    }
}
