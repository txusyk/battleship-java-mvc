package Controlador;
import Modelo.Battleship;
import Modelo.GestorFicheros;
import Vista.VistaBattleship;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Edgar on 06/05/2017.
 */
public class ControladorBarraHerramientas  implements ActionListener {
    private static ControladorBarraHerramientas instancia;
    private String laSeleccion;

    private  ControladorBarraHerramientas(){

    }

    public static ControladorBarraHerramientas getControladorBarraHerramientas(){
        if(instancia== null){
            instancia=new ControladorBarraHerramientas();
        }
        return instancia;
    }

    public void VerificacionUsuario(String pUsr ,String pPsw,String pSeleccion) {
        GestorFicheros.getMyGestorFicheros().comprobarLogin(pUsr, pPsw.toCharArray());
        if (pSeleccion.equals("facil") || pSeleccion.equals("medio") || pSeleccion.equals("dificil")) {
            try {
                Battleship.getMyBattleship().setDificultad(pSeleccion);
                Battleship.getMyBattleship().inicializarJuego(pUsr);
            } catch (Exception e) {
                VistaBattleship.getVista().popUpError("error en la lectura de datos lo sentimos, vuelva a intentarlo");
            }
        } else if (pSeleccion.equals("cargar")) {
            GestorFicheros.getMyGestorFicheros().cargarJuego(pUsr);
        } else if (pSeleccion.equals("guardar")) {
            try {
                GestorFicheros.getMyGestorFicheros().guardarPartida(pUsr);
            } catch (Exception e) {
                VistaBattleship.getVista().popUpError("error en la escritura de datos lo sentimos");
            }
        }
    }


    public String getDifAct(){
       return Battleship.getMyBattleship().getDificultad();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * acerdaLogin ---> popUpInfoLogin
         * salir--->popUpLogin
         * reiniciar --->popUpReiniciar
         * cambiarDif --->popUpCambiarDif
         * reglasJuego --->lanzarPopUpInstruccionesJUego
         * acercaDe--->popUpAcercaDe
         * guardarPartida--->popUpVerificacionUsuario + guardar(usr)
         * cargarPartida--->popUpVerificación + cargar(usr)
         * verificar--->recoger info de verificación y verificar
         * confirmar reinicio--->popUpVErificaciónUsuario + reiniciar(antigua dif)
         * dificultad facil --->popUpVerificacion + reiniciar(nueva dif)
         * dificultad medio --->popUpVerificacion + reiniciar(nueva dif)
         * dificultad dificil --->popUpVerificacion + reiniciar(nueva dif)
         * confirmar salir--->exit 0
         * entendido-->cerrar popUp
         */

        //recuperamos el origen del evento para distinguir la accion que se ejecutará
        AbstractButton btnSeleccionado= (AbstractButton)e.getSource();
        String accionSeleccionada=btnSeleccionado.getText();

        //segun la accion deseada realizamos diferentes acciones
        if(accionSeleccionada.equals("Salir")){
            VistaBattleship.getVista().popUpInformacion("¿deseas salir ,o fué un erro? , cierrame si no estas seguro","confirmar salir");
        }else if(accionSeleccionada.equals("Reiniciar")){
            VistaBattleship.getVista().popUpInformacion("se reiniciara la partida con la misma configuración, cierrame si no estas seguro","confirmar reinicio");
        }else if(accionSeleccionada.equals("Cambiar dificultad")){
            VistaBattleship.getVista().popUpCambiarDif();
        }else if(accionSeleccionada.equals("Info. pantalla login")){
            VistaBattleship.getVista().popUpInformacion("Este login fue desarrollado con el fin de mantener la seguridad del usuario , y asimismo proveer de un gestor de partidas al juego ¡disfuta!","entendido");
        }else if(accionSeleccionada.equals("Info. developers")){
            VistaBattleship.getVista().popUpInformacion("Hola,parece que quieres conocernos,nosotros somos:Josu Álvarez , David Max y Edgar Andres ........Development Group,¡Disfrutad! ","entendido");
        }else if(accionSeleccionada.equals("Reglas del juego")){
            VistaBattleship.getVista().lanzarPopUpInstruccionesJuego();
        }else if(accionSeleccionada.equals("Cargar partida")){
            VistaBattleship.getVista().popUpVerificacionUsuario("cargar");
            laSeleccion="cargar";
        }else if(accionSeleccionada.equals("Guardar partida")){
            VistaBattleship.getVista().popUpVerificacionUsuario("guardar");
            laSeleccion="guardar";
        }else if(accionSeleccionada.equals("verificar")){
            VistaBattleship.getVista().disposePopUp();
            try {
                VerificacionUsuario(VistaBattleship.getVista().getUserToVerify(), VistaBattleship.getVista().getPswToVerify(), laSeleccion);
            }catch(Exception exc){
                VistaBattleship.getVista().popUpError("usuario o contraseña incorrectos");
            }
        }else if(accionSeleccionada.equals("confirmar reinicio")){
            VistaBattleship.getVista().disposePopUp();
            VistaBattleship.getVista().popUpVerificacionUsuario(Battleship.getMyBattleship().getDificultad());
            laSeleccion=Battleship.getMyBattleship().getDificultad();
        }else if(accionSeleccionada.equals("dificultad facil")){
            VistaBattleship.getVista().disposePopUp();
            VistaBattleship.getVista().popUpVerificacionUsuario("facil");
            laSeleccion="facil";
        }else if(accionSeleccionada.equals("dificultad medio")){
            VistaBattleship.getVista().disposePopUp();
            //verificamos usuario y reiniciamos con la dificultad seleccionada medio
            VistaBattleship.getVista().popUpVerificacionUsuario("medio");
            laSeleccion="medio";
        }else if(accionSeleccionada.equals("dificultad dificil")){
            VistaBattleship.getVista().disposePopUp();
            //verificamos usuario y reiniciamos con la dificultad seleccionada dificil
            VistaBattleship.getVista().popUpVerificacionUsuario("dificil");
            //detenemos ejecucion hasta que se seleccione verificar
            laSeleccion="dificil";
        }else if(accionSeleccionada.equals("confirmar salir")){
            //detenemos la ejecución del programa
            System.exit(0);
        }else if(accionSeleccionada.equals("entendido")){
            //cerramos popUp
            VistaBattleship.getVista().disposePopUp();
        }

    }
}
