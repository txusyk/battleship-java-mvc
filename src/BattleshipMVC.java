import Controlador.ControladorBattleship;
import Modelo.Battleship;
import Vista.VistaBattleship;

/**
 * Created by Josu on 05/05/2017.
 */
public class BattleshipMVC {

    private BattleshipMVC() {

    }

    public static void main(String[] args) {
        VistaBattleship v = new VistaBattleship();
        new ControladorBattleship(Battleship.getMyBattleship(), v);


    }
}
