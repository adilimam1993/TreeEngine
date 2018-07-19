import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FiSetNode {

    private List<FiSetNode> children = new ArrayList<>();
    private String d_keyName;
    private Object value;

    //FiSetMetaData
    private static Map<String, FISetNodeInformation> fiSetMetaData = new HashMap<>();

    static
    {
        fiSetMetaData.put("root_accounts", new FISetNodeInformation(true, "acctid"));
        fiSetMetaData.put("root_transactions", new FISetNodeInformation(true, "fitid"));
        fiSetMetaData.put("phone", new FISetNodeInformation(false, null));
        fiSetMetaData.put("desc", new FISetNodeInformation(false, null));
        fiSetMetaData.put("name", new FISetNodeInformation(false, null));
        fiSetMetaData.put("acctid", new FISetNodeInformation(false, null));
        fiSetMetaData.put("trnamount", new FISetNodeInformation(false, null));
        fiSetMetaData.put("fitid", new FISetNodeInformation(false, null));
        fiSetMetaData.put("trntype", new FISetNodeInformation(false, null));
    }

    FiSetNode(String d_keyName, Object value)
    {
        this.d_keyName = d_keyName;
        this.value = value;
    }

    /**
     * Given ketName of Node, And values for the root nodes in a map, function adds the node to the tree
     * @param keyName
     * @param valueMap
     * @return
     */
    FiSetNode addChild(String keyName, Map valueMap)
    {
        Object realValue = valueMap.get(keyName);

        if(hasChildren(this))
        {
           FiSetNode node = processChildren(valueMap, keyName);
           if(node != null)
           {
               return node;
           }
        }
        return processNodeWithNoChildren(keyName, realValue);
    }


    /**
     * Processes all the children of the node, to traverse to the correct child based on values of the root nodes
     * @param valueMap
     * @param keyName
     * @return
     */
    FiSetNode processChildren(Map valueMap, String keyName)
    {
        //When node has children, loop over all the children
        for (FiSetNode child: children )
        {
            Object fieldValue = valueMap.get(keyName);

            if(fiSetMetaData.get(keyName).isList)
            {
                if (child.d_keyName.equals(keyName))  // and it equals node name
                {
                    String listkey = fiSetMetaData.get(keyName).getListkey();

                    if(hasChildWithGivenNameAndValue(child, listkey, fieldValue))
                    {
                        return getChild(child, listkey);
                    }
                    else
                    {
                        return child.addChild(new FiSetNode(listkey, fieldValue));
                    }
                }
                else
                {
                    FiSetNode rootNode = new FiSetNode(keyName,""); //Value is empty for root nodes
                    String listKey = fiSetMetaData.get(keyName).getListkey();
                    return rootNode.addChild(new FiSetNode(listKey, fieldValue));
                }
            }
            else
            {
                if(child.d_keyName.equals(keyName) && child.value.equals(fieldValue))
                {
                    return child;
                }
            }
        }
        return null;
    }


    /**
     * Processes node with children, if node is a root node, create a root node and then add a child node to root
     * @param keyName
     * @param realValue
     * @return
     */
    FiSetNode processNodeWithNoChildren(String keyName, Object realValue)
    {
         if(fiSetMetaData.get(keyName).isList)
        {
            FiSetNode fisetRoot = new FiSetNode(keyName,"");
            String listKey = fiSetMetaData.get(keyName).getListkey();
            FiSetNode nodeChild = addChild(fisetRoot);
            return nodeChild.addChild(new FiSetNode(listKey, realValue));
        }
        return addChild(new FiSetNode(keyName, realValue));
    }


    /**
     * Function adds the child to the current node
     * @param child
     * @return
     */
    FiSetNode addChild(FiSetNode child)
    {
        children.add(child);
        return child;
    }


    FiSetNode getChild(FiSetNode fiSetNode, String childName)
    {
        return fiSetNode.children.stream().filter(n->n.d_keyName.equals(childName)).findFirst().get();
    }


    boolean hasChildWithGivenNameAndValue(FiSetNode fiSetNode, String name, Object value)
    {
         return fiSetNode.children.stream().anyMatch(n->n.d_keyName.equals(name) && n.value.equals(value));
    }


    boolean hasChildren(FiSetNode fiSetNode)
    {
        return fiSetNode.children.size() > 0;
    }

}