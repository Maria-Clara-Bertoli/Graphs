package grafos;
import java.util.*;

class Aresta{
	int origem;
	int destino;
	int peso;
	
	public Aresta(int origem, int destino, int peso) {
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
	}
}

public class ListaAdjacencia {
	public int nVertices;
	public List<List<Aresta>>adjacencias;
	public boolean direcionado;
	
	public ListaAdjacencia(int nVertices, boolean direcionado) {
		this.nVertices = nVertices;
		this.direcionado = direcionado;
		this.adjacencias = new ArrayList<>(nVertices);
		for(int i=0; i<nVertices; i++) {
			adjacencias.add(new ArrayList<Aresta>());
		}
	}
	
	//Implementação do algoritmo de Dijkstra
	
	public List<Integer> dijkstra(int origem, int destino) {
        Map<Integer, Integer> distancia = new HashMap<>();
        Map<Integer, Integer> predecessores = new HashMap<>();
        PriorityQueue<No> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(no -> no.distancia));

        for (int i = 0; i < nVertices; i++) {
            distancia.put(i, Integer.MAX_VALUE);
        }

        distancia.put(origem, 0);
        filaPrioridade.add(new No(origem, 0));

        while (!filaPrioridade.isEmpty()) {
            No atual = filaPrioridade.poll();

            if (atual.distancia > distancia.get(atual.vertice)) {
                continue;
            }

            for (Aresta aresta : adjacencias.get(atual.vertice)) {
                int vizinho = aresta.destino;
                int distanciaParaVizinho = atual.distancia + aresta.peso;

                if (distanciaParaVizinho < distancia.get(vizinho)) {
                    distancia.put(vizinho, distanciaParaVizinho);
                    predecessores.put(vizinho, atual.vertice);
                    filaPrioridade.add(new No(vizinho, distanciaParaVizinho));
                }
            }
        }

        return construirCaminho(origem, destino, predecessores);
    }

    private List<Integer> construirCaminho(int origem, int destino, Map<Integer, Integer> predecessores) {
        List<Integer> caminho = new ArrayList<>();
        Integer atual = destino;

        while (atual != null) {
            caminho.add(atual);
            atual = predecessores.get(atual);
        }

        Collections.reverse(caminho);

        return caminho;
    }
	
	static class No {
        int vertice;
        int distancia;

        No(int vertice, int distancia) {
            this.vertice = vertice;
            this.distancia = distancia;
        }
    }
	
	//Iplementação dos demais algoritmos
	
	private  List<Integer> buscaEmLargura(int verticeInicial) {
        boolean[] visitado = new boolean[nVertices];
        List<Integer> verificador = new ArrayList<>();
        //Fila para busca em largura
        Queue<Integer> fila = new LinkedList<>();

        visitado[verticeInicial] = true;
        fila.add(verticeInicial);

//        System.out.println("Resultado da busca em largura a partir do vértice " + verticeInicial + ":");
        while (!fila.isEmpty()) {
            int verticeAtual = fila.poll();
//            System.out.print(verticeAtual + " ");
            verificador.add(verticeAtual); 

            for (Aresta aresta : adjacencias.get(verticeAtual)) {
                int vizinho = aresta.destino;
                if (!visitado[vizinho]) {
                    visitado[vizinho] = true;
                    fila.add(vizinho);
                }
            }
        }
        return verificador;
    }
	
	//Método que verifica a conexão de um grafo
	
	public boolean verificaConexao() {
		List<Integer> verificador = new ArrayList<>();
		boolean trueorfalse = true;
		for(int i = 0; i < nVertices; i++) {
			verificador = buscaEmLargura(i);
			if(verificador.size() != nVertices) {
				trueorfalse = false;
				break;
			}
			else {
				trueorfalse = true;
			}
	    }
		return trueorfalse;
	}
	
	//Método que verifica a completude de um grafo
	
	public boolean verificaCompletude(ListaAdjacencia grafo) {
		boolean trueorfalse = true;
		for(int i = 0; i < nVertices; i++) {
			if(grafo.adjacencias.get(i).size() != nVertices - 1) {
				trueorfalse = false;
				break;
			}
			else {
				trueorfalse = true;
			}
	    }
		return trueorfalse;
	}
	
	public void adicionaAresta(int u, int v, int peso) {
	Aresta aresta = new Aresta(u, v, peso);
	adjacencias.get(u).add(aresta);
	if(!direcionado) {
		Aresta arestainvertida = new Aresta(v, u, peso);
		adjacencias.get(v).add(arestainvertida);
	}
}
		//Método que verifica se o grafo é Euleriano
	
	    public String verificaEulerianismo() {
	        int numVerticesGrauImpar = 0;

	        for (int i = 0; i < nVertices; i++) {
	            int grau = adjacencias.get(i).size();
	            
	            if (grau % 2 != 0) {
	                numVerticesGrauImpar += 1;
	            }
	        }
	        
	        if (numVerticesGrauImpar == 0) {
	            return "O grafo é euleriano.";
	        } else if (numVerticesGrauImpar == 2) {
	            return "O grafo é semi-euleriano.";
	        } else {
	            return "O grafo não é euleriano.";
	        }
	    }
	
	public void mostrarListaAdjacencia() {
		for(int i=0; i<nVertices; i++) {
			System.out.print("Vértice "+i+": ");
			for (Aresta aresta : adjacencias.get(i)) {
				System.out.print("("+aresta.destino+", Peso: "+aresta.peso+")");
			}
			System.out.println();
		}
	}
	
	public void mostrarListaAdjacenciaVertice(int u) {
		for (Aresta aresta : adjacencias.get(u)) {
			System.out.print("("+aresta.destino+", Peso: "+aresta.peso+")");
		}
	}
	
	public void verificaAdjacencia(int u, int v) {
		for (Aresta aresta : adjacencias.get(u)) {
			if(v == aresta.destino) {
				System.out.print("Possui adjacência");
			}
			else {
				System.out.println("Não possui adjacência");
			}
		}
	}
	
	public void removeAresta(int u, int v) {
		List<Aresta>arestasU = adjacencias.get(u);
		for (Aresta aresta : arestasU) {
			if(aresta.destino == v) {
				arestasU.remove(aresta);
				break;
			}
		}
		if(!direcionado) {
			List<Aresta>arestasV = adjacencias.get(v);
			for(Aresta aresta : arestasV) {
				if(aresta.destino == u) {
					arestasV.remove(aresta);
					break;
				}
			}
		}
	}
}
