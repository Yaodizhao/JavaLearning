package JavaCoreLearning2;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Chap3 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File f = new File("src/a.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(f);
        Element root = doc.getDocumentElement();
        NodeList children = root.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            //去除空白字符
            if (child instanceof Element) {
                System.out.println(child);
                // var textNode = (Text)child.getLastChild();
                // String text = textNode.getData().trim();
                // System.out.println(text);
                NodeList nodeList = child.getChildNodes();
                for (int j = 0; j < nodeList.getLength(); j++) {
                    if (nodeList.item(j) instanceof Element) {
                        // System.out.println(nodeList.item(j));
                        var textNode = (Text)nodeList.item(j).getLastChild();
                        String text = textNode.getData().trim();
                        System.out.println(text);
                    }
                }
            }
        }
        char a[] = new char[]{'a','b'};
        System.out.println(a.hashCode());
    }
}
