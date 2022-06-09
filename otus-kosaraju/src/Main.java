import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Тест алгоритма Косарайю\n");
        Kosaraju k = new Kosaraju();

        System.out.println("Введите количество вершин");
        // количество верин
        int V = scan.nextInt();
        List<Integer>[] g = new List[V];
        for (int i = 0; i < V; i++)
            g[i] = new ArrayList<Integer>();

        System.out.println("\nВведите количество рёбер");
        int E = scan.nextInt();
        // Рёбра
        System.out.println("Введите "+ E +" координат x, y");
        for (int i = 0; i < E; i++)
        {
            int x = scan.nextInt();
            int y = scan.nextInt();

            // добавляем ребро
            g[x].add(y);
        }
        System.out.println("\nКомпоненты сильной связности : ");

        // Печать компонентов сильной связности
        List<List<Integer>> scComponents = k.getSCComponents(g);
        System.out.println(scComponents);
    }
}