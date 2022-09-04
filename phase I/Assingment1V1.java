import java.util.ArrayList;

class Assignment1V1 {
    private static IScheduler scheduler;

    public static void main(String[] args) {
        ShopModel shopModel ;
        Simulator simulator ;
        ArrayList<Event> eventQueue = new ArrayList<Event>();
        ArrivalEvent arrivalEvent = new ArrivalEvent(0);
        ArrayList<ShopModel> shopModels = new ArrayList<ShopModel>();
        int j = 0;

        System.out.println("Simulator Traced");
        System.out.println("======================================\n");
        for(int i=0; i<11; i++)
        { 
                arrivalEvent = new ArrivalEvent(j);
                shopModel = new ShopModel(i, 2, arrivalEvent.getTime());
                shopModels.add(shopModel);
                simulator = new Simulator(shopModel);
                simulator.intialize(eventQueue);
                arrivalEvent.process(shopModel, scheduler);
                eventQueue.add(arrivalEvent);
                simulator.run(0);
                j = j + 2;
        }
        
        System.out.println("\nthe following groups are in the shop:");
        System.out.println("======================================\n");
        for(ShopModel s : shopModels) {
            s.showGroups();
        }
        System.out.println("\nthe following groups are in the log:");
        System.out.println("======================================\n");

        for(ShopModel s : shopModels) {
            s.showLog();
        }
    }
}

