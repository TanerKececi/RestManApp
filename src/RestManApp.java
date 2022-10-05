import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class RestManApp {
    private ArrayList<Staff> staffs;
    private ArrayList<Customer> customers;

    public RestManApp() throws ParseException {
        this.staffs = new ArrayList<>();
        this.customers = new ArrayList<>();
        PopulateData();
        menu();
    }

    public void PopulateData() throws ParseException {

        Date newDate1 = new SimpleDateFormat("dd/MM/yyyy").parse("5/10/2022");
        Staff staff1 = new Staff(1111, "staff1", 'F', newDate1);
        this.staffs.add(staff1);

        newDate1 = new SimpleDateFormat("dd/MM/yyyy").parse("6/10/2022");
        Staff staff2 = new Staff(2222, "staff2", 'F', newDate1);
        this.staffs.add(staff2);

        newDate1 = new SimpleDateFormat("dd/MM/yyyy").parse("7/10/2022");
        Staff staff3 = new Staff(3333, "staff3", 'F', newDate1);
        this.staffs.add(staff3);


        newDate1 = new SimpleDateFormat("dd/MM/yyyy").parse("2/3/2020");
        Date newDate2 = new SimpleDateFormat("dd/MM/yyyy").parse("7/3/2020");
        Date newDate3 = new SimpleDateFormat("dd/MM/yyyy").parse("12/5/2020");

        Order order = new Order("Order Detail 1", "Order description 1");
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order);

        Booking booking = new Booking(newDate1, 1, orders);
        ArrayList<Booking> bookings = new ArrayList<>();
        bookings.add(booking);

        Customer customer1 = new Customer(1111, "Customer1", 'M', newDate2, newDate3, bookings);
        this.customers.add(customer1);



        newDate1 = new SimpleDateFormat("dd/MM/yyyy").parse("2/3/2020");
        newDate2 = new SimpleDateFormat("dd/MM/yyyy").parse("7/3/2020");
        newDate3 = new SimpleDateFormat("dd/MM/yyyy").parse("12/5/2020");

        Order order2 = new Order("Order Detail 2", "Order description 2");
        ArrayList<Order> orders2 = new ArrayList<>();
        orders2.add(order2);

        Booking booking2 = new Booking(newDate1, 2, orders2);
        ArrayList<Booking> bookings2 = new ArrayList<>();
        bookings2.add(booking2);

        Customer customer2 = new Customer(2222, "Customer2", 'M', newDate2, newDate3, bookings2);
        this.customers.add(customer2);




        newDate1 = new SimpleDateFormat("dd/MM/yyyy").parse("2/3/2020");
        newDate2 = new SimpleDateFormat("dd/MM/yyyy").parse("7/3/2020");
        newDate3 = new SimpleDateFormat("dd/MM/yyyy").parse("12/5/2020");
        Order order3 = new Order("Order Detail 2", "Order description 2");
        ArrayList<Order> orders3 = new ArrayList<>();
        orders3.add(order3);

        Booking booking3 = new Booking(newDate1, 3, orders3);
        ArrayList<Booking> bookings3 = new ArrayList<>();
        bookings3.add(booking3);

        Customer customer3 = new Customer(2222, "Customer2", 'M', newDate2, newDate3, bookings3);
        this.customers.add(customer3);

    }

    public void addStaff() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter ssn for staff:");
        int ssn = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter name for staff:");
        String name = scanner.nextLine();

        System.out.println("Enter gender of the staff (M/F)");
        char gender = scanner.nextLine().charAt(0);

        System.out.println("Enter date of birth in dd/mm/yyyy: ");
        String dateString = scanner.nextLine();
        Date newDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);

        Staff newStaff = new Staff(ssn,name,gender,newDate);
        staffs.add(newStaff);
        System.out.println("New staff added!");
    }

    public void deleteStaff(int ssn){
        int index = searchStaff(ssn);
        if(index == -1){
            System.out.println("There is no such staff in the record!");
        }
        else{
            staffs.remove(index);
            System.out.println("Staff deleted from the record!");
        }
    }

    public void getStaffDetails(int ssn){
        int index = searchStaff(ssn);
        if(index == -1){
            System.out.println("There is no such staff in the record!");
        }
        else{
            Staff staff = staffs.get(index);
            System.out.println("Staff ssn: " + staff.getSsn() + "\t|| Staff name: " + staff.getName()
                    + "\t|| Staff gender: " + staff.getGender() + "\t|| Staff date of birth : " + staff.getDateOfBirth());
        }
    }

    private int searchStaff(int ssn){
        for (int i = 0; i < staffs.size(); i++){
            if(ssn == staffs.get(i).getSsn()){
                return i;
            }
        }
        return -1;
    }

    public void addCustomer() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter ssn for customer:");
        int ssn = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter name for customer:");
        String name = scanner.nextLine();

        System.out.println("Enter gender of the customer (M/F)");
        char gender = scanner.nextLine().charAt(0);

        System.out.println("Enter date of birth in dd/mm/yyyy: ");
        String dateString1 = scanner.nextLine();
        Date newDate1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateString1);

        System.out.println("Enter registration date in dd/mm/yyyy: ");
        String dateString2 = scanner.nextLine();
        Date newDate2 = new SimpleDateFormat("dd/MM/yyyy").parse(dateString2);

        ArrayList<Booking> bookings = new ArrayList<>();
        Customer customer = new Customer(ssn,name,gender,newDate1,newDate2,bookings);
        customer.makeBooking();
        customers.add(customer);
        System.out.println("New customer is added!");

    }

    public int searchCustomer(int ssn){
        for (int i = 0; i < customers.size(); i++){
            if(ssn == customers.get(i).getSsn()){
                return i;
            }
        }
        return -1;
    }

    public void deleteCustomer(int ssn){
        int index = searchCustomer(ssn);
        if(index == -1){
            System.out.println("There is no customer with that ssn!");
        }
        else{
            customers.remove(index);
            System.out.println("Customer is removed");
        }
    }

    public void receiveBooking(int ssn) throws ParseException {
        int index = searchCustomer(ssn);
        if(index == -1){
            System.out.printf("There is no such customer!");
        }
        else{
            Customer customer = customers.get(index);
            customer.makeBooking();
        }
    }

    public int searchBooking(Customer customer, Date bookingDate){
        for(int i = 0; i < customer.getBookings().size(); i++){
            if(customer.getBookings().get(i).getBookingDate().equals(bookingDate)){
                return i;
            }
        }
        return -1;
    }

    public void receiveOrder(int ssn, Date bookingDate){
        int index = searchCustomer(ssn);
        if(index == -1){
            System.out.println("There is no such customer!");
        }
        else{
            Customer customer = customers.get(index);
            index = searchBooking(customer,bookingDate);
            if(index != -1){
                Booking booking = customer.getBookings().get(index);
                booking.makeOrder();
            }
            else {
                System.out.println("There is no such booking!");
            }
        }
    }

    public void getCustomerDetails(int ssn){
        int index = searchCustomer(ssn);
        if(index == -1){
            System.out.println("There is no such customer!");
        }
        else{
            Customer customer = customers.get(index);
            System.out.println("Customer ssn: " + customer.getSsn() + "\t|| Customer name: " + customer.getName()
                    + "\t|| Customer gender: " + customer.getGender() + "\t|| Customer date of birth : " + customer.getDateOfBirth()
                    + "\t|| Customer registration date: " + customer.getRegistrationDate());
        }
    }

    public void getCustomerBookings(int ssn){
        int index = searchCustomer(ssn);
        if(index == -1){
            System.out.println("There is no such customer!");
        }
        else{
            Customer customer = customers.get(index);
            ArrayList<Booking> bookings = customer.getBookings();
            for(Booking booking: bookings){
                System.out.println("Booking Date: " + booking.getBookingDate() + "\t|| Booking table: " + booking.getBookingTable());
            }
        }
    }

    public void getCustomerOrders(int ssn, Date bookingDate){
        int index = searchCustomer(ssn);
        if(index == -1){
            System.out.println("There is no such customer!");
        }
        else{
            Customer customer = customers.get(index);
            index = searchBooking(customer,bookingDate);
            if(index == -1){
                System.out.println("There is no booking for this customer!");
            }
            else{
                Booking booking = customer.getBookings().get(index);
                ArrayList<Order> orders = booking.getOrders();
                for(Order order: orders){
                    System.out.println("Order details: " + order.getDetails() + "\t|| Order Description: " + order.getDescription());
                }
            }
        }
    }

    public void listCustomer(){
        for (Customer customer: customers){
            System.out.println("Customer ssn: " + customer.getSsn() + "\t|| Customer name: " + customer.getName()
                    + "\t|| Customer gender: " + customer.getGender() + "\t|| Customer date of birth : " + customer.getDateOfBirth()
                    + "\t|| Customer registration date: " + customer.getRegistrationDate());
        }
    }

    public void listStaff(){
        for (Staff staff: staffs){
            System.out.println("Staff ssn: " + staff.getSsn() + "\t|| Staff name: " + staff.getName()
                    + "\t|| Staff gender: " + staff.getGender() + "\t|| Staff date of birth : " + staff.getDateOfBirth());
        }
    }

    public void menu() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int ssn;
        int option;
        String dateString;
        Date newDate;
        printMenu();
        System.out.println("Enter menu option: ");
        option = Integer.parseInt(scanner.nextLine());
        System.out.println("Option is: " + option);
        while(true)
        {
            switch (option){
                case 1:
                    addStaff();
                    break;
                case 2:
                    System.out.println("Enter ssn:");
                    ssn = Integer.parseInt(scanner.nextLine());
                    deleteStaff(ssn);
                    break;
                case 3:
                    System.out.println("Enter ssn:");
                    ssn = Integer.parseInt(scanner.nextLine());
                    getStaffDetails(ssn);
                    break;
                case 4:
                    addCustomer();
                    break;
                case 5:
                    System.out.println("Enter ssn:");
                    ssn = Integer.parseInt(scanner.nextLine());
                    deleteCustomer(ssn);
                    break;
                case 6:
                    System.out.println("Enter ssn:");
                    ssn = Integer.parseInt(scanner.nextLine());
                    receiveBooking(ssn);
                    break;
                case 7:
                    System.out.println("Enter ssn:");
                    ssn = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter date dd/mm/yyyy");
                    dateString = scanner.nextLine();
                    newDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
                    receiveOrder(ssn, newDate);
                    break;
                case 8:
                    System.out.println("Enter ssn:");
                    ssn = Integer.parseInt(scanner.nextLine());
                    getCustomerDetails(ssn);
                    break;
                case 9:
                    System.out.println("Enter ssn:");
                    ssn = Integer.parseInt(scanner.nextLine());
                    getCustomerBookings(ssn);
                    break;
                case 10:
                    System.out.println("Enter ssn:");
                    ssn = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter date dd/mm/yyyy");
                    dateString = scanner.nextLine();
                    newDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
                    getCustomerOrders(ssn, newDate);
                    break;
                case 11:
                    listStaff();
                    break;
                case 12:
                    listCustomer();
                    break;
                case 13:
                    printMenu();
                    break;
                case 14:
                    System.out.println("Exiting!");
                    return;
                default:
                    System.out.println("Unknown option!");
                    break;
            }
            printMenu();
            System.out.println("!Enter menu option: ");
            option = Integer.parseInt(scanner.nextLine());
        }

    }

    public void printMenu(){
        System.out.println("1: Add Staff\n2: Delete Staff\n3: Get Staff Details" +
                "\n4: Add Customer\n5: Delete Customer\n6: Receive Booking" +
                "\n7: Receive Order\n8: Get Customer Details\n9: Get Customer Booking" +
                "\n10: Get Customer Order\n11: List Staff\n12: List Customer\n13: Print Menu\n14: Exit");
    }

}
