package electronictollcollection.vehicles;

import electronictollcollection.vehicles.Vehicle.Weight;

public class VanStyle extends VehicleStore {

  /**
   * Create a van vehicle.
   *
   * @return a van vehicle
   */
  public Vehicle createVehicle(int vanStyle) {
    switch (vanStyle) {
      case 1:
        return new Van("Van", "Mercedes-Benz Sprinter", "2019", Weight.STANDARD);
      case 2:
        return new Van("Van", "RAM ProMaster", "2019", Weight.STANDARD);
      case 3:
        return new Van("Van", "Mercury Sable GS", "2019", Weight.STANDARD);
      case 4:
        return new Van("Van", "Chevrolet Express", "2019", Weight.STANDARD);
      case 5:
        return new Van("Van", "Nissan NV Cargo", "2019", Weight.STANDARD);
      default:
        System.out.println(vanStyle);
        throw new IllegalArgumentException("Invalid Random Value.");
    }
  }
}
