package electronictollcollection.vehicles;

import electronictollcollection.vehicles.Vehicle.Weight;

public class CarWithTrailerStyle extends VehicleStore {

  /**
   * Create a car with trailer vehicle.
   *
   * @return a car with trailer vehicle
   */
  public Vehicle createVehicle(int carWithTrailerStyle) {
    switch (carWithTrailerStyle) {
      case 1:
        return new CarWithTrailer("Car With Trailer", "Toyato Camry", "2019", Weight.STANDARD);
      case 2:
        return new CarWithTrailer("Car With Trailer", "Mazda Grand Touring", "2011",
            Weight.STANDARD);
      case 3:
        return new CarWithTrailer("Car With Trailer", "Mercury Sable GS", "2003", Weight.STANDARD);
      case 4:
        return new CarWithTrailer("Car With Trailer", "Volvo S60", "2012", Weight.STANDARD);
      case 5:
        return new CarWithTrailer("Car With Trailer", "Honda Civic", "2015", Weight.STANDARD);
      default:
        System.out.println(carWithTrailerStyle);
        throw new IllegalArgumentException("Invalid Random Value.");
    }
  }
}

