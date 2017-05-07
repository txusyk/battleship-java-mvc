import Controlador.ControladorBattleship;

/**
 * Created by Josu on 05/05/2017.
 */
public class BattleshipMVC {

    private BattleshipMVC() {
    }

    public static void main(String[] args) {
        ControladorBattleship.getMyControladorBattleship().iniciar();
    }

}
