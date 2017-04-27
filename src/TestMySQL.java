import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by xiaobang213452 on 2017/4/26.
 */
public class TestMySQL {

    private ArrayList<String> queries = new ArrayList<>();

    public static void main(String args[]) throws IOException, InterruptedException {
        TestDescroptor.initialize(new Configuration("config.properties"));
        new TestMySQL().start(TestDescroptor.getInstance().clients);
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
    public void start(int threadNumber) throws InterruptedException {

        final CountDownLatch countDownLatch = new CountDownLatch(threadNumber);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threadNumber; i++) {
            final int threadID = i;
            new Thread(new Runnable(){
                @Override
                public void run() {
                    long start = System.currentTimeMillis();
                    Random random = new Random();
                    new Dao().query(queries.get(random.nextInt(queries.size())));
                    long end = System.currentTimeMillis();
                    System.out.println(String.format("threadID:[%s] finished in "+ (end-start)/1000.0 + " s", threadID));
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println("main thread finished in "+ (endTime-startTime)/1000.0 + " s");
    }
}
