package Java_DataStructure;

import Java_DataStructure.BinaryTree.Node;

//"Longest path to the bottom of a Binary Tree"
//+ " forming an Arithmetic Progression-"
//+ ""
//+ "
public class LongestPath {
	static int maxlength=1;
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt=new BinaryTree();
		Java_DataStructure.BinaryTree.Node root=bt.createTree();
		LongestPath lp= new LongestPath(); 
		
		if(root==null)
			maxlength=0;
		if(root.left==null && root.right==null)
			maxlength=1;
		maxlength=2;
		if(root.left!=null)
		{
			int cd=root.left.data-root.data;
			lp.path(root.left,cd,2);
		}
		
		if(root.right!=null)
		{
			int cd=root.right.data-root.data;
			lp.path(root.right, cd, 2);
		}
		
		System.out.println("Longest path to the bottom of a Binary Tree"
				+ " forming an Arithmetic Progression-"+ maxlength);
		

	}

	static int max(int l, int r) {
		// TODO Auto-generated method stub
		if(l>r)
			return l;
			else
				return r;
	}

	public  void path(Node root, int cd, int c) {
		// TODO Auto-generated method stub
		
		if(root.left!=null)
		{
			if(cd==(root.left.data-root.data))
			{
				
				if(c+1>maxlength)
					maxlength=c+1;
				path(root.left,cd,c+1);
			}
			else
				path(root.left,(root.left.data-root.data),2);
		}
		
		if(root.right!=null)
		{
			if(cd==(root.right.data-root.data))
			{
				if(c+1>maxlength)
					maxlength=c+1;
				path(root.right,cd,c+1);
					
			}
			else
				path(root.right,(root.right.data-root.data),2);
		}
	}

}
