package math.other;

/**
 *
 * @author gongzhipeng
 * @version $$ LinkedListRevert, 2020/7/24 16:12 gongzhipeng $$
 */
public class LinkedListRevert
{
	static class Node
	{
		int value;
		Node next;

		public Node(int value)
		{
			this.value = value;
		}
	}

	public static void main(String[] args)
	{
		Node first = new Node(5);
		Node second = new Node(6);
		Node third = new Node(7);
		first.next = second;
		second.next = third;

		Node x = null;
		x = revert(first, null, x);

		System.out.println(x.value);
		System.out.println(x.next.value);
	}

	private static Node revert(Node first, Node pre, Node head)
	{
		if(first.next != null)
		{
			Node next = first.next;
			head = revert(next, first, head);
		}
		else
		{
			head = first;
		}
		first.next = pre;
		return head;
	}

}
