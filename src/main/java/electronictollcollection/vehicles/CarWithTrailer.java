package electronictollcollection.vehicles;

public class CarWithTrailer extends Vehicle {

  /**
   * Construct a car with a trailer.
   *
   * @param type the type of this van
   * @param year the year of manufacture of this van
   * @param weight the weight of this van
   */
  public CarWithTrailer(String type, String model, String year, Weight weight) {
    super(type, model, year, weight, 2 * Vehicle.getBasePrice());
  }
}