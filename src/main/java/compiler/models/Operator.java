package compiler.models;

public enum Operator {

    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/"),
    REM("%"),
    EQ("=="),
    NEQ("!="),
    LT("<"),
    GT(">"),
    LTE("<="),
    GTE(">="),
    AND("&&"),
    OR("||");

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
