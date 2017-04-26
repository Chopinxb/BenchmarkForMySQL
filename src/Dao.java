/**
 * Created by xiaobang213452 on 2017/4/26.
 */
import java.sql.*;
public class Dao {
    public String url = "";
    public String user = "";
    public String password = "";
    public String driver = "";


    public void connect(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        try{
//            //调用Class.forName()方法加载驱动程序
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("成功加载MySQL驱动！");
//        }catch(ClassNotFoundException e1){
//            System.out.println("找不到MySQL驱动!");
//            e1.printStackTrace();
//        }

//        String url="jdbc:mysql://localhost:3306/mysql";    //JDBC的URL
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.print("成功连接到数据库！");
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
