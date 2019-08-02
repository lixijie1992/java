import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;

import java.io.IOException;

public class app {
    private static ZookeeperWatcher zookeepers;

    public static void main(String[] args) throws IOException {
        final String  CONNECT="192.168.1.6:2181,192.168.1.7:2181,192.168.1.8:2181";
        zookeepers  = new ZookeeperWatcher(CONNECT);

    }


}
