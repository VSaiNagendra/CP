// Working program using Reader Class 
import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*; 
import java.util.StringTokenizer; 
import java.math.*;

 class Pair{
	int x,y;
	Pair(int x,int y)
	{
		this.x=x;this.y=y;
	}
}
class Pairs{
	double x;
	int y,z;
	Pairs(double x,int y,int z)
	{
		this.x=x;this.y=y;this.z=z;
	}
}

 class Main 
{ 
	public static int findset(int u,int []p)
	{
		if (p[u]==u) return u;
		p[u]=findset(p[u],p);
		return p[u];
	}
	public static int sqr(Pair a , Pair b)
	{
		return (a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y);
	}
	public static void main(String[] args) throws IOException 
		{ 
			Reader s=new Reader(); 
			int t=s.nextInt();
			int temp=t;
			t=0;
			while(t<temp)
			{
				int n=s.nextInt();
				Pair coordinates[]=new Pair[n];
				double roads=0,rails=0;
				double r = s.nextDouble();
				int p[]=new int[n];
				for(int i=0;i<n;i++) {
					p[i]=i;
				 	coordinates[i]=new Pair(s.nextInt(),s.nextInt());
				}
				ArrayList<Pairs> edges = new ArrayList<Pairs>();
				for(int i=0;i<n;i++)
				{
					for(int j=i+1;j<n;j++) {
						edges.add(new Pairs(Math.sqrt(sqr(coordinates[j],coordinates[i])),i,j));
					}
				}
				edges.sort(new Comparator<Pairs>(){
					public int compare(Pairs a,Pairs b)
					{
						if(a.x<b.x) return -1;
						else return 1;
					}
				});
				int e=0;
				int count=0;
				for(int i=0;i<edges.size() && e<n-1;i++) {
					int u=edges.get(i).y,v=edges.get(i).z;
					// System.out.println(roads+" "+rails+" "+u+" "+v+" "+edges.get(i).x);
					if(findset(u,p)==findset(v,p)) continue;
					p[p[u]]=p[v];
					e++;
					// System.out.println(roads+" "+rails+" "+u+" "+v+" "+edges.get(i).x);
					if(edges.get(i).x<r) 
						roads+=edges.get(i).x;
					else
						{rails+=edges.get(i).x;
						count+=1;
					}
				}
				System.out.println("Case #"+(t+1)+": "+(count+1)+" "+Math.round(roads)+" "+Math.round(rails));
				t++;
			}
		} 
	static class Reader 
	{ 
		final private int BUFFER_SIZE = 1 << 16; 
		private DataInputStream din; 
		private byte[] buffer; 
		private int bufferPointer, bytesRead; 

		public Reader() 
		{ 
			din = new DataInputStream(System.in); 
			buffer = new byte[BUFFER_SIZE]; 
			bufferPointer = bytesRead = 0; 
		} 

		public Reader(String file_name) throws IOException 
		{ 
			din = new DataInputStream(new FileInputStream(file_name)); 
			buffer = new byte[BUFFER_SIZE]; 
			bufferPointer = bytesRead = 0; 
		} 

		public String readLine() throws IOException 
		{ 
			byte[] buf = new byte[64]; // line length 
			int cnt = 0, c; 
			while ((c = read()) != -1) 
			{ 
				if (c == '\n') 
					break; 
				buf[cnt++] = (byte) c; 
			} 
			return new String(buf, 0, cnt); 
		} 

		public int nextInt() throws IOException 
		{ 
			int ret = 0; 
			byte c = read(); 
			while (c <= ' ') 
				c = read(); 
			boolean neg = (c == '-'); 
			if (neg) 
				c = read(); 
			do
			{ 
				ret = ret * 10 + c - '0'; 
			} while ((c = read()) >= '0' && c <= '9'); 

			if (neg) 
				return -ret; 
			return ret; 
		} 

		public long nextLong() throws IOException 
		{ 
			long ret = 0; 
			byte c = read(); 
			while (c <= ' ') 
				c = read(); 
			boolean neg = (c == '-'); 
			if (neg) 
				c = read(); 
			do { 
				ret = ret * 10 + c - '0'; 
			} 
			while ((c = read()) >= '0' && c <= '9'); 
			if (neg) 
				return -ret; 
			return ret; 
		} 

		public double nextDouble() throws IOException 
		{ 
			double ret = 0, div = 1; 
			byte c = read(); 
			while (c <= ' ') 
				c = read(); 
			boolean neg = (c == '-'); 
			if (neg) 
				c = read(); 

			do { 
				ret = ret * 10 + c - '0'; 
			} 
			while ((c = read()) >= '0' && c <= '9'); 

			if (c == '.') 
			{ 
				while ((c = read()) >= '0' && c <= '9') 
				{ 
					ret += (c - '0') / (div *= 10); 
				} 
			} 

			if (neg) 
				return -ret; 
			return ret; 
		} 

		private void fillBuffer() throws IOException 
		{ 
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
			if (bytesRead == -1) 
				buffer[0] = -1; 
		} 

		private byte read() throws IOException 
		{ 
			if (bufferPointer == bytesRead) 
				fillBuffer(); 
			return buffer[bufferPointer++]; 
		} 

		public void close() throws IOException 
		{ 
			if (din == null) 
				return; 
			din.close(); 
		} 
	} 
} 
