import java.util.ArrayList;

public class ShopModel {
    private ArrayList<CustomerGroup> groups = new ArrayList<CustomerGroup>();
    private ArrayList<CustomerGroup> history = new ArrayList<CustomerGroup>();
    private int nextid;
    private int numGroups = 0;
    private int numSeats;
    private int lostBusiness =0;
    private int numServed = 0;

    public Object showGroups;
    public ShopModel(int numSeats) {
        this.numSeats = numSeats;
    }

    public void addGroup(CustomerGroup g){
        groups.add(g);
    }

    public void removeGroup(CustomerGroup g){
        groups.remove(g);
    }

    public void logGroup(CustomerGroup g) {
        this.history.add(g);
    }

    public int getNextId() {
        return this.nextid;
    }

    public int getNumGroups() {
        return this.numGroups;
    }

    public void showGroups() {
        for (CustomerGroup g : this.groups) {
            System.out.println(g);
        }
    }
    
    public void showLog() {
        for (CustomerGroup g : this.history) {
            System.out.println(g);
        }
    }

    public  boolean canSeat(int time, CustomerGroup group){
        
        if (this.numSeats >= group.getNumberInGroup()) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getNumberServed(){
        return this.numServed;
    }

    public int getLostBusiness(){
        return this.lostBusiness;
    }

    //Phase II 
    public void serveOrder(int time, CustomerGroup g){
        numServed = numServed + g.getNumberInGroup();
    }

    //Phase III
    public void leaveGroup(int time, CustomerGroup g){
        lostBusiness = lostBusiness + g.getNumberInGroup();
        groups.remove(g);
        System.out.println("t= " + time + ": " + "group " + g.getId() + " (" + g.getNumberInGroup() + " people) left" );
    }
}
