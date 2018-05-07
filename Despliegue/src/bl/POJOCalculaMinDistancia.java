package bl;

public class POJOCalculaMinDistancia {
	
	public int minDistancia(int[] array){
		
		int min=array[0];
		int i=0;
		
		for(i=0;i<array.length;i++){
			if(array[i]<min){
				min=array[i];
			}
			
		}	
		return min;
			
	}

}
