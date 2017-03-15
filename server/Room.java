import java.util.ArrayList;

public class Room {
  private String name;
  private ArrayList<ClientThread> clients;

  public Room(String name){
    this.name = name;
    clients = new ArrayList<ClientThread>();
  }

  public void connect(ClientThread th){
    clients.add(th);
  }

  public void leave(){

  }

  public void close(){

  }

  public void messageBroadcast(String message){
    for(ClientThread th : clients){
      th.output.println(message);
      th.output.flush();
    }
  }
}