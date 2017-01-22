package com.absurd.zookeeper;


import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class CreateGroup implements Watcher {
    private static final int SESSION_TIMEOUT = 5000;
    private ZooKeeper zk;
    private CountDownLatch connectedSignal = new CountDownLatch(1);
    public void connect(String hosts) throws IOException, InterruptedException {
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
        connectedSignal.await();
    }
    public void close() throws InterruptedException {
        zk.close();
    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            connectedSignal.countDown();
        }

    }

    // PERSISTENT_SEQUENTIAL-持久化顺序编号目录节点
    //EPHEMERAL-临时目录节点
    //EPHEMERAL_SEQUENTIAL-临时顺序编号目录节点
    public void create(String groupName) throws KeeperException,
            InterruptedException {
        String path = "/" + groupName;
        String createdPath = zk.create(path, null/*data*/, ZooDefs.Ids.OPEN_ACL_UNSAFE,
                //持久化目录节点 客户端与zookeeper断开连接后，该节点依旧存在
                CreateMode.PERSISTENT);
        System.out.println("Created " + createdPath);
    }

    public static void main(String[] args) throws Exception {
        CreateGroup createGroup = new CreateGroup();
        createGroup.connect("localhost:2181");
        createGroup.create("aa");
        createGroup.close();
    }
}
