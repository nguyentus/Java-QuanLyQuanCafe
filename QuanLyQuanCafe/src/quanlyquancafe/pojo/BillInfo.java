package quanlyquancafe.pojo;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="billinfo")
public class BillInfo implements Serializable {
    @Id
    @Column(name="idBillInfo")
    private int idBillInfo;
    @Column(name="count", nullable = false)
    private int count;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOrderTable")
    private OrderTable orderTable;

    public BillInfo() {
    }
    
   
}
