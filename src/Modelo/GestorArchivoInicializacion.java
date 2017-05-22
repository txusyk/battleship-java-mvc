package Modelo;/*
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Josu on 21/03/2017.
 */
public class GestorArchivoInicializacion {

    private static GestorArchivoInicializacion myGestorArchivoInicializacion;

    private int numBombas, numMisiles, numMisilesDirig, numRadares, numEscudos;
    private int precioMisiles, precioMisilesDirig, precioRadares, precioEscudos;
    private int precioBaseReparacion, precioBaseImpacto, dineroInicial;
    private int numFrag, numDestr, numSub, numPortaav;

    private GestorArchivoInicializacion() {
    }

    public static GestorArchivoInicializacion getMyGestorArchivoInicializacion() {
        if (myGestorArchivoInicializacion == null) {
            myGestorArchivoInicializacion = new GestorArchivoInicializacion();
        }
        return myGestorArchivoInicializacion;
    }

    /**
     * Lee el XML que guarda la configuracion del juego
     *
     * @param pDif
     */
    public void readXML(String pDif) throws ExcepcionFicheros {
        try {
            String url = System.getProperty("user.home");
            File fDif = new File(url + "/config_IS_battleship.xml");
            if (!fDif.exists()) {
                throw new ExcepcionFicheros();
            }
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(fDif);

            doc.getDocumentElement().normalize();

            Node nNode = doc.getElementsByTagName(pDif).item(0);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Node nCantArmas = ((Element) nNode).getElementsByTagName("cantidadArmas").item(0);
                if (nCantArmas.getNodeType() == Node.ELEMENT_NODE) {
                    numBombas = Integer.parseInt(((Element) nCantArmas).getElementsByTagName("bomba").item(0).getTextContent());
                    numMisiles = Integer.parseInt(((Element) nCantArmas).getElementsByTagName("misil").item(0).getTextContent());
                    numMisilesDirig = Integer.parseInt(((Element) nCantArmas).getElementsByTagName("misilDirig").item(0).getTextContent());
                    numRadares = Integer.parseInt(((Element) nCantArmas).getElementsByTagName("radar").item(0).getTextContent());
                    numEscudos = Integer.parseInt(((Element) nCantArmas).getElementsByTagName("escudo").item(0).getTextContent());
                }

                Node nPrecioArmas = ((Element) nNode).getElementsByTagName("preciosArmas").item(0);

                if (nPrecioArmas.getNodeType() == Node.ELEMENT_NODE) {
                    precioMisiles = Integer.parseInt(((Element) nPrecioArmas).getElementsByTagName("misil").item(0).getTextContent());
                    precioMisilesDirig = Integer.parseInt(((Element) nPrecioArmas).getElementsByTagName("misilDirig").item(0).getTextContent());
                    precioRadares = Integer.parseInt(((Element) nPrecioArmas).getElementsByTagName("radar").item(0).getTextContent());
                    precioEscudos = Integer.parseInt(((Element) nPrecioArmas).getElementsByTagName("escudo").item(0).getTextContent());
                }

                Node nBarcos = ((Element) nNode).getElementsByTagName("barcos").item(0);

                if (nBarcos.getNodeType() == Node.ELEMENT_NODE) {
                    precioBaseReparacion = Integer.parseInt(((Element) nBarcos).getElementsByTagName("precioBaseReparacion").item(0).getTextContent());
                    precioBaseImpacto = Integer.parseInt(((Element) nBarcos).getElementsByTagName("precioBaseImpacto").item(0).getTextContent());
                }

                Node nJugador = ((Element) nNode).getElementsByTagName("jugador").item(0);
                if (nJugador.getNodeType() == Node.ELEMENT_NODE) {
                    dineroInicial = Integer.parseInt(((Element) nJugador).getElementsByTagName("dineroInicial").item(0).getTextContent());
                }

                Node nNodeBarcos = doc.getElementsByTagName("numBarcos").item(0);
                if (nNodeBarcos.getNodeType() == Node.ELEMENT_NODE) {
                    numFrag = Integer.parseInt(((Element) nNodeBarcos).getElementsByTagName("fragata").item(0).getTextContent());
                    numDestr = Integer.parseInt(((Element) nNodeBarcos).getElementsByTagName("destructor").item(0).getTextContent());
                    numSub = Integer.parseInt(((Element) nNodeBarcos).getElementsByTagName("submarino").item(0).getTextContent());
                    numPortaav = Integer.parseInt(((Element) nNodeBarcos).getElementsByTagName("portaaviones").item(0).getTextContent());
                }
            }
        } catch (IOException e1) {
            e1.getMessage();
        } catch (ParserConfigurationException e2) {
            System.err.println("Error en el sistema. Error en el parseador XML");
            e2.printStackTrace();
        } catch (SAXException e3) {
            e3.printStackTrace();
        }
    }

    /**
     *
     * @param pArma
     * @return devuelve el precio del arma especificada como parametro, en caso de no existir devolvera -1
     */
    public int getPrecioArma(String pArma) {
        if (pArma.equalsIgnoreCase("misil")) {
            return this.precioMisiles;
        }
        if (pArma.equalsIgnoreCase("misildirig")) {
            return this.precioMisilesDirig;
        }
        if (pArma.equalsIgnoreCase("radar")) {
            return this.precioRadares;
        }
        if (pArma.equalsIgnoreCase("escudo")) {
            return this.precioEscudos;
        } else {
            return -1;
        }
    }

    /**
     *
     * @param pArma
     * @return devuelve la cantidad asociada al parametro que recibe
     */
    public int getNumeroArmas(String pArma) {
        if (pArma.equalsIgnoreCase("bomba")) {
            return this.numBombas;
        }
        if (pArma.equalsIgnoreCase("misil")) {
            return this.numMisiles;
        }
        if (pArma.equalsIgnoreCase("misildirig")) {
            return this.numMisilesDirig;
        }
        if (pArma.equalsIgnoreCase("radar")) {
            return this.numRadares;
        }
        if (pArma.equalsIgnoreCase("escudo")) {
            return this.numEscudos;
        } else {
            return -1;
        }
    }

    /**
     * @param pBarco
     * @return deuvuelve el numero de barcos de cada tipo
     */
    public int getNumBarco(String pBarco) {
        if (pBarco.equalsIgnoreCase("fragata")) {
            return this.numFrag;
        }
        if (pBarco.equalsIgnoreCase("destructor")) {
            return this.numDestr;
        }
        if (pBarco.equalsIgnoreCase("submarino")) {
            return this.numSub;
        }
        if (pBarco.equalsIgnoreCase("portaaviones")) {
            return this.numPortaav;
        } else {
            return -1;
        }
    }

    public int obtenerPrecioReparacion() {
        return precioBaseReparacion;
    }

    public int getPrecioBaseReparacion() {
        return precioBaseReparacion;
    }

    public int getPrecioBaseImpacto() {
        return precioBaseImpacto;
    }

    public int getDineroInicial() {
        return dineroInicial;
    }

}

