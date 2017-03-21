/**
 * Created by Josu on 19/03/2017.
 */
public enum DireccionesArma {
    NS ("norte-sur"),EO("este-oeste"), BOOM("boom");

    private final String direccion;

    DireccionesArma(String pDireccion){
        this.direccion = pDireccion;
    }

    public String getDireccion(){
        return this.direccion;
    }
}
