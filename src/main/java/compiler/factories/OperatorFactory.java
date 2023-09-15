package compiler.factories;

import compiler.models.Operator;

public class OperatorFactory {

    public static Operator _returnOperator(String op){

        switch (op){

            case "Eq" -> {
                return Operator.EQ;
            }
            case "Add" -> {
                return Operator.ADD;
            }
            case "Or" ->{
                return Operator.OR;
            }
            case "Sub" ->{
                return Operator.SUB;
            }
            default -> throw new RuntimeException("Operador não existe");

        }

    }

}
