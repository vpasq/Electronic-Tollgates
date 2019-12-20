package electronictollcollection.highways;

public class Location {
  private int node1;
  private int node2;

  /**
   * Construct a location.
   *
   * @param node1 a location point
   * @param node2 a location point
   */
  public Location(int node1, int node2) {
    this.node1 = node1;
    this.node2 = node2;
  }

  /**
   * Accessor method for location point.
   *
   * @return location point, node1
   */
  public int getNode1() {
    return node1;
  }

  /**
   * Accessor method for location point.
   *
   * @return location point, node2
   */
  public int getNode2() {
    return node2;
  }
}
