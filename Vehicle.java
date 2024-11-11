public class Vehicle {
    protected String name;
    protected String model;
    protected String color;
    protected int year;
    protected double price;

    public Vehicle(String name, String model, String color, int year, double price) {
        this.name = name;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getDetails() {
        return "Name: " + name + ", Model: " + model + ", Color: " + color +
                ", Year: " + year + ", Price: " + price;
    }
}
