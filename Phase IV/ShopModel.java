import java.util.ArrayList;

public class ShopModel {
    private ArrayList<CustomerGroup> groups = new ArrayList<CustomerGroup>();
    private ArrayList<CustomerGroup> history = new ArrayList<CustomerGroup>();
    private int nextid;
    private int numGroups;
    private int numSeats;
    private int lostBusiness;
    private int numServed;

    public Object showGroups;
    public ShopModel(int numSeats) {
        this.numSeats = numSeats;
    }

    public void addGroup(CustomerGroup g){
        groups.add(g);
        numGroups = numGroups + g.getNumberInGroup();
    }

    public void removeGroup(CustomerGroup g){
        groups.remove(g);
        numGroups = numGroups - g.getNumberInGroup();
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
            System.out.println("number : " + group.getNumberInGroup() + " can be seated");
            // numSeats = numSeats - group.getNumberInGroup();
            return true;
        }
        
        return false;
    }

    public int getNumberServed(){
        return this.numServed;
    }

    public int getLostBusiness(){
        return this.lostBusiness;
    }

    //Phase II
    //to display order served to the group id
    public void serveOrder(int time, CustomerGroup g){
        System.out.println("t= " + time + ": " + "group " + g.getId() + " (" + g.getNumberInGroup() + " people) seated" );
    }

    //Phase III
    public void leaveGroup(int time, CustomerGroup g){
        // numSeats = numSeats - g.getNumberInGroup();
        groups.remove(g);
        System.out.println("t= " + time + ": " + "group " + g.getId() + " (" + g.getNumberInGroup() + " people) left" );
    }
}
