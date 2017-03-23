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

    private void readXML(String pDif){
        try (InputStream resource = Configurador.class.getResourceAsStream("config_IS_battleship.xml")){
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(resource);

            doc.getDocumentElement().normalize();


            Node nNode = doc.getElementsByTagName(pDif).item(0);

            //System.out.println(doc.getElementsByTagName(pDif).item(0).getAttributes().item(0));

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
                mostrarInicializacion();
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
    }

    private static void mostrarInicializacion(){
        System.out.println("[*] Cantidades de armas");
        System.out.println("\t\tBombas: "+numBombas);
        System.out.println("\t\tMisil: "+numMisiles);
        System.out.println("\t\tMisilDirig: "+numMisilesDirig);
        System.out.println("\t\tRadar: "+numRadares);
        System.out.println("\t\tEscudo: "+numEscudos);

        System.out.println("[*] Precios de armas");
        System.out.println("\t\tMisiles: "+precioMisiles);
        System.out.println("\t\tMisilesDirig: "+numMisilesDirig);
        System.out.println("\t\tRadar: "+precioRadares);
        System.out.println("\t\tEscudo: "+precioEscudos);

        System.out.println("[*] Precios de barcos");
        System.out.println("\t\tprecioBaseReparacion: "+precioBaseReparacion);
        System.out.println("\t\tprecioBaseImpacto: "+precioBaseImpacto);

        System.out.println("[*] Jugador");
        System.out.println("\t\tdineroInicial: "+dineroInicial);
    }

}
