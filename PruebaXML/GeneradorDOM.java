/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebaXML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;




/**
 *
 * @author jolun
 */
public class GeneradorDOM {
   private Document document;

    public GeneradorDOM() throws ParserConfigurationException {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder b = f.newDocumentBuilder();
        document = (Document) b.newDocument();
    }

    public void generarDocument() {
     Element personas = document.createElement("personas"); 
        document.appendChild(personas); 

        Element persona = document.createElement("persona"); 
        persona.setAttribute("profesion", "cantante");
        personas.appendChild(persona);

        Element nombre = document.createElement("nombre");
        nombre.appendChild(document.createTextNode("Elsa"));
        persona.appendChild(nombre);

        Element mujer = document.createElement("mujer");
        persona.appendChild(mujer);

        Element fechaNacimiento = document.createElement("fecha_de_nacimiento");
        persona.appendChild(fechaNacimiento);

        Element dia = document.createElement("dia");
        dia.appendChild(document.createTextNode("18"));
        fechaNacimiento.appendChild(dia);

        Element mes = document.createElement("mes");
        mes.appendChild(document.createTextNode("6"));
        fechaNacimiento.appendChild(mes);

        Element año = document.createElement("año");
        año.appendChild(document.createTextNode("1996"));
        fechaNacimiento.appendChild(año);

        Element ciudad = document.createElement("ciudad");
        ciudad.appendChild(document.createTextNode("Pamplona"));
        persona.appendChild(ciudad);

    }


    public void generarXml() throws TransformerConfigurationException, IOException, TransformerException {
        TransformerFactory factoria = TransformerFactory.newInstance();
        Transformer transformer = factoria.newTransformer();

        Source source = new DOMSource((Node) document);
        File file = new File("C:\\Users\\jolun\\Desktop\\prueba3.xml");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        Result r = new StreamResult(pw);

        transformer.transform(source, r);
    }

    public static void main(String[] args) throws Exception {
        GeneradorDOM generador = new GeneradorDOM();
        generador.generarDocument();
        generador.generarXml();
    }
}


