package zookeeper.basic;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import zookeeper.Constants;

import java.io.IOException;

public class JoinGroup extends ConnectionWatcher {

    public void join(String groupName, String memberName) throws KeeperException, InterruptedException {
        String path = "/" + groupName + "/" + memberName;
        String createPath = zooKeeper.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("Created: "+createPath);
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        JoinGroup joinGroup = new JoinGroup();
        joinGroup.connect(Constants.LOCAL_HOST);
        joinGroup.join("test", "children1");
        Thread.sleep(Long.MAX_VALUE);
    }

}
