package compiler;

import com.fasterxml.jackson.databind.JsonNode;
import compiler.actions.Interpreter;

class Main {

    public static final String PATH = "src/main/resources/var/rinha/source/print.rinha.json";

    public static void main(String[] args) {

        Interpreter interpreter = new Interpreter();

        JsonNode node = interpreter._readArchiveJson(PATH);

        interpreter._readJson(node.get("expression"));

    }
}