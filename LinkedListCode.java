public class LinkedListCode {
	private static void deleteMiddleNode(LinkedList.Node node) {
		if (node.next == null) return; //End node provided
		LinkedList.Node prev = node;
		node = node.next;

		while (node.next != null) {
			prev.value = node.value;
			prev = node;
			node = node.next;
		}
		prev.value = node.value;
		prev.next = null;
	}

	private static <T> LinkedList<T>.Node selectMiddleNode(LinkedList <T> ll, int index) {
		LinkedList<T>.Node node = ll.head;
		for (int i = 0; node.next != null && i <= index - 1; ++i) {
			node = node.next;
		}
		return node;
	}

	public static <T> LinkedList<T> buildList(T[] a) {
		LinkedList<T> ll = new LinkedList<>();
		for (T t: a) {
			ll.add(t);
		}
		return ll;
	}

	public static void main(String[] args) {
		Character array[] = new Character[] {'A','B','C','D','E'};
		LinkedList <Character> ll = buildList(array);
		LinkedList <Character> .Node node = selectMiddleNode(ll, 2);
		deleteMiddleNode(node);
		System.out.println(ll);
	}
	
}

class LinkedList <T> {
	Node head;

	class Node {
		Node next;
		T value;

		Node(T value) {
			this.value = value;
		}
	}

	public void add(T value) {
		if (head == null) {
			head = new Node(value);
			return;
		}
		Node t = head;
		while (t.next != null) {
			t = t.next;
		}
		t.next = new Node(value);
	}

	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public String toString() {
		StringBuilder bf = new StringBuilder();
		Node t = head;
		while (t != null) {
			bf.append(t.value);
			t = t.next;
		}
		return bf.toString();
	}

}
