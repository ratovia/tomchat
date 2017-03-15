import java.net.*;
import java.io.*;

class TomchatServer {

  private Room room;

  TomchatServer(){
    room = new Room("defoult room");
  }

  private void start(){
    // サーバのソケットを用意
    ServerSocket ss = null;
    try{
      ss = new ServerSocket(9999);
    }catch(IOException e){
      System.out.println(e);
    }
    // accept()でクライアントを待機
    while(true){
      Socket cs = null;
      try{
        cs = ss.accept();
      }catch(IOException e){
        System.out.println(e);
      }
      // accept()でクライアントのスレッドを作る.
      Runnable runnable = new ClientThread(cs , room);
      new Thread(runnable).start();
    }
  }

  public static void main(String args[]){
    System.out.println("start tomchat");
    TomchatServer server = new TomchatServer();
    server.start();
  }
}