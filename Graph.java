package Java_DataStructure;

import java.util.*;



public class Graph {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		
		ArrayList<ArrayList<Integer>> al =
									new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<v;i++)
			al.add(new ArrayList<Integer>());
		
		int[][] edge=new int[e][2];
		for(int i=0;i<e;i++)
		{
			edge[i][0]=sc.nextInt();
			edge[i][1]=sc.nextInt();
		}
		
		for(int i=0;i<e;i++)
			addEdge(al,edge[i][0],edge[i][1]);
		
//		bfs(v,al);
//		System.out.println();
//		dfs(v,al);
		System.out.println("----cycle in graph--"+cycle(v,al));
		System.out.println("-------topo sort----------");
		
		int x[]=topoSort(v,al);
		for(int i=0;i<x.length;i++)
			System.out.print(x[i]+" ");
		

	}

	private static void dfs(int V, ArrayList<ArrayList<Integer>> al) {
		// TODO Auto-generated method stub
		 ArrayList<Integer> l=new ArrayList<>();
	        java.util.Stack<Integer> st=new java.util.Stack<>();
	        boolean visited[]=new boolean[V];
	        Arrays.fill(visited,false);
	        for(int i=0; i<al.size(); i++)           
	            if(al.get(i)!=null){
	            st.push(i);
	            visited[i]=true;
	            break;
	                
	            }
	            
	            while(!st.isEmpty())
	            {
	                int i=st.pop();
	                //l.add(i);
	                System.out.print(i+" ");
	                Iterator itr=al.get(i).iterator();
	                while(itr.hasNext())
	                {
	                    int x=(Integer)itr.next();
	                   if(!visited[x])
	               {
	                   visited[x]=true;
	                   st.push(x);
	                   
	               }
	                }       
	                
	            }
	           // return l;
		
	}

	public static void bfs(int V, ArrayList<ArrayList<Integer>> al) {
		
		Queue<Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[V];
        Arrays.fill(visited,false);
        //ArrayList<Integer> al=new ArrayList<>();
        
        for(int i=0; i<al.size(); i++)           
            if(al.get(i)!=null){
            q.add(i);
            visited[i]=true;
            break;
                
            }
        while(!q.isEmpty())
        {
            int i=q.poll();
            System.out.print(i+" ");
            


           Iterator itr = al.get(i).iterator();
           
           while(itr.hasNext())
           {
               int x=(Integer)itr.next();
               if(!visited[x])
               {
                   visited[x]=true;
                   q.add(x);
                   
               }
           }
           
        }
		
	}

	public static void addEdge
				(ArrayList<ArrayList<Integer>> al, int i, int j) {
		
		al.get(i).add(j);
	}
	
//	public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
//    {
//        // code here
//        boolean v[]=new boolean[V];
//        Arrays.fill(v,false);
//        for(int i=0;i<V;i++)
//        {
//        	System.out.println("vertex--"+i);
//        	Arrays.fill(v,false);
//            v[i]=true;
//            Iterator itr=adj.get(i).iterator();
//            while(itr.hasNext())
//            {
//                if(dfs((Integer)itr.next(),adj,v))
//                return true;
//            }
//            v[i]=false;
//        }
//        return false;
//        
//    }
//    static boolean dfs(int i,ArrayList<ArrayList<Integer>> adj,boolean[] v)
//    {
//        if(v[i]==true) {
//        	System.out.println(i);
//            return true;
//        }
//            
//        v[i]=true;
//        Iterator itr=adj.get(i).iterator();
//        while(itr.hasNext())
//        {
//            if(dfs((Integer)itr.next(),adj,v))
//            return true;
//            
//        }
//        v[i]=false;
//        return false;
//            
//    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] in=new int[V];
        
        for(int i=0;i<V;i++)
        {
            Iterator itr=adj.get(i).iterator();
            while(itr.hasNext())
            {
                int x=(Integer)itr.next();
                in[x]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++)
        if(in[i]==0)
        q.add(i);
        int[] t_sort=new int[V];
        int j=0;
        while(!q.isEmpty())
        {
            int x=(Integer)q.poll();
            t_sort[j++]=x;
            Iterator itr=adj.get(x).iterator();
            while(itr.hasNext())
            {
                int y=(Integer)itr.next();
                in[y]--;
                if(in[y]==0)
                q.add(y);
            }
            for(int k=0;k<V;k++)
            	System.out.print(in[k]+" ");
            System.out.println(" -- ");
            
        }
       
        return t_sort;
        
    }
    public static boolean cycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
    	int[] in=new int[V];
    	Arrays.fill(in, 0);
    	
    	for(int i=0;i<V;i++)
    	{
    		Iterator itr=adj.get(i).iterator();
    		while(itr.hasNext())
    		{
    			int x=(Integer)itr.next();
    			in[x]++;
    		}
    		
    	}
    	Queue<Integer> q=new LinkedList<>();
    	int c=0;
    	
    	for(int i=0;i<V;i++)
    		if(in[i]==0)
    			q.add(i);
    	
    	while(!q.isEmpty())
    	{
    		int x=q.poll();
    		c++;
    		Iterator itr=adj.get(x).iterator();
    		while(itr.hasNext())
    		{
    			int y=(Integer)itr.next();
    			in[y]--;
    			if(in[y]==0)
    				q.add(y);
    		}
    	}
    	if(c==V)
    		return false;
    	else
    	return true;
    }

}



