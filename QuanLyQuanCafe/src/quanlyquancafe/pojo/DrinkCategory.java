package quanlyquancafe.pojo;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="drinkcategory")
public class DrinkCategory implements Serializable {
    @Id
    @Column(name="idDrinkCategory")
    private int idDrinkCategory;
    @Column(name="nameDrinkCategory")
    private String nameDrinkCategory;

    public DrinkCategory() {
    }
    public DrinkCategory(int idDrinkCategory, String nameDrinkCategory) {
        this.idDrinkCategory = idDrinkCategory;
        this.nameDrinkCategory = nameDrinkCategory;
    }

    public void setIdDrinkCategory(int idDrinkCategory) {
        this.idDrinkCategory = idDrinkCategory;
    }

    public void setNameDrinkCategory(String nameDrinkCategory) {
        this.nameDrinkCategory = nameDrinkCategory;
    }

    public int getIdDrinkCategory() {
        return idDrinkCategory;
    }

    public String getNameDrinkCategory() {
        return nameDrinkCategory;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.idDrinkCategory); 
    }
    
}
