package quanlyquancafe.pojo;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="bill")
public class Bill implements Serializable {
    @Id
    @Column(name="idBill")
    private int idBill;
    @Column(name="dateCheckIn", nullable = false)
    private String dateCheckIn;
    @Column(name="dateCheckOut", nullable = false)
    private String dateCheckOut;
    @Column(name="statusBill", length= 100, nullable = false)
    private String statusBill;
    @Column(name="discountBill", nullable = false)
    private int discountBill;
    @Column(name="totalPrices", nullable = false)
    private double totalPrices;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOrderTable")
    private OrderTable orderTable;

    public Bill() {
    }
    
    public Bill(int idBill, String dateCheckIn, String dateCheckOut, String statusBill, int discountBill, double totalPrices, OrderTable orderTable) {
        this.idBill = idBill;
        this.dateCheckIn = dateCheckIn;
        this.dateCheckOut = dateCheckOut;
        this.statusBill = statusBill;
        this.discountBill = discountBill;
        this.totalPrices = totalPrices;
        this.orderTable = orderTable;
    }

    public int getIdBill() {
        return idBill;
    }

    public String getDateCheckIn() {
        return dateCheckIn;
    }

    public String getDateCheckOut() {
        return dateCheckOut;
    }

    public String getStatusBill() {
        return statusBill;
    }

    public int getDiscountBill() {
        return discountBill;
    }

    public double getTotalPrices() {
        return totalPrices;
    }

    public OrderTable getOrderTable() {
        return orderTable;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public void setDateCheckIn(String dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public void setDateCheckOut(String dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public void setStatusBill(String statusBill) {
        this.statusBill = statusBill;
    }

    public void setDiscountBill(int discountBill) {
        this.discountBill = discountBill;
    }

    public void setTotalPrices(double totalPrices) {
        this.totalPrices = totalPrices;
    }

    public void setOrderTable(OrderTable orderTable) {
        this.orderTable = orderTable;
    }
    
    
}
