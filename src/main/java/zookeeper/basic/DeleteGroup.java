package zookeeper.basic;

import org.apache.zookeeper.KeeperException;
import zookeeper.Constants;

import java.io.IOException;

public class DeleteGroup extends ConnectionWatcher {

    public void delete(String groupName) throws KeeperException, InterruptedException {
        String path = "/" + groupName;
        try {
            zooKeeper.delete(path, -1);
        } catch (KeeperException.NoNodeException e) {
            System.out.printf("Group %s is not exit", groupName);
            System.exit(1);
        }
    }

    public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
        DeleteGroup deleteGroup = new DeleteGroup();
        deleteGroup.connect(Constants.LOCAL_HOST);
        deleteGroup.delete("test");
        deleteGroup.close();
    }

}
