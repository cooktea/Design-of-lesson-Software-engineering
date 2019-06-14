package util.database;
import rote.station;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class dbRouteInfo extends database{
    String id = null;
    public dbRouteInfo(String id){
        super();
        this.id = id;
    }
    public List<station> getStations(){
        List<station> stations = new LinkedList<station>();
        String sql = String.format("select * from stopStation join station where routeId =\"%s\" and stationId = station.id order by number",id);
        try {
            this.init();
            res = stmt.executeQuery(sql);
            while (res.next()){
                station s = new station();
                s.id = res.getString("routeId");
                s.arrTime = res.getString("arrTime");
                s.leaTime = res.getString("leaTime");
                s.price = res.getDouble("price");
                s.name = res.getString("name");
                stations.add(s);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            this.destory();
        }
        for(int i=1;i<stations.size();i++){
            stations.get(i).price -= stations.get(i-1).price;
        }
        return stations;
    }
}
