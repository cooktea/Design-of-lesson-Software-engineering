package util.database;

import java.sql.SQLException;

public class dbUnbook extends database{
    String id;
    public dbUnbook(String id){
        this.id = id;
    }
    public Boolean unBook(){
        String sql = "update orders set status = 1 where id = "+id;
        try{
            this.init();
            stmt.executeUpdate(sql);
            sql = "select * from orders where id = "+id;
            res = stmt.executeQuery(sql);
            String route = null;
            String date = null;
            String seat = null;
            while(res.next()){
                route = res.getString("route");
                date = res.getString("date");
                seat = res.getString("seat");
            }
            sql = String.format("update route set %s = %s - 1 where date = \"%s\" and number = \"%s\"",seat,seat,date,route);
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
