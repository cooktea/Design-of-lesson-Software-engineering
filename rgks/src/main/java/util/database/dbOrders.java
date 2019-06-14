package util.database;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import rote.orders;


public class dbOrders extends database {
    private String phoneNumber = null;
    public dbOrders(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public List<orders> getOrders(){
        String sql = String.format("select * from orders where user = \"%s\"",phoneNumber);
        List<orders> myOrders = new LinkedList<orders>();
        try {
            this.init();
            res = this.stmt.executeQuery(sql);
            while(res.next()){
                orders order = new orders();
                order.id = res.getString("id");
                order.date = res.getString("date");
                order.start = res.getString("start");
                order.end = res.getString("end");
                order.route = res.getString("route");
                if("0".equals(res.getString("status"))){
                    order.status = "已确认";
                } else {
                    order.status = "以取消";
                }
                if("seatTwo".equals(res.getString("seat"))){
                    order.seat = "二等座";
                } else if("seatOne".equals(res.getString("seat"))){
                    order.seat = "一等座";
                } else {
                    order.seat = "商务座";
                }
                myOrders.add(order);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            this.destory();
        }
        return myOrders;
    }
}
