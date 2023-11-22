public class Aviao {
	private int id;
	private double passageiros;
	private String companhia;
	private int combustivel;
	private int emergencia;
	private String Identification;
	public String getIdentification() {
		return Identification;
	}
	public void setIdentification(String Identification) {
		this.Identification = Identification;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPassageiros() {
		return passageiros;
	}
	public void setPassageiros(double passageiros) {
		this.passageiros = passageiros;
	}
	public String getCompanhia() {
		return companhia;
	}
	public void setCompanhia(String companhia) {
		this.companhia = companhia;
	}
	public int getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}
	public int getEmergencia() {
		return emergencia;
	}
	public void setEmergencia(int emergencia) {
		this.emergencia = emergencia;
	}
	public Aviao() {
		
	}
	public Aviao(int id,double passageiros, String companhia, int combustivel,int emergencia) {
		this.id = id;
		this.passageiros = passageiros;
		this.companhia = companhia;
		this.combustivel = combustivel;
		this.emergencia = emergencia;
	}
}
