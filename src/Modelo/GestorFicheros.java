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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Josu on 21/03/2017.
 */
public class GestorFicheros {

    private static GestorFicheros myGestorFicheros;

    private int numBombas, numMisiles, numMisilesDirig, numRadares, numEscudos;
    private int precioMisiles, precioMisilesDirig, precioRadares, precioEscudos;
    private int precioBaseReparacion, precioBaseImpacto, dineroInicial;
    private int numFrag, numDestr, numSub, numPortaav;

    private Document listaUsuarios;
    private Document partidaGuardada;

    private GestorFicheros() {
        // cargarUsuariosXML();
    }


    public static GestorFicheros getMyGestorFicheros() {
        if (myGestorFicheros == null) {
            myGestorFicheros = new GestorFicheros();
        }
        return myGestorFicheros;
    }

    public void readXML(String pDif) {
        try (InputStream resource = GestorFicheros.class.getResourceAsStream("config_IS_battleship.xml")) {

            File fDif = new File("/Users/Josu/IdeaProjects/battleship-java-mvc/resources/config_IS_battleship.xml");
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
            System.err.println("Error en el sistema. Error en el archivo");
            e1.printStackTrace();
        } catch (ParserConfigurationException e2) {
            System.err.println("Error en el sistema. Error en el parseador XML");
            e2.printStackTrace();
        } catch (SAXException e3) {
            e3.printStackTrace();
        }
    }

    private void cargarUsuariosXML() {
        try (InputStream resource = GestorFicheros.class.getResourceAsStream("usersDB.xml")) {

            File f = new File("/IdeaProject/Users/Josus/battleship-java-mvc/resources/usersDB.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            listaUsuarios = documentBuilder.parse(f);

            listaUsuarios.getDocumentElement().normalize();

        } catch (IOException e1) {
            System.err.println("Error en el sistema. Error en el archivo");
            e1.printStackTrace();
        } catch (ParserConfigurationException e2) {
            System.err.println("Error en el sistema. Error en el parseador XML");
            e2.printStackTrace();
        } catch (SAXException e3) {
            e3.printStackTrace();
        }
    }

    private void cargarPartidaXML(String pUsr) {
        try (InputStream resource = GestorFicheros.class.getResourceAsStream("partidasDB.xml")) {

            //cambiar el path(usar relativo)
            File f = new File("/Users/$USER/IdeaProjects/battleship-java-mvc/resources/partidas/" + pUsr + ".xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            partidaGuardada = documentBuilder.parse(f);
            partidaGuardada.getDocumentElement().normalize();

        } catch (IOException e1) {
            System.err.println("Error en el sistema. Error en el archivo");
            e1.printStackTrace();
        } catch (ParserConfigurationException e2) {
            System.err.println("Error en el sistema. Error en el parseador XML");
            e2.printStackTrace();
        } catch (SAXException e3) {
            e3.printStackTrace();
        }
    }

    public void cargarJuego(String pUsr) {

    }

    /**
     * Simulacion de prueba del guardado supera los test para los siguientes valores:
     *
     * tableroHumano="parteBarco,true>tocado>1-1;agua,true>0-0<2"
     * tableroOrdenador="parteBarco,true>tocado>1-1;agua,true>0-0<2"
     *
     * armasHumano="5>5>5>5>5"
     * armasOrdenador="5>5>5>5>5"
     *
     * dineroHumano="100"
     * dineroOrdenador="100"
     *
     * flotaHumano="true¿tocado¿1-1!true¿tocado¿0-0_2>null>4>H>1>false,true¿tocado¿1-1!true¿tocado¿0-0_2>null>4>H>1>false;2<true¿tocado¿1-1!true¿tocado¿0-0_2>null>4>H>1>false,true¿tocado¿1-1!true¿tocado¿0-0_2>null>4>H>1>false;2<true¿tocado¿1-1!true¿tocado¿0-0_2>null>4>H>1>false,true¿tocado¿1-1!true¿tocado¿0-0_2>null>4>H>1>false;2<true¿tocado¿1-1!true¿tocado¿0-0_2>null>4>H>1>false,true¿tocado¿1-1!true¿tocado¿0-0_2>null>4>H>1>false;2"
     * flotaOrdenador="true¿tocado¿1-1!true¿tocado¿0-0_2>null>4>H>1>false,true¿tocado¿1-1!true¿tocado¿0-0_2>null>4>H>1>false;2<true¿tocado¿1-1!true¿tocado¿0-0_2>null>4>H>1>false,true¿tocado¿1-1!true¿tocado¿0-0_2>null>4>H>1>false;2<true¿tocado¿1-1!true¿tocado¿0-0_2>null>4>H>1>false,true¿tocado¿1-1!true¿tocado¿0-0_2>null>4>H>1>false;2<true¿tocado¿1-1!true¿tocado¿0-0_2>null>4>H>1>false,true¿tocado¿1-1!true¿tocado¿0-0_2>null>4>H>1>false;2"
     *
     * @param args
     */
    public static void main(String[] args) {
        try{
             GestorFicheros.getMyGestorFicheros().guardarPartida("edgar");
             GestorFicheros.getMyGestorFicheros().guardarPartida("david");
            GestorFicheros.getMyGestorFicheros().guardarPartida("josu");
        }catch(Exception e) {

         }

    }

    /**
     * metodo capaz de generar archivos (.xml) con la siguiente estructura:
     * (es un mapa conceptual de variables y etiquetas, en desarrollo pero funcional)
     *
     *
     *               partida
     *                  |
     * |---------------------------------|
     * |                                 |
     * jugador                         ordenador
     *  |----------tablero            (como el humano)
     *  |           |
     *  |           |---tipoCasilla(n) <estado,visible>   //en las casillas de tipo agua desaparece el estado
     *  |           |       |
     *  |           |       |-posiciones <x,y>
     *  |          ....
     *  |        (n casillas)
     *  |
     *  |----------armas
     *  |            |------armas <nBombas,nEscudos,nMisiles,nMisilDirig,nRadares>
     *  |
     *  |----------dinero <cantidadDinero>
     *  |
     *  |----------flota
     *             |
     *             |---barco0  <escudo,hundido,orientacion,precioReparacion,tamaño>
     *             |       |
     *             |       |----posiciones
     *             |               |
     *           ....              |---parteBarco(n) <estado,visible>
     *        (n barcos)           |       |
     *                             |       |-posiciones <x,y>
     *                            ....
     *                          (n posiciones)
     *
     *
     *
     * @param pUsr
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    public void guardarPartida(String pUsr) throws ParserConfigurationException, TransformerException {

        //recuperar la información paraa guardar
        String tableroHumano=ListaJugadores.getMyListaJug().guardarTableroHumano();
        String tableroOrdenador=ListaJugadores.getMyListaJug().guardarTableroOrdenador();

        String armasHumano=ListaJugadores.getMyListaJug().guardarArmasHumano();
        String armasOrdenador=ListaJugadores.getMyListaJug().guardarArmasOrdenador();

        String dineroHumano=ListaJugadores.getMyListaJug().guardarDineroHumano();
        String dineroOrdenador=ListaJugadores.getMyListaJug().guardarDineroOrdenador();

        String flotaHumano=ListaJugadores.getMyListaJug().guardarFlotaHumano();
        String flotaOrdenador=ListaJugadores.getMyListaJug().guardarFlotaOrdenador();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        //root elements
        Document doc = documentBuilder.newDocument();

        //recoger el nodo donde se guarda la info de la partida
        Element raiz =doc.createElement("partida");//raiz
        doc.appendChild(raiz);

        //generar los nodos de jugador
        Element jugadorH=doc.createElement("jugador");//humano
        Element jugadorO=doc.createElement("ordenador");//ordenador
        raiz.appendChild(jugadorH);
        raiz.appendChild(jugadorO);

        //generar los nodos de tablero y relacionarlos con sus respectivos jugadores
        Element tableroH= doc.createElement("tablero");//nuevo nodo tablero Humano
        Element tableroO= doc.createElement("tablero");//nuevo nodo tablero ordenador
        jugadorH.appendChild(tableroH);//asociar el tablerohumano con el jugador
        jugadorO.appendChild(tableroO);//asociar el tableroordenador con el ordenador

        //iterar para cada jugador
        for(int i=0;i<2;i++) {
            //guardar composicion del tablero
            String[] tablero;
            if(i==0) {
                //guardar en humano
                tablero = tableroHumano.split("<");//contenido separado de lngitud por <
            }else{
                //guardar en ordenador
                tablero = tableroOrdenador.split("<");//contenido separado de lngitud por <
            }

            String[] casillas = tablero[0].split(";");//casillas separadas del numero de casillas totales por ;
            System.out.println(casillas[0]);
            System.out.println(casillas[1]);
            int nElement = Integer.parseInt(tablero[1]);//numero de casillas totales

            for (int j = 0; j < nElement; j++) {

                String[] unaCasilla = casillas[j].split(",");//tipo de casilla separada de infoCasilla por ,
                System.out.println(unaCasilla[0]);
                if (unaCasilla[0].equals("parteBarco")) {
                    //si parteBArco....
                    Element parteBArco = doc.createElement("parteBarco"+j);//generar nodo que albergará la siguiente pos
                    //comprobar pertenencia de la información
                    if(i==0) {
                        //asociar con el tablero humano
                        tableroH.appendChild(parteBArco);
                    }else{
                        //asociar con el tablero ordenador
                        tableroO.appendChild(parteBArco);
                    }

                    //variables: visible,posiciones,estado
                    String[] valores=unaCasilla[1].split(">");//los valores de los tres campos separados por >
                    parteBArco.setAttribute("visible",valores[0]);//añadimos la variale visible
                    parteBArco.setAttribute("estado",valores[1]);//añadimos la variale estado
                    Element posiciones = doc.createElement("posiciones");//nuevo nodo posiciones(x,y)
                    String[] laPos=valores[2].split("-");//los valores de las posiciones separados por -
                    posiciones.setAttribute("pos1",laPos[0]);//eje x
                    posiciones.setAttribute("pos2",laPos[1]);//eje y
                    parteBArco.appendChild(posiciones);//asociar la parteBrco  con sus posiciones

                } else {
                    //si agua.....
                    Element agua = doc.createElement("agua"+j);//generar nodo que albergará la siguiente pos
                    if(i==0) {
                        //asociar con el tablero humano
                        tableroH.appendChild(agua);
                    }else{
                        //asociar con el tablero ordenador
                        tableroO.appendChild(agua);
                    }

                    //variables: visible , posiciones
                    String[] valores=unaCasilla[1].split(">");//los valores de amboss campos separados por >
                    agua.setAttribute("visible",valores[0]);//añadimos la variale visible
                    Element posiciones =doc.createElement("posiciones");//añadimos la variale posiciones
                    String[] laPos=valores[1].split("-");//los valores de las posiciones separados por -
                    //estas posiciones se resolveran en el tablero y no se guardaran en el objeto(al cargar)
                    posiciones.setAttribute("pos1",laPos[0]);//eje x
                    posiciones.setAttribute("pos2",laPos[1]);//eje y
                    agua.appendChild(posiciones);//asociar el agua  con sus posiciones

                }

            }
        }
        System.out.println("guardada casilla...... 25%");
        Element armasH=doc.createElement("armas");//armas Humano
        Element armasO=doc.createElement("armas");//armas ordenador
        jugadorH.appendChild(armasH);
        jugadorO.appendChild(armasO);

        for(int i=0;i<2;i++) {
            //guardar cantidad de armas
            String[] armas;
            Element listaArmas = doc.createElement("armas");//creamos la lista de armas
            if(i==0) {
                //guardar el humano
                armas = armasHumano.split(">");//valores de los campos separados por >
                armasH.appendChild(listaArmas);
            }else{
                //guardar el ordenador
                armas = armasOrdenador.split(">");//valores de los campos separados por >
                armasO.appendChild(listaArmas);
            }
            //variables bomba,misil,misilDirig,radar,escudo
            listaArmas.setAttribute("bombas",armas[0]);//añadimos la variale bombas
            listaArmas.setAttribute("misiles",armas[1]);//añadimos la variale misiles
            listaArmas.setAttribute("misilesDirig",armas[2]);//añadimos la variale misilesDirig
            listaArmas.setAttribute("radar",armas[3]);//añadimos la variale radar
            listaArmas.setAttribute("escudo",armas[4]);//añadimos la variale escudo
        }

        System.out.println("guardadas armas...... 50%");
        Element dineroH=doc.createElement("dinero");//dinero Humano
        Element dineroO=doc.createElement("dinero");//dinero ordenador
        jugadorH.appendChild(dineroH);
        jugadorO.appendChild(dineroO);

        for(int i=0;i<2;i++) {
            //guardar variable dinero
            if(i==0) {
                //guardar el humano
                dineroH.setAttribute("dinero",dineroHumano);
            }else{
                //guardar el ordenador
                dineroO.setAttribute("dinero",dineroOrdenador);
            }
        }
        System.out.println("guardado dinero...... 75%");

        Element flotaH=doc.createElement("flota");//flota Humano
        Element flotaO=doc.createElement("flota");//flota ordenador
        jugadorH.appendChild(flotaH);
        jugadorO.appendChild(flotaO);


        for(int i=0;i<2;i++) {
            //guardar composicion de la flota
            String[] flota;
            if (i == 0) {
                //guardar en humano
                flota = flotaHumano.split("<");//cada tipo de barco separado por .
            } else {
                //guardar en ordenador
                flota = flotaOrdenador.split("<");//cada tipo de barco separado por .
            }

            for (int w = 0; w < flota.length; w++) {
                String[] tipo = flota[w].split(";");//info separada de nBarcos por ;
                String[] barcos = tipo[0].split(",");//cada barco separado por ,
                int nElement = Integer.parseInt(tipo[1]);
                Element tipoAct = null;

                //resolver tipo de barco
                if (w == 0) {
                    tipoAct = doc.createElement("fragata");//frgatas...
                } else if (w == 1) {
                    tipoAct = doc.createElement("destructor");//destructores...
                } else if (w == 2) {
                    tipoAct = doc.createElement("submarino");//submarinos....
                } else if (w == 3) {
                    tipoAct = doc.createElement("portaaviones");//portaviones....
                }


                if (tipoAct != null) {
                    for (int j = 0; j < nElement; j++) {
                        String[] unBarco = barcos[i].split(">"); // variables del barco separadas por >

                        Element barco = doc.createElement("barco" + j);//barco....
                        tipoAct.appendChild(barco);
                        if (i == 0) {
                            //guardar el humano
                            flotaH.appendChild(tipoAct);
                        } else {
                            //guardar el ordenador
                            flotaO.appendChild(tipoAct);
                        }
                        //variables posiciones,escudo,tamaño,orientacion,precioReparacion y hundido
                        //añadir parteBarco....
                        String[] posBarco = unBarco[0].split("_");//info de posiciones separada de nPos por _
                        int nPos = Integer.parseInt(posBarco[1]);
                        Element susPartes = doc.createElement("posiciones");//posiciones
                        barco.appendChild(susPartes);
                        String[] posiciones=posBarco[0].split("!");

                        for (int k = 0; k < nPos; k++) {
                            Element parteBarco =doc.createElement("parteBarco" + k);//partesBarco
                            String[] valores = posiciones[k].split("¿");//los valores de los tres campos separados por ¿

                            //variables visible,posiciones,estado
                            parteBarco.setAttribute("visible", valores[0]);//añadimos la variale visible
                            parteBarco.setAttribute("estado", valores[1]);//añadimos la variale estado
                            Element posicionesElem = doc.createElement("posiciones");//añadimos la variale posiciones
                            String[] laPos = valores[2].split("-");//los valores de las posiciones separados por -
                            posicionesElem.setAttribute("pos1", laPos[0]);//eje x
                            posicionesElem.setAttribute("pos2", laPos[1]);//eje y
                            parteBarco.appendChild(posicionesElem);
                            susPartes.appendChild(parteBarco);


                        }

                        barco.setAttribute("escudo", unBarco[1]);//añadimos la variale escudo
                        barco.setAttribute("tamaño", unBarco[2]);//añadimos la variale tamaño
                        barco.setAttribute("orientacion", unBarco[3]);//añadimos la variale orientacion
                        barco.setAttribute("precioReparacion", unBarco[4]);//añadimos la variale precioReparacion
                        barco.setAttribute("hundido", unBarco[5]);//añadimos la variale hundido
                    }
                }

            }
        }
        System.out.println("guardadas flotas...... 99%");
        //instanciamos un transformador de datos
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();


        //fuente de nuevos datos el documento creado
        DOMSource source = new DOMSource(doc);

        //aqui cambiar la ruta a la específica del equipo(solucionar)
        StreamResult result = new StreamResult(new File("C:\\Users\\Edgar\\Desktop\\Programacion\\Programando en Java\\TercerSprint\\battleship-java-mvc-master\\resources\\partidas\\"+pUsr+".xml"));
        //settear propiedades
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        //lanzar el nuevo fichero
        transformer.transform(source, result);
        System.out.println("exportado archivo...... 100%");
        System.out.println("listo");
    }

    public void añadirUsuario(String nUsuario, char[] pUsuario) throws ParserConfigurationException, TransformerException {
        if (!estaUsuario(nUsuario)) {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            //root elements
            Document doc = documentBuilder.newDocument();
            Element rootElement = doc.createElement("usuarios");
            doc.appendChild(rootElement);

            NodeList nNode = listaUsuarios.getElementsByTagName("usuario");
            int i = 0;
            while (i < nNode.getLength()) {
                Element auxE = (Element) nNode.item(i);

                Element usuario = doc.createElement("usuario");
                rootElement.appendChild(usuario);

                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(auxE.getElementsByTagName("nombre").item(0).getTextContent()));
                usuario.appendChild(nombre);
                Element password = doc.createElement("password");
                password.appendChild(doc.createTextNode(auxE.getElementsByTagName("password").item(0).getTextContent()));
                usuario.appendChild(password);
                i++;
            }
            Element usuario = doc.createElement("usuario");
            rootElement.appendChild(usuario);
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(nUsuario));
            usuario.appendChild(nombre);
            Element password = doc.createElement("password");
            password.appendChild(doc.createTextNode(convertirPass(pUsuario)));
            usuario.appendChild(password);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            doc.normalize();
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new File("/Users/Josu/IdeaProjects/battleship-java-mvc/resources/usersDB.xml"));

            //output to console
            StreamResult r = new StreamResult(System.out);

            listaUsuarios = doc;

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(source, result);
        }
    }

    public void eliminarJugadorXML(String nUsuario) throws ParserConfigurationException, TransformerException {
        if (estaUsuario(nUsuario)) {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            //root elements
            Document doc = documentBuilder.newDocument();
            Element rootElement = doc.createElement("usuarios");
            doc.appendChild(rootElement);

            NodeList nNode = listaUsuarios.getElementsByTagName("usuario");
            int i = 0;
            while (i < nNode.getLength()) {
                Element auxE = (Element) nNode.item(i);

                if (!auxE.getElementsByTagName("nombre").item(0).getTextContent().equalsIgnoreCase(nUsuario)) {
                    Element usuario = doc.createElement("usuario");
                    rootElement.appendChild(usuario);

                    Element nombre = doc.createElement("nombre");
                    nombre.appendChild(doc.createTextNode(auxE.getElementsByTagName("nombre").item(0).getTextContent()));
                    usuario.appendChild(nombre);
                    Element password = doc.createElement("password");
                    password.appendChild(doc.createTextNode(auxE.getElementsByTagName("password").item(0).getTextContent()));
                    usuario.appendChild(password);
                }
                i++;
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            doc.normalize();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/Users/Josu/IdeaProjects/battleship-java-mvc/resources/usersDB.xml"));

            //output to console
            StreamResult r = new StreamResult(System.out);

            listaUsuarios = doc;

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(source, result);
        }
    }

    private String convertirPass(char[] pass) {
        String s = "";
        for (char c : pass) {
            s += c;
        }
        return s;
    }

    public boolean comprobarLogin(String nUsuario, char[] pUsuario) {
        boolean login = false;
        if (estaUsuario(nUsuario) && comprobarPass(nUsuario, pUsuario)) {
            login = true;
        }
        return login;
    }

    public boolean estaUsuario(String nUsuario) {
        boolean enc = false;
        NodeList nNode = listaUsuarios.getElementsByTagName("usuario");
        int i = 0;
        while (i < nNode.getLength() && !enc) {
            if (nNode.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element auxE = (Element) nNode.item(i);
                if (nUsuario.equalsIgnoreCase(auxE.getElementsByTagName("nombre").item(0).getTextContent())) {
                    enc = true;
                }
            }
            i++;
        }
        return enc;
    }

    private boolean comprobarPass(String nUsuario, char[] pUsuario) {
        boolean iguales = true;
        char[] posiblePass = getPasswordDeUser(nUsuario);
        if (pUsuario.length == posiblePass.length) {
            int i = 0;
            while (i < pUsuario.length && iguales) {
                if (pUsuario[i] != posiblePass[i]) {
                    iguales = false;
                }
                i++;
            }
        } else {
            iguales = false;
        }
        return iguales;
    }

    private char[] getPasswordDeUser(String nUsuario) {
        NodeList nNode = listaUsuarios.getElementsByTagName("usuario");
        char[] pass = new char[10];
        if (estaUsuario(nUsuario)) {
            int i = 0;
            boolean enc = false;
            while (i < nNode.getLength() && !enc) {
                if (nNode.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element auxE = (Element) nNode.item(i);
                    if (nUsuario.equalsIgnoreCase(auxE.getElementsByTagName("nombre").item(0).getTextContent())) {
                        pass = auxE.getElementsByTagName("password").item(0).getTextContent().toCharArray();
                    }
                }
                i++;
            }
            return pass;
        } else {
            return null;
        }

    }

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

