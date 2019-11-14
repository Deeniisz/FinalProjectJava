import java.util.Random;
import java.util.Scanner;

public class FinalProject {

	public static void main(String[] args) {
		Random random = new Random(System.currentTimeMillis());
		
		// Define a variável para contagem de trocas
        int trocas = 0;
        
		// Define o tamanho do vetor a ser inicializado
		int tamanho = 10;
		
		// Declara um vetor com 10 posições para números inteiros
		int v[] = new int[tamanho];
		
		// Define a variável de controle do laço para popular o vetor
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
		System.out.println("5 - QuickSort");
		System.out.println("6 - Busca Linear");
		System.out.println("7 - Busca Linear Ordenada");
		System.out.println("8 - Busca Binária");
		int x = keyboard.nextInt();
		switch(x) 
		{
			case 1:
				// Bubblesort
		        // Percorre o vetor, da primeira à penultima posição
		        for(int i=0; i < v.length; i++){
		            
		            for(int j=0; j < v.length -1 ; j++){
		                if(v[j] > v[j+1]){
		                    trocas++;
		                    int aux = v[j];
		                    v[j] = v[j+1];
		                    v[j+1] = aux;
		                }
		            }
		        }
		        System.out.println("Vetor ordenado com "+ trocas +" trocas:");
		        for(int i = 0; i < v.length; i++){
		            System.out.print(v[i]+" ");
		        }
				break;
			case 2:
				long tempoinicial = System.currentTimeMillis();
				for (int i = 0; i < v.length; i++)
				{
				int atual = v[i];
				int j = i - 1;
				
				while (j >= 0 && v[j] >= atual)
				{
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
				for(i = 0; i < v.length; i++)
				{
					System.out.print(v[i] + " ");
				}


				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
	        }
	}
}
