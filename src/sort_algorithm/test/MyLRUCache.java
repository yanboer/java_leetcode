package sort_algorithm.test;

import java.util.HashMap;
import java.util.Map;

public class MyLRUCache {
    static class Node{
        String key;
        Object value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
    Node head;
    Node tail;

    private Map<String,Node> cache;

    private int cap;

    public MyLRUCache(int cap){
        this.cap = cap;
        cache = new HashMap<>(cap);

        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public Object get(String key){
        Node cur = cache.get(key);
        if(cur == null){
            return null;
        }
        Object res = cur.value;
        //移到首节点
        moveToHead(cur);
        return res;
    }

    //移到首节点
    private void moveToHead(Node cur){
        //1、从当前位置删除
        cur.next.pre = cur.pre;
        cur.pre.next = cur.next;

        //2、移到首节点
        cur.next = head.next;
        cur.pre = head;
        head.next.pre = cur;
        head.next = cur;
    }

    public void put(String key,Object value){
        Node cur = cache.get(key);
        //没有该节点
        if(cur == null){
            Node node = new Node(key, value);
            //放入缓存中
            cache.put(key,node);
            //放到头结点
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;

            //超过最大容量
            if(cache.size() > cap){
                //删除最久未使用的节点    ===》尾节点
                Node deleteNode = tail.pre;

                deleteNode.next.pre = deleteNode.pre;
                deleteNode.pre.next = deleteNode.next;

                cache.remove(deleteNode.key);
            }
        }
        //有该节点
        else {
            cur.value = value;
            moveToHead(cur);
        }
    }
}
