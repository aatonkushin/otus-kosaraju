import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Реализация алгоритма Косарайю
 */
public class Kosaraju {
    // Поиск в глубину (DFS)
    public void dfs(List<Integer>[] graph, int v, boolean[] visited, List<Integer> comp) {
        visited[v] = true;
        for (int i = 0; i < graph[v].size(); i++)
            if (!visited[graph[v].get(i)])
                dfs(graph, graph[v].get(i), visited, comp);
        comp.add(v);
    }

    // Заполнение графа
    public List<Integer> fillOrder(List<Integer>[] graph, boolean[] visited) {
        int v = graph.length;
        List<Integer> order = new ArrayList<Integer>();

        for (int i = 0; i < v; i++)
            if (!visited[i])
                dfs(graph, i, visited, order);
        return order;
    }


    // построение обратного графа
    public List<Integer>[] getTranspose(List<Integer>[] graph)
    {
        int V = graph.length;
        List<Integer>[] g = new List[V];
        for (int i = 0; i < V; i++)
            g[i] = new ArrayList<Integer>();
        for (int v = 0; v < V; v++)
            for (int i = 0; i < graph[v].size(); i++)
                g[graph[v].get(i)].add(v);
        return g;
    }

    //Поиск компонент сильной связности
    public List<List<Integer>> getSCComponents(List<Integer>[] graph)
    {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        List<Integer> order = fillOrder(graph, visited);

        // получаем обратный граф
        List<Integer>[] reverseGraph = getTranspose(graph);

        // очищаем массив посещённых узлов
        visited = new boolean[V];

        // меняем порядок
        Collections.reverse(order);

        // получаем сильно связанные узлы
        List<List<Integer>> SCComp = new ArrayList<>();
        for (int i = 0; i < order.size(); i++)
        {
            int v = order.get(i);
            if (!visited[v])
            {
                List<Integer> comp = new ArrayList<>();
                dfs(reverseGraph, v, visited, comp);
                SCComp.add(comp);
            }
        }
        return SCComp;
    }
}
