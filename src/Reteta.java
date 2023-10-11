import java.util.ArrayList;
import java.util.Objects;

public class Reteta {

	private String denumireReteta;
	private ArrayList<Ingredient> listaIngrediente=new ArrayList<>();
	private int timpPregatire;
	public Reteta(String denumireReteta, ArrayList<Ingredient> listaIngrediente, int timpPregatire) {
		super();
		this.denumireReteta = denumireReteta;
		this.listaIngrediente = listaIngrediente;
		this.timpPregatire = timpPregatire;
	}
	public String getDenumireReteta() {
		return denumireReteta;
	}
	public void setDenumireReteta(String denumireReteta) {
		this.denumireReteta = denumireReteta;
	}
	public ArrayList<Ingredient> getListaIngrediente() {
		return listaIngrediente;
	}
	public void setListaIngrediente(ArrayList<Ingredient> listaIngrediente) {
		this.listaIngrediente = listaIngrediente;
	}
	public int getTimpPregatire() {
		return timpPregatire;
	}
	public void setTimpPregatire(int timpPregatire) {
		this.timpPregatire = timpPregatire;
	}
	@Override
	public String toString() {
		return  denumireReteta + ", " + listaIngrediente
				+ ", " + timpPregatire;
	}
	@Override
	public int hashCode() {
		return Objects.hash(denumireReteta, listaIngrediente, timpPregatire);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reteta other = (Reteta) obj;
		return Objects.equals(denumireReteta, other.denumireReteta)
				&& Objects.equals(listaIngrediente, other.listaIngrediente) && timpPregatire == other.timpPregatire;
	}
	
	
	
	
}
