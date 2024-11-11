public class Showroom {
    private String showroomName;
    private String location;
    private String ownerName;
    private String branchName;
    private String managerName;

    //Constructor
    public Showroom(String showroomName, String location, String ownerName, String branchName, String managerName) {
        this.showroomName = showroomName; //this: to differentiate between the class's fields and the parameters
        this.location = location;
        this.ownerName = ownerName;
        this.branchName = branchName;
        this.managerName = managerName;
    }

    public String getShowroomName() {
        return showroomName;
    } //By using getter methods, the data remains encapsulated

    public String getLocation() {
        return location;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getDetails() {
        return "Showroom Name: " + showroomName + ", Location: " + location +
               ", Owner Name: " + ownerName + ", Branch Name: " + branchName +
               ", Manager Name: " + managerName;
    }
}