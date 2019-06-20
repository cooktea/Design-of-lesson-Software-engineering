package util.database;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class dbUser extends database {
    public dbUser(){
        super();
    }
    public List<String[]> getUsers(){
        String sql = "select * from user ";
        List<String[]> users = new ArrayList<String[]>();
        try {
            this.init();
            res = stmt.executeQuery(sql);
            while(res.next()){
                String[] user = new String[3];
                user[0] = res.getString("idNumber");
                user[1] = res.getString("passwd");
                user[2] = res.getString("phoneNumber");
                users.add(user);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            this.destory();
        }
        return users;
    }
    public boolean deleteUser(String id){
        String sql = String.format("delete from user where idNumber = \"%s\"",id);
        try {
            this.init();
            stmt.executeUpdate(sql);
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        } finally {
            this.destory();
        }
        return true;
    }

}
