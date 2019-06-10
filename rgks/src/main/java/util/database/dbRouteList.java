package util.database;

import com.sun.tools.javac.comp.Todo;
import rote.route;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


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
        List<route> routes = new LinkedList<>();
        String getStart = "SELECT stopStation.StationId from stopStation full join station where station.name = "+start;
        String getEnd = "SELECT stopStation.StationId from stopStation full join station where station.name = "+end;
        List<String> startId = new LinkedList<String>();
        List<String> endId = new LinkedList<String>();
        List<String> routesId = new LinkedList<String>();
        try{
            res = stmt.executeQuery(getStart);
            while(res.next()){
                startId.add(res.getString(0));
            }
            res = stmt.executeQuery(getEnd);
            while(res.next()){
                endId.add(res.getString(0));
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        for(int i=0;i<startId.size();i++){
            for(int j=0;j<endId.size();j++){
                if(startId.get(i).equals(endId.get(j))){
                    routesId.add(startId.get(i));
                }
            }
        }
        for(int i=0;i<routesId.size();i++){
            System.out.println(routesId.get(i));
            String getListItem = "SELECT * from route where id = " + routesId.get(i) + " and DATE_FORMAT(time,\"%Y-%m-%d\") = " + time;
            try{
                res = stmt.executeQuery(getListItem);
                while(res.next()){
                    route route = new route();
//                    TODO 获取车次列表未完成，修改查询语句使其能够获取出发时间和到达时间。
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

        }




        return routes;
    }



}
