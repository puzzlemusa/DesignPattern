import java.util.ArrayList;
import java.util.List;

abstract class AbstractObservable {
    abstract void attach(AbstractObserver observer);

}

class ConcreteObservable extends AbstractObservable{
    private String state;
    private List<AbstractObserver> observers = new ArrayList<>();

    public String getState(){
        return state;
    }

    public void notifyObserver(){
        for (AbstractObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    void attach(AbstractObserver observer) {
        observers.add(observer);
    }
}

abstract class AbstractObserver{
    abstract void update();
    AbstractObservable observable;
}

class MyApp extends AbstractObserver {
    public MyApp(AbstractObservable observable){
        this.observable = observable;
        this.observable.attach(this);
    }

    @Override
    void update() {
        System.out.println("Got notification at MyApp");
    }
}

class YourApp extends AbstractObserver {
    public YourApp(AbstractObservable observable){
        this.observable = observable;
        this.observable.attach(this);
    }

    @Override
    void update() {
        System.out.println("Got notification at YourApp");
    }
}

public class ObserverPattern {

    public static void main( String[] args ) {
        ConcreteObservable observable = new ConcreteObservable();
        MyApp myApp = new MyApp(observable);
        YourApp yourApp = new YourApp(observable);

        observable.notifyObserver();
    }
}
