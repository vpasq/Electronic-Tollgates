package electronictollcollection.vehicles;

import electronictollcollection.vehicles.Vehicle.Weight;

public class CarStyle extends VehicleStore {

  /**
   * Create a car vehicle.
   *
   * @return a car vehicle
   */
  public Vehicle createVehicle(int carStyle) {
    switch (carStyle) {
      case 1:
        return new Car("Car", "Toyato Camry", "2019", Weight.STANDARD);
      case 2:
        return new Car("Car", "Mazda Grand Touring", "2011", Weight.STANDARD);
      case 3:
        return new Car("Car", "Mercury Sable GS", "2003", Weight.STANDARD);
      case 4:
        return new Car("Car", "Volvo S60", "2012", Weight.STANDARD);
      case 5:
        return new Car("Car", "Honda Civic", "2015", Weight.STANDARD);
      default:
        System.out.println(carStyle);
        throw new IllegalArgumentException("Invalid Random Value.");
    }
  }
}
