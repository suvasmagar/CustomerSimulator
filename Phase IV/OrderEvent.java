public class OrderEvent extends Event {

    private CustomerGroup group;
    int leaveLowerBound;
    int leaveGeneratorBound;
    public OrderEvent(int time, CustomerGroup g) {
        super(time);
        group = g;
    }

    @Override
    public void process(ShopModel shopModel, IScheduler scheduler){
        int arrivalTime = getTime();        
        if(shopModel.canSeat(arrivalTime, group)){
            shopModel.serveOrder(arrivalTime, group);
            shopModel.addGroup(group);
        }
        else {
            System.out.println("t= " + arrivalTime + ": " + "group " + group.getId() + " <" + group.getNumberInGroup() + " people> cannot be seated" );
        }

    }    
}
