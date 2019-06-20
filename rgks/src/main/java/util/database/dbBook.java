package util.database;

import java.sql.SQLException;

public class dbBook extends database {
    private String id = null;
    private String date = null;
    private String start = null;
    private String end = null;
    private String phoneNumber = null;
    private String seat = null;
    public dbBook(String id,String date,String start,String end,String phoneNumber,String seat){
        super();
        this.id = id;
        this.date = date;
        this.start = start;
        this.end = end;
        this.phoneNumber = phoneNumber;
        this.seat = seat;
    }
    public boolean book(){
        String sql = String.format("insert into orders(user,start,end,date,route,seat) values(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\")",phoneNumber,start,end,date,id,seat);
        try {
            this.init();
            System.out.println(sql);
            stmt.executeUpdate(sql);
            sql = String.format("update route set %s = %s+1 where number = \"%s\" and date = \"%s\"",seat,seat,id,date);
            System.out.println(sql);
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
