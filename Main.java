import java.util.ArrayList;
import java.util.Scanner;

class Node {
	int node;
	Node parent;

	Node(int node) {
		this.node = node;
	}
}

public class Main {
	static ArrayList<ArrayList<Node>> graph;
	static boolean visit[];
	static int parent[];

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		graph = new ArrayList<>();
		visit = new boolean[n];
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < n - 1; i++) {
			int a = input.nextInt()-1;
			int b = input.nextInt()-1;
			graph.get(a).add(new Node(b));
			graph.get(b).add(new Node(a));
		}
		visit[0] = true;
		dfs(0);
		for (int i = 1; i < n; i++) {
			System.out.println(parent[i] + 1);
		}
	}

	private static void dfs(int cur) {
		for (Node next : graph.get(cur)) {
			if (!visit[next.node]) {
				visit[next.node] = true;
				parent[next.node] = cur;
				dfs(next.node);
				visit[next.node] = false;
			}
		}
	}
}
