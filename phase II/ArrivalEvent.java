public class ArrivalEvent extends Event {

    public ArrivalEvent(int time) {
        super(time);
    }
//
    public void process(ShopModel shopModel, IScheduler scheduler) {
        int id = shopModel.getId();
        // int numberinGroup = (int) (Math.random() * 10) + 1;
        int arrivalTime = getTime();
        System.out.println("t= " + arrivalTime + ": " + "group " + id + " <2 people> arrived" );
     }
}
