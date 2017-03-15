import java.net.*;
import java.io.*;

public class ClientThread implements Runnable{
  private BufferedReader input;
  private PrintWriter output;
  private Room room;

  ClientThread(Socket cs, Room room){
    this.room = room;
    room.connect(this);
    try{
      input = new BufferedReader(new InputStreamReader(cs.getInputStream()));
      output = new PrintWriter(cs.getOutputStream());
    }catch(IOException e){
      System.out.println(e);
    }
  }

  //@Override
  public void run(){
    while(true){
      String message = null;
      try{
        message = input.readLine();
        System.out.println(message);
      }catch(IOException e){
        System.out.println(e);
      }
      room.messageBroadcast(message);
    }
  }
}