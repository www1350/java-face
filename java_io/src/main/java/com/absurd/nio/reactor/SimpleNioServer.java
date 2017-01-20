package com.absurd.nio.reactor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SimpleNioServer implements Runnable{
    Logger logger = LoggerFactory.getLogger(getClass());
    public final ServerSocketChannel serverSocketChannel;
    public SimpleNioServer(int port) throws IOException {
        InetSocketAddress inetSocketAddress=new InetSocketAddress(InetAddress.getLocalHost(),port);
        serverSocketChannel=ServerSocketChannel.open();
        serverSocketChannel.socket().bind(inetSocketAddress);
        serverSocketChannel.configureBlocking(false);
    }

    @Override
    public void run() {
        while (true){
            try {
                ByteBuffer inputBuffer=ByteBuffer.allocate(43);
                inputBuffer.clear();
                SocketChannel socketChannel=serverSocketChannel.accept();
                if (socketChannel!=null){
                int bytesRead = socketChannel.read(inputBuffer);
                    logger.info(""+new String(inputBuffer.array()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
