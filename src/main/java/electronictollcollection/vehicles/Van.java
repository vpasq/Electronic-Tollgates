package electronictollcollection.vehicles;

public class Van extends Vehicle {

  /**
   * Construct a Van.
   *
   * @param type the type of this van
   * @param year the year of manufacture of this van
   * @param weight the weight of this van
   */
  public Van(String type, String model, String year, Weight weight) {
    super(type, model, year, weight, 1.5 * Vehicle.getBasePrice());
  }
}