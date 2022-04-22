package designpattern;

interface Vehicle {
    void move();
}

class Car implements Vehicle {
    @Override
    public void move() {
        System.out.println("Hoo~");
    }
}

class Bike implements Vehicle {
    @Override
    public void move() {
        System.out.println("Ling~");
    }
}

class VehicleFactory {
    public static Vehicle getInstance(String type) {
        if (type.equals("car")) {
            return new Car();
        }
        else if (type.equals("bike")) {
            return new Bike();
        }
        else {
            throw new RuntimeException("Not Supported type " + type);
        }
    }
}

public class Factory {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getInstance("car");
        Vehicle bike = VehicleFactory.getInstance("bike");
        car.move();
        bike.move();
    }
}
