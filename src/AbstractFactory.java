enum CarType {
    Sedan, Mini, Sport
}
class Car {
    private CarType model;
    private String manufacturer;
    public Car() {
        this.model = null;
        this.manufacturer = null;
    }
    public Car(CarType model, String manufacturer) {
        this.model = model;
        this.manufacturer = manufacturer;
    }
    public void setModel(CarType model) {
        this.model = model;
    }
    public void setManufacturer(String year) {
        this.manufacturer = year;
    }
    public String getModel() {
        return "model is " + model;
    }
    public String getManufacturer() {
        return manufacturer;
    }
}
interface SedanFactory {
    public Car order();
}
interface SportFactory {
    public Car order();
}
interface CarFactory {
    public SedanFactory createSedanFac();
    public SportFactory createSportFac();
}
class ToyotaSedan implements SedanFactory {
    @Override
    public Car order() {
        System.out.println("Ordering a new Toyota Sedan");
        return new Car(CarType.Sedan, "Toyota");
    }
}
class ToyotaSport implements SportFactory {
    @Override
    public Car order() {
        return new Car(CarType.Sport, "Toyota");
    }
}
class ToyotaFactory implements CarFactory {
    public SedanFactory createSedanFac() {
        System.out.println("Starting Toyota Sedan Factory.");
        return new ToyotaSedan();
    }
    public SportFactory createSportFac() {
        System.out.println("Starting Toyota Sport Factory.");
        return new ToyotaSport();
    }
}
public class AbstractFactory {
    private SedanFactory sedanf;
    private SportFactory sportf;
    private CarFactory carf;
    public AbstractFactory(CarFactory carf) {
        this.carf = carf;
        this.sedanf = carf.createSedanFac();
        this.sportf = carf.createSportFac();
    }
    public Car sedan() {
        return sedanf.order();
    }
    public Car sport() {
        return sportf.order();
    }

    public static void main(String[] args) {
        CarFactory cf = new ToyotaFactory();
        AbstractFactory af = new AbstractFactory(cf);

        Car premio = af.sedan();
    }
}
