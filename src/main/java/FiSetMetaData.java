import java.util.HashMap;
import java.util.Map;

/**
 * This structure holds skeleton for FiSetMetaData
 */
public class FiSetMetaData
{
    //key is keyname in FiSetDummy and value is datatype for the field
    private Map<String, FiSetMetaObject> d_fiSetMetaData;

    private Map<String, FiSetDataTree> d_fiSetTreesSkeleton;  //FiSetMetaData needs a Tree

    public FiSetMetaData()
    {
        d_fiSetMetaData = new HashMap<>();
    }


    public void addEntryInFiSetMetaData(String key, FiSetMetaObject fiSetMetaObject)
    {
        d_fiSetMetaData.put(key, fiSetMetaObject);
      //   FiSetMetaObject fiSetMetaObject = new FiSetMetaObject(nodeKeyName, className, pathInTree, isD_isList);
       //  d_fiSetMetaData.put(key, fiSetMetaObject);
    }


    public void addTree(String key, FiSetEngine fiSetNode)
    {
        FiSetDataTree fiSetDataTree = new FiSetDataTree();
        fiSetDataTree.setRoot(fiSetNode);

        d_fiSetTreesSkeleton.put(key, fiSetDataTree);
    }

    public FiSetMetaObject getValueFromFisetMetaDataMap(String key)
    {
        return d_fiSetMetaData.get(key);
    }




}
