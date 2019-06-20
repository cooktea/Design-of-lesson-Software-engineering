package util.database;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dbAddSeat extends database {
    public dbAddSeat(){
        super();
    }

    public boolean addSeat(String route,String time,String seat,String number){
        String sql = String.format("update route set %s = %s - %s where date = \"%s\" and number = \"%s\"",seat,seat,number,time,route);
        System.out.println(sql);
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

    public List<String> getRouteNumbers(){
        List<String> numbers = new ArrayList<String>();
        String sql = "select number from route group by number";
        try {
            this.init();
            res = stmt.executeQuery(sql);
            while (res.next()){
                numbers.add(res.getString(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            this.destory();
        }
        return numbers;
    }
}
