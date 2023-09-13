package compiler.actions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import compiler.annotations.CompilerPrinter;
import compiler.factories.Factory;
import compiler.factories.LocationFactory;
import compiler.factories.PrintFactory;
import compiler.factories.StrFactory;
import compiler.models.Executor;
import compiler.models.Location;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Interpreter {

    /* ---------------- VARS ---------------- */

    private HashMap<String, Factory> FACTORIES = new HashMap<>(){{
       put("str", new StrFactory());
       put("print", new PrintFactory());
    }};


    /* ---------------- PUBLIC METHODS ---------------- */

    public void _readJson(JsonNode node){

        Stack<JsonNode> nodes = new Stack<>();
        Stack<Object> objects_process = new Stack<>();

        nodes.add(node);

        _addNodesByValue(node, nodes);

        nodes.removeElementAt(nodes.size()-1);

        Object last_ob = null;

        while (!nodes.isEmpty()){

            JsonNode node_analyse = nodes.pop();
            JsonNode location_node = node_analyse.get("location");

            Location location = LocationFactory._createLocationByNode(location_node);

            String word = node_analyse.get("kind").textValue().toLowerCase();

            Object value = last_ob == null ? node_analyse.get("value").textValue() : last_ob;

            HashMap<String, Object> arguments = new HashMap<>(){{
               put("location", location);
               put("value", value);
            }};

            Object ob_created = FACTORIES.get(word)._create(arguments);

            if(_isObjectExecutor(ob_created))
                objects_process.push(ob_created);

            last_ob = ob_created;
        }

        while(!objects_process.isEmpty()){

            Object executor = objects_process.pop();

            ((Executor) executor)._execute();

        }

    }

    /**
     *
     * Lê o arquivo para interpretar o arquivo .rinha
     * Read the archive to interpret a .rinha file
     *
     * @return JSON
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

    private void _addNodesByValue(JsonNode node, Stack<JsonNode> nodes){

        JsonNode node_analyse = node.get("value");

        if(node_analyse != null){
            nodes.push(node_analyse);
            _addNodesByValue(node_analyse, nodes);
        }

    }

    private boolean _isObjectExecutor(Object object){

        return object.getClass().isAnnotationPresent(CompilerPrinter.class);

    }

}
