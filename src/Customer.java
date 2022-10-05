import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Customer {
    private int ssn;
    private String name;
    private char gender;
    private Date dateOfBirth;
    private Date registrationDate;
    private ArrayList<Booking> bookings;


    public Customer(int ssn, String name, char gender, Date dateOfBirth, Date registrationDate, ArrayList<Booking> bookings) {
        this.ssn = ssn;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
        this.bookings = bookings;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public void makeBooking() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter booking date in dd/mm/yyyy: ");
        String dateString = scanner.nextLine();
        Date newDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);

        System.out.println("Enter table id: ");
        int newTableId = Integer.parseInt(scanner.nextLine());

        System.out.println("How many orders there will be: ");
        int numberOfOrders = Integer.parseInt(scanner.nextLine());

        ArrayList<Order> orders = new ArrayList<>();

        Booking newBooking = new Booking(newDate, newTableId, orders);

        for(int i = 0 ; i < numberOfOrders; i++){
            newBooking.makeOrder();
        }
        bookings.add(newBooking);
    }
}
