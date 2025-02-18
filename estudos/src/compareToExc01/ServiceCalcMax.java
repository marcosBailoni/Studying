package compareToExc01;

import java.util.List;

public class ServiceCalcMax {
	
	// O método irá retornar o "max" de uma lista
	// a Lista precisa ser "herdeira" de Comparable para utilizar o compareTo();
	
	public static <T extends Comparable<T>> T max(List<T> lista) {
		
		
		if(lista.isEmpty() ) {
			throw new IllegalStateException("Lista Vazia!");
		}
		
		T max = lista.get(0);
		
		for(T item: lista) {
			if(item.compareTo(max) > 0) {
				max = item;
			}
		}
		
		return max;
	}
	
	
}
