/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package toy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 流式读取DB
 * <a href="http://dev.mysql.com/doc/connector-j/5.1/en/connector-j-reference-implementation-notes.html">ResultSet流式说明</a>
 *
 * @author chichen  Date: 16-4-20 Time: 下午5:12
 */
public class StreamReadTest {

    public static void testStreamTest(String sql) {
        String url = "jdbc:mysql://localhost:3306/toy?user=cc&password=chenchi";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        int counter = 0;

        try {
            connection = DriverManager.getConnection(url);
            preparedStatement = connection.prepareStatement(
                    sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setFetchSize(Integer.MIN_VALUE);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
                System.out.println(++counter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
            // 忽略
        }
    }

    public static void main(String[] args) {
        String sql = "select * from small_toy";
        testStreamTest(sql);
    }
}
