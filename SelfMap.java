package Java_DataStructure;

public class SelfMap {

	public static void main(String[] args) {
		
		

	}

}

class Key
{
	char c;
	Key(char c)
	{
		this.c=c;
		
	}
	
	int hashcode(char c)
	{
		return (int)this.c;
	}
	boolean equal(Object o)
	{
		return c==(char)0;
	}
}

class Node
{
	int hashcode;
	Key k;
	int val;
	Node next;
	
	void put( Key k, int val)
	{
		hashcode=(int)k.c;
		this.k=k;
		this.val=val;
		next=null;
		
		
	}
}
