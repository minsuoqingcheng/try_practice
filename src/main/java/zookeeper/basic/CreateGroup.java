package zookeeper.basic;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class CreateGroup implements Watcher {

    private static final int SESSION_TIMEOUT = 5000;
    private ZooKeeper zooKeeper;
    private CountDownLatch connectedSignal = new CountDownLatch(1);

    public void connect(String host) throws IOException, InterruptedException {
        zooKeeper = new ZooKeeper(host, SESSION_TIMEOUT, this);
        connectedSignal.await();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            connectedSignal.countDown();
        }
    }

    public void create(String groupName) throws KeeperException, InterruptedException {
        String path = "/" + groupName;
        String createdPath = zooKeeper.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("Created: " + createdPath);
    }

    public void close() throws InterruptedException {
        zooKeeper.close();
    }


    public static void main(String[] args) throws Exception {
        CreateGroup createGroup = new CreateGroup();
        createGroup.connect("127.0.0.1");
        createGroup.create("test");
        createGroup.close();
    }
}
