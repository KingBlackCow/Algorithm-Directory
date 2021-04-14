package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1194_달이차오른다가자 {
	static int N, M;
	static char[][] map;
	static int result = 987654321;
	static boolean[][][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static class Node{
		int r, c, key, cnt;
		Node(int r, int c, int key, int cnt){
			this.r = r;
			this.c = c;
			this.key = key;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		visited = new boolean[N][M][1<<6];
		Node start = null;
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++) {
				if(map[i][j] == '0') {
					//여기가 시작점.
					start = new Node(i,j,0,0);
				}
			}
		}
		//큐를 준비하고.
		Queue<Node> q = new LinkedList<>();
		//시작점을 큐에 넣고 방문췌크
		q.offer(start);
		visited[start.r][start.c][start.key] = true;
		//큐가 빌때까지.
		while(!q.isEmpty()) {
			//하나꺼내서. 
			Node n = q.poll();
			//도착하면 끝.
			if(map[n.r][n.c] == '1') {
				System.out.println(n.cnt);
				return;
			}
			//아니면 4방에 대해서
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				int nKey = n.key;
				int nCnt = n.cnt + 1;
				//	범위벗어나면 패스
				if( nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				//	벽이라 못가면 패스
				if(map[nr][nc] == '#')
					continue;
				//	키를 찾았으면 비트마스킹에 키를 추가
				if( 'a' <= map[nr][nc] && map[nr][nc] <= 'f')
					nKey |= (1<< (map[nr][nc]- 'a') );
				//	A-F(문)이면 키가 없으면 패스
				if( 'A' <= map[nr][nc] && map[nr][nc] <= 'F') {
					if( (nKey & (1 << (map[nr][nc] - 'A'))) == 0 )
						continue;
				}
				//	방문한적이 있으면 패스
				if(visited[nr][nc][nKey])
					continue;
				//	방문체크하고 큐에 삽입
				visited[nr][nc][nKey] = true;
				q.offer(new Node(nr, nc, nKey, nCnt));
			}
		}
		System.out.println(-1);
	}
}
