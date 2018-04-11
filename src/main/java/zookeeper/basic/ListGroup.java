package zookeeper.basic;

import org.apache.zookeeper.KeeperException;
import zookeeper.Constants;

import java.io.IOException;
import java.util.List;

public class ListGroup extends ConnectionWatcher {

    public void list(String groupName) throws KeeperException, InterruptedException {
        String path = "/" + groupName;
        try {
            List<String> children = zooKeeper.getChildren(path, false);
            if (children.isEmpty()) {
                System.out.printf("No members exit int the group %s", groupName);
                System.exit(1);
            }
            for (String child : children) {
                System.out.println(child);
            }
        } catch (KeeperException.NoNodeException e) {
            System.out.printf("Group %s is not exist", groupName);
            System.exit(1);
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ListGroup listGroup = new ListGroup();
        listGroup.connect(Constants.LOCAL_HOST);
        listGroup.list("test1");
    }

}
