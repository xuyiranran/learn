package learn_data_structure.hash;

import com.google.common.collect.Sets;

import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 一致性哈希算法java代码实现
 *
 * 1、通过将真实物理节点映射成N个虚拟节点
 * 2、使用TreeMap有序map存放虚拟节点映射关系
 * 3、key哈希值,定义顺时针第一个虚拟节点就是存放该key的真实物理节点
 */
public class ConsistentHashing {


    //每个物理节点对应虚拟节点个数
    private int vmNodes;

    //真实物理节点集合
    private Set<String> realNodes;

    //TreeMap存放有序的虚拟节点对应的hashKey-vmNode
    private TreeMap<Integer, String> vm = new TreeMap<>();

    public ConsistentHashing(int vmNodes, Set<String> realNodes) {
        this.vmNodes = vmNodes;
        this.realNodes = realNodes;
        for (String realNode : realNodes) {
            for (int i = 0; i < vmNodes; i++) {
                String vmNodeName = realNode + "&&" + i;
                vm.put(hash(vmNodeName), vmNodeName);
            }
        }
    }

    //这里的哈希函数可以设计的更合理些,直接使用Java Object中的hashCode并不好.
    private int hash(String string) {
        return Math.abs(Objects.hash(string));
    }

    public String getRealNode(String key) {

        //得到key的哈希值
        int hash = hash(key);
        //这个哈希值可能大于最大的虚拟节点对应的hash值所以需要单独处理下.
        if (hash >= vm.lastKey()) {
            String value = vm.lastEntry().getValue();
            return value.substring(0, value.indexOf("&&"));
        }
        //顺时针最近的那个节点,也就是大于hash最近的那个key-value节点
        SortedMap<Integer, String> sortedMap = vm.tailMap(hash);
        Integer vmNodeKey = sortedMap.firstKey();
        String vmNodeValue = sortedMap.get(vmNodeKey);
        return vmNodeValue.substring(0, vmNodeValue.indexOf("&&"));
    }

    public static void main(String[] args) {

        ConsistentHashing consistentHashing = new ConsistentHashing(5, Sets.newHashSet("192.168.1.1", "192.168.1.2", "192.168.1.3", "192.168.1.4"));
        System.out.println(consistentHashing.getRealNode("hello1"));
        System.out.println(consistentHashing.getRealNode("china"));
        System.out.println(consistentHashing.getRealNode("my"));
        System.out.println(consistentHashing.getRealNode("21"));
        System.out.println(consistentHashing.getRealNode("21"));
        System.out.println(consistentHashing.getRealNode("12"));

    }
}
