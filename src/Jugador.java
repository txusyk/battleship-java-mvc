public abstract class Jugador {

	private Tablero tablero;
	private Tablero tableroAdv;
	private Flota flota;
	private int dinero;
	private HashSet<Arma> lArmas;

	/**
	 * 
	 * @param pFlota
	 * @param pDinInicial
	 * @param pArmas
	 */
	public Jugador(Flota pFlota, int pDinInicial, HashSet<Arma> pArmas) {
		// TODO - implement Jugador.Jugador
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCantidad
	 */
	protected void decrementarDinero(int pCantidad) {
		// TODO - implement Jugador.decrementarDinero
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pArma
	 */
	protected void comprarArma(String pArma) {
		// TODO - implement Jugador.comprarArma
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pBarco
	 */
	protected void repararBarco(Barco pBarco) {
		// TODO - implement Jugador.repararBarco
		throw new UnsupportedOperationException();
	}

}