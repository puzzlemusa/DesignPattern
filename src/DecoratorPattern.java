interface Dish{
    float price();
}

abstract class PastaWrapper implements Dish {

    private Dish dish;

    public PastaWrapper(Dish dish){
        this.dish = dish;
    }

    public float price(){
        return dish.price();
    }
}

class Spaghetti implements Dish {
    private float standaloneCost = 4;

    public float price(){
        return this.standaloneCost;
    }
}

class Penne implements Dish {
    private float standaloneCost = 4.3f;

    public float price(){
        return this.standaloneCost;
    }
}

class TomatoSauce extends PastaWrapper{
    private float standaloneCost = 1;

    public TomatoSauce(Dish dish) {
        super(dish);
    }

    public float price(){
        return super.price() + this.standaloneCost;
    }
}

class BologneseSauce extends PastaWrapper{
    private float standaloneCost = 3;

    public BologneseSauce(Dish dish) {
        super(dish);
    }

    public float price(){
        return super.price() + this.standaloneCost;
    }
}

class GorgonzolaSauce extends PastaWrapper{
    private float standaloneCost = 2.5f;

    public GorgonzolaSauce(Dish dish) {
        super(dish);
    }

    public float price(){
        return super.price() + this.standaloneCost;
    }
}

class Spice extends PastaWrapper{
    private float standaloneCost = .5f;

    public Spice(Dish dish) {
        super(dish);
    }

    public float price(){
        return super.price() + this.standaloneCost;
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        BologneseSauce a = new BologneseSauce(new Spice(new Spaghetti()));
        System.out.println(a.price());
    }
}
