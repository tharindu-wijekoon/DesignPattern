abstract class Pizza {
    protected Style style;
    protected String size;
    protected Pizza(Style style, String size) {
        this.style = style;
        this.size = size;
    }
    abstract public void make();
}
interface Style {
    abstract public void cook(String size);
}
class Italian implements Style {
    @Override
    public void cook(String size) {
        System.out.println("Cooking Italian " + size + " Pizza.");
    }
}
class Mongolian implements Style {
    @Override
    public void cook(String size) {
        System.out.println("Cooking Mongolian " + size + " Pizza.");
    }
}
class ChickenP extends Pizza {
    public ChickenP(Style style, String size) {
        super(style, size);
    }
    @Override
    public void make() {
        System.out.println("Chicken " + size + " Pizza.");
        style.cook(size);
    }
}
class VegetableP extends Pizza {
    public VegetableP(Style style, String size) {
        super(style, size);
    }
    @Override
    public void make() {
        System.out.println("Vegetable " + size + " Pizza.");
        style.cook(size);
    }
}
public class PizzaShop {
    public static void main(String[] args) {
        Pizza pizza1 = new ChickenP(new Italian(), "Large");
        pizza1.make();
    }
}