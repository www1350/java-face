package com.absurd.nio.reactor;


import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class DiscardServer {
    public static void main(String[] args) throws IOException {
        DiscardServer discardServer = new DiscardServer();
        Reactor reactor = new Reactor(8088);
        new Thread(reactor).start();

        List<Thread> ts =   new ArrayList<Thread>();
        WriteClient writeClient =  discardServer.new WriteClient(8088);
        for(int i=0;i<100;i++)
            ts.add(new Thread(writeClient ));
        for(int i=0;i<100;i++)
            ts.get(i).start();
    }

    class WriteClient implements Runnable{
        public final SocketChannel socketChannel;
        public WriteClient(int port) throws IOException {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(), port));
        }

        @Override
        public void run() {
            try {
                String newData = "New String to write to file..." + System.currentTimeMillis();
                ByteBuffer buf = ByteBuffer.allocate(8129);
                buf.clear();
                buf.put(newData.getBytes());
                buf.flip();
                while(buf.hasRemaining()) {
                    socketChannel.write(buf);
                }

//                int bytesRead = socketChannel.read(buf);
//                System.out.printf(""+bytesRead);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
