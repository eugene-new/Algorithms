package MST;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
	static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		int cost;

		Edge(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.cost < o.cost)
				return -1;
			else if (this.cost == o.cost)
				return 0;
			else
				return 1;
		}
	}

	static int[] root;
	static ArrayList<Edge> edgeList;

	static int find(int x) {
		if (root[x] == x)
			return x;
		return root[x] = find(root[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			root[y] = x;
		}
	}
	static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) return true;
		else return false;
	}
	public static void main(String[] args) {

		edgeList = new ArrayList<Edge>();
		edgeList.add(new Edge(1, 4, 4));
		edgeList.add(new Edge(1, 2, 6));
		edgeList.add(new Edge(2, 3, 5));
		edgeList.add(new Edge(2, 4, 3));
		edgeList.add(new Edge(2, 5, 7));
		edgeList.add(new Edge(2, 6, 8));
		edgeList.add(new Edge(3, 6, 8));
		edgeList.add(new Edge(4, 5, 9));
		edgeList.add(new Edge(5, 6, 11));
		
		root = new int[7];
		// 1. makeSet
		for(int i=1; i<=6; i++) {
			root[i] = i;
		}
		
		// 2. 간선의 가중치 기준 오름차순으로 정렬 
		Collections.sort(edgeList);
		
		// 3. 간선이 같은 집합에 있는지 확인하고 아니면 추가 
		int sum = 0; // MST의 비용 
		for(int i=0; i<edgeList.size(); i++) {
			// 간선 꺼내기 
			Edge edge = edgeList.get(i);
			// 같은 집합에 속하는지 확인 
			if(!isSameParent(edge.v1, edge.v2)) {
				// 다른 집합에 속해 있으면 
				sum += edge.cost; // 가중치 더해주기 
				union(edge.v1, edge.v2); // union해서 같은 집합으로 만들기 
			}
		}
		System.out.println(sum);
	}
	

}
