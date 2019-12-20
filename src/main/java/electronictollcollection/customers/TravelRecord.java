package electronictollcollection.customers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TravelRecord {

  private List<Date> timestamps;

  /**
   * Construct a TravelRecord.
   */
  public TravelRecord() {
    this.timestamps = new ArrayList<>();
  }

  /**
   * Accessor method for list of timestamps.
   *
   * @return current list of timestamps
   */
  public List<Date> getTimestamps() {
    return timestamps;
  }

  /**
   * Modifier method to add a timestamp to timestamps list.
   *
   * @postcondition a timestamp was added to this timestamp's list
   */
  public void setTimestamp(Date timestamp) {
    timestamps.add(timestamp);
  }


}
