package util.database;

import java.sql.*;

public class database {
    private final String url = "jdbc:mysql://********";
    private final String user = "****";
    private final String passwd = "*******";
    protected Connection connect = null;
    protected Statement stmt = null;
    protected ResultSet res = null;

    public database(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void init() {
        try {
            this.connect = DriverManager.getConnection(url, user, passwd);
            System.out.println("数据库连接成功");
            this.stmt = connect.createStatement();
            System.out.println("数据库初始化成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void destory() {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connect != null) {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
