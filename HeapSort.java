package Java_DataStructure;

public class HeapSort {
	
	void sort(int[] a,int n)
	{
		buildMaxHeap(a, n);
		for(int i=n-1;i>=1;i--)
		{
			int t=a[i];
			a[i]=a[0];
			a[0]=t;
			n--;
			maxHeapify(a, n, 0);
		}
	}

	void buildMaxHeap(int[] a, int n)
	{
		for(int i=n/2-1;i>=0;i--)
			maxHeapify(a, n, i);
	}
	
	void maxHeapify(int[] a,int n,int i)
	{
		int l=2*i+1;
		int r=2*i+2;
		
		int largest=i;
		
		if(l<n && a[l] > a[largest])
			largest=l;
		if(r<n && a[r]>a[largest])
			largest=r;
		if(largest!=i)
		{
			int t=a[i];
			a[i]=a[largest];
			a[largest]=t;
			
			maxHeapify(a, n, largest);
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {2,6,4,5,8,7,9,11,15,12};
		HeapSort hs=new HeapSort();
		hs.sort(a, a.length);
		
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");

	}

}
