package electronictollcollection.vehicles;


public abstract class VehicleStore {

  /**
   * Order a vehicle.
   *
   * @return a vehicle
   */
  public Vehicle orderVehicle(int randomStyle) {
     return createVehicle(randomStyle);
  }


  /**
   * Create a vehicle.
   *
   * @return a vehicle
   */
  public abstract Vehicle createVehicle(int randomStyle);
}
