package sample.hashtest;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import redis.clients.jedis.Jedis;

public class JeRedis {
    public static void main(String[] arg) {
        //连接本地的 Redis 服务
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("Connect to database successfully");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}

