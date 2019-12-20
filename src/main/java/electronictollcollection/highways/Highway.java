package electronictollcollection.highways;

import java.util.ArrayList;
import java.util.List;


public class Highway {

  private String name;
  private Location location;
  private int distance;
  private boolean twoWay;

  private List<Tollgate> tollgates;

  /**
   * Construct a highway.
   *
   * @param name the name of the highway
   * @param distance the highway distance
   * @param location the location of the highway
   * @param twoWay true if highway has two-way traffic, false otherwise
   */
  public Highway(String name, int distance, Location location, boolean twoWay) {
    tollgates = new ArrayList<>();
    this.name = name;
    this.location = location;
    this.distance = distance;
    this.twoWay = twoWay;
  }

  /**
   * Modifier method for setting s tollgate.
   *
   * @postcondition a tollgate was added to this highway's tollgates list
   */
  public void setTollgates() {
    int markerDistance = distance / 10;
    int tollMarker = markerDistance;
    while (tollMarker <= distance) {
      Tollgate tollgate = new Tollgate(this, tollMarker);
      tollgates.add(tollgate);
      tollMarker += markerDistance;
    }
  }

  /**
   * Accessor method for name of this highway.
   *
   * @return name of this highway
   */
  public String getName() {
    return name;
  }

  /**
   * Accessor method for location of this highway.
   *
   * @return location of this highway
   */
  public Location getLocation() {
    return location;
  }

  /**
   * Accessor method for this highway's distance.
   *
   * @return this highway's distance
   */
  public int getDistance() {
    return distance;
  }

  /**
   * Accessor method for this highway's tollgates.
   *
   * @return this highway's tollgates
   */
  public List<Tollgate> getTollgates() {
    return tollgates;
  }

  /**
   * Accessor method to check if this highway has two-way traffic.
   *
   * @return true if this highway has two-way traffic, false otherwise
   */
  public boolean isTwoWay() {
    return twoWay;
  }

  /**
   * Format this object's state for display.
   *
   * @return a formatted string for this objects state
   */
  @Override
  public String toString() {
    String str = String.format("%n%-16s %s%n%-16s %s%n%-16s %s%n%-16s %s",
        "Highway Name:", getName(),
        "Distance:", getDistance() + " miles",
        "Location node1:", getLocation().getNode1(),
        "Location node2:", getLocation().getNode2());

    for (Tollgate tollgate : tollgates) {
      str = str.concat(tollgate.toString());
    }
    return str;
  }
}
