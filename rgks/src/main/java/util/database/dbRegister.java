package util.database;

import java.sql.SQLException;

public class dbRegister extends database {
    String id = null;
    String pwd = null;
    String phoneNumber = null;
    public dbRegister(String id,String pwd,String phoneNumber){
        super();
        this.id = id;
        this.pwd = pwd;
        this.phoneNumber = phoneNumber;
    }

    public boolean register(){
        boolean isSuccess = true;
        try {
            this.init();
            String sql = String.format("INSERT INTO user(passwd,idNumber,phoneNumber) values (\"%s\",\"%s\",\"%s\")",pwd,id,phoneNumber);
            this.stmt.executeUpdate(sql);
        } catch (SQLException e){
            e.printStackTrace();
            isSuccess = false;
        } finally {
            this.destory();
        }
        return isSuccess;
    }

}
