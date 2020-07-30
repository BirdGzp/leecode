//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package jvm;


import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class JVMGcAggregator  {
    private GarbageCollectorMXBean fullGC;
    private GarbageCollectorMXBean youngGC;
    private long lastYoungGCCollectionCount = -1L;
    private long lastYoungGCCollectionTime = -1L;
    private long lastFullGCCollectionCount = -1L;
    private long lastFullGCCollectionTime = -1L;

    public JVMGcAggregator() {
        System.out.println("---------------JVMGc-----------:");
        List<GarbageCollectorMXBean> lisfOfGCMbean = ManagementFactory.getGarbageCollectorMXBeans();
        ListIterator iter = lisfOfGCMbean.listIterator();

        while(true) {
            GarbageCollectorMXBean item;
            label51:
            do {
                while(iter.hasNext()) {
                    item = (GarbageCollectorMXBean)iter.next();
                    System.out.println("bean name:" + item.getName());
                    if (!"ConcurrentMarkSweep".equals(item.getName()) && !"MarkSweepCompact".equals(item.getName()) && !"PS MarkSweep".equals(item.getName()) && !"G1 Old Generation".equals(item.getName()) && !"Garbage collection optimized for short pausetimes Old Collector".equals(item.getName()) && !"Garbage collection optimized for throughput Old Collector".equals(item.getName()) && !"Garbage collection optimized for deterministic pausetimes Old Collector".equals(item.getName())) {
                        continue label51;
                    }

                    this.fullGC = item;
                    System.out.println(" full gc bean name:" + item.getName());
                }

                System.out.println("---------------JVMGc end-----------:");
                return;
            } while(!"ParNew".equals(item.getName()) && !"Copy".equals(item.getName()) && !"PS Scavenge".equals(item.getName()) && !"G1 Young Generation".equals(item.getName()) && !"Garbage collection optimized for short pausetimes Young Collector".equals(item.getName()) && !"Garbage collection optimized for throughput Young Collector".equals(item.getName()) && !"Garbage collection optimized for deterministic pausetimes Young Collector".equals(item.getName()));

            this.youngGC = item;
            System.out.println(" young gc bean name:" + item.getName());
        }
    }

    public long getYoungGCCollectionCountTotal() {
        return this.youngGC == null ? 0L : this.youngGC.getCollectionCount();
    }

    public long getYoungGCCollectionTimeTotal() {
        return this.youngGC == null ? 0L : this.youngGC.getCollectionTime();
    }

    public long getFullGCCollectionCountTotal() {
        return this.fullGC == null ? 0L : this.fullGC.getCollectionCount();
    }

    public long getFullGCCollectionTimeTotal() {
        return this.fullGC == null ? 0L : this.fullGC.getCollectionTime();
    }

    public long getYoungGCCollectionCount() {
        long current = this.getYoungGCCollectionCountTotal();
        if (this.lastYoungGCCollectionCount == -1L) {
            this.lastYoungGCCollectionCount = current;
            return current;
        } else {
            long reslut = current - this.lastYoungGCCollectionCount;
            this.lastYoungGCCollectionCount = current;
            return reslut;
        }
    }

    public long getYoungGCCollectionTime() {
        long current = this.getYoungGCCollectionTimeTotal();
        if (this.lastYoungGCCollectionTime == -1L) {
            this.lastYoungGCCollectionTime = current;
            return current;
        } else {
            long reslut = current - this.lastYoungGCCollectionTime;
            this.lastYoungGCCollectionTime = current;
            return reslut;
        }
    }

    public long getFullGCCollectionCount() {
        long current = this.getFullGCCollectionCountTotal();
        if (this.lastFullGCCollectionCount == -1L) {
            this.lastFullGCCollectionCount = current;
            return current;
        } else {
            long reslut = current - this.lastFullGCCollectionCount;
            this.lastFullGCCollectionCount = current;
            return reslut;
        }
    }

    public long getFullGCCollectionTime() {
        long current = this.getFullGCCollectionTimeTotal();
        if (this.lastFullGCCollectionTime == -1L) {
            this.lastFullGCCollectionTime = current;
            return current;
        } else {
            long reslut = current - this.lastFullGCCollectionTime;
            this.lastFullGCCollectionTime = current;
            return reslut;
        }
    }

    public String getModelName() {
        return "gc";
    }

    public Map<String, Object> constructItemRow() {
        Map<String, Object> row = new HashMap(10);
        row.put("youngGCCollectionCount", this.getYoungGCCollectionCount());
        row.put("youngGCCollectionTime", this.getYoungGCCollectionTime());
        row.put("fullGCCollectionCount", this.getFullGCCollectionCount());
        row.put("fullGCCollectionTime", this.getFullGCCollectionTime());
        row.put("youngGCCollectionCountTotal", this.getYoungGCCollectionCountTotal());
        row.put("youngGCCollectionTimeTotal", this.getYoungGCCollectionTimeTotal());
        row.put("fullGCCollectionCountTotal", this.getFullGCCollectionCountTotal());
        row.put("fullGCCollectionTimeTotal", this.getFullGCCollectionTimeTotal());
        if (this.fullGC != null) {
            row.put("fullGCMBeanName", this.fullGC.getName());
        }

        if (this.youngGC != null) {
            row.put("youngGCMBeanName", this.youngGC.getName());
        }

        return row;
    }
}
