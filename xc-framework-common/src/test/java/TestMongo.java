import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

/**
 * ClassName: TestMongo
 * Date:      2020/3/14 10:42
 * author     congzi
 * version    V1.0
 */
public class TestMongo {

    @Test
    public void testConnection(){

        //1.创建Mongo客户端连接对象
        MongoClient mc = new MongoClient("localhost",27017);

        //或者使用 连接字符串
        //MongoClientURI clientURI = new MongoClientURI("mongodb://root:root@localhost:27017");
        //MongoClient mc = new MongoClient(clientURI);

        //2.连接数据库
        MongoDatabase database = mc.getDatabase("test");

        //3.连接connection
        MongoCollection<Document> collection = database.getCollection("student");

        //4.查询第一个文档
        Document document = collection.find().first();

        //5.得到文件内容的字符串
        String json = document.toJson();
        System.out.println(json);
    }

}
