package Java_DataStructure;

import java.util.*;

public class Trie {
	
	 Node root;
	 public static class Node
	{
		int end;
		Node child[]=new Node[26];
		
		Node()
		{
			this.end=0;
			Arrays.fill(this.child,null);
			
		}
	}
	
	 void insert(String s)
	{
		int n=s.length();
		Node temp=root;
		for(int i=0;i<n;i++)
		{
			char ch=s.charAt(i);
			int j=ch-'a';
			if(temp.child[j]==null)
				temp.child[j]=new Node();
			temp=temp.child[j];
		}
		temp.end=1;
			
	}

	public static void main(String[] args) 
	{
		Trie t=new Trie();
		t.insert("govind");
		System.out.println("Given String is present "+t.search("govind"));
		

	}

	public boolean search(String s) 
	{
		
		int n=s.length();
		Node temp=root;
		for(int i=0;i<n;i++)
		{
			char ch=s.charAt(i);
			int j=ch-'a';
			if(temp.child[j]!=null)
				temp=temp.child[j];
			else return false;
		}
		if(temp.end==1)
			return true;
		else return false;
		
	}
	public void delete(String s)
	{
		if(s=="")
			return ;
		int n=s.length();
	}

}
