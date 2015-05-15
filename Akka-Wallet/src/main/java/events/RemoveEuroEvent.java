package events;

/**
 * Created by dennish on 15/05/15.
 */
public class RemoveEuroEvent extends MoneyEvent {

  public RemoveEuroEvent(int euro) {
    super(euro, 0);
  }
}
