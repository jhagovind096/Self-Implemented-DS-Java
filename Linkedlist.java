package Java_DataStructure;

import java.io.*;
import java.time.format.ResolverStyle;

import Java_DataStructure.Linkedlist.Node;
public class Linkedlist {

	 public Node head;
	
	 public static class Node {
		public int data;
		public Node next;
		
		public Node(int a)
		{
			this.data=a;
			next=null;
		}
		
		}
	 public void addAtLast(int a)
		{
			Node addLast=new Node(a);
			Node temp=head;
			if(head==null) {
				head=addLast;
				return;
			}
			else
			{
				while(temp.next!=null)
					temp=temp.next;
				temp.next=addLast;
			}
	}
	 public void traverse()
	 {
		Node temp=head;
		if(head==null)
			return;
		else
		{
			while(temp!=null)
			{
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
		}
	 }
	 public void delete(int data)
	 {		
		 
		 if(head==null) {
			 System.out.println("Linked list empty");
		 return;
		 }
		 else if(head.next==null)
		 {
			 if(head.data==data) {
				 head=null;
				 return;
				 }
			 else
			 {
				 System.out.println("element not exist");
				 return;
			 }
			
		 }
		 else if(head.data==data)
		 {
			 head=head.next;
		 }
		 else
		 {
			 Node temp1=head;
			 Node temp=head;
			 
			 while(temp.data!= data && temp.next!=null)
			 {
				 temp1=temp;
				 temp=temp.next;
			 }
			 if(temp.next==null)
			 {
				 System.out.println("given element not present in linked list");
				 return;
			 }
			  
			 else if(temp.data==data)
			 {
				 if(temp.next!=null)
				temp1.next=temp.next;
				 else
					 temp1.next=null;
			 }
			 else
			 {
				 System.out.println("given element not present in linked list");
				 return;
			 }
			 
		 }
	 }
	 
	 Node middle(Node head)
	 {
		 if(head==null || head.next==null)
			 return head;
		 Node p=head,q=head;
		 while(q!=null && q.next!=null)
		 {
			 p=p.next;
			 q=q.next.next;
		 }
		 return p;
	 }
	 
	 public void insertStart(int val)
	 {
		 Node newNode=new Node(val);
		 if(head==null)
		 {
			 head=newNode;
			 return ; 
		 }
			
		 else 
		 {
			 newNode.next=head;
			 head=newNode;
			 return ;
		 }
	 }
	 
	 public void insertMid(int afterValue, int value)
	 {
		 Node temp=head;
		 Node newNode=new Node(value);
		 if(head==null)
		 {
			 System.out.println("Linked list is null");
			 return;
		 }
		 else
		 {
			 while(temp.data!=afterValue && temp.next!=null)
				 temp=temp.next;
			 if(temp.data==afterValue)
			 {
				 newNode.next=temp.next;
				 temp.next=newNode;
			 }
			 else
			 {
				 System.out.println("After value not found");
			 }
			 
		 }
		 
	 }
	 
	 Node reverseLinkedList(Node head)
	 {
		 Node p=head;
		 if(head==null || head.next==null)
			 return head;

		 Node q=p.next;
		 Node r=q.next;
		 p.next=null;
		 while(r!=null)
		 {
			 q.next=p;
			 p=q;
			 q=r;
			 r=r.next;					 
		 }
		 q.next=p;
		 head=q;
		return head;
		 
	 }

	 Node addLists(Node first, Node second)
	 {
		 if(first!=null)
		        first=reverseLinkedList(first);
		        if(second!=null)
		        second=reverseLinkedList(second);
		        int c=0;
		        Node p=first, q=second,r=null,r1=null;
		        while(p!=null && q!=null)
		        {
		            int s=p.data+q.data+c;
		            c=s/10;
		            s=s%10;
		            
		            if(r==null)
		            r=new Node(s);
		            else
		            {
		                r1=new Node(s);
		                r1.next=r;
		                r=r1;
		            }
		            
		        
		        
		            
		        }
		            
		        
		        return r;
		        
		        
		    
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Linkedlist ll=new Linkedlist();
		Linkedlist l2=new Linkedlist();
		
		ll.addAtLast(5);
		ll.addAtLast(4);
		ll.addAtLast(12);
		ll.addAtLast(10);
		
		l2.addAtLast(4);
		l2.addAtLast(6);
		l2.addAtLast(1);
		l2.addAtLast(0);
		
	
		
		ll.traverse();
//		ll.delete(12);//(value)
//		System.out.println();
//		ll.traverse();
//		ll.insertStart(3);//(value)
//		System.out.println();
//		ll.traverse();
//		ll.insertMid(4,11);//(after value, value)
//		System.out.println();
//		ll.traverse();
//		ll.insertMid(9,20);
//		System.out.println();
//		ll.traverse();
//		ll.addAtLast(14);
//		ll.addAtLast(12);
//		ll.addAtLast(30);
//		System.out.println();
//		ll.traverse();
//		System.out.println("\nreverse");
//		ll.reverseLinkedList(ll.head);
//		ll.traverse();
//		System.out.println();
//		System.out.println("middle-"+ll.middle(ll.head).data);
	}

}
