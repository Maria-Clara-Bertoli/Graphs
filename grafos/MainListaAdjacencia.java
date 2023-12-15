package grafos;
import java.util.*;

public class MainListaAdjacencia {

	public static void main(String[] args) {
		
		ListaAdjacencia grafo = new ListaAdjacencia(5, false);

		grafo.adicionaAresta(0, 1, 1);  
		grafo.adicionaAresta(2, 3, 1);
		grafo.adicionaAresta(3, 0, 1);
		grafo.adicionaAresta(2, 4, 1);
		grafo.adicionaAresta(1, 4, 1);
		grafo.adicionaAresta(0, 4, 1);
		grafo.adicionaAresta(1, 3, 1);

        
        System.out.println();
        System.out.println();
        System.out.println(grafo.verificaEulerianismo());
//        grafo.mostrarListaAdjacencia();
//        System.out.println(grafo.verificaCompletude(grafo));
        
//        grafo.adicionaAresta(0, 2, 50);
//        grafo.adicionaAresta(0, 1, 80);
//        grafo.adicionaAresta(1, 2, 50);
//        grafo.adicionaAresta(2, 3, 100);
//        grafo.adicionaAresta(1, 3, 120);
//        grafo.adicionaAresta(3, 4, 140);
//        grafo.adicionaAresta(3, 5, 150);
//        grafo.adicionaAresta(3, 6, 110);
//        grafo.adicionaAresta(1, 7, 70);
//        grafo.adicionaAresta(7, 6, 100);
//        grafo.adicionaAresta(7, 8, 80);
//        grafo.adicionaAresta(6, 8, 80);
//        grafo.adicionaAresta(7, 6, 100);
//        grafo.adicionaAresta(6, 5, 80);
//        grafo.adicionaAresta(5, 8, 160);
//        grafo.adicionaAresta(5, 9, 100);
//        grafo.adicionaAresta(9, 8, 160);
//        grafo.adicionaAresta(9, 13, 80);
//        grafo.adicionaAresta(9, 12, 200);
//        grafo.adicionaAresta(12, 11, 70);
//        grafo.adicionaAresta(8, 10, 70);
//        grafo.adicionaAresta(10, 11, 130);
//        grafo.adicionaAresta(12, 13, 150);
//        grafo.adicionaAresta(12, 14, 120);
//        grafo.adicionaAresta(13, 14, 100);
//        grafo.adicionaAresta(11, 16, 50);
//        grafo.adicionaAresta(16, 15, 135);
//        grafo.adicionaAresta(14, 11, 150);
//        grafo.adicionaAresta(14, 15, 80);
//        grafo.adicionaAresta(15, 17, 170);
//        grafo.adicionaAresta(17, 16, 260);
//   
//        System.out.println("Grafo original:");
//        grafo.mostrarListaAdjacencia();
//
//        int origem = 11;
//        int destino = 2;
//
//        List<Integer> caminhoMaisCurto = grafo.dijkstra(origem, destino);
//
//        System.out.println("\nCaminho mais curto de " + origem + " para " + destino + ":");
//        System.out.println(caminhoMaisCurto);
//        System.out.println();
//        System.out.println(grafo.verificaConexao());
//        System.out.println();
//        System.out.println(grafo.verificaCompletude(grafo)); 
//        System.out.println();
//        System.out.println(grafo.verificaEulerianismo());
	}
}
