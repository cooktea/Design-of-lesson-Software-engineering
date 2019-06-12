package util.database;

import java.sql.SQLException;

public class dbLogin extends database{
    private String id = null;
    private String passwd = null;
    public dbLogin(String id,String passwd){
        super();
        this.id = id;
        this.passwd = passwd;
    }
    public String login(){
        String sql = String.format("SELECT phoneNumber FROM user WHERE idNumber = \"%s\" AND passwd = \"%s\"",id,passwd);
        String phoneNumber = null;
        System.out.println(sql);
        try {
            this.init();
            res = stmt.executeQuery(sql);
            while(res.next()){
                phoneNumber = res.getString("phoneNumber");
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            this.destory();
        }
        System.out.println(phoneNumber);
        return phoneNumber;
    }
}
