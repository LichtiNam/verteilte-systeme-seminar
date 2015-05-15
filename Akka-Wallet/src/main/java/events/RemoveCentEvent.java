package events;

/**
 * Created by dennish on 15/05/15.
 */
public class RemoveCentEvent extends MoneyEvent{

  public RemoveCentEvent(int cent) {
    super(0, cent);
  }
}
