package MST;


public class UnionFind_최적화 {
	static int[] root;
	static int[] rank; // rank에 트리의 높이를 저장 : 항상 높이가 더 낮은 트리를 높은 트리 밑에 넣는
	static void makeSet(int x) {
		root[x] = x; // 루트를 자신으로 
		rank[x] = 0; // 트리의 높이 초기화 
	}
	static int find(int x) {
		if(root[x]==x) {
			return x;
		}
		else {
			// <경로 압축> 
			// find 하면서 만난 모든 값의 부모 노드를 root로 만든다.
			return root[x] = find(root[x]);
		}
	}
	static void union(int x, int y) {
		// 각 원소가 속한 트리의 루트 노드를 찾는다.
		x = find(x);
		y = find(y);
		
		// 두 값의 root가 같다 (이미 같은 트리)
		if(x==y) return;
		
		// <union-by-rank>
		// 항상 높이가 더 낮은 트리를 높은 트리 밑에 넣는다. (높은 쪽을 root로 삼는다)
		if(rank[x]<rank[y]) {
			root[x] = y;
		} else {
			root[y] = x;
		}
		
		if(rank[x]==rank[y]) {
			rank[x]++; // 높이가 같다면 x의 높이를 하나 높여주기 
		}
	}
	
	
	
	
	
	
	// 루트 노드의 자식 수 저장 
	static int[] cnt=new int[100];
	void init() {
		for(int i=0; i<cnt.length; i++) {
			cnt[i] = 1;
		}
	}
	// 두 원소가 속한 트리의 전체 노드 수 구하기
	static int cntNodes(int x, int y) {
		int rx = find(x);
		int ry = find(y);
		// 두 값의 root가 같지 않으면 
		if(rx!=ry) {
			root[ry] = rx;
			
			cnt[rx] += cnt[ry];
			cnt[ry] = 1;
		}
		
		return cnt[rx];
	}
	public static void main(String[] args) {
		
		
	}

}
