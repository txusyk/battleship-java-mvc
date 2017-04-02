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

import java.util.Scanner;

public class Keyboard {

    private static Keyboard miKeyboard;
    private Scanner scan;

    public Keyboard() {
        scan = new Scanner(System.in);
    }

    public static Keyboard getMyKeyboard() {
        if (miKeyboard == null) {
            miKeyboard = new Keyboard();
        }
        return miKeyboard;
    }

    public static void main() {
        Keyboard.getMyKeyboard().catchYesNo();
    }

    /*
     * Recoge un int. En caso de que no sea valido, vuelve a solicitarlo hasta que
     * reciba un int valido.
     */
    public int getInt() {
        String auxS = scan.nextLine();
        while (!this.isNumeric(auxS)) {
            try {
                Integer.parseInt(auxS);
            } catch (NumberFormatException nfe) {
                System.out.println("Insert a valid number");
                auxS = scan.nextLine();
            }
        }
        int resul = Integer.parseInt(auxS);
        return resul;
    }

    /*
     * Comprueba si el String que se recibe es parseable a int
     */
    private boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /*
     * Recoge por Keyboard un String
     */
    public String getString() {
        return scan.nextLine();
    }

    /*
    Recoge una opcion concreta entre un min y max. Ambos incluidos.
     */
    public int getOptionFromRange(int min, int max) {
        int opt = Keyboard.getMyKeyboard().getInt();
        while (!(opt > min - 1) && !(opt < max + 1)) {
            System.out.println("You have inserted: " + opt + ".Insert a option between " + min + " and " + max);
            opt = Keyboard.getMyKeyboard().getInt();
        }
        return opt;
    }

    /*
    Recoge un Yes (Y) o un No (N)
     */
    public boolean catchYesNo() {
        String auxS;
        auxS = scan.nextLine();
        boolean flag = false;
        if (auxS.equalsIgnoreCase("Y")) {
            flag = true;
        } else if (auxS.equalsIgnoreCase("n")) {
            flag = false;
        } else {
            while (!auxS.equalsIgnoreCase("y") && !auxS.equalsIgnoreCase("n")) {
                System.out.println("Invalid character. Introduce Y/N");
                auxS = scan.nextLine();
            }
            if (auxS.equalsIgnoreCase("y")) {
                flag = true;
            }
        }
        return flag;
    }

}
