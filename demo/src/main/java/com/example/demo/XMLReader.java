package com.example.demo;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReader {
  public static void main(String[] args) {
    try {
      // Создание фабрики для создания парсера
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();

      // Загрузка XML-файла
      Document document = builder.parse("m.xml");

      // Получение корневого элемента
      Element root = document.getDocumentElement();

      // Получение списка всех элементов с тегом "item"
      NodeList itemList = root.getElementsByTagName("item");

      // Обход элементов списка
      for (int i = 0; i < itemList.getLength(); i++) {
        Node itemNode = itemList.item(i);
        if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
          Element itemElement = (Element) itemNode;

          // Получение значений атрибутов и содержимого элемента

          String name = itemElement.getElementsByTagName("description").item(0).getTextContent();
          String description = itemElement.getElementsByTagName("author").item(0).getTextContent();

          // Вывод данных в консоль
          System.out.println("title: " + description);

          System.out.println("Description: " + name);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
