package com.absurd.nio.reactor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Reactor implements Runnable{
    public final Selector selector;
    public final ServerSocketChannel serverSocketChannel;

    public Reactor(int port) throws IOException {
        InetSocketAddress inetSocketAddress=new InetSocketAddress(InetAddress.getLocalHost(),port);
        selector=Selector.open();
        serverSocketChannel=ServerSocketChannel.open();
        serverSocketChannel.socket().bind(inetSocketAddress);
        serverSocketChannel.configureBlocking(false);

        //向selector注册该channel
        SelectionKey selectionKey=serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

/*        SocketChannel socketChannel=serverSocketChannel.accept();
        if(socketChannel!=null){//调用Handler来处理channel
            ByteBuffer inputBuffer=ByteBuffer.allocate(1024);
            inputBuffer.clear();
            try {
                socketChannel.read(inputBuffer);
                //激活线程池 处理这些request
                //requestHandle(new Request(socket,btt));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        //利用selectionKey的attache功能绑定Acceptor 如果有事情，触发Acceptor
        selectionKey.attach(new Acceptor(this));
    }


    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                selector.select();
                Set<SelectionKey> selectionKeys= selector.selectedKeys();
                Iterator<SelectionKey> it=selectionKeys.iterator();
                //Selector如果发现channel有OP_ACCEPT或READ事件发生，下列遍历就会进行。
                while(it.hasNext()){
                    //来一个事件 第一次触发一个accepter线程
                    //以后触发SocketReadHandler
                    SelectionKey selectionKey=it.next();
//                    logger.info(">>>>>>>>>>>>>>>>>>");
                    dispatch(selectionKey);
                }
                selectionKeys.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 运行Acceptor或SocketReadHandler
     * @param key
     */
    private void dispatch(SelectionKey key) {
        Runnable r = (Runnable)(key.attachment());
        if (r != null){
            r.run();
        }
    }
}
