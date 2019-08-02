import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ZookeeperWatcher implements Watcher {
    private ZooKeeper zooKeeper;
    CountDownLatch countDownLatch = new CountDownLatch(1);

    /*超时时间*/
    private static final int SESSION_TIME_OUT = 2000;

    public ZookeeperWatcher() {
    }

    /*创建Zookeeper*/
    public ZookeeperWatcher(String host) throws IOException {
        zooKeeper = new ZooKeeper(host, SESSION_TIME_OUT, this);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(zooKeeper.getState());
    }

    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            countDownLatch.countDown();
            try {
                if (watchedEvent.getType() == Event.EventType.NodeCreated) {
                    System.out.println("路径" + watchedEvent.getPath() + "后" + zooKeeper.getData(watchedEvent.getPath(), true, new Stat()));
                } else if (watchedEvent.getType() == Event.EventType.ChildWatchRemoved) {
                    System.out.println("路径" + watchedEvent.getPath() + "后" + zooKeeper.getData(watchedEvent.getPath(), true, new Stat()));
                } else if (watchedEvent.getType() == Event.EventType.DataWatchRemoved) {
                    System.out.println("路径" + watchedEvent.getPath() + "后" + zooKeeper.getData(watchedEvent.getPath(), true, new Stat()));
                } else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                    System.out.println("路径" + watchedEvent.getPath() + "后" + zooKeeper.getData(watchedEvent.getPath(), true, new Stat()));
                } else if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
                    System.out.println("路径" + watchedEvent.getPath() + "后" + zooKeeper.getData(watchedEvent.getPath(), true, new Stat()));
                }
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 创建节点
     * @param path
     * @param data
     * @throws Exception
     */
    public String createNode(String path,String data) throws Exception{
        return this.zooKeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }


}
