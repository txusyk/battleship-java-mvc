public abstract class Barco {

	private int longitudX;
	private int longitudY;
	private int[] posicion;
	private String estadoPosicion;
	private boolean[] listaDaños;
	private int preciorReparacion;

	public Barco() {
		// TODO - implement Barco.Barco
		throw new UnsupportedOperationException();
	}

	public int getLongitudX() {
		return this.longitudX;
	}

	public int getLongitudY() {
		return this.longitudY;
	}

	public String getEstadoPosicion() {
		return this.estadoPosicion;
	}

	public boolean estaDañado() {
		// TODO - implement Barco.estaDañado
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pArma
	 * @param posAtaq
	 */
	public void recibirDaños(Arma pArma, int posAtaq) {
		// TODO - implement Barco.recibirDaños
		throw new UnsupportedOperationException();
	}

}