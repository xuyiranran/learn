package learn_algorithm;

import java.util.Objects;

/**
 * 哈希算法
 * 哈希算法在计算机领域也是应用非常广泛的一种算法思想
 * 1、哈希表设计
 * 2、消息摘要信息
 * 3、布隆过滤器
 */
public class HashingFunction {


    public int hash(String string) {
        char[] value = string.toCharArray();
        int hash = 0;
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return hash;
    }

}
