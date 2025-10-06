package Java_DataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class SegmentTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int i=1;
		while(i<2*n-1)
			i=2*i;
		int st[]=new int[i];
		Arrays.fill(st, -1);
		createSegmentTree(st,0,a,0,n-1);
		
		for(i=0;i<st.length;i++)
			System.out.print(st[i]+" ");
		
		System.out.println(rangeSum(st, 0, 0, n-1, 0, 7));
		
		

	}

	public static int createSegmentTree(int[] st, int i, int[] a, int l, int r) {
		// TODO Auto-generated method stub
		
		if(l==r)
		{
			st[i]=a[l];
			return a[l];
		}
		int m=(l+r)/2;
		st[i]=createSegmentTree(st,2*i+1, a, l, m)
				+ createSegmentTree(st, 2*i+2, a,m+1,r);
		
		return st[i];
				
			
	}
	
	public static int rangeSum(int[] st,int i, int sl,int  sr, int l , int r)
	{
		if(l<=sl && sr<=r)
			return st[i];
		
		if(l>sr || sl>r)
			return 0;
		
		int m=(sl+sr)/2;
		 return rangeSum(st,2*i+1, sl, m, l, r)
				 + rangeSum(st, 2*i+2, m, sr, l, r);
			
	}

	public static void update(int st[],int i,int sl , int sr, int pos, int diff)
	{
		if(pos<sl || sr<pos)
			return;
		st[i]+=diff;
		
		int m=(sl+sr)/2;
		update(st, 2*i+1, sl, m, pos, diff);
		update(st, 2*i+2, m , sr, pos, diff);
	}

}
