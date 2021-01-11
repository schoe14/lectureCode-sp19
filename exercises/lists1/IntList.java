public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		return 0;
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		return 0;
	}

	/** Returns the ith value in this list.*/
	public int get(int i) {
		return 0;
	}

	public void skippify() {
		IntList p = this;
		int n = 1;
		while (p != null) {
			IntList next = p.rest;
			for (int i = 0; i < n; i++) {
				if (next != null) {
					next = next.rest;
				}
				p.rest = next;
			}
			p = p.rest;
			n++;
		}
	}

	public IntList ilsans(IntList x, int y) {
		if (x == null) {
			return null;
		}
		if (x.first == y) {
			return ilsans(x.rest, y);
		}
		return new IntList(x.first, ilsans(x.rest, y));
	}

	public IntList dilsans(IntList x, int y) {
		if (x == null) {
			return null;
		}
		x.rest = dilsans(x.rest, y);
		if (x.first == y) {
			return x.rest;
		}
		return x;
	}

	public static void main(String[] args) {
//		IntList L = new IntList(10, null);
//		L = new IntList(9, L);
//		L = new IntList(8, L);
//		L = new IntList(7, L);
//		L = new IntList(6, L);
//		L = new IntList(5, L);
//		L = new IntList(4, L);
//		L = new IntList(3, L);
//		L = new IntList(2, L);
//		L = new IntList(1, L);
//		L.skippify();
		IntList L = new IntList(4, null);
		L = new IntList(3, L);
		L = new IntList(2, L);
		L = new IntList(1, L);
		L.dilsans(L, 3);
//		System.out.println(L.iterativeSize());
	}
} 