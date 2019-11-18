package quanlyquancafe.pojo;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="account")
public class Account implements Serializable {
    @Id
    @Column(name="idAccount")
    private String idAccount;
    @Column(name="password", length = 200, nullable = false)
    private String password;
    @Column(name="displayName", length = 100, nullable = false)
    private String displayName;
    @Column(name="type", nullable = false)
    private int type;
    public Account() {
        
    }
    public Account(String idAccount, String password, String displayName, int type) {
        this.idAccount = idAccount;
        this.password = password;
        this.displayName = displayName;
        this.type = type;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getType() {
        return type;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setType(int type) {
        this.type = type;
    }
}
