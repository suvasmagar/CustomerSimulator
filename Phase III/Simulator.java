import java.util.ArrayList;

public class Simulator implements IScheduler {
    private ArrayList<Event> events;
    private int clock;
    private ShopModel model; 

    public Simulator(ShopModel shopModel) {
        this.model = shopModel;
    }

    public void intialize(ArrayList<Event> events) {
        this.events = events;
        this.clock = 0;
    }

    public void run(int stopTime) {
        if((events==null) || (events.size()==0)) {
            return;
        }
        Event e = events.remove(0);
        clock = e.getTime();
        while(clock < stopTime) {
            e.process(model, this);
            e = events.remove(0);
            clock = e.getTime();
        }
    }

    public void schedule(Event event){
        this.events.add(event);
    }

}
