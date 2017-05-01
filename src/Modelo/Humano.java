/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Josu
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package Modelo;


import java.security.Key;

public class Humano extends Jugador {

    private String nombre;

    /**
     * @param pNombre
     */
    public Humano(String pNombre) {
        super();
        this.nombre = pNombre;
        this.turno = true;
        this.dinero = GestorFicheros.getMyGestorFicheros().getDineroInicial();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void jugarTurno() {

        boolean turnoActivo = true;

        while(turnoActivo){
            System.out.println("Quieres comprar un arma? (s/n): ");
            String resp = Keyboard.getMyKeyboard().getString();
            if (resp.equalsIgnoreCase("s")){
                System.out.println("\tQue arma desea comprar?: ");
                String nombreArma = Keyboard.getMyKeyboard().getString();
                comprarArma(nombreArma);
            }

            System.out.println("Quieres usar radar? (s/n): ");
            resp = Keyboard.getMyKeyboard().getString();
            if(resp.equalsIgnoreCase("s")){
                System.out.println("\tIntroduce coordenada x: ");
                int x = Keyboard.getMyKeyboard().getInt();
                System.out.println("\tIntroduce coordenada y: ");
                int y = Keyboard.getMyKeyboard().getInt();
                if(getListaArmas().getSize("radar") != 0){
                    getListaArmas().getArma("radar").accion(x, y);
                }
            }

            System.out.println("Quieres colocar un escudo? (s/n): ");
            resp = Keyboard.getMyKeyboard().getString();
            if(resp.equalsIgnoreCase("s")){
                System.out.println("\tIntroduce coordenada x: ");
                int x = Keyboard.getMyKeyboard().getInt();
                System.out.println("\tIntroduce coordenada y: ");
                int y = Keyboard.getMyKeyboard().getInt();
                if(getListaArmas().getSize("escudo") != 0){
                    Battleship.getMyBattleship().getJugActivo().getFlota().getBarcoPorPos(x,y).setEscudo((Escudo)getListaArmas().getArma("escudo"));
                }
            }

            System.out.println("Con que arma vas a disparar?: ");
            String nArma = Keyboard.getMyKeyboard().getString();
            if(getListaArmas().getArma(nArma) != null){
                System.out.println("\tIntroduce coordenada x: ");
                int x = Keyboard.getMyKeyboard().getInt();
                System.out.println("\tIntroduce coordenada y: ");
                int y = Keyboard.getMyKeyboard().getInt();
                getListaArmas().getArma(nArma).accion(x, y);
                if(Battleship.getMyBattleship().getJugNoActivo().getTablero().getPosicion(x, y) instanceof Agua){ //FALTA METER AREABARCO
                    Battleship.getMyBattleship().partidaAcabada();
                    Battleship.getMyBattleship().cambiarJugActivo();
                    turnoActivo = false;
                }
            }
        }

    }

    public void colocarBarcos() {
        // TODO - implement Humano.colocarBarcos
        throw new UnsupportedOperationException();
    }

}