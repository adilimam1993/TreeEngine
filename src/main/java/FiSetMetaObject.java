/**
 * FiSetMetaData contains a map of FiSetMetaObjects
 */
public class FiSetMetaObject
{
    private Class d_className;
    private String d_fiSetKeyName;  // If FiSetKeyName happens to be a d_listKey, then we have to look at d_listKey to traverse down
    private boolean d_isList;  //If list, then its going to have key inside it
    private String d_listKey;  // key for that list,
    private String d_pathToTree;

    FiSetMetaObject()
    {

    }

    public Class getClassName() {
        return d_className;
    }

    public FiSetMetaObject setClassName(Class className) {
        d_className = className;
        return this;
    }

    public String getFiSetKeyName() {
        return d_fiSetKeyName;
    }

    public FiSetMetaObject setFiSetKeyName(String fiSetKeyName) {
        d_fiSetKeyName = fiSetKeyName;
        return this;
    }

    public boolean isList() {
        return d_isList;
    }

    public FiSetMetaObject setIsList(boolean isList) {
        d_isList = isList;
        return this;
    }

    public String getListKey() {
        return d_listKey;
    }

    public FiSetMetaObject setListKey(String listKey) {
        d_listKey = listKey;
        return this;
    }

    public String getPathToTree() {
        return d_pathToTree;
    }

    public FiSetMetaObject setPathToTree(String pathToTree) {
        d_pathToTree = pathToTree;
        return this;
    }
}
