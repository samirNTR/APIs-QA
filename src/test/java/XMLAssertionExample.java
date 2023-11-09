
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class XMLAssertionExample {
    public static void main(String[] args) {
        try {
            // Specify the path to your XML file
            String filePath = "D:\\Testing\\ProgramPractice\\ABC.xml";

            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file to create a Document object
            Document document = builder.parse(filePath);

            // Get the root element of the document
            Element rootElement = document.getDocumentElement();

            // Get a NodeList of elements with a specific tag name
            NodeList nodeList = rootElement.getElementsByTagName("Author");

            // Assuming there's only one <Author> element, extract its text content
            String authorValue = nodeList.item(0).getTextContent();

            // Assert the value of <Author>
            Assert.assertEquals("James Gosling", authorValue);

            // If the assertion passes, print a success message
            System.out.println("Assertion passed: Author is James Gosling");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






//...

//Get a NodeList of elements with a specific tag name
/*
 * NodeList nodeList = rootElement.getElementsByTagName("Author");
 * 
 * //Iterate through the NodeList and extract data for (int i = 0; i <
 * nodeList.getLength(); i++) { Node node = nodeList.item(i);
 * 
 * if (node.getNodeType() == Node.ELEMENT_NODE) { String authorValue =
 * node.getTextContent();
 * 
 * // Use the extracted data as needed System.out.println("Author: " +
 * authorValue); } }
 */
