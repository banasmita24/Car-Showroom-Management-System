public class Cars extends Vehicle {
    public Cars(String name, String model, String color, int year, double price) {
        super(name, model, color, year, price);
    }

    @Override //Polymorphism
    public String getDetails() {
        return super.getDetails();
    }
}

