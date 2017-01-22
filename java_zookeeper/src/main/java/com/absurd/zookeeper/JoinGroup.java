package com.absurd.zookeeper;


import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;

import java.io.IOException;

public class JoinGroup extends ConnectionWatcher{
    public void join(String groupName, String memberName) throws KeeperException,
            InterruptedException {
        String path = "/"+groupName+"/"+memberName;
        zk.create(path,null/*data*/, ZooDefs.Ids.OPEN_ACL_UNSAFE,
                //Ephemeral Node (临时节点)的操作。 临时节点驻存在ZooKeeper中，当连接和session断掉时被删除。
                CreateMode.EPHEMERAL);
    }

    public static void main(String[] args) throws InterruptedException, KeeperException, IOException {
        JoinGroup joinGroup = new JoinGroup();
        joinGroup.connect("localhost:2181");
        joinGroup.join("aa", "absurd");
// stay alive until process is killed or thread is interrupted
        Thread.sleep(Long.MAX_VALUE);
    }
}
