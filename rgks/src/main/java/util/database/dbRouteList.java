package util.database;

import rote.route;

import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.sql.SQLWarning;
import java.util.*;


public class dbRouteList extends database{
    private String start;
    private String end;
    private String time;

    public dbRouteList(){
        super();
    }
    public dbRouteList(String start,String end,String time){
        super();
        this.start = start;
        this.end = end;
        this.time = time;
    }

    public List<route> getRouteList(){
        List<String> ids = this.getRouteId(start,end);
        return getRouteInfo(ids);
    }

    private List<route> getRouteInfo(List<String> ids){
        List<route> routes = new LinkedList<route>();
        for(int i=0;i<ids.size();i++){
            route line = new route();
            line.id = ids.get(i);
            try{
                this.init();
                String sql = String.format("select * from stopStation full join station where routeId = \"%s\" and station.name = \"%s\" and stationId = station.id;",ids.get(i),start);
                res = stmt.executeQuery(sql);
                System.out.println(sql);
                while(res.next()){
                    line.leatime = res.getString("leaTime");
                    line.price = res.getDouble("price");
                }
                res = stmt.executeQuery(String.format("select * from stopStation full join station where routeId = \"%s\" and station.name = \"%s\" and stationId = station.id;",ids.get(i),end));
                while(res.next()){
                    line.arrTime = res.getString("arrTime");
                    line.price = res.getDouble("price")-line.price;
                }
                res = stmt.executeQuery(String.format("select train.seatOne,train.seatTwo,train.seatBuss,route.seatOne,route.seatTwo,route.seatBuss,route.type from train join route where route.number = \"%s\" AND train.type = route.type and date = \"%s\"",ids.get(i),time));
                while(res.next()){
                    line.seat[0] = res.getInt(1)-res.getInt(4);
                    line.seat[1] = res.getInt(2)-res.getInt(5);
                    line.seat[2] = res.getInt(3)-res.getInt(6);
                    line.type = res.getString(7);
                }
//                line.printInfo();
            } catch (SQLException e){
                e.printStackTrace();
            } finally {
                this.destory();
            }
            routes.add(line);
        }
        return routes;
    }

    private List<String> getRouteId(String s_city,String e_city){
        String getStart = String.format("select routeId,number from stopStation full join station where station.name = \"%s\" AND StationId = station.id",s_city);
        String getEnd = String.format("select routeId,number from stopStation full join station where station.name = \"%s\" AND StationId = station.id",e_city);
//        System.out.println(getStart);
//        System.out.println(getEnd);
        List<String> ids = new LinkedList<String>();
        try{
            this.init();
            Map<String,String> start = new HashMap<String,String>();
            res = stmt.executeQuery(getStart);
            while(res.next()){
                start.put(res.getString(1),res.getString(2));
            }
            Map<String,String> end = new HashMap<String,String>();
            res = stmt.executeQuery(getEnd);
            while(res.next()){
                end.put(res.getString(1),res.getString(2));
            }
            for(String startId:start.keySet()){
//                System.out.println(startId+":"+start.get(startId));
                for(String endId:end.keySet()){
//                    System.out.println(endId+":"+end.get(endId));
                    if(startId.equals(endId)){
                        if(Integer.parseInt(start.get(startId)) < Integer.parseInt(end.get(endId))){
//                            System.out.println(startId);
                            ids.add(startId);
                        }
                    }
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            this.destory();
        }
        return ids;
    }

    public void test(){
//        getRouteId(start,end);
        getRouteList();
    }

}
