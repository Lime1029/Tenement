package db;
/*封装数据库连接操作*/

import java.sql.*;
import admin.DBAdmin;

public class DBConnection {
    private final String driverName = DBAdmin.driverName;
    private final String userName = DBAdmin.db_username;
    private final String userPwd = DBAdmin.db_password;
    private final String dbName = DBAdmin.db_name;
    private Connection conn = null;

    public Connection getDBConnection() {
        //获取数据库连接对象的方法
        String url1 = "jdbc:mysql://localhost:3306/"+dbName;
        String url2 = "?user="+userName+"&password="+userPwd;
        String url3 = "&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String url = url1+url2+url3; //形成数据库连接字

        try {
            Class.forName(driverName);
            this.conn = DriverManager.getConnection(url);
        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("connected.");
        return conn;
    }


    //关闭数据库连接的各资源对象
    public static void closeDBConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
        if(rs != null) try{
            rs.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        if(ps != null) try {
            ps.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        if(conn != null) try{
            conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
