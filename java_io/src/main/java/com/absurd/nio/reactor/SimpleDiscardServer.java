package com.absurd.nio.reactor;


import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class SimpleDiscardServer {
    public static void main(String[] args) throws IOException {
        SimpleDiscardServer simpleDiscardServer = new SimpleDiscardServer();
        SimpleNioServer simpleNioServer = new SimpleNioServer(8088);
        new Thread(simpleNioServer).start();

        List<Thread> ts =   new ArrayList<Thread>();
        SimpleNioClient client =  simpleDiscardServer.new SimpleNioClient(8088);
        for(int i=0;i<100;i++) {
            ts.add(new Thread(client));
        }
        for(int i=0;i<100;i++)
            ts.get(i).start();

    }

    class SimpleNioClient implements Runnable{
        public final SocketChannel socketChannel;
        public SimpleNioClient(int port) throws IOException {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(),port));
        }

        @Override
        public void run() {
            try {
                String newData = "New String to write to file..." + System.currentTimeMillis();
                ByteBuffer buf = ByteBuffer.allocate(8129);
                buf.clear();
                buf.put(newData.getBytes());
                buf.flip();
                while(buf.hasRemaining())
                    socketChannel.write(buf);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
