import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

class Assignment1V1 {
    private static IScheduler scheduler;

    public static void main(String[] args) {
        ShopModel shopModel = new ShopModel(10);
        Simulator simulator = new Simulator(shopModel);
        CustomerGroup g ;
        ArrayList<Event> eventQueue = new ArrayList<Event>();
        ArrivalEvent arrivalEvent;
        OrderEvent orderEvent;
        LeaveEvent leaveEvent;
        int j = 0;
        int numberinGroup;

        System.out.println("Simulator Traced");
        System.out.println("======================================\n");
        for(int i=0; i<11; i++)
        { 
            numberinGroup = 2;
            arrivalEvent = new ArrivalEvent(j);
            g = new CustomerGroup(i, numberinGroup, arrivalEvent.getTime());
            shopModel.logGroup(g);
            arrivalEvent.getCustomerGroup(g);
            arrivalEvent.process(shopModel, scheduler);
            simulator.intialize(eventQueue);


            // group served
            orderEvent = new OrderEvent(arrivalEvent.getTime(), g);
            orderEvent.process(shopModel, scheduler);
            
            if((i)/2 == 0)
            {
                leaveEvent = new LeaveEvent(arrivalEvent.getTime(), g);
                leaveEvent.process(shopModel, scheduler);
            }   
            // eventQueue.add(arrivalEvent);
            j =j + 2;
            // simulator.run(0);
            
        }

        System.out.println("\nthe following groups are in the shop :");
        System.out.println("======================================\n");
        shopModel.showGroups();
        System.out.println("\nthe following groups are in the log:");
        System.out.println("======================================\n");
        shopModel.showLog();
    }
}

