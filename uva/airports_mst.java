 import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*; 
import java.util.StringTokenizer; 
import java.math.*;

class Pairs{
	int x;
	int y,z;
	Pairs(int x,int y,int z)
	{
		this.x=x;this.y=y;this.z=z;
	}
}

class Main
{ 
	static class UnionFind
	{
		int[] set,rank;
		int numSets;
		public UnionFind(int n)
		{
			numSets = n;
			set = new int[n];
			rank = new int[n];
			for (int i = 0; i < rank.length; i++) {
				set[i] = i;
				rank[i] = 1;
			}
		}
		public int find(int x)
		{
			return (set[x]==x)?x:(set[x]=find(set[x]));
		}
		public void union(int a,int b)
		{
			int x = find(a) , y = find(b);
			if(isSameSet(a, b))
				return;
			if(rank[x]>rank[y])
				set[y] = x;
			else
			{
				set[x] = y;
				if(rank[x]==rank[y])
					rank[y]++;
			}
			numSets--;
		}
		public boolean isSameSet(int a,int b)
		{
			return find(a)==find(b);
		}
	}
	public static void main(String[] args) 
		{ 
			
			Scanner s=new Scanner(System.in); 
			try{
			int t=s.nextInt();
			int temp=t;
			t=0;
			StringBuilder sb = new StringBuilder();
			ArrayList<Pairs> edges=new ArrayList<Pairs>();
			UnionFind uf=new UnionFind(1);
			int n=0,m=0,cost=0;

			while(t<temp)
			{
				
				 n=s.nextInt();
				m = s.nextInt();
				cost = s.nextInt();
				// int p[]=new int[n+1];
				
				edges = new ArrayList<Pairs>();
				uf = new UnionFind(n);
				
				
				for(int i=0;i<m;i++) {
				 	edges.add(new Pairs(s.nextInt()-1,s.nextInt()-1,s.nextInt()));
				}
				
				if(edges.size()>1)
				{edges.sort(new Comparator<Pairs>(){
					public int compare(Pairs a,Pairs b)
					{
						if(a.z<b.z) return -1;
						else return 1;
					}
				});
				}
				int e=0;
				int count=0;
				long ans=0;
		
				for(int i=0;i<edges.size() && e<n-1;i++) {
					int u=edges.get(i).x,v=edges.get(i).y;
					// System.out.println(u+" "+v+" "+edges.get(i).z);
					if(uf.isSameSet(u, v)) continue;
					
						// System.out.println(u+" "+v+" "+edges.get(i).z);
					if(edges.get(i).z>=cost)
					 break;
					uf.union(u,v);
					ans+=edges.get(i).z;
					e++;
					}
					// System.out.println(ans);
				sb.append("Case #"+(t+1)+": "+(ans+(uf.numSets)*cost)+" "+(uf.numSets)+"\n");
				t++;
			}
			System.out.println(sb);
			}
		catch(Exception eee)
		{
			System.exit(0);
		}
		
		} 
	
}
