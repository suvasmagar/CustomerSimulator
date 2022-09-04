public class CustomerGroup {
    private int id;
    private int numberinGroup;
    private int arrivalTime;

    public  CustomerGroup(int id, int numberinGroup, int arrivalTime) {
        this.id = id;
        this.numberinGroup = numberinGroup;
        this.arrivalTime = arrivalTime;
    }
    
    public int getId() {
        return this.id;
    }

    public int getNumberInGroup() {
        return this.numberinGroup; 
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }
    
    @Override
    public String toString() {
        return "Group " + this.id + " (" + this.numberinGroup + " people) arrived at t= " + this.arrivalTime;
    }
    
}
