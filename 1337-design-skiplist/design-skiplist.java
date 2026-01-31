class Skiplist {
    private static final int MAX_LEVEL = 32;
    private static final double P = 0.5; 
    private final Node head = new Node(-1, MAX_LEVEL);
    private int currentLevel = 0;
    private final Random random = new Random();

    class Node {
        int val;
        Node[] next;
        Node(int val, int level) {
            this.val = val;
            this.next = new Node[level];
        }
    }

    public Skiplist() {
        
    }
    
    public boolean search(int target) {
        Node curr = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].val < target) curr = curr.next[i];
            if (curr.next[i] != null && curr.next[i].val == target) return true;
        }
        return false;
    }
    
    public void add(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Node curr = head;
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].val < num) curr = curr.next[i];
            update[i] = curr;
        }

        int level = randomLevel();
        if (level > currentLevel) currentLevel = level;
        
        Node newNode = new Node(num, level);
        for (int i = 0; i < level; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
    }
    
    public boolean erase(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Node curr = head;
        boolean found = false;
        for (int i = currentLevel - 1; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].val < num) curr = curr.next[i];
            if (curr.next[i] != null && curr.next[i].val == num) found = true;
            update[i] = curr;
        }

        if (!found) return false;

        for (int i = 0; i < currentLevel; i++) {
            if (update[i].next[i] != null && update[i].next[i].val == num) {
                update[i].next[i] = update[i].next[i].next[i];
            }
        }
        return true;
    }
    private int randomLevel() {
        int level = 1;
        while (random.nextDouble() < P && level < MAX_LEVEL) level++;
        return level;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */