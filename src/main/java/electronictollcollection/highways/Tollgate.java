package electronictollcollection.highways;

public class Tollgate {
  private Highway highway;
  private int marker;

  /**
   * Construct a tollgate.
   *
   * @param highway the highway to add tollgates
   * @param marker the tollgate position on this highway
   */
  public Tollgate(Highway highway, int marker) {
    this.highway = highway;
    this.marker = marker;
  }

  /**
   * Accessor method for this tollgate's highway.
   *
   * @return this tollgate's highway
   */
  public Highway getHighway() {
    return highway;
  }

  /**
   * Accessor method for this tollgate's location.
   *
   * @return this tollgate's location
   */
  public int getMarker() {
    return marker;
  }

  /**
   * Format this object's state for display.
   *
   * @return a formatted string for this objects state
   */
  @Override
  public String toString() {
    return  String.format("%n%-16s %s",
        "Toll Marker:", getMarker());
  }
}
