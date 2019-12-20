package electronictollcollection.vehicles;

public class Taxi extends Vehicle {

  /**
   * Construct a taxi.
   *
   * @param type the type of this car
   * @param year the year of manufacture of this car
   * @param weight the weight of this car
   */
  public Taxi(String type, String model, String year, Weight weight) {
    super(type, model, year, weight, 0.5 * Vehicle.getBasePrice());
  }

}
