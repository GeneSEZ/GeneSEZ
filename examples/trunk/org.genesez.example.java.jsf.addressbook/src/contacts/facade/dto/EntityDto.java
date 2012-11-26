package contacts.facade.dto;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author georg beier
 */
public class EntityDto implements Serializable {

	private static final long serialVersionUID = 1L;

	public EntityDto() {
    }

    public Map<String, Object> valueMap() {
        Map<String, Object> valueMap = new HashMap<String, Object>();
        Class myClass = getClass();
        Method[] methods = myClass.getMethods();
        Object[] params = new Object[0];
        for (Method method : methods) {
            String name = method.getName();
            if (name.startsWith("get") // nur getter
                    && myClass == method.getDeclaringClass() // in der dto Klasse
                    // aber keine Collections o. ä.
                    && !Iterable.class.isAssignableFrom(method.getReturnType())
                    // und ohne parameter
                    && method.getParameterTypes().length == 0) {
                try {
                    Object val = method.invoke(this, params);
                    if (val != null) {
                        String st = name.substring(3, 4).toLowerCase();
                        name = st + name.substring(4);
                        valueMap.put(name, val);
                    }
                } catch (Exception ex) {
                    assert false : "Fehler beim Zugriff auf " + name + ": " + ex;
                }
            }
        }
        return valueMap;
    }
}
