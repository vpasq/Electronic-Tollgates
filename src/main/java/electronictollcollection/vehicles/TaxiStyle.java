package electronictollcollection.vehicles;

import electronictollcollection.vehicles.Vehicle.Weight;

public class TaxiStyle extends VehicleStore {

  /**
   * Create a taxi vehicle.
   *
   * @return a taxi vehicle
   */
  public Vehicle createVehicle(int taxiStyle) {
    switch (taxiStyle) {
      case 1:
        return new Taxi("Taxi", " Crown Victoria", "1990", Weight.STANDARD);
      case 2:
        return new Taxi("Taxi", "Chevrolet Caprice ", "1995", Weight.STANDARD);
      case 3:
        return new Taxi("Taxi", "Checker Cab", "1907", Weight.STANDARD);
      case 4:
        return new Taxi("Taxi", "Toyota Prius", "2010", Weight.STANDARD);
      case 5:
        return new Taxi("Taxi", "Toyota Sienna", "2019", Weight.STANDARD);
      default:
        System.out.println(taxiStyle);
        throw new IllegalArgumentException("Invalid Random Value.");
    }
  }
}