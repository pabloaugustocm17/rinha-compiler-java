package compiler.factories;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import compiler.models.Location;
import compiler.models.Parameter;
import compiler.models.Term;

import java.util.LinkedList;

public class TermFactory {

    public Term _createTerm(JsonNode node){

        String type_term = node.get("kind").textValue();

        switch (type_term.toLowerCase()){

            case "function" -> {

                LinkedList<Parameter> parameters = new LinkedList<>();

                ArrayNode node_array_paramters = node.withArray(node.textValue());

                node_array_paramters.forEach(jsonNode ->
                    parameters.add(_createParameterByNode(jsonNode))
                );

                Term term_function = _createTerm(node.get("value"));

                Location location = LocationFactory._createLocationByNode(node.get("location"));

                return FunctionFactory._createFunction(parameters, term_function, location);
            }

            case "let" -> {

                Parameter parameter = _createParameterByNode(node.get("name"));

                Term value = _createTerm(node.get("value"));

                Term next = _createTerm(node.get("next"));

                Location location = LocationFactory._createLocationByNode(node.get("location"));

                return LetFactory._createLet(parameter, value, next, location);

            }

            default -> throw new RuntimeException("Tipo não existe");
        }

    }

    private Parameter _createParameterByNode(JsonNode node){

        String text = node.get("text").textValue();
        Location location = LocationFactory._createLocationByNode(node.get("location"));

        return ParameterFactory._createParameter(text, location);
    }

}
