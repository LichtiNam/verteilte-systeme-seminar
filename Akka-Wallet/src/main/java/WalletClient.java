import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import events.AddCentEvent;
import events.AddEuroEvent;
import events.AddMoneyEvent;
import events.RemoveMoneyEvent;

/**
 * Created by dennish on 15/05/15.
 */
public class WalletClient {

  public static void main(String[] args) {
    Config config = ConfigFactory.load().getConfig("ClientSys");

    ActorSystem system = ActorSystem.create("wallet", config);
    ActorRef server =
            system.actorFor("akka://wallet@127.0.0.1:2552/user/walletKeeper");
    server.tell(new AddEuroEvent(4), null);
    server.tell(new AddMoneyEvent(10, 80), null);
    server.tell(new RemoveMoneyEvent(8, 10), null);
    server.tell(new AddCentEvent(860), null);
  }
}
