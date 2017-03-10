public class Almacen {

	private HashMap<String, Stack<Arma>> AlmacenIA;
	private HashMap<Sring, Stack<Arma>> AlmacenHumano;
	private static Almacen miAlmacen;

	private Almacen() {
		// TODO - implement Almacen.Almacen
		throw new UnsupportedOperationException();
	}

	public static Almacen getMiAlmacen() {
		return this.miAlmacen;
	}

	/**
	 * 
	 * @param pNombre
	 */
	public void comprarArma(String pNombre) {
		// TODO - implement Almacen.comprarArma
		throw new UnsupportedOperationException();
	}

}