package question_every_day.hashmap_dilatation_test;

import java.util.HashMap;

public class HashMapDilatationTest {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("1", "2");
        System.out.println(map);

    /*
        JDK1.7的HashMap扩容的方法
        int i = indexFor(e.hash, newCapacity);
        e.next = newTable[i];
        newTable[i] = e;
            首先计算出元素e在新数组中的位置，然后将新数组在位置i的元素加到元素e的后面，
            最后将新数组位置i的元素设置为e。
     */
//    void trasnfer(HashMapEntry[] newTable) {
//        int newCapacity = newTable.length;
//        for (HashMapEntry<K,V> e : table) {
//            while (null != e) {
//                HashMapEntry<K,V> next = e.next;
//                int i = indexFor(e.hash, newCapacity);
//                e.next = newTable[i];
//                newTable[i] = e;
//                e = next
//            }
//        }
//    }


        /*
            JDK1.8的HashMap扩容的方法
            HashMap.Node<K,V> loHead = null, loTail = null;
            HashMap.Node<K,V> hiHead = null, hiTail = null;
            if (loTail == null)
                loHead = e;
            else
                loTail.next = e;
            loTail = e;
                定义loHead、loTail、hiHead、hiTail是为了如果保持原数组里链表的顺序。
            newTab[j + oldCap] = hiHead;
                这边简化计算元素在新数组中位置，如果与原数组的长度做&运算结果为0，则在新数组中的位置与
                原数组相同，否则的话在新数组中的位置为原数组的长度+元素在原数组中的索引。

         */
//        final HashMap.Node<K,V>[] resize() {
//            HashMap.Node<K,V>[] oldTab = table;
//            int oldCap = (oldTab == null) ? 0 : oldTab.length;
//            int oldThr = threshold;
//            int newCap, newThr = 0;
//            if (oldCap > 0) {
//                if (oldCap >= MAXIMUM_CAPACITY) {
//                    threshold = Integer.MAX_VALUE;
//                    return oldTab;
//                }
//                else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
//                        oldCap >= DEFAULT_INITIAL_CAPACITY)
//                    newThr = oldThr << 1; // double threshold
//            }
//            else if (oldThr > 0) // initial capacity was placed in threshold
//                newCap = oldThr;
//            else {               // zero initial threshold signifies using defaults
//                newCap = DEFAULT_INITIAL_CAPACITY;
//                newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
//            }
//            if (newThr == 0) {
//                float ft = (float)newCap * loadFactor;
//                newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
//                        (int)ft : Integer.MAX_VALUE);
//            }
//            threshold = newThr;
//            @SuppressWarnings({"rawtypes","unchecked"})
//            HashMap.Node<K,V>[] newTab = (HashMap.Node<K,V>[])new HashMap.Node[newCap];
//            table = newTab;
//            if (oldTab != null) {
//                for (int j = 0; j < oldCap; ++j) {
//                    HashMap.Node<K,V> e;
//                    if ((e = oldTab[j]) != null) {
//                        oldTab[j] = null;
//                        if (e.next == null)
//                            newTab[e.hash & (newCap - 1)] = e;
//                        else if (e instanceof HashMap.TreeNode)
//                            ((HashMap.TreeNode<K,V>)e).split(this, newTab, j, oldCap);
//                        else { // preserve calculate
//                            HashMap.Node<K,V> loHead = null, loTail = null;
//                            HashMap.Node<K,V> hiHead = null, hiTail = null;
//                            HashMap.Node<K,V> next;
//                            do {
//                                next = e.next;
//                                if ((e.hash & oldCap) == 0) {
//                                    if (loTail == null)
//                                        loHead = e;
//                                    else
//                                        loTail.next = e;
//                                    loTail = e;
//                                }
//                                else {
//                                    if (hiTail == null)
//                                        hiHead = e;
//                                    else
//                                        hiTail.next = e;
//                                    hiTail = e;
//                                }
//                            } while ((e = next) != null);
//                            if (loTail != null) {
//                                loTail.next = null;
//                                newTab[j] = loHead;
//                            }
//                            if (hiTail != null) {
//                                hiTail.next = null;
//                                newTab[j + oldCap] = hiHead;
//                            }
//                        }
//                    }
//                }
//            }
//            return newTab;
//        }

    }


}
