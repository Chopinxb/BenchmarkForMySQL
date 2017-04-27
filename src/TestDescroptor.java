/**
 * Created by Chopin on 4/27/17.
 */
public class TestDescroptor {
    public final Configuration config;

    public final String url;
    public final String address;
    public final String database;
    public final String user;
    public final String password;
    public final String driver;

    public final int clients;
    public final boolean handleResult;

    private static TestDescroptor instance;

    public static void initialize(Configuration config){
        TestDescroptor.instance = new TestDescroptor(config);
    }
    public static TestDescroptor getInstance(){ return instance; }

    private TestDescroptor(Configuration config){

        this.config = config;
        this.driver = config.getProperty(Config.Database_Driver_Name, Config.Default_Database_Driver_Name);
        this.address = config.getProperty(Config.Database_Address, Config.Default_Database_Address);
        this.database = config.getProperty(Config.Database_Name, Config.Default_Database_Name);
        this.url = "jdbc:mysql://" + address + "/" + database;
        this.user = config.getProperty(Config.Database_User, Config.Default_Database_User);
        this.password = config.getProperty(Config.Database_Password, Config.Default_Database_Password);
        this.clients = config.getIntProperty(Config.Client_Num, Config.Default_Client_Num);
        this.handleResult = config.getBooleanProperty(Config.Handle_Result, Config.Default_Handle_Result);
    }

}
