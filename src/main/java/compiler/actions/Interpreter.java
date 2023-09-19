package compiler.actions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import compiler.annotations.CompilerPrinter;
import compiler.factories.TermFactory;
import compiler.models.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class Interpreter {


    /* ---------------- PUBLIC METHODS ---------------- */

    public void _readJson(JsonNode node){

        TermFactory term_factory = new TermFactory();

        LinkedList<Term> terms = new LinkedList<>();

        File file = new File(
                node.get("name").textValue(),
                (Term) term_factory._createTerm(node.get("expression"), terms),
                term_factory._createLocationByNode(node.get("location"))
        );


        List<Term> printers = _findPrinters(terms);

        printers.forEach(printer ->{

            Print print = ((Print) printer);
            Term print_value = print.value();

            switch (print_value.returnTypeTerm()){

                case "call" -> {

                    _interpretCall((Call) print_value, terms);

                }


                case "str", "int", "bool" -> print._execute();

                default -> throw new RuntimeException("Tipo não existe");


            }

        });
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

    /**
     *
     * @param terms Termos achados na busca / Terms find in the research
     * @return List<Print>
     */
    private List<Term> _findPrinters(LinkedList<Term> terms){

        return terms
                .parallelStream()
                .filter(term -> term.getClass().isAnnotationPresent(CompilerPrinter.class))
                .sorted()
                .toList();

    }

    private Let _findTermByTextVar(String text, LinkedList<Term> terms){

        return (Let) terms
                .parallelStream()
                .filter(term -> term.returnTypeTerm().equals("let"))
                .filter(term -> ((Let) term).name().text().equals(text))
                .toList().get(0);

    }

    private void _interpretCall(Call call, LinkedList<Term> terms){

        Term callee = call.callee();

        switch (callee.returnTypeTerm()){

            case "var" -> {

                Let let = _findTermByTextVar(((Var) callee).text(), terms);

                Function function = (Function) let.value();

                if(call.arguments().size() != function.parameters().size()){
                    throw new RuntimeException("Paramêtros passados são divergentes");
                }



            }

            default -> throw new RuntimeException("Tipo não existe");

        }

    }



}
