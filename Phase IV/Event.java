public abstract class Event {
    private int time;

    public abstract void process(ShopModel shopModel, IScheduler scheduler);

    public Event(int time) {
        this.time = time;
    }

    public int getTime() {
        return this.time;
    } 
}
