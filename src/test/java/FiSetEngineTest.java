import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FiSetEngineTest {

    FiSetEngine fiSetEngine = new FiSetEngine();
    FiSetNode accounts = new FiSetNode("Root", null);
    FiSetNode current = accounts;
    List<Map> listMap = new ArrayList<>();

    String[] paths = {"root_accounts.root_transactions", "root_accounts.desc", "root_accounts.name", "root_accounts.phone", "root_accounts.phone",
            "root_accounts.root_transactions.trnamount", "root_accounts.root_transactions.trnamount", "root_accounts.name",
            "root_accounts.root_transactions.trntype", "root_accounts.desc", "root_accounts.name", "root_accounts.name", "root_accounts.desc"};

    @Before
    public void setUp() throws Exception
    {
        Map<String, String> value1 = new HashMap<>();
        value1.put("root_accounts", "123");
        value1.put("root_transactions", "000");

        Map<String, String> value2 = new HashMap<>();
        value2.put("root_accounts", "123");
        value2.put("desc", "BANK");

        Map<String, String> value3 = new HashMap<>();
        value3.put("root_accounts", "123");
        value3.put("name", "Adil Imam");

        Map<String, String> value4 = new HashMap<>();
        value4.put("root_accounts", "123");
        value4.put("phone", "914-243-2424");

        Map<String, String> value5 = new HashMap<>();
        value5.put("root_accounts", "999");
        value5.put("phone", "732-245-1111");

        Map<String, String> value6 = new HashMap<>();
        value6.put("root_accounts", "123");
        value6.put("root_transactions", "000");
        value6.put("trnamount", "3456357");

        Map<String, String> value7 = new HashMap<>();
        value7.put("root_accounts", "123");
        value7.put("root_transactions", "555");
        value7.put("trnamount", "1000");

        Map<String, String> value8 = new HashMap<>();
        value8.put("root_accounts", "878");
        value8.put("name", "Asad Imam");


        Map<String, String> value9 = new HashMap<>();
        value9.put("root_accounts", "666");
        value9.put("root_transactions", "000");
        value9.put("trntype", "Deposit");

        Map<String, String> value10 = new HashMap<>();
        value10.put("root_accounts", "666");
        value10.put("desc", "MacBook Pro");

        Map<String, String> value11 = new HashMap<>();
        value11.put("root_accounts", "666");
        value11.put("name", "David Bornstein");

        Map<String, String> value12 = new HashMap<>();
        value12.put("root_accounts", "999");
        value12.put("name", "Paul Allen");

        Map<String, String> value13 = new HashMap<>();
        value13.put("root_accounts", "999");
        value13.put("desc", "CC");

        listMap.add(value1);
        listMap.add(value2);
        listMap.add(value3);
        listMap.add(value4);
        listMap.add(value5);
        listMap.add(value6);
        listMap.add(value7);
        listMap.add(value8);
        listMap.add(value9);
        listMap.add(value10);
        listMap.add(value11);
        listMap.add(value12);
        listMap.add(value13);

    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void addChildTest()
    {
        int index = 0;

        for (String tree : paths)
        {
            FiSetNode root = current;

            for (String nodeName : tree.split("\\."))
            {
                current = fiSetEngine.addChild(current, nodeName, listMap.get(index));
            }

            current = root; // reset current to root
            index++;
        }

        int countNodes = fiSetEngine.findTotalNodesByDepthFirstSearch(current);

        Assert.assertEquals(23, countNodes);
    }

    @Test
    public void processChildren()
    {
    }

    @Test
    public void getChild()
    {
    }
}