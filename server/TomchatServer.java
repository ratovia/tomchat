import java.net.*;
import java.io.*;

class TomchatServer {
  public static void main(String args[]){
    System.out.println("start tomchat");
    TomchatServer server = new TomchatServer();
    server.start();
  }

  public void start(){
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
    }
  }
}