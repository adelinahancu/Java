//D:\\unitbv\\pob\\ExamenPOBHancuAdelina
public class Ingredient {
	private String nume;
	private String unitateMasura;
	private int cantitate;
	private int nrCalorii;
	public Ingredient(String nume, String unitateMasura, int cantitate, int nrCalorii) {
		super();
		this.nume = nume;
		this.unitateMasura = unitateMasura;
		this.cantitate = cantitate;
		this.nrCalorii = nrCalorii;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getUnitateMasura() {
		return unitateMasura;
	}
	public void setUnitateMasura(String unitateMasura) {
		this.unitateMasura = unitateMasura;
	}
	public int getCantitate() {
		return cantitate;
	}
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	public int getNrCalorii() {
		return nrCalorii;
	}
	public void setNrCalorii(int nrCalorii) {
		this.nrCalorii = nrCalorii;
	}
	@Override
	public String toString() {
		return  nume + ", " + unitateMasura + ", " + cantitate
				+ ", " + nrCalorii;
	}
	
	
	

}
