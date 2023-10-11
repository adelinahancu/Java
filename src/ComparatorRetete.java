import java.util.Comparator;

public class ComparatorRetete implements Comparator<Reteta>{

	@Override
	public int compare(Reteta r1, Reteta r2) {
		
		
		if(r1.getTimpPregatire()>r2.getTimpPregatire())
		{
			return 1;
		}
		else 
			if(r1.getTimpPregatire()<r2.getTimpPregatire())
				return -1;
					
		return Integer.compare(r1.getListaIngrediente().size(), r2.getListaIngrediente().size());
	
	
		
			
		
		
		
	}

}
