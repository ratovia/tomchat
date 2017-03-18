import java.net.*;
import java.io.*;

public class Receiver implements Runnable{

  private BufferedReader input;
  private PrintWriter output;

  Receiver(Socket cs) {
    try {
      input = new BufferedReader(new InputStreamReader(cs.getInputStream()));
      output = new PrintWriter(cs.getOutputStream());
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  @Override
  public void run(){
    while(true){
      String message = null;
      try{
        message = input.readLine();
      }catch(IOException e){
        System.out.println(e);
      }
      System.out.println(message);
    }
  }
}