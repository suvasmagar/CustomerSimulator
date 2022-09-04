public class OrderEvent extends Event {

    private CustomerGroup group;
    int leaveLowerBound;
    int leaveGeneratorBound;
    public OrderEvent(int time, CustomerGroup g) {
        super(time);
        group = g;
    }

    public void process(ShopModel shopModel, IScheduler scheduler){
        // int id = group.getId();
        // int numberinGroup = group.getNumberInGroup();
        int arrivalTime = getTime();
        shopModel.serveOrder(arrivalTime, group);
    }    
}
