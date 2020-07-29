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
			int t=0;
			while(true)
			{
				int p=s.nextInt();
				if(p==0) break;
				LinkedList<Pair> l=new LinkedList<>();
				ArrayList<Pair>  m1=new ArrayList<>();
				int dist[][]=new int[2001][2001];
				for(int i=0;i<2001;i++)
					for(int j=0;j<2001;j++) 
						dist[i][j]=Integer.MAX_VALUE;
				int u,v;
				int mark[][]=new int[2001][2001];
				while(p-->0)
				{
					u=s.nextInt();v=s.nextInt();
					l.add(new Pair(u,v));
					dist[u][v]=0;
				}
				p=s.nextInt();
				ArrayList<Pair> m2=new ArrayList<>();
				while(p-->0)
				{
					u=s.nextInt();v=s.nextInt();
					mark[u][v]=1;
				}
				// int temparray[4][]
				int ans=Integer.MAX_VALUE;
				while(l.size()!=0)
				{
					Pair top = l.pollFirst();
					u=top.x;v=top.y;
					if(mark[u][v]==1) ans=Integer.min(ans,dist[u][v]);
					if(v+1<2001 && dist[u][v+1]==Integer.MAX_VALUE) {l.addLast(new Pair(u,v+1));dist[u][v+1]=dist[u][v]+1;}
					if(v-1>=0 && dist[u][v-1]==Integer.MAX_VALUE) {l.addLast(new Pair(u,v-1));dist[u][v-1]=dist[u][v]+1;}
					if(u+1<2001 && dist[u+1][v]==Integer.MAX_VALUE) {l.addLast(new Pair(u+1,v));dist[1+u][v]=dist[u][v]+1;}
					if(u-1>=0 && dist[u-1][v]==Integer.MAX_VALUE){ l.addLast(new Pair(u-1,v));dist[u-1][v]=dist[u][v]+1;}
				}

				System.out.println(ans);
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
