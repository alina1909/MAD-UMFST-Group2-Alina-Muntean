class Car {
    int speed;
    double regularPrice;
    String color;

    public Car(int speed, double regularPrice, String color) {
        this.speed = speed;
        this.regularPrice = regularPrice;
        this.color = color;
    }

    public double getSalePrice() {
        return regularPrice;
    }
}


class Truck extends Car {
    int weight;

    public Truck(int speed, double regularPrice, String color, int weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }


    @Override
    public double getSalePrice() {
        if (weight > 2000) {
            return regularPrice * 0.9;
        } else {
            return regularPrice * 0.8;
        }
    }
}


class Ford extends Car {
    int year;
    int manufacturerDiscount;

    public Ford(int speed, double regularPrice, String color, int year, int manufacturerDiscount) {
        super(speed, regularPrice, color);
        this.year = year;
        this.manufacturerDiscount = manufacturerDiscount;
    }

    @Override
    public double getSalePrice() {
        return regularPrice - manufacturerDiscount;
    }
}


class Sedan extends Car {
    int length;

    public Sedan(int speed, double regularPrice, String color, int length) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    @Override
    public double getSalePrice() {
        if (length > 20) {
            return regularPrice * 0.95;
        } else {
            return regularPrice * 0.9;
        }
    }
}


public class MyAutoShop {
    public static void main(String[] args) {
        Sedan sedan = new Sedan(90, 29500, "Blue", 21);
        Ford ford15 = new Ford(200, 69000, "Red", 2023, 4000);
        Ford ford4 = new Ford(100, 19990.99, "White", 2010, 2000);
        Car car = new Car(120, 25000, "Black");

        System.out.println("Sale Price for sedan: $" + sedan.getSalePrice());
        System.out.println("Sale Price for ford15: $" + ford15.getSalePrice());
        System.out.println("Sale Price for ford4: $" + ford4.getSalePrice());
        System.out.println("Sale Price for car: $" + car.getSalePrice());
    }
}
