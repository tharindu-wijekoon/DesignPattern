class Engine {
    private final Integer capacity;
    private final String manufacturer;
    private final Integer year;

    public Engine(Integer capacity, String manufacturer, Integer year) {
        this.capacity = capacity;
        this.manufacturer = manufacturer;
        this.year = year;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Integer getYear() {
        return year;
    }
}

class Tyre {
    private final Integer width;
    private final Integer aspectRatio;
    private final Integer diameter;
    private final String manufacturer;

    public Tyre(Integer width, Integer aspectRatio, Integer diameter, String manufacturer) {
        this.width = width;
        this.aspectRatio = aspectRatio;
        this.diameter = diameter;
        this.manufacturer = manufacturer;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getAspectRatio() {
        return aspectRatio;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}

class Body {
    private final String manufacturer;
    private final String model;
    private final Integer year;
    private final String chasisNo;

    public Body(String manufacturer, String model, Integer year, String chasisNo) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.chasisNo = chasisNo;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public String getChasisNo() {
        return chasisNo;
    }
}

class Interior {
    private final String type;
    private final String primaryColour;
    private final String secondaryColour;

    public Interior(String type, String primaryColour, String secondaryColour) {
        this.type = type;
        this.primaryColour = primaryColour;
        this.secondaryColour = secondaryColour;
    }

    public String getType() {
        return type;
    }

    public String getPrimaryColour() {
        return primaryColour;
    }

    public String getSecondaryColour() {
        return secondaryColour;
    }
}

interface CarDesigner {
    public void setEngine(Engine engine);
    public void setBody(Body body);
    public void setFtyre(Tyre tyre);
    public void setRtyre(Tyre tyre);
    public void setInterior(Interior interior);
}

class CarB implements CarDesigner {
    private Engine engine;
    private Body body;
    private Tyre ftyre;
    private Tyre rtyre;
    private Interior interior;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public void setFtyre(Tyre tyre) {
        this.ftyre = tyre;
    }

    public void setRtyre(Tyre tyre) {
        this.rtyre = tyre;
    }

    public void setInterior(Interior interior) {
        this.interior = interior;
    }

    public Engine getEngine() {
        return engine;
    }

    public Body getBody() {
        return body;
    }

    public Tyre getFtyre() {
        return ftyre;
    }

    public Tyre getRtyre() {
        return rtyre;
    }

    public Interior getInterior() {
        return interior;
    }
}

interface CarAssembler {
    public void assembleEngine();
    public void assembleBody();
    public void assembleFTyre();
    public void assembleRTyre();
    public void assembleInterior();
    public CarB returnCar();
}

class LamborghiniAventadorAssembler implements CarAssembler {
    private CarB aventador;

    public LamborghiniAventadorAssembler() {
        this.aventador = new CarB();
    }

    public void assembleEngine() {
        aventador.setEngine(new Engine(6498,"Lamborghini", 2011));
        System.out.println("Engine Capacity : " + aventador.getEngine().getCapacity() +
                " | Year : " + aventador.getEngine().getYear());
    }

    public void assembleBody() {
        aventador.setBody(new Body("Lamborghini", "LP 700-4", 2011, "LP700HJ734"));
        System.out.println("Chasis Number : " + aventador.getBody().getChasisNo()
                + " | Year : " + aventador.getBody().getYear());
    }

    public void assembleFTyre() {
        aventador.setFtyre(new Tyre(255, 35, 19, "Pirelli"));
        System.out.println("Front Tyres : " + aventador.getFtyre().getManufacturer() + " "
                + aventador.getFtyre().getWidth() + "/" + aventador.getFtyre().getAspectRatio() + "ZR"
                + aventador.getFtyre().getDiameter() + " XL");
    }

    public void assembleRTyre() {
        aventador.setRtyre(new Tyre(355, 30, 20, "Pirelli"));
        System.out.println("Rear Tyres : " + aventador.getRtyre().getManufacturer() + " "
                + aventador.getRtyre().getWidth() + "/" + aventador.getRtyre().getAspectRatio() + "ZR"
                + aventador.getRtyre().getDiameter() + " XL");
    }

    public void assembleInterior() {
        aventador.setInterior(new Interior("Sport", "Black", "White"));
        System.out.println(aventador.getInterior().getType() + " interior with primary colour as "
                + aventador.getInterior().getPrimaryColour() + " and secondary colour as "
                + aventador.getInterior().getSecondaryColour() + ".");
    }

    public CarB returnCar() {
        System.out.println(aventador.getBody().getManufacturer() + " Aventador "
                + aventador.getBody().getModel() + " assembled.");
        return aventador;
    }
}

class FerrariStradaleAssembler implements CarAssembler {
    private CarB stradale;

    public FerrariStradaleAssembler() {
        this.stradale = new CarB();
    }

    public void assembleEngine() {
        stradale.setEngine(new Engine(3990, "Ferrari", 2020));
        System.out.println("Engine Capacity : " + stradale.getEngine().getCapacity() +
                " | Year : " + stradale.getEngine().getYear());
    }

    public void assembleBody() {
        stradale.setBody(new Body("Ferrari", "SF90", 2021, "SF90LEW301"));
        System.out.println("Chasis Number : " + stradale.getBody().getChasisNo()
                + " | Year : " + stradale.getBody().getYear());
    }

    public void assembleFTyre() {
        stradale.setFtyre(new Tyre(255, 35, 20, "Michelin"));
        System.out.println("Front Tyres : " + stradale.getFtyre().getManufacturer() + " "
                + stradale.getFtyre().getWidth() + "/" + stradale.getFtyre().getAspectRatio() + "ZR"
                + stradale.getFtyre().getDiameter() + " XL");
    }

    public void assembleRTyre() {
        stradale.setRtyre(new Tyre(315, 30, 20, "Michelin"));
        System.out.println("Rear Tyres : " + stradale.getRtyre().getManufacturer() + " "
                + stradale.getRtyre().getWidth() + "/" + stradale.getRtyre().getAspectRatio() + "ZR"
                + stradale.getRtyre().getDiameter() + " XL");
    }

    public void assembleInterior() {
        stradale.setInterior(new Interior("sport", "Beige", "White"));
        System.out.println(stradale.getInterior().getType() + " interior with primary colour as "
                + stradale.getInterior().getPrimaryColour() + " and secondary colour as "
                + stradale.getInterior().getSecondaryColour() + ".");
    }

    public CarB returnCar() {
        System.out.println(stradale.getBody().getManufacturer() + " Stradale "
                + stradale.getBody().getModel() + " assembled.");
        return stradale;
    }
}

class AutomobileEngineer {
    private CarAssembler carAssembler;

    public AutomobileEngineer(CarAssembler carAssembler) {
        this.carAssembler = carAssembler;
    }

    public CarB assembleCar() {
        return this.carAssembler.returnCar();
    }

    public void define_car() {
        this.carAssembler.assembleEngine();
        this.carAssembler.assembleBody();
        this.carAssembler.assembleFTyre();
        this.carAssembler.assembleRTyre();
        this.carAssembler.assembleInterior();
    }
}
public class Builder {
    public static void main(String[] args) {
        CarAssembler lamborghini = new LamborghiniAventadorAssembler();
        CarAssembler ferrari = new FerrariStradaleAssembler();

        AutomobileEngineer me = new AutomobileEngineer(lamborghini);
        AutomobileEngineer she = new AutomobileEngineer(ferrari);

        me.define_car();
        me.assembleCar();
        System.out.println();

        she.define_car();
        she.assembleCar();
    }
}
