package MST;


public class UnionFind {
	static int[] root;
	static void makeSet(int x) {
		root[x] = x;
	}
	static int find(int x) {
		if(root[x]==x) {
			return x;
		}
		else {
			return find(root[x]);
		}
	}
	static void union(int x, int y) {
		// x와 y의 루트 노드를 찾는다.
		int px = find(x);
		int py = find(y);
		
		// y의 루트를 x의 루트로 
		root[py] = px;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
