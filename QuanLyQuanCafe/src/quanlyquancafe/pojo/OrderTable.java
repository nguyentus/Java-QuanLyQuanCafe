package quanlyquancafe.pojo;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="ordertable")
public class OrderTable implements Serializable {
    @Id
    @Column(name="idOrderTable")
    private int idOrderTable;
    @Column(name="nameOrderTable", length = 100, nullable = false)
    private String nameOrderTable;
    @Column(name="statusOrderTable", length = 100, nullable = false)
    private double statusOrderTable;

    public OrderTable() {
    }
    public OrderTable(int idOrderTable, String nameOrderTable, double statusOrderTable) {
        this.idOrderTable = idOrderTable;
        this.nameOrderTable = nameOrderTable;
        this.statusOrderTable = statusOrderTable;
    }
    public int getIdOrderTable() {
        return idOrderTable;
    }

    public String getNameOrderTable() {
        return nameOrderTable;
    }

    public double getStatusOrderTable() {
        return statusOrderTable;
    }

    public void setIdOrderTable(int idOrderTable) {
        this.idOrderTable = idOrderTable;
    }

    public void setNameOrderTable(String nameOrderTable) {
        this.nameOrderTable = nameOrderTable;
    }

    public void setStatusOrderTable(double statusOrderTable) {
        this.statusOrderTable = statusOrderTable;
    }
    
}
