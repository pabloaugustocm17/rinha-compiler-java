package compiler.factories;

import com.fasterxml.jackson.databind.JsonNode;
import compiler.models.*;

import java.util.LinkedList;

public class TermFactory {

    public Object _createTerm(JsonNode node, LinkedList<Term> terms){

        String type_term = node.get("kind").textValue();

        switch (type_term.toLowerCase()){

            case "function" -> {

                LinkedList<Parameter> parameters = new LinkedList<>();

                JsonNode node_parameters = node.get("parameters");

                node_parameters.forEach(jsonNode ->
                    parameters.add(_createParameterByNode(jsonNode))
                );

                Term term_function = (Term) _createTerm(node.get("value"), terms);

                Location location = _createLocationByNode(node.get("location"));

                Function function = new Function(parameters, term_function, location);

                terms.add(function);

                return function;
            }

            case "let" -> {

                Parameter parameter = _createParameterByNode(node.get("name"));

                Term value = (Term) _createTerm(node.get("value"), terms);

                Term next = (Term) _createTerm(node.get("next"), terms);

                Location location = _createLocationByNode(node.get("location"));

                Let let = new Let(parameter, value, next, location);

                terms.add(let);

                return let;

            }

            case "binary" -> {

                Term lhs = (Term) _createTerm(node.get("lhs"), terms);

                Operator operator = OperatorFactory._returnOperator(node.get("op").textValue());

                Term rhs = (Term) _createTerm(node.get("rhs"), terms);

                Location location = _createLocationByNode(node.get("location"));

                Binary binary = new Binary(lhs, operator, rhs, location);

                terms.add(binary);

                return binary;

            }

            case "int" -> {

                Integer value = Integer.valueOf(node.get("value").toPrettyString());

                Location location = _createLocationByNode(node.get("location"));

                Int int_ = new Int(value, location);

                terms.add(int_);

                return int_;

            }

            case "var" -> {

                String text = node.get("text").textValue();

                Location location = _createLocationByNode(node.get("location"));

                Var var = new Var(text, location);

                terms.add(var);

                return var;

            }

            case "print" -> {

                Term value = (Term) _createTerm(node.get("value"), terms);

                Location location = _createLocationByNode(node.get("location"));

                Print print = new Print(value, location);

                terms.add(print);

                return print;

            }

            case "call" -> {

                Term callee = (Term) _createTerm(node.get("callee"), terms);

                LinkedList<Term> arguments = new LinkedList<>();

                JsonNode node_array_arguments = node.get("arguments");

                node_array_arguments.forEach(jsonNode ->
                        arguments.add((Term) _createTerm(jsonNode, terms))
                );

                Location location = _createLocationByNode(node.get("location"));

                Call call = new Call(callee, arguments, location);

                terms.add(call);

                return call;
            }

            case "str" -> {

                String value = node.get("value").textValue();

                Location location = _createLocationByNode(node.get("location"));

                Str str = new Str(value, location);

                terms.add(str);

                return str;
            }

            case "if" -> {

                Term condition = (Term) _createTerm(node.get("condition"), terms);

                Term then = (Term) _createTerm(node.get("then"), terms);

                Term otherwise = (Term) _createTerm(node.get("otherwise"), terms);

                Location location = _createLocationByNode(node.get("location"));

                If if_ =  new If(condition, then, otherwise, location);

                terms.add(if_);

                return if_;

            }

            default -> throw new RuntimeException("Tipo não existe");
        }

    }

    /* Private Methods */

    private Parameter _createParameterByNode(JsonNode node){

        String text = node.get("text").textValue();
        Location location = _createLocationByNode(node.get("location"));

        return new Parameter(text, location);
    }

    public Location _createLocationByNode(JsonNode location_node){

        String start = location_node.get("start").toPrettyString();
        String end = location_node.get("end").toPrettyString();
        String filename = location_node.get("filename").textValue();

        return new Location(start, end, filename);
    }

}
