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

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Josu on 21/03/2017.
 */
public class Configurador {

    private static Configurador myConfigurador;

    private ListaArmas ls = new ListaArmas();

    private static int numBombas,numMisiles,numMisilesDirig,numRadares,numEscudos, precioMisiles, precioMisilesDirig,precioRadares,precioEscudos,precioBaseReparacion,precioBaseImpacto,dineroInicial;

    private Configurador(){

    }

    public static Configurador getMyConfigurador(){
        if (myConfigurador == null){
            myConfigurador = new Configurador();
        }
        return myConfigurador;
    }

    public static void main(String[] args){
        Configurador.getMyConfigurador().readXML("facil");
    }

    public ListaArmas readXML(String pDif){
        try (InputStream resource = Configurador.class.getResourceAsStream("config_IS_battleship.xml")){
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(resource);

            doc.getDocumentElement().normalize();


            Node nNode = doc.getElementsByTagName(pDif).item(0);

            if (nNode.getNodeType() == Node.ELEMENT_NODE){
                Node nCantArmas= ((Element) nNode).getElementsByTagName("cantidadArmas").item(0);

                if (nCantArmas.getNodeType() == Node.ELEMENT_NODE){
                    numBombas = Integer.parseInt(((Element) nCantArmas).getElementsByTagName("bomba").item(0).getTextContent());
                    numMisiles = Integer.parseInt(((Element) nCantArmas).getElementsByTagName("misil").item(0).getTextContent());
                    numMisilesDirig = Integer.parseInt(((Element) nCantArmas).getElementsByTagName("misilDirig").item(0).getTextContent());
                    numRadares = Integer.parseInt(((Element) nCantArmas).getElementsByTagName("radar").item(0).getTextContent());
                    numEscudos = Integer.parseInt(((Element) nCantArmas).getElementsByTagName("escudo").item(0).getTextContent());
                }

                Node nPrecioArmas = ((Element) nNode).getElementsByTagName("preciosArmas").item(0);

                if (nPrecioArmas.getNodeType() == Node.ELEMENT_NODE){
                    precioMisiles = Integer.parseInt(((Element) nPrecioArmas).getElementsByTagName("misil").item(0).getTextContent());
                    precioMisilesDirig = Integer.parseInt(((Element) nPrecioArmas).getElementsByTagName("misilDirig").item(0).getTextContent());
                    precioRadares = Integer.parseInt(((Element) nPrecioArmas).getElementsByTagName("radar").item(0).getTextContent());
                    precioEscudos = Integer.parseInt(((Element) nPrecioArmas).getElementsByTagName("escudo").item(0).getTextContent());
                }

                Node nBarcos = ((Element) nNode).getElementsByTagName("barcos").item(0);

                if (nBarcos.getNodeType() == Node.ELEMENT_NODE){
                    precioBaseReparacion = Integer.parseInt(((Element) nBarcos).getElementsByTagName("precioBaseReparacion").item(0).getTextContent());
                    precioBaseImpacto = Integer.parseInt(((Element) nBarcos).getElementsByTagName("precioBaseImpacto").item(0).getTextContent());
                }

                Node nJugador = ((Element) nNode).getElementsByTagName("jugador").item(0);
                if (nJugador.getNodeType() == Node.ELEMENT_NODE){
                    dineroInicial = Integer.parseInt(((Element) nBarcos).getElementsByTagName("precioBaseReparacion").item(0).getTextContent());
                }
            }
        }catch(IOException e1){
            System.err.println("Error en el sistema. Error en el archivo");
            e1.printStackTrace();
        }catch (ParserConfigurationException e2){
            System.err.println("Error en el sistema. Error en el parseador XML");
            e2.printStackTrace();
        }catch (SAXException e3){
            e3.printStackTrace();
        }
        ls = inicializar();
        return ls;
    }

    private ListaArmas inicializar(){
        ls.inicializarArma("bomba",numBombas,0);
        ls.inicializarArma("misil",numMisiles,precioMisiles);
        ls.inicializarArma("misildirig",numMisilesDirig,precioMisilesDirig);
        ls.inicializarArma("radar",numRadares,precioRadares);
        ls.inicializarArma("escudo",numEscudos,precioBaseImpacto);

        return ls;
    }

}
