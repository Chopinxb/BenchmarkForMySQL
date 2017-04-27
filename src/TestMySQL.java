import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by xiaobang213452 on 2017/4/26.
 */
public class TestMySQL {

    private ArrayList<String> queries = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        TestDescroptor.initialize(new Configuration("config.properties"));
        new TestMySQL().start();
    }
    public TestMySQL() throws IOException {
        try {

            FileInputStream fis = new FileInputStream("query.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            for(String query = reader.readLine(); query != null ; query = reader.readLine()){
                queries.add(query);
            }
        } catch (FileNotFoundException e) {
            System.out.println("the query txt is not exist");
        }

    }
    public void start(){

        long start = System.currentTimeMillis();
        new Thread(new Runnable(){
            @Override
            public void run() {
                Random random = new Random();
                new Dao().query(queries.get(random.nextInt(queries.size())));
            }
        }).start();
    }
}
