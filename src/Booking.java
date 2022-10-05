import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking {
    private Date bookingDate;
    private int bookingTable;
    private ArrayList<Order> orders;

    public Booking(Date bookingDate, int bookingTable, ArrayList<Order> orders) {
        this.bookingDate = bookingDate;
        this.bookingTable = bookingTable;
        this.orders = orders;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getBookingTable() {
        return bookingTable;
    }

    public void setBookingTable(int bookingTable) {
        this.bookingTable = bookingTable;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void makeOrder(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter Order details:");
        String orderDetail = scanner.nextLine();

        System.out.println("Please enter Order description:");
        String orderDescription = scanner.nextLine();

        Order newOrder = new Order(orderDetail, orderDescription);
        orders.add(newOrder);
        System.out.println("Order is added successfully!");
    }

}
