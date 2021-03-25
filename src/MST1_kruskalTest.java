
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST1_kruskalTest {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V, E;
	static int parents[];
	static Edge[] edgeList;

	static void make() {// 크기가 1인 단위집합을 만든다.
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (parents[a] == a) {
			return a;
		}
		// return findSet(parents[a]); //path compression전
		return parents[a] = findSet(parents[a]);// path compression 후
	}

	static boolean union(int a, int b) {
	        int aRoot=findSet(a);
	        int bRoot=findSet(b);
	        if (aRoot == bRoot) return false;

	        parents[bRoot] = a;
	        return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 V = Integer.parseInt(st.nextToken());
		 E = Integer.parseInt(st.nextToken());
		parents = new int[V];
		edgeList = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		//간선의 가중치 오름차순정렬
		Arrays.sort(edgeList);
	
		make();
		int result = 0;
		int count =0;//선택한 간선수
		
		for(Edge edge:edgeList) {
			if(union(edge.from,edge.to)) {//싸이클이 발생하지 않았다면
				result+=edge.weight;
				if(++count==V-1)break;
			}
		}
		System.out.println(result);
	}
}
