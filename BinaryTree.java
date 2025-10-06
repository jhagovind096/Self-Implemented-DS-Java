package Java_DataStructure;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class BinaryTree {

	int max_level=0 , c_level=0, ht=0;
		
	public static class Node
	{
		public int data;
		public Node left;
		public Node right;
		
		Node(int data)
		{
			this.data=data;
			left=null;
			right=null;
		}
	}
	public Node createTree()
	{
		Scanner sc=new Scanner(System.in);
		Node root=null;
		System.out.println("enter data ");
		int a=sc.nextInt();
		if(a==-1) return null;
		
		root=new Node(a);
		System.out.println("Enter left of "+a+"-");
		root.left=createTree();
		System.out.println("Enter right of "+a+"-");
		root.right=createTree();
		
		
		return root;
	}
	
	void inOrder(Node root)
	{
		
		
		if(root==null)
			return;
		
		inOrder(root.left);
		System.out.print(root.data+"  ");
		inOrder(root.right);
	}

	void preOrder(Node root)
	{
		//System.out.println();
		
		if(root==null)
			return;
		System.out.print(root.data+"  ");
		preOrder(root.left);
		preOrder(root.right);
	}
	

	void postOrder(Node root)
	{
		
		
		if(root==null)
			return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+"  ");
	}
	
	int height(Node root)
	{
		int lheight=0 , rheight=0;
		if(root==null)
			return 0;
		lheight=height(root.left);
		rheight=height(root.right);
		
		if(lheight>rheight)
			return lheight+1;
		else
			return rheight+1;
			
	}
	
	void bfs(Node root)
	{
		Queue<Node> q=new  LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node n=q.poll();
			System.out.print(n.data+" ");
			if(n.left!=null)
				q.add(n.left);
			if(n.right!=null)
				q.add(n.right);
			System.out.println();
			
		}
						
	}
	
	
	void leftView(Node root,int level)
	{
		if(root==null)
			return;
		if(max_level<level) {
		System.out.print(root.data+" ");
		max_level=level;
		
		}
		leftView(root.left,level +1);
		leftView(root.right,level +1);
		
	}
	void rightView(Node root, int level)
	{
		if(root==null)
			return;
		if(c_level<level) {
		System.out.println(root.data);
		c_level=level;
		}
		
		rightView(root.right,level+1);
		rightView(root.left,level+1);
	}
	
	
	void topView(Node root)
	{
		if(root==null)
			return;
	 class NewNode{
		 Node node;
		 int h;
		 public NewNode(Node n , int h) {
			// TODO Auto-generated constructor stub
			 this.node=n;
			 this.h=h;
		}
	 }
		Queue<NewNode> q=new  LinkedList<NewNode>();
		Map<Integer,Node> tm=new TreeMap<Integer,Node>();
		
		q.add(new NewNode(root,0));
		
		while(!q.isEmpty())
		{
			NewNode n=q.poll();
			if(!tm.containsKey(n.h))
				tm.put(n.h, n.node);
			if(n.node.left!=null)
				q.add(new NewNode(n.node.left,n.h -1));
			if(n.node.right!=null)
				q.add(new NewNode(n.node.right,n.h +1));
			
		}
		for (Entry<Integer, Node> entry :
            tm.entrySet()) {
           System.out.print(entry.getValue().data);
       }
		
	}
	
	void bottomView(Node root)
	{
		class NewNode
		{
			Node node;
			int h;
			
			public NewNode(Node n, int h) {
				// TODO Auto-generated constructor stub
				this.h=h;
				this.node=n;
			}
		}
		
		Queue<NewNode> q=new LinkedList<>();
		Map<Integer, Node> tm=new TreeMap<>();
		q.add(new NewNode(root,0));
		
		while(!q.isEmpty()) 
		{
			NewNode n=q.poll();
			 tm.put(n.h, n.node);
			 
			 if(n.node.left!=null)
				 q.add(new NewNode(n.node.left, n.h-1));
			 if(n.node.right!=null)
				 q.add(new NewNode(n.node.right, n.h+1));
			 		 
		}
		
		for(Entry<Integer,Node> e:tm.entrySet()) {
			System.out.print("  "+e.getValue().data);
			
	}
		
	
}
	
	void postorder(Node root)
	{
		if(root==null)
	        return ;
	        
	        //List<Integer> l=new ArrayList<>();
	        Stack<Node> st=new Stack<>();
	        st.push(root);
	        root=root.left;
	        while(st.empty()==false || root!=null)
	        {
	            while(root!=null)
	            {
	                st.push(root);
	                root=root.left;
	            }
	            root=st.pop();
	            System.out.print(root.data+" ");
	            root=st.peek();
	            root=root.right;
	        }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt=new BinaryTree();
		Node root=bt.createTree(); 
//		System.out.println("Inorder Traversal of Tree");
//		bt.inOrder(root);
//		System.out.println("\nPost order Traversal of Tree");
//		bt.postOrder(root);
//		System.out.println("\nPreorder Traversal of Tree");
//		bt.preOrder(root);
//		System.out.println("\nLevel Order Traversal of Tree/BFS ");
//		bt.bfs(root);
//		System.out.println("\nLeft view Traversal of Tree ");
//		bt.leftView(root,1);
//		System.out.println("\nRight view Traversal of Tree ");
//		bt.rightView(root,1);
//		System.out.println("top view     ");
//		bt.topView(root);
//		System.out.println("bottom view     ");
//		bt.bottomView(root);
		bt.postorder(root);
	}

	

	
}

