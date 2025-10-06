package Java_DataStructure;

//import java.util.Stack;
 class Stack {
	
	Node top;
	
	public class Node{
		int data;
		Node next;	
		
		Node(int data){
		this.data=data;
		next=null;
		}
		
	}
	
	void push(int data)
	{
		Node t=new Node(data);
		if(top==null)
			top=t;
		else
		{
			t.next=top;
			top=t;
		}
			
	}
	
	int pop()
	{
		int t=top.data;
		top=top.next;
		return t;
	}
	
	int peek()
	{
		int t=top.data;
		return t;
	}
	void traverse()
	{
		Node t=top;
		while(t!=null)
		{
			System.out.print(t.data+" ");
			t=t.next;
		}
	}
	
	 public boolean balancedParenthesis(String s) {
	        
		 java.util.Stack<Character> st=new  java.util.Stack<>();
	         boolean b=true;
	        for(int i=0;i<s.length();i++)
	        {
	            char ch=s.charAt(i);
	            
	            
	            
	            if(ch=='(' || ch=='[' || ch=='{'){
	            st.push(ch);
	           
	            }
	            
	            if(st.empty())
	            {
	                st.push(ch);
	                b=false;
	                break;
	            }
	            
	            
	            else if(ch==')')
	            {
	                if(st.peek()=='(')
	                st.pop();
	                else {
	                b=false;
	                break;
	                }
	            }
	            else if(ch==']')
	            {
	                if(st.peek()=='[')
	                st.pop();
	                else {
	                b=false;
	                break;
	                }
	            }
	            else if(ch=='}')
	            {
	                if(st.peek()=='{')
	                st.pop();
	                else {
	                b=false;
	                break;
	                }
	            }
	        }
	        if(st.empty())
	        b=true;
	        else 
	        b=false;
	        
	        return b;
	             
	        
	    }
	
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack st=new Stack();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);
		st.push(7);
		st.push(8);
		st.push(9);
		st.push(10);
		st.traverse();
		System.out.println();
		System.out.println("pop-"+st.pop());
		System.out.println("pop-"+st.pop());
		System.out.println("peek-"+st.peek());
		System.out.println();
		st.traverse();
		

	}

}
