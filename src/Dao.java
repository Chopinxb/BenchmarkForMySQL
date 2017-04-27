/**
 * Created by xiaobang213452 on 2017/4/26.
 */
import java.sql.*;
public class Dao {
    private String url;
    private String user;
    private String password ;
    private String driver ;
    private boolean handlerResult;

    public Dao(){
        TestDescroptor descroptor = TestDescroptor.getInstance();
        this.url = descroptor.url;
        this.user = descroptor.user;
        this.password = descroptor.password;
        this.driver = descroptor.driver;
        this.handlerResult = descroptor.handleResult;

    }
    public void query(String query){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn;
        try {
            conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            if(!handlerResult){
                stmt.executeQuery(query);
            }
            else{
                ResultSet  resultSet = stmt.executeQuery(query);
                int num = 0;
                while(resultSet.next()){
                    num++;
                }
                System.out.println("This query has " + num +"records");
            }
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
