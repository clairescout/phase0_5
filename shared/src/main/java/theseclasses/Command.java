package theseclasses;

import java.lang.reflect.Method;

/**
 * Created by clairescout on 1/13/18.
 */

public class Command  implements ICommand {

    private String _className;
    private String _methodName;
    private Class<?>[] _paramTypes;
    private Object[] _paramValues;

    public Command(String className, String methodName,
                          Class<?>[] paramTypes, Object[] paramValues){
        _className = className;
        _methodName = methodName;
        _paramTypes = paramTypes;
        _paramValues = paramValues;
    }

    @Override
    public Results execute() {
        Results r = new Results();
        try {
            Class<?> receiver = Class.forName(_className);
            Method method = receiver.getMethod(_methodName, _paramTypes);
            r = (Results)method.invoke(null, _paramValues);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
}
