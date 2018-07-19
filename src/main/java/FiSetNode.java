import java.util.ArrayList;
import java.util.List;

public class FiSetNode {

    private List<FiSetNode> children = new ArrayList<>();
    private String d_keyName;
    private Object value;

    FiSetNode(String d_keyName, Object value)
    {
        this.d_keyName = d_keyName;
        this.value = value;
    }

    public List<FiSetNode> getChildren() {
        return children;
    }

    public void setChildren(List<FiSetNode> children) {
        this.children = children;
    }

    public String getkeyName() {
        return d_keyName;
    }

    public void setkeyName(String d_keyName) {
        this.d_keyName = d_keyName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
