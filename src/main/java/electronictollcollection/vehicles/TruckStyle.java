package electronictollcollection.vehicles;

import electronictollcollection.vehicles.Vehicle.Weight;

public class TruckStyle extends VehicleStore {

  /**
   * Create a truck vehicle.
   *
   * @return a truck vehicle
   */
  public Vehicle createVehicle(int truckStyle) {
    switch (truckStyle) {
      case 1:
        return new Truck("Dump Truck", "Mack Granite", "2019", Weight.DYNAMIC, 2);
      case 2:
        return new Truck("Dump Truck", "Waste Management ", "2019", Weight.DYNAMIC, 4);
      case 3:
        return new Truck("Dump Truck", "Recycling Truck", "2019", Weight.DYNAMIC, 3);
      case 4:
        return new Truck("Dump Truck", "Western Star", "2019", Weight.DYNAMIC, 5);
      case 5:
        return new Truck("Dump Truck", "Kenworth", "2019", Weight.DYNAMIC, 6);
      default:
        System.out.println(truckStyle);
        throw new IllegalArgumentException("Invalid Random Value.");
    }
  }
}
