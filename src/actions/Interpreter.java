package actions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import jdk.incubator.vector.VectorOperators.Binary;
import models.Bool;
import models.Executor;
import models.Print;

public class Interpreter {
    
    /* ---------------- VARS ---------------- */

    private final String PATH = "/var/rinha/source/source.rinha";

    private final HashMap<String, Class<?>> CLASSNAME_CLASS = _initializeHashMap();;

    /* ---------------- PUBLIC METHODS ---------------- */

    public void _interpreter(){

        LinkedList<String> lines_archive = _readArchive();

        for(String line : lines_archive){

            Class<?> claz = CLASSNAME_CLASS.get(line);

            String interface_name = claz.getInterfaces().getClass().getSimpleName();

            //if(interface_name.toLowerCase().equals("executor"))
              //((Executor)claz)._executor();

        }

    }

    /* ---------------- PRIVATE METHODS ---------------- */

    private HashMap<String, Class<?>> _initializeHashMap(){

        HashMap<String, Class<?>> map = new HashMap<>();

        map.put("binary", Binary.class);
        map.put("bool", Bool.class);
        map.put("print", Print.class);

        return map;

    }

    /**
     * 
     * Lê o arquivo para interpretar o arquivo .rinha 
     * Read the archive to interpret a .rinha file
     * 
     * @return Linhas do arquivo (Lines of archive)
     */
    private LinkedList<String> _readArchive(){

        Scanner scanner;

        try {

            scanner = new Scanner(PATH);

            LinkedList<String> lines = new LinkedList<>();

            for(String line = scanner.next(); scanner.hasNextLine(); line = scanner.next())
                lines.add(line.toLowerCase());

            scanner.close();

            return lines;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao realizar a leitura do arquivo");
        }

    }



    

}
