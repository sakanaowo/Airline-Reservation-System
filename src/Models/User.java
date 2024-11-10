package Models;
// chưa xong
import java.util.ArrayList;
import java.util.List;

public class User {
    private String account, password;
    private Passenger passenger;
    private List<Ticket> tickets;

    public User() {
        this.tickets = new ArrayList<>();
    }

    public User(String account, String password, Passenger passenger, List<Ticket> tickets) {
        this.account = account;
        this.password = password;
        this.passenger = passenger;
        this.tickets = (tickets != null ? tickets : new ArrayList<>());
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    // kiểm tra mật khẩu
    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    // Phương thức thêm vé vào danh sách tickets
    public void addTicket(Ticket ticket) {
        if (tickets == null) {
            tickets = new ArrayList<>();  // Khởi tạo nếu chưa có danh sách
        }
        this.tickets.add(ticket);
        System.out.println("Ticket added for user: " + account);
    }

    // Phương thức xóa vé khỏi danh sách tickets (chỉ xóa vé chưa bị hủy)
    public boolean removeTicket(Ticket ticket) {
        if (ticket.isCancelled()) {
            System.out.println("Cannot remove a canceled ticket: " + ticket.getTicketID());
            return false;
        }
        if (tickets != null && tickets.remove(ticket)) {
            System.out.println("Ticket removed from list: " + ticket.getTicketID());
            return true;
        } else {
            System.out.println("Ticket not found in list: " + ticket.getTicketID());
            return false;
        }
    }

    // Phương thức hủy một vé
    public boolean cancelTicket(Ticket ticket) {
        if (tickets.contains(ticket)) {
            ticket.cancelTicket();
            System.out.println("Ticket canceled for user: " + account);
            return true;
        } else {
            System.out.println("Ticket not found for user: " + account);
            return false;
        }
    }

    // Hiển thị danh sách tickets và trạng thái của chúng (active/canceled)
    public void showTickets() {
        if (tickets == null || tickets.isEmpty()) {
            System.out.println("No tickets found for user: " + account);
        } else {
            System.out.println("Tickets for user: " + account);
            for (Ticket ticket : tickets) {
                System.out.println(ticket + " - Status: " + (ticket.isCancelled() ? "Cancelled" : "Active"));
            }
        }
    }

    // Không hiển thị mật khẩu trong toString vì lý do bảo mật
    @Override
    public String toString() {
        return "User [account=" + account + ", passenger=" + passenger.getName() + "]";
    }

    public String getAccount() {
        return account;
    }
}
