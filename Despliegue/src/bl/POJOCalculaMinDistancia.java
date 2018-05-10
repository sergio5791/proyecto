package bl;

public class POJOCalculaMinDistancia {
	
	//Devuelve la posicion del array de la moto mas cercana
	public int minDistancia(int[] array){
		
		int min=array[0];
		int i=0,j=0;
		
		for(i=0;i<array.length;i++){
			if(array[i]<min){
				min=array[i];
				j=i;
			}
			
		}	
		return j;
			
	}

}
