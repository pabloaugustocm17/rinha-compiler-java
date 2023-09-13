package models;

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

    private String value;

    Operator(String value){
        this.value = value;
    }

}
