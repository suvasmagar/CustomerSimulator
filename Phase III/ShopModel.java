import java.util.ArrayList;

public class ShopModel extends CustomerGroup{

    private ArrayList<CustomerGroup> groups = new ArrayList<CustomerGroup>();
    private ArrayList<CustomerGroup> history = new ArrayList<CustomerGroup>();
    private int nextid;
    private int numGroups;
    public Object showGroups;

    public ShopModel(int id, int numberinGroup, int arrivalTime) {
        super(id, numberinGroup, arrivalTime);
        addGroup(id, numberinGroup, arrivalTime);
        logGroup(groups.get(0));
    }

    public void addGroup(int id, int numberinGroup, int arrivalTime) {
        CustomerGroup group = new CustomerGroup(id, numberinGroup, arrivalTime);
        groups.add(group);
        nextid = id + 1;
        numGroups = numGroups + 1;
    }

    public void logGroup(CustomerGroup g) {
        this.history.add(g);
    }

    public void setnumGroups(int numGroups) {
        this.numGroups = numGroups;
    }

    public int getNextId() {
        return this.nextid;
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

    //Phase II
    //to display order served to the group id
    public void serveOrder(int time, CustomerGroup g){
        System.out.println("t= " + time + ": " + "group " + g.getId() + " (" + g.getNumberInGroup() + " people) seated" );
    }

    //Phase III
    public void leaveGroup(int time, CustomerGroup g){
        groups.remove(g);
        System.out.println("t= " + time + ": " + "group " + g.getId() + " (" + g.getNumberInGroup() + " people) left" );
    }
    




   

}
