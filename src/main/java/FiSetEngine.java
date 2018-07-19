import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FiSetEngine {

    private FiSetNode d_currentNode;
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

    /**
     * Given ketName of Node, And values for the root nodes in a map, function adds the node to the tree
     * @param keyName
     * @param valueMap
     * @return
     */
    FiSetNode addChild(FiSetNode currentNode, String keyName, Map valueMap)
    {
        Object realValue = valueMap.get(keyName);
        d_currentNode = currentNode;

        if(hasChildren(currentNode))
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
        for (FiSetNode child: d_currentNode.getChildren())
        {
            Object fieldValue = valueMap.get(keyName);

            if(fiSetMetaData.get(keyName).isList)
            {
                if (child.getkeyName().equals(keyName))  // and it equals node name
                {
                    String listkey = fiSetMetaData.get(keyName).getListkey();

                    if(hasChildWithGivenNameAndValue(child, listkey, fieldValue))
                    {
                        return getChildWithValue(child, listkey, fieldValue);
                    }
                    else
                    {
                        return addChild(child, new FiSetNode(listkey, fieldValue));
                    }
                }
                else
                {
                    FiSetNode rootNode = new FiSetNode(keyName,""); //Value is empty for root nodes
                    String listKey = fiSetMetaData.get(keyName).getListkey();
                    return addChild(rootNode, new FiSetNode(listKey, fieldValue));
                }
            }
            else
            {
                if(child.getkeyName().equals(keyName) && child.getValue().equals(fieldValue))
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
            FiSetNode nodeChild = addChild(d_currentNode, fisetRoot);
            return addChild(nodeChild, new FiSetNode(listKey, realValue));
        }
        return addChild( d_currentNode, new FiSetNode(keyName, realValue));
    }


    /**
     * Function adds the child to the current node
     * @param child
     * @return
     */
    FiSetNode addChild(FiSetNode parent, FiSetNode child)
    {
        parent.getChildren().add(child);
        return child;
    }


    FiSetNode getChild(FiSetNode fiSetNode, String childName)
    {
        return fiSetNode.getChildren().stream().filter(n->n.getkeyName().equals(childName)).findFirst().get();
    }

    FiSetNode getChildWithValue(FiSetNode fiSetNode, String childName, Object value)
    {
        return fiSetNode.getChildren().stream().filter(n->n.getkeyName().equals(childName) && n.getValue().equals(value)).findFirst().get();
    }

    boolean hasChildWithGivenNameAndValue(FiSetNode fiSetNode, String name, Object value)
    {
         return fiSetNode.getChildren().stream().anyMatch(n->n.getkeyName().equals(name) && n.getValue().equals(value));
    }


    boolean hasChildren(FiSetNode fiSetNode)
    {
        return fiSetNode.getChildren().size() > 0;
    }

    int findTotalNodesByDepthFirstSearch(FiSetNode fiSetNode)
    {
        int count = 0;

        if(fiSetNode == null)
        {
            return 0;
        }
        else
        {
            FiSetNode current = fiSetNode;
            Stack<FiSetNode> stackNodes = new Stack<>();

            stackNodes.push(current);

            while (!stackNodes.empty())
            {
                FiSetNode node = stackNodes.pop();
                count++;

                for( FiSetNode currentNode : node.getChildren())
                {
                    stackNodes.push(currentNode);
                }
            }

        }
        return count;
    }
}