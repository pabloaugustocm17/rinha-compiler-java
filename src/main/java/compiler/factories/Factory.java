package compiler.factories;

import java.util.HashMap;

public interface Factory {

    Object _create(HashMap<String, Object> arguments);


}
