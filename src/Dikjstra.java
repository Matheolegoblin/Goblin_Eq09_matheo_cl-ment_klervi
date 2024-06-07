import java.util.*;


import java.io.File;
import java.sql.*;
public class Dikjstra {

	public static void dijkstra(Client matrice, int start) {
		int n = matrice.getNb();
        boolean[] mark = new boolean[n];
        int[] val = new int[n];
        int[] pred = new int[n];
        
        Arrays.fill(val, Integer.MAX_VALUE / 2);
        Arrays.fill(pred, -1);

        val[start] = 0;
        pred[start] = start;
        
	}
	
	
	private static Map<Integer, Map<Integer, Integer>> buildGraph() {
		Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

		try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:database"+File.separator+"basic;shutdown=true", "sa", "");
				Statement statement = connection.createStatement();
				ResultSet resultset = statement.executeQuery("SELECT * FROM Routes")) {

			while (resultset.next()) {
				int origine = resultset.getInt("origine");
				int destination = resultset.getInt("destination");
				int distance = resultset.getInt("distance");

				graph.putIfAbsent(origine, new HashMap<>());
				graph.putIfAbsent(destination, new HashMap<>());

				graph.get(origine).put(origine, distance);
				graph.get(destination).put(destination, distance);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return graph;
	}

	public static Map<Integer, Integer> dijkstra(int start) {
		Map<Integer, Map<Integer, Integer>> graph = buildGraph();
		Map<Integer, Integer> distances = new HashMap<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

		distances.put(start, 0);
		pq.add(new int[]{start, 0});

		while (!pq.isEmpty()) {
			int[] current = pq.poll();
			int node = current[0];
			int distance = current[1];

			if (distance > distances.get(node)) continue;

			for (Map.Entry<Integer, Integer> neighbor : graph.get(node).entrySet()) {
				int newDist = distance + neighbor.getValue();
				if (newDist < distances.getOrDefault(neighbor.getKey(), Integer.MAX_VALUE)) {
					distances.put(neighbor.getKey(), newDist);
					pq.add(new int[]{neighbor.getKey(), newDist});
				}
			}
		}

		return distances;
	}

	public static void main(String[] args) {
		Map<Integer, Integer> distances = dijkstra(1); // Starting from position 1
		distances.forEach((k, v) -> System.out.println("Distance to " + k + " is " + v));
	}
}
