package compiler;

import com.fasterxml.jackson.databind.JsonNode;
import compiler.actions.Interpreter;

class Main {

    public static final String PATH = "src/main/resources/var/rinha/source/combination.rinha.json";

    public static void main(String[] args) {

        Interpreter interpreter = new Interpreter();

        long tempo = System.currentTimeMillis();

        JsonNode node = interpreter._readArchiveJson(PATH);

        interpreter._readJson(node);

        System.out.println("EXEC: " + (System.currentTimeMillis() - tempo));

    }
}