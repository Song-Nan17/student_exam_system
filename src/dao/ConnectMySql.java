package dao;

import java.sql.*;

public class ConnectMySql {
    private static final String URL = "jdbc:mysql://localhost:3306/exam_system?useSSL=false";
    private static final String NAME = "root";
    private static final String PASSWORD = "766413";

    public Connection getConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动不存在！");
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("数据库连接失败！");
        }
        return conn;
    }

    public Statement getStatement(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("创建Statement失败！");
        }
        return statement;
    }

    public ResultSet executeSQL(Statement statement, String sql) {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("查询失败！");
        }
        return rs;
    }


    public static void closeConnect(ResultSet rs, Statement st, Connection conn) {
        if (rs != null) {   // 关闭记录集
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {   // 关闭声明
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {  // 关闭连接对象
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
