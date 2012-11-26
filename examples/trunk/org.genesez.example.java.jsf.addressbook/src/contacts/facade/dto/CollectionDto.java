package contacts.facade.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * transport a map of uid keys and display strings
 * @author georg beier
 */
public class CollectionDto implements Serializable {
	private static final long serialVersionUID = 1L;
    private Map<Long, String> elements = new HashMap<Long, String>();

    public Map<Long, String> getElements() {
        return elements;
    }

    public void addElement(Long uid, String display) {
        elements.put(uid, display);
    }
    
    public void removeElement(Long uid) {
        elements.remove(uid);
    }
}
