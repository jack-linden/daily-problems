package linkedlist;


public class Node {
	public int val;
	public Node next;

	public Node(int val){
		this.val = val;
	}

   public Node append(Node node){
      Node curr = this;

      while( curr.next != null ){
         curr = curr.next;
      }

      curr.next = node;
      return this;
   }

	public Node getIth(int i){
		Node curr = this;
		while( i-- > 0 && curr != null){
			curr = curr.next;
		}

		return curr;
	}

	 public static Node of(int[] vals){
		Node node = new Node(vals[0]);
		Node curr = node;
		for( int i = 1; i < vals.length; i++ ){
			curr.next = new Node(vals[i]);
			curr = curr.next;
		}
		return node;
	}

	 public static int length(Node node){
		Node curr = node;
		int i = 0;

		while( curr != null ){
			curr = curr.next;
			i++;
		}

		return i;
	}

   @Override
   public String toString(){
      return String.format("{%d}", val);
   }

}