import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class FiSetMetaDataReaderHc implements FiSetMetaDataReader {

    @Override
    public FiSetMetaData read() throws Exception {

        FiSetMetaData fiSetMetaData = new FiSetMetaData();

        FiSetMetaObject fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("desc").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.desc");

        fiSetMetaData.addEntryInFiSetMetaData("desc", fiSetMetaObject);  //

        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("phone").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.phone");

        fiSetMetaData.addEntryInFiSetMetaData("phone", fiSetMetaObject);

        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("brokerid").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.brokerid");
        fiSetMetaData.addEntryInFiSetMetaData("brokerid", fiSetMetaObject);


        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("root_accounts").setClassName(String.class).setIsList(true).setListKey("acctid").setPathToTree("root_accounts");
        fiSetMetaData.addEntryInFiSetMetaData("root_accounts",  fiSetMetaObject);

        //fiSetMetaData.addEntryInFiSetMetaData("Account_acctid", "acctid", String.class, "acctid", false);

        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("usproducttype").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.usproducttype");
        fiSetMetaData.addEntryInFiSetMetaData("usproducttype", fiSetMetaObject);



        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("checking").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.checking");
        fiSetMetaData.addEntryInFiSetMetaData("checking", fiSetMetaObject);


        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("svcstatus").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.svcstatus");
        fiSetMetaData.addEntryInFiSetMetaData("svcstatus", fiSetMetaObject);


        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("invacctype").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.invacctype");
        fiSetMetaData.addEntryInFiSetMetaData("invacctype", fiSetMetaObject);


        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("dtacctup").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.dtacctup");
        fiSetMetaData.addEntryInFiSetMetaData("dtacctup", fiSetMetaObject);


        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("suptxdl").setClassName(LocalDateTime.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.suptxdl");
        fiSetMetaData.addEntryInFiSetMetaData("suptxdl", fiSetMetaObject);


        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("xfersrc").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.xfersrc");
        fiSetMetaData.addEntryInFiSetMetaData("xfersrc", fiSetMetaObject);

        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("xferdst").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.xferdst");
        fiSetMetaData.addEntryInFiSetMetaData("xferdst", fiSetMetaObject);

        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("bankid").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.bankid");
        fiSetMetaData.addEntryInFiSetMetaData("bankid", fiSetMetaObject);

        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("accountType").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.accountType");
        fiSetMetaData.addEntryInFiSetMetaData("accountType", fiSetMetaObject);

        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("type").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.type");
        fiSetMetaData.addEntryInFiSetMetaData("type", fiSetMetaObject);

        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("accountCurrency").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.accountCurrency");
        fiSetMetaData.addEntryInFiSetMetaData("accountCurrency", fiSetMetaObject);

        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("accountSchemeName").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.accountSchemeName");
        fiSetMetaData.addEntryInFiSetMetaData("accountSchemeName", fiSetMetaObject);

        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("accountIdentification").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.accountIdentification");
        fiSetMetaData.addEntryInFiSetMetaData("accountIdentification", fiSetMetaObject);

        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("accountIdentification2").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.accountIdentification2");
        fiSetMetaData.addEntryInFiSetMetaData("accountIdentification2", fiSetMetaObject);


        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("accountName").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.accountName");
        fiSetMetaData.addEntryInFiSetMetaData("accountName", fiSetMetaObject);


        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("servicerSchemeName").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.servicerSchemeName");
        fiSetMetaData.addEntryInFiSetMetaData("servicerSchemeName", fiSetMetaObject);


        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("servicerIdentification").setClassName(String.class).setIsList(false).setListKey(null).setPathToTree("root_accounts.servicerIdentification");
        fiSetMetaData.addEntryInFiSetMetaData("servicerIdentification", fiSetMetaObject);


        // Get Statement Transactions
        fiSetMetaObject = new FiSetMetaObject();
        fiSetMetaObject.setFiSetKeyName("root_transactions").setClassName(String.class).setIsList(true).setListKey("fitid").setPathToTree("root_accounts.root_transactions");
        fiSetMetaData.addEntryInFiSetMetaData("root_transactions",  fiSetMetaObject);

        return fiSetMetaData;
    }

}
