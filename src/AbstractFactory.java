class Cupboard{
    void draw(){

    }
}

class Sink{
    void draw(){

    }
}

class FarmhouseCupboard extends Cupboard{

    @Override
    public void draw() {
    }
}

class IndustrialCupboard extends Cupboard{

    @Override
    public void draw() {
    }
}

class FarmhouseSink extends Sink{

    @Override
    public void draw() {
    }
}

class IndustrialSink extends Sink{

    @Override
    public void draw() {
    }
}

interface KitchenPartFactory{
    Cupboard createCupboard();
    Sink createSink();
}

class FarmhouseKitchenPartFactory implements KitchenPartFactory{

    @Override
    public Cupboard createCupboard() {
        return new FarmhouseCupboard();
    }

    @Override
    public Sink createSink() {
        return new FarmhouseSink();
    }
}

class IndustrialKitchenPartFactory implements KitchenPartFactory{

    @Override
    public Cupboard createCupboard() {
        return new IndustrialCupboard();
    }

    @Override
    public Sink createSink() {
        return new IndustrialSink();
    }
}

public class AbstractFactory {
    public static void main( String[] args ) {
        String  choice = "";
        KitchenPartFactory factory;
        switch (choice) {
            case "Farmhouse":
                factory = new FarmhouseKitchenPartFactory();
                break;

            case "Industrial":
                factory = new IndustrialKitchenPartFactory();
                break;
        }
    }
}
