package rote;

public class route {
    public String id;
    public double price;
    public String type;
    public String arrTime;
    public String leatime;
    public int[] seat = new int[3];
    public route(){
    }
    public void printInfo(){
        System.out.println("id :"+id);
        System.out.println("price :"+price);
        System.out.println("type :"+type);
        System.out.println("arrtime :"+arrTime);
        System.out.println("leatime :"+leatime);
        System.out.println("二等座 :"+seat[1]);
        System.out.println("一等座 :"+seat[0]);
        System.out.println("商务座 :"+seat[2]);
    }
}
