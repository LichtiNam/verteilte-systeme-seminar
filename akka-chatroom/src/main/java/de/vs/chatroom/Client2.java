package de.vs.chatroom;

import de.vs.chatroom.System.Client;
import de.vs.chatroom.common.ClientConfig;

/**
 * Sample client starter.
 *
 * Created by goerickm on 06.05.15.
 */
public class Client2 {

  public static void main(String[] args) {
    String configName = "ClientSys2";
    ClientConfig clientConfig = new ClientConfig("Test2", configName, "127.0.0.1", 2552, "serverActor", "Chatroom");
    new Client(clientConfig);
  }
}
