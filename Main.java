import javax.swing.*; //for GUI
import javax.swing.table.DefaultTableModel;
import java.awt.*; //Abstract Window Toolkit: for managing components, label, button
import java.util.ArrayList; //dynamic data storage, resizable array

public class Main {
    static ArrayList<Showroom> showrooms = new ArrayList<>();
    static ArrayList<Employees> employees = new ArrayList<>();
    static ArrayList<Cars> cars = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Showroom Management System"); //main window of application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        // frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel welcomeLabel = new JLabel("Welcome to Showroom Management System", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        welcomeLabel.setForeground(new Color(0x2F2F89));
        frame.add(welcomeLabel, BorderLayout.NORTH);
        
        JPanel panel = new JPanel(); //Button Panel Setup
        // panel.setBackground(Color.LIGHT_GRAY);
        JButton btnAddShowroom = new JButton("Add Showroom");
        // btnAddShowroom.setBackground(Color.CYAN); // Set background color
        JButton btnAddEmployee = new JButton("Add Employee");
        JButton btnAddCar = new JButton("Add Car");
        JButton btnViewShowrooms = new JButton("View Showrooms");
        JButton btnViewEmployees = new JButton("View Employees");
        JButton btnViewCars = new JButton("View Cars");
        JButton exitButton = new JButton("Exit");

        panel.add(btnAddShowroom); //Adding Buttons to the Panel
        panel.add(btnAddEmployee);
        panel.add(btnAddCar);
        panel.add(btnViewShowrooms);
        panel.add(btnViewEmployees);
        panel.add(btnViewCars);
        panel.add(exitButton);
        
        frame.add(panel, BorderLayout.CENTER); //button panel is added to the center of the JFrame

        btnAddShowroom.addActionListener(e -> {
            try {
                String name = JOptionPane.showInputDialog(frame, "Enter Showroom Name:");
                String location = JOptionPane.showInputDialog(frame, "Enter Location:");
                String ownerName = JOptionPane.showInputDialog(frame, "Enter Owner Name:");
                String branchName = JOptionPane.showInputDialog(frame, "Enter Branch Name:");
                String managerName = JOptionPane.showInputDialog(frame, "Enter Manager Name:");

                // Check if any input is empty and throw an error immediately if so
                if (name == null || name.trim().isEmpty()) {
                    throw new IllegalArgumentException("Showroom Name cannot be empty.");
                }
                if (location == null || location.trim().isEmpty()) {
                    throw new IllegalArgumentException("Location cannot be empty.");
                }
                if (ownerName == null || ownerName.trim().isEmpty()) {
                    throw new IllegalArgumentException("Owner Name cannot be empty.");
                }
                if (branchName == null || branchName.trim().isEmpty()) {
                    throw new IllegalArgumentException("Branch Name cannot be empty.");
                }
                if (managerName == null || managerName.trim().isEmpty()) {
                    throw new IllegalArgumentException("Manager Name cannot be empty.");
                }

                Showroom showroom = new Showroom(name, location, ownerName, branchName, managerName);
                showrooms.add(showroom);
                JOptionPane.showMessageDialog(frame, "Showroom added successfully!");

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        btnAddEmployee.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(frame, "Enter Employee Name:");
            String position = JOptionPane.showInputDialog(frame, "Enter Employee Position:");
            String email = JOptionPane.showInputDialog(frame, "Enter Email:");
            String phoneNumber = JOptionPane.showInputDialog(frame, "Enter Phone Number:");
            String ageString = JOptionPane.showInputDialog(frame, "Enter Age:");
            if (name != null && position != null && email != null && phoneNumber != null && ageString != null) {
                try {
                    int age = Integer.parseInt(ageString);
                    Employees employee = new Employees(name, position, email, phoneNumber, age);
                    employees.add(employee);
                    JOptionPane.showMessageDialog(frame, "Employee added successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid age entered.");
                }
            }
        });
        
        btnAddCar.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(frame, "Enter Car Name:");
            String model = JOptionPane.showInputDialog(frame, "Enter Car Model:");
            String color = JOptionPane.showInputDialog(frame, "Enter Car Color:");
            String yearString = JOptionPane.showInputDialog(frame, "Enter Car Year:");
            String priceString = JOptionPane.showInputDialog(frame, "Enter Car Price:");
            if (name != null && model != null && color != null && yearString != null && priceString != null) {
                try {
                    int year = Integer.parseInt(yearString);
                    double price = Double.parseDouble(priceString);
                    Cars car = new Cars(name, model, color, year, price);
                    cars.add(car);
                    JOptionPane.showMessageDialog(frame, "Car added successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid year or price entered.");
                }
            }
        });
        
        btnViewShowrooms.addActionListener(e -> showInTable("Showrooms", showrooms)); //calls the showInTable method
        btnViewEmployees.addActionListener(e -> showInTable("Employees", employees));
        btnViewCars.addActionListener(e -> showInTable("Cars", cars));
        
        exitButton.addActionListener(e -> System.exit(0)); //closes the application when clicked
        
        frame.setVisible(true);
    }

    private static void showInTable(String title, ArrayList<?> dataList) {
        String[] columnNames;
        Object[][] data;

        if (title.equals("Showrooms")) {
            columnNames = new String[]{"Name", "Location", "Owner", "Branch", "Manager"};
            data = new Object[dataList.size()][5];
            for (int i = 0; i < dataList.size(); i++) {
                Showroom showroom = (Showroom) dataList.get(i);
                data[i][0] = showroom.getShowroomName();
                data[i][1] = showroom.getLocation();
                data[i][2] = showroom.getOwnerName();
                data[i][3] = showroom.getBranchName();
                data[i][4] = showroom.getManagerName();
            }
        } else if (title.equals("Employees")) {
            columnNames = new String[]{"ID", "Name", "Position", "Email", "Phone", "Age"};
            data = new Object[dataList.size()][6];
            for (int i = 0; i < dataList.size(); i++) {
                Employees employee = (Employees) dataList.get(i);
                data[i][0] = employee.getId();
                data[i][1] = employee.getName();
                data[i][2] = employee.getPosition();
                data[i][3] = employee.getEmail();
                data[i][4] = employee.getPhoneNumber();
                data[i][5] = employee.getAge();
            }
        } else {
            columnNames = new String[]{"Name", "Model", "Color", "Year", "Price"};
            data = new Object[dataList.size()][5];
            for (int i = 0; i < dataList.size(); i++) {
                Cars car = (Cars) dataList.get(i);
                data[i][0] = car.getName();
                data[i][1] = car.getModel();
                data[i][2] = car.getColor();
                data[i][3] = car.getYear();
                data[i][4] = car.getPrice();
            }
        }

        JTable table = new JTable(new DefaultTableModel(data, columnNames)); //display data in a table
        JOptionPane.showMessageDialog(null, new JScrollPane(table), title, JOptionPane.INFORMATION_MESSAGE);
    }
}