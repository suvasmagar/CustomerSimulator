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
        shopModel.serveOrder(arrivalTime, group);   
        System.out.println("t: "+ group.getArrivalTime() + " Order served for group " + group.getId() + " (" + group.getNumberInGroup() + " people)");
    }    
}
