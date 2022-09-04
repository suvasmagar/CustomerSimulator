public class ArrivalEvent extends Event {
    CustomerGroup group;

    public ArrivalEvent(int time) {
        super(time);
    }

    public void getCustomerGroup(CustomerGroup g) {
        group = g;
    }  

    @Override
    public void process(ShopModel shopModel, IScheduler scheduler){
        int arrivalTime = getTime();        
        System.out.println("t= " + arrivalTime + ": " + "group " + group.getId() + " <" + group.getNumberInGroup() + " people> arrived");
        if(shopModel.canSeat(arrivalTime, group)){
            System.out.println("t= " + arrivalTime + ": " + "group " + group.getId() + " (" + group.getNumberInGroup() + " people) seated");
            shopModel.addGroup(group);
        }
        else {
            System.out.println("t= " + arrivalTime + ": " + "group " + group.getId() + " <" + group.getNumberInGroup() + " people> cannot be seated" );
        }
    }    
}
