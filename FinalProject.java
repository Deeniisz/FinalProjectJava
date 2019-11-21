import java.util.Random;
import java.util.Scanner;

public class FinalProject {

	public static void main(String[] args) {
		Random random = new Random(System.currentTimeMillis());

		// Define a variÃ¡vel para contagem de trocas
		int trocas = 0;

		// Define o tamanho do vetor a ser inicializado
		int tamanho = 10;

		// Declara um vetor com 10 posiÃ§Ãµes para nÃºmeros inteiros
		int v[] = new int[tamanho];

		// Define a variÃ¡vel de controle do laÃ§o para popular o vetor
		int cont;

		System.out.println("Vetor Desordenado :");
		// Popula o vetor com valores gerados aleatoriamente
		for (cont = 0; cont < tamanho; cont++) {
			v[cont] = (int) Math.round(Math.random() * 100);
			System.out.println(cont + v[cont]);
		}

		Scanner keyboard = new Scanner(System.in);
		System.out.println("-------Menu-------");
		System.out.println("1 - BubbleSort");
		System.out.println("2 - SelectionSort");
		System.out.println("3 - InsertionSort");
		System.out.println("4 - MergeSort");
		System.out.println("5 - Busca Linear");
		System.out.println("6 - Busca Binaria");
		int x = keyboard.nextInt();
		switch (x) {
		case 1:
			// Bubblesort
			// Percorre o vetor, da primeira Ã  penultima posiÃ§Ã£o
			for (int i = 0; i < v.length; i++) {

				for (int j = 0; j < v.length - 1; j++) {
					if (v[j] > v[j + 1]) {
						trocas++;
						int aux = v[j];
						v[j] = v[j + 1];
						v[j + 1] = aux;
					}
				}
			}
			System.out.println("Vetor ordenado com " + trocas + " trocas:");
			for (int i = 0; i < v.length; i++) {
				System.out.print(v[i] + " ");
			}
			break;
		case 2:
			long tempoinicial = System.currentTimeMillis();
			for (int i = 0; i < v.length; i++) {
				int atual = v[i];
				int j = i - 1;

				while (j >= 0 && v[j] >= atual) {
					v[j + 1] = v[j];
					j--;
				}

				v[j + 1] = atual;
			}

			System.out.println();
			System.out.println();

			long tempofinal = System.currentTimeMillis();
			long tempototal = tempofinal - tempoinicial;

			System.out.println("Tempo de Processamento de InsertionSort: " + tempototal + "ms");
			System.out.println();

			System.out.println("Valores Ordenados:");
			for (int i = 0; i < v.length; i++) {
				System.out.print(v[i] + " ");
			}

			break;
		case 3:
			tempoinicial = System.currentTimeMillis();
			for (int i = 0; i < v.length; i++) {
				int atual = v[i];
				int j = i - 1;

				while (j >= 0 && v[j] >= atual) {
					v[j + 1] = v[j];
					j--;
				}

				v[j + 1] = atual;
			}

			System.out.println();
			System.out.println();

			tempofinal = System.currentTimeMillis();
			tempototal = tempofinal - tempoinicial;

			System.out.println("Tempo de Processamento de InsertionSort: " + tempototal + "ms");
			System.out.println();

			System.out.println("Valores Ordenados:");
			for (int i = 0; i < v.length; i++) {
				System.out.print(v[i] + " ");
			}
			break;
		case 4:
			FinalProject ob = new FinalProject();
			ob.sort(v, 0, v.length - 1);

			System.out.println("\nValores Ordenados:");
			printArray(v);
			break;
		case 5:
			// Busca Linear

			System.out.println("\nQual o Valor a ser buscado: ");
			Scanner x1 = new Scanner(System.in);

			int scan = x1.nextInt();

			FinalProject busca = new FinalProject();
			int ret = busca.linearSearch(v, scan);

			if (ret == -1) {
				System.out.println("O Valor Não Foi Encontrado no Vetor");
			} else {
				System.out.println("O valor foi encontrado na posição" + ret);
			}

			break;
		case 6:
			System.out.println("\nQual o Valor a ser buscado: ");
			Scanner x11 = new Scanner(System.in);
			
			scan = x11.nextInt();
			
			//MergeSort busca = new MergeSort();
			ret = FinalProject.buscaBinaria(v, scan);
			if(ret == -1)
			{
			System.out.println("Valor não encontrado");
			}
			else
			{
			System.out.println("Valor encontrado na posição" + ret);
			}
			break;
		}
	}

	// procura o objeto 'key' no vetor 'a'
	public int linearSearch(int[] a, int key)
	{
	        for(int i = 0; i < a.length; i++){
	            if(a[i] == (key)){
	                return i; //valor encontrado, retorna o índice
	            }
	        }
	        return -1; //valor não encontrado
	}

	void merge(int v[], int l, int m, int r) {
		// Encontra o tamanho dos 2 vetores
		int n1 = m - l + 1;
		int n2 = r - m;

		// Vetores temporários
		int L[] = new int[n1];
		int R[] = new int[n2];

		// Copia os dados para os vetores
		for (int i = 0; i < n1; ++i)
			L[i] = v[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = v[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				v[k] = L[i];
				i++;
			} else {
				v[k] = R[j];
				j++;
			}
			k++;
		}

		// Copia o resto dos elementos em L
		while (i < n1) {
			v[k] = L[i];
			i++;
			k++;
		}

		// Copia o Resto dos elementos em R
		while (j < n2) {
			v[k] = R[j];
			j++;
			k++;
		}
	}

	void sort(int v[], int l, int r) {
		if (l < r) {
			// Encontra o meio do vetor
			int m = (l + r) / 2;

			// Organiza a primeira e segunda metade
			sort(v, l, m);
			sort(v, m + 1, r);

			// Junta as partes
			merge(v, l, m, r);
		}
	}

	// Imprime os valores ordenados
	static void printArray(int v[]) {
		int n = v.length;
		for (int i = 0; i < n; ++i)
			System.out.print(v[i] + " ");
		System.out.println();
	}

	public static int buscaBinaria(int[] numeros, int x) {
	    	int pos = -1, posInicial = 0, posFinal = numeros.length - 1;
	    	while(posInicial <= posFinal) {
	    	pos = (posFinal + posInicial) / 2;
	    	if(numeros[pos] == x) return pos;
	    	else if(numeros[pos] > x) posFinal = pos - 1;
	    	else posInicial = pos + 1;
	    	};
	    	return -1;
	}
}
