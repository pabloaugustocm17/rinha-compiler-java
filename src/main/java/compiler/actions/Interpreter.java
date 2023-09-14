package compiler.actions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import compiler.annotations.CompilerPrinter;
import compiler.factories.*;
import compiler.models.Parameter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Interpreter {


    /* ---------------- PUBLIC METHODS ---------------- */

    public void _readJson(JsonNode node){

        Stack<JsonNode> nodes = new Stack<>();
        Stack<Object> objects_process = new Stack<>();

        String type = node.get("kind").textValue();

        JsonNode node_kind = node.get("kind");




    }

    /**
     *
     * Lê o arquivo para interpretar o arquivo .rinha
     * Read the archive to interpret a .rinha file
     *
     * @return JsonNode
     */
    public JsonNode _readArchiveJson(String path) {

        try {

            String json_file = Files.readString(Path.of(path));

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readTree(json_file);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao realizar a leitura do arquivo: " + e);
        }

    }

    /* ---------------- PRIVATE METHODS ---------------- */

}
