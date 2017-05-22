package Modelo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * Created by Josu on 05/05/2017.
 */
public class Login {

    private Document listaUsuarios;

    public Login() throws ExcepcionFicheros {
        cargarUsuariosXML();
    }

    private void cargarUsuariosXML() throws ExcepcionFicheros {
        try {
            String url = System.getProperty("user.home");
            File f = new File(url + "/usersDB.xml");
            if (!f.exists()) {
                throw new ExcepcionFicheros();
            }

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

    public void añadirUsuario(String nUsuario, char[] pUsuario) {
        if (!estaUsuario(nUsuario)) {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            try {
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
            } catch (ParserConfigurationException | TransformerException e) {
                e.getMessage();
            }


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

}
