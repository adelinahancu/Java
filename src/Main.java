import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static boolean validareDenumire(String denumireReteta)
	{
		String regex="[A-N][a-z]+";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(denumireReteta);
		
		if(matcher.matches())
		{
			return true;
		}
		return false;
	}
	
	public static boolean validareTimpPregatire(int timp)
	{
		if(timp>0)
		{
			return true;
		}
		return false;
	}
	
	public static boolean validareListaIngrediente(String[] listaIngrediente) {
		
		if(listaIngrediente.length>=2)
		{
			return true;
		}
		return false;
	}

	public static ArrayList<Reteta> citireFisier(String caleFisier) throws FileNotFoundException
	{
		
		ArrayList<Reteta> listaRetete=new ArrayList<>();
		Scanner sc=new Scanner(new File(caleFisier));
		while(sc.hasNext())
		{
			String informatie=sc.nextLine();
			String[] informatieReteta=informatie.split("\\*");
			
			String[] listaIngrediente=informatieReteta[1].split(";");
		
			
			ArrayList<Ingredient> listaIngredienteFisier=new ArrayList<>();
			
			for(int i=0;i<listaIngrediente.length;i++)
			{
				String []infoIngredient=listaIngrediente[i].split("_");
				int cantitate=Integer.parseInt(infoIngredient[2]);
				int calorii=Integer.parseInt(infoIngredient[3]);
				listaIngredienteFisier.add(new Ingredient(infoIngredient[0],infoIngredient[1], cantitate,calorii));
			}
			int timpPregatire=Integer.parseInt(informatieReteta[2]);
			
			for(int i=0;i<informatieReteta.length;i++)
			{
				informatieReteta[i]=informatieReteta[i].trim();
			}
			
			if(validareDenumire(informatieReteta[0] ) && validareTimpPregatire(timpPregatire) && validareListaIngrediente(listaIngrediente))
			{
				listaRetete.add(new Reteta(informatieReteta[0],listaIngredienteFisier,timpPregatire));
			}

			
			
			
			
		}
		
		return listaRetete;
		
		
	}
	
	public static int nrCalorii(Reteta r)
	{
		int nrCalorii=0;
		for(int i=0;i<r.getListaIngrediente().size();i++)
		{
			nrCalorii=nrCalorii+r.getListaIngrediente().get(i).getNrCalorii();
		}
		
		return nrCalorii;
	}
	
	public static void esteUnica(ArrayList<Reteta> listaRetete)
	{
		HashSet<Reteta> setRetete=new HashSet<>(listaRetete);
		if(setRetete.size()!=listaRetete.size())
		{
			System.out.println("Lista de retete nu este unica!");
		}
		else
			System.out.println("Lista de retete este unica.");
		
		System.out.println("\nLista de retete fara duplicate:");
		for(Reteta r:setRetete)
		{
			System.out.println(r);
		}
		
	}
	
	public static void IngredientPopular(ArrayList<Reteta> listaRetete)
	{
		HashMap<String,Integer> mapa=new HashMap<>();
		for(int i=0;i<listaRetete.size();i++)
		{
			if(mapa.containsKey(listaRetete.get(i).getListaIngrediente().get(i).getNume()))
			{
				mapa.put(listaRetete.get(i).getListaIngrediente().get(i).getNume(), 1);
			}
			else
			{
				int contor=mapa.get(listaRetete.get(i).getListaIngrediente().get(i).getNume());
				mapa.put(listaRetete.get(i).getListaIngrediente().get(i).getNume(), ++contor);
				
			}
		}
		
		for(Map.Entry<String, Integer> ob:mapa.entrySet())
		{
			System.out.println(ob.getKey()+" "+ob.getValue());
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Reteta> listaRetete=citireFisier("D:\\unitbv\\pob\\ExamenPOBHancuAdelina\\Retete.txt");
		esteUnica(citireFisier("D:\\unitbv\\pob\\ExamenPOBHancuAdelina\\Retete.txt"));
		Collections.sort(listaRetete,new ComparatorRetete());
		
		System.out.println("\nLista retetelor sortate dupa timp de pregatire sau dupa nr de ingrediente:");
		
		for(Reteta r:listaRetete)
		{
			System.out.println(r);
		}
		
		System.out.println(nrCalorii(listaRetete.get(0)));
		
		IngredientPopular(listaRetete);
		
	}

}
