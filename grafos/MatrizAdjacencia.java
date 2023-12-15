package grafos;
import java.util.*;

public class MatrizAdjacencia {
	
	private int[][]G;
	private int[][]E;
	private int numVertices;
	private boolean ponderado;
	private boolean direcionado;
	
	public MatrizAdjacencia(int numVertices, boolean ponderado, boolean direcionado) {
		this.numVertices = numVertices;
		this.direcionado = direcionado;
		this.ponderado = ponderado;
		G = new int[numVertices][numVertices];
	}
	
	public void inserirAresta(int vertice1, int vertice2) {
		if(!ponderado) {
			G[vertice1][vertice2] = 1;
			
			if(!direcionado) {
				G[vertice2][vertice1] = 1;
 			}
		}
		else {
			System.out.println("Grafo ponderado. Necessita peso da aresta.");
		}
	}
	
	//Implementação dos demais algoritmos
	
	//Método de remoção
	
	public void excluirVertice(int vertice) {
		E = new int[G[0].length - 1][G[0].length - 1];
		int contador_a = -1;
		int contador_b = -1;
		for(int i = 0; i < G[0].length; i++) {
			contador_b = -1;
			if(i != vertice) {
				contador_a += 1;
			}
			for(int j = 0; j < G[0].length; j++) {
				if(i != vertice && j != vertice) {
					contador_b += 1;
					E[contador_a][contador_b] = G[i][j];
				}
			}
		}
	}
	
	//Método que verifica se o caminho é Hamiltoniano
	
	public boolean verificaCaminhoHamiltoniano() {
        boolean[] visitado = new boolean[numVertices];

        // Verifica se existe um caminho Hamiltoniano iniciando de cada vértice
        for (int i = 0; i < numVertices; i++) {
            Arrays.fill(visitado, false);
            if (dfsParaHamiltoniano(i, visitado, 1)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfsParaHamiltoniano(int vertice, boolean[] visitado, int instackCount) {
        if (instackCount == numVertices) {
            return true;
        }

        visitado[vertice] = true;

        for (int i = 0; i < numVertices; i++) {
            if (G[vertice][i] == 1 && !visitado[i]) {
                if (dfsParaHamiltoniano(i, visitado, instackCount + 1)) {
                    return true;
                }
            }
        }

        visitado[vertice] = false;
        return false;
    }
	
	public void inserirAresta(int vertice1, int vertice2, int peso) {
		if(ponderado) {
			G[vertice1][vertice2] = peso;
			if(!direcionado) {
				G[vertice2][vertice1] = peso;
			}
		}
		else {
			System.out.println("Grafo não ponderado. Arestas não possuem pesos.");
		}
	}
	
	public void removerAresta(int vertice1, int vertice2) {
		G[vertice1][vertice2] = 0;
		if(!direcionado) {
			G[vertice2][vertice1] = 0;
		}
	}
	
	public void mostrarMatrizAdjacenciaG() {
		for(int i = 0; i < numVertices; i++) {
			for(int j = 0; j < numVertices; j++) {
				System.out.print(G[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void mostrarMatrizAdjacenciaE() {
		for(int i = 0; i < numVertices - 1; i++) {
			for(int j = 0; j < numVertices - 1; j++) {
				System.out.print(E[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void mostrarAdjacencia(int vertice1, int vertice2) {
		if(G[vertice1][vertice2] != 0 || G[vertice2][vertice1] != 0) {
			System.out.println("Adjacentes!");
		}
		else {
			System.out.println("Não adjacentes!");
		}
	}
}
