import java.net.*;
import java.io.*;
class TomchatClient {

  BufferedReader buffer;
  PrintWriter output;

  TomchatClient(){
    buffer = new BufferedReader(new InputStreamReader(System.in));
  }

  public void start(){
    Socket cs = null;
    try{
      cs = new Socket("localhotst",9999);
    }catch(UnknownHostException e){
      System.out.println(e);
    }catch(IOException e){
      System.out.println(e);
    }

    Runnable runnable = new Receiver(cs);
    new Thread(runnable).start();

    while(true){
      try{
        String line = buffer.readLine();
        output = new PrintWriter(cs.getOutputStream());
        output.println(line);
        output.flush();
      }catch(IOException e){
        System.out.println(e);
      }
    }
  }

  public static void main(String args[]){
    System.out.println("start tomchat");
    TomchatClient client = new TomchatClient();
    client.start();
  }
}