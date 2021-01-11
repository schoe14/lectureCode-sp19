public class DMSList {
    private IntNode sentinel;

    public DMSList() {
        sentinel = new IntNode(-1000, new lastIntNode());
    }

    public class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode h) {
            item = i;
            next = h;
        }

        public int max() {
            return Math.max(item, next.max());
        }
    }

    public int addLast(int a) {
        IntNode ptr = sentinel;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new IntNode(a, null);
        return a;
    }

    public class lastIntNode extends IntNode {
        public lastIntNode() {
            super(0, null);
        }

        @Override
        public int max() {
            return 0;
        }
    }

    public int max() {
        return sentinel.next.max();
    }

    public static void main(String[] args) {
        DMSList d = new DMSList();
        d.addLast(1);
        d.addLast(2);
        d.addLast(3);
        d.addLast(4);
        System.out.println(d.max());
//        d.max();
    }
}
