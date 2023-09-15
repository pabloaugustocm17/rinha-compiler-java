package compiler.actions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import compiler.factories.TermFactory;
import compiler.models.Call;
import compiler.models.Location;
import compiler.models.Print;
import compiler.models.Term;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;

public class Interpreter {


    /* ---------------- PUBLIC METHODS ---------------- */

    public void _readJson(JsonNode node){

        TermFactory term_factory = new TermFactory();

        String type = node.get("kind").textValue();

        HashMap<Location, Object> objects = new HashMap<>();

        LinkedList<Print> printers = new LinkedList<>();

        switch (type.toLowerCase()){

            case "print", "let" -> {

                Object term = term_factory._createTerm(node, objects, printers);


            }

        }

        for (Print printer : printers) {

            Term value = printer.value();

        }




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
