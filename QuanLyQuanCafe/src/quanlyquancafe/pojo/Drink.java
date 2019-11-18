package quanlyquancafe.pojo;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="drink")
public class Drink implements Serializable {
    @Id
    @Column(name="idDrink")
    private int idDrink;
    @Column(name="nameDrink", length = 100, nullable = false)
    private String nameDrink;
    @Column(name="priceDrink", nullable = false)
    private double priceDrink;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDrinkCategory")
    private DrinkCategory drinkCategory;

    public Drink() {
    }

    public Drink(int idDrink, String nameDrink, double priceDrink, DrinkCategory drinkCategory) {
        this.idDrink = idDrink;
        this.nameDrink = nameDrink;
        this.priceDrink = priceDrink;
        this.drinkCategory = drinkCategory;
    }

    public int getIdDrink() {
        return idDrink;
    }

    public String getNameDrink() {
        return nameDrink;
    }

    public double getPriceDrink() {
        return priceDrink;
    }

    public DrinkCategory getDrinkCategory() {
        return drinkCategory;
    }

    public void setIdDrink(int idDrink) {
        this.idDrink = idDrink;
    }

    public void setNameDrink(String nameDrink) {
        this.nameDrink = nameDrink;
    }

    public void setPriceDrink(double priceDrink) {
        this.priceDrink = priceDrink;
    }

    public void setDrinkCategory(DrinkCategory drinkCategory) {
        this.drinkCategory = drinkCategory;
    }
    
}
