package electronictollcollection.vehicles;

public class Truck extends Vehicle {

  /**
   * Construct a Truck.
   *
   * @param type the type of this van
   * @param year the year of manufacture of this van
   * @param weight the weight of this van
   */
  public Truck(String type, String model, String year, Weight weight, double weightInTons) {
    super(type, model, year, weight, (2 * Vehicle.getBasePrice()
        + weightInTons * Vehicle.getBasePrice()));
  }
}