package grafos;

public class MainMatrizAdjacencia {

	public static void main(String[] args) {
		
		int numVertices = 4;
		MatrizAdjacencia grafo = new MatrizAdjacencia(numVertices, false, true);
		grafo.inserirAresta(0, 1);
		grafo.inserirAresta(1, 2);
		grafo.inserirAresta(2, 3);
		grafo.inserirAresta(3, 0);

		
		System.out.println();
		System.out.println();
		grafo.mostrarMatrizAdjacenciaG();			
		System.out.println("----------");
		System.out.println(grafo.verificaCaminhoHamiltoniano());
		
	}
}
