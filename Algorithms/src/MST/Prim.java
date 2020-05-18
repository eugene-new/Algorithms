// 출처 : https://velog.io/@dudrkdl777
package MST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Prim {
	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
	}
	
	static int V, E;
	static ArrayList<Edge>[] graph; // 인접리스트
	static ArrayList<Edge> mst;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		graph = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			graph[i] = new ArrayList<Prim.Edge>();
		}
		mst = new ArrayList<Prim.Edge>();
		for(int i=0; i<E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			graph[a].add(new Edge(a, b, w));
			graph[b].add(new Edge(a, b, w));
		}
		prim();
		System.out.println(mst);
	}
	static void prim() {
		// 1. 시작점 지정
		// 2. 선택한 정점에 연결된 간선을 pq에 push
		// 3. pq에서 간선을 poll해서 그 끝 정점이 이미 방문한 정점이 아니면 해당 간선 선택
		// 4. 2~3 반복. n-1개 간선이 선택될 때까지 or 모든 정점이 연결될 때까지 
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[10];
		q.offer(1); // 시작점 넣기 
		
		while(!q.isEmpty()) {
			int now = q.poll();
			visit[now] = true;
			
			for(Edge edge: graph[now]) {
				if(!visit[edge.end]) {
					pq.add(edge);
				}
				while(!pq.isEmpty()) {
					Edge next = pq.poll();
					if(!visit[next.end]) {
						q.add(next.end);
						visit[next.end] = true;
						mst.add(next);
						break;
					}
				}
			}
		}
		
		
	}
}
