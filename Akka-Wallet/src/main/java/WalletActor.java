import akka.actor.UntypedActor;
import events.*;

/**
 * Created by dennish on 15/05/15.
 */
public class WalletActor extends UntypedActor {

  private Wallet wallet;

  public WalletActor() {
    this.wallet = new Wallet();
  }

  @Override
  public void onReceive(Object messages) throws Exception {
    MoneyEvent moneyEvent = (MoneyEvent) messages;
    if (messages instanceof AddMoneyEvent) {
      messageToConsole();
      wallet.addMoney(moneyEvent.getEuro(), moneyEvent.getCent());
      messageToConsole();
    }
    if (messages instanceof RemoveMoneyEvent) {
      messageToConsole();
      wallet.removeMoney(moneyEvent.getEuro(), moneyEvent.getCent());
      messageToConsole();
    }
    if (messages instanceof AddEuroEvent) {
      messageToConsole();
      wallet.addEuro(moneyEvent.getEuro());
      messageToConsole();
    }
    if (messages instanceof RemoveEuroEvent) {
      messageToConsole();
      wallet.removeEuro(moneyEvent.getEuro());
      messageToConsole();
    }
    if (messages instanceof AddCentEvent) {
      messageToConsole();
      wallet.addCent(moneyEvent.getCent());
      messageToConsole();
    }
    if (messages instanceof RemoveCentEvent) {
      messageToConsole();
      wallet.removeCent(moneyEvent.getCent());
      messageToConsole();
    }
  }

  private void messageToConsole() {
    System.out.printf("%s %10d,%02d Euro\n", "Money amount", wallet.getEuro(), wallet.getCent());
  }
}
