import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

class Assignment1V1 {
    private static IScheduler scheduler;

    public static void main(String[] args) throws FileNotFoundException {
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
            numberinGroup = (int) (Math.random()*5+1);
            arrivalEvent = new ArrivalEvent(j);
            g = new CustomerGroup(i, numberinGroup, arrivalEvent.getTime());
            shopModel.logGroup(g);
            arrivalEvent.getCustomerGroup(g);
            arrivalEvent.process(shopModel, scheduler);
            simulator.intialize(eventQueue);

            // group served
            if((i%2==0) && (i!=0))
            {
                orderEvent = new OrderEvent(arrivalEvent.getTime(), g);
                orderEvent.process(shopModel, scheduler);
            }
            
            if(i%4 == 0 && i!=0)
            {
                leaveEvent = new LeaveEvent(arrivalEvent.getTime(), g);
                leaveEvent.process(shopModel, scheduler);
            }
            eventQueue.add(arrivalEvent);
            j =j + 2;
            simulator.run(0);
            
        }

        try {
            final boolean append = true, autoflush = true;
            PrintStream printStream = new PrintStream(new FileOutputStream("statistics.txt", append), autoflush);
            System.setOut(printStream);
            System.setErr(printStream);

        } 
        catch (IOException e) {
            System.out.println("Error during reading/writing");
        }

        System.out.println("\nStatitics");
        System.out.println("=========\n");
        System.out.println("Number of groups served: " + shopModel.getNumberServed());
        System.out.println("Number of groups lost: " + shopModel.getLostBusiness());

        System.out.println("\nthe following groups are in the shop :");
        System.out.println("======================================\n");
        shopModel.showGroups();
        System.out.println("\nthe following groups are in the log:");
        System.out.println("======================================\n");
        shopModel.showLog();
    }    
}



