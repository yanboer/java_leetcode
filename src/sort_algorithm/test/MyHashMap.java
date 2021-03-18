package sort_algorithm.test;


public class MyHashMap {

    public static class Node{
        public Object key;
        public Object value;
        public int hash;
        public Node next;

        public Node(Object key, Object value, int hash, Node next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }
    }

    private Node[] table;

    private int size;

    private static final int DEFAULT_CAP = 16;

    private float loadFactory;

    private float threshold;

    public MyHashMap(int cap,float loadFactory){
        this.threshold = loadFactory * tableSizeFor(cap);
        this.loadFactory = loadFactory;
        table = new Node[tableSizeFor(cap)];
    }

    private int tableSizeFor(int cap) {
        int n = cap - 1;

        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n <= 1 ? 0 : (n + 1);
    }

    public MyHashMap(){
        this(DEFAULT_CAP,0.75f);
    }

    public MyHashMap(int cap){
        this(cap,0.75f);
    }


    public boolean isEmpty(){
        return table.length == 0;
    }

    public int size(){
        return table.length;
    }

    public int hash(Object key){
        int h = key.hashCode();
        return key == null ? 0 : h ^ (h >>> 16);
    }

    public boolean put(Object key,Object value){
        //寻址
        int h = hash(key);
        Node cur = table[h & (table.length - 1)];

        //当前 bucket 为空
        if(cur == null){
            table[h & (table.length - 1)] = new Node(key,value,h,null);
        }
        //一个节点
        else if (cur.next == null){
            //相等
            if (cur.hash == h && cur.key == (key)){
                cur.value = value;
            } else {
                cur.next = new Node(key,value,h,null);
            }
        }
        //链表
        else {
            for(int index = 0; ;index++){
                //重复
                if(cur.hash == h && cur.key == key){
                    cur.value = value;
                    break;
                }
                else if (cur.next == null){
                    cur.next = new Node(key,value,h,null);
                    break;
                }
                cur = cur.next;
            }
        }
        //扩容
        if(++size > threshold){
            table = resize();
        }
        return true;
    }

    public Object get(Object key){
        int h = hash(key);
        Node cur = table[h & (table.length - 1)];

        //空
        if(cur == null){
            return null;
        }
        //一个节点
        else if(cur.next == null){
            //相等
            if(cur.key == key && cur.hash == h){
                return cur.value;
            }
            else {
                return null;
            }
        }
        //链表
        else {
            for(int index = 0; ; index++){
                if(cur.key == key && cur.hash == h){
                    return cur.value;
                }
                cur = cur.next;
                if(cur == null){
                    return null;
                }
            }
        }
    }

    //扩容
    public Node[] resize() {
        //老表
        Node[] oldTab = table;

        //老表长度
        int oldLength = table.length;

        //新表
        Node[] newTab = new Node[table.length << 1];

        //扩容阈值更新
        threshold = newTab.length * loadFactory;

        for(int i = 0;i < oldLength;i++){
            //当前头结点
            Node cur = table[i];

            if(table[i] != null){
                //老表置空
                table[i] = null;

                //一个节点
                if (cur.next == null){
                    newTab[(newTab.length - 1) & cur.hash] = cur;
                }
                //链表
                else {
                    //高低链表
                    Node lohead = null,lotail = null;
                    Node hihead = null,hitail = null;

                    while (cur != null){
                        //低位链
                        if ((cur.hash & oldLength) == 0){
                            if (lotail == null){
                                lohead = cur;
                            }
                            else {
                                lotail.next = cur;
                            }
                            lotail = cur;
                        }

                        //低位链
                        if ((cur.hash & oldLength) == 1){
                            if (hitail == null){
                                hihead = cur;
                            }
                            else {
                                hitail.next = cur;
                            }
                            hitail = cur;
                        }
                        cur = cur.next;
                    }

                    //链表迁移
                    if(lotail != null){
                        lotail = null;
                        newTab[i] = lohead;
                    }

                    if(hitail != null){
                        hitail = null;
                        newTab[i + oldLength] = hihead;
                    }

                }
            }

        }

        return newTab;
    }

    public Node remove(Object key){
        int h = hash(key);

        //key 所在 的 bucket
        Node cur = table[h & (table.length - 1)];

        Node res = null;
        //空
        if(cur == null){
            return null;
        }
        //一个节点
        else if(cur.next == null){
            if(cur.hash == h && cur.key == key){
                table[h & (table.length - 1)] = null;
                res = cur;
                return cur;
            }
        }
        //链表
        else {
            //要删除的节点的前一个节点
            Node temp = null;
            for(int index = 0; ;index++){
                if(cur.hash == h && cur.key == key){
                    res = cur;
                    break;
                }
                temp = cur;     //前一个节点
                cur = cur.next;
                if(cur == null){
                    break;
                }
            }
            temp.next = cur.next;
        }
        size--;
        return res;
    }
}
