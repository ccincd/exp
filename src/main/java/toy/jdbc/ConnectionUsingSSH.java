/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package toy.jdbc;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 121.196.193.185是SSH服务器
 * 172.16.0.1是远端本机服务器（MySQL服务器）
 *
 * @author chichen  Date: 16-4-26 Time: 下午2:10
 */
public class ConnectionUsingSSH {

    public static void main(String[] args) {
        JSch jSch = new JSch();
        Session session = null;
        Connection conn = null;
        Statement statement = null;
        try {
            session = jSch.getSession("root", "121.196.193.185", 22);
            session.setPassword("1qaz2wsx`");
            // 如果不设置此项会抛出UnknownHostKey异常
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            // 打印ssh服务器版本信息
            System.out.println(session.getServerVersion());

            // 端口转发，本地起一个socket进行监听，通过ssh安全通道传输数据
            int assignedPort = session.setPortForwardingL(1234, "172.16.0.1", 3306);
            System.out.println(assignedPort);

            Class.forName("com.mysql.jdbc.Driver");
            // 虽然使用ssh进行了连接，127.0.0.1连接的是本地数据库，而非远端的localhost
            conn = DriverManager.getConnection("jdbc:mysql://localhost:1234/toy?user=root&password=chenchi");

            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) from small_toy");

            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i + 1);
                System.out.println(columnName);
            }

            while (resultSet.next()) {
                for (int j = 0; j < metaData.getColumnCount(); j++) {
                    System.out.println(resultSet.getString(j + 1) + '\t');
                }

                System.out.println();
            }

            statement.close();
            conn.close();
            session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (session != null) {
                session.disconnect();
            }
        }
    }
}
