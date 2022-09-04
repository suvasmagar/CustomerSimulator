public class LeaveEvent extends Event {
    CustomerGroup group;
    public LeaveEvent(int time, CustomerGroup g) {
        super(time);
        group = g;
    }
    
    public void process(ShopModel shopModel, IScheduler scheduler){
        int arrivalTime = getTime();
        shopModel.leaveGroup(arrivalTime, group);
    }
    
}
