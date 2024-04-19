package Exercises;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.lang.String;
import javax.xml.parsers.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class StudentXMLProcessor {
    public static void main(String[] args) {
        // Khởi tạo và chạy 3 luồng
        Thread thread1 = new Thread(new ReadStudentThread());
        Thread thread2 = new Thread(new CalculateAgeThread());
        Thread thread3 = new Thread(new CheckPrimeThread());
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // Đợi cho các luồng hoàn thành
            thread1.join();
            thread2.join();
            thread3.join();

            // Đọc dữ liệu từ các luồng
            String studentId = ReadStudentThread.studentId;
            String studentName = ReadStudentThread.studentName;
            String studentAddress = ReadStudentThread.studentAddress;
            Date dateOfBirth = CalculateAgeThread.dateOfBirth;
            String encodedAge = CalculateAgeThread.encodedAge;
            boolean isSumPrime = CheckPrimeThread.isSumPrime;

            // Tạo DOM Document và các phần tử
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // Tạo phần tử gốc <Student>
            Element rootElement = doc.createElement("Student");
            doc.appendChild(rootElement);

            // Tạo phần tử <id> và thêm vào rootElement
            Element idElement = doc.createElement("id");
            idElement.appendChild(doc.createTextNode(studentId));
            rootElement.appendChild(idElement);

            // Tạo phần tử <name> và thêm vào rootElement
            Element nameElement = doc.createElement("name");
            nameElement.appendChild(doc.createTextNode(studentName));
            rootElement.appendChild(nameElement);

            // Tạo phần tử <address> và thêm vào rootElement
            Element addressElement = doc.createElement("address");
            addressElement.appendChild(doc.createTextNode(studentAddress));
            rootElement.appendChild(addressElement);

            // Tạo phần tử <age> và thêm vào rootElement
            Element ageElement = doc.createElement("age");
            ageElement.appendChild(doc.createTextNode(encodedAge));
            rootElement.appendChild(ageElement);

            // Tạo phần tử <sum> và thêm vào rootElement
            Element sumElement = doc.createElement("sum");
            sumElement.appendChild(doc.createTextNode(String.valueOf(isSumPrime)));
            rootElement.appendChild(sumElement);

            // Tạo Transformer và ghi kết quả vào file kq.xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("kq.xml"));
            transformer.transform(source, result);

            System.out.println("Đã tạo file kq.xml thành công.");
        } catch (InterruptedException | ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}

//Luồng 1: Đọc file student.xml
class ReadStudentThread implements Runnable {
 static String studentId;
 static String studentName;
 static String studentAddress;

 @Override
 public void run() {
     try {
         File file = new File("student.xml");
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();
         Document doc = builder.parse(file);

         // Đọc thông tin học sinh từ file student.xml
         doc.getDocumentElement().normalize();
         Element root = doc.getDocumentElement();
         Node studentNode = root.getElementsByTagName("Student").item(0);
         if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
             Element studentElement = (Element) studentNode;
             studentId = studentElement.getElementsByTagName("id").item(0).getTextContent();
             studentName = studentElement.getElementsByTagName("name").item(0).getTextContent();
             studentAddress = studentElement.getElementsByTagName("address").item(0).getTextContent();
         }

         System.out.println("Đọc file student.xml thành công.");
     } catch (ParserConfigurationException | SAXException | IOException e) {
         e.printStackTrace();
     }
 }
}

//Luồng 2: Tính tuổi và mã hoá chữ số
class CalculateAgeThread implements Runnable {
 static Date dateOfBirth;
 static String encodedAge;

 @Override
 public void run() {
     try {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         dateOfBirth = dateFormat.parse("1990-01-01"); // Thay thế "1990-01-01" bằng ngày sinh thực tế của sinh viên

         // Tính tuổi
         Date currentDate = new Date();
         long diff = currentDate.getTime() - dateOfBirth.getTime();
         long ageInMillis = 1000L * 60 * 60 * 24 * 365;
         long age = diff / ageInMillis;

         // Mã hoá tuổi thành chữ số
         encodedAge = encodeNumber(age);

         System.out.println("Tính tuổi và mã hoá chữ số thành công.");
     } catch (ParseException e) {
         e.printStackTrace();
     }
 }

 private String encodeNumber(long number) {
     // Mã hoá chữ số thành chuỗi
     String encodedNumber = "";
     while (number > 0) {
         long digit = number % 10;
         encodedNumber = digit + encodedNumber;
         number /= 10;
     }
     return encodedNumber;
 }
}

//Luồng 3: Kiểm tra tổng các chữ số có phải là số nguyên tố
class CheckPrimeThread implements Runnable {
 static boolean isSumPrime;

 @Override
 public void run() {
     String encodedAge = CalculateAgeThread.encodedAge;

     // Tính tổng các chữ số
     int sum = 0;
     for (int i = 0; i < encodedAge.length(); i++) {
         int digit = Character.getNumericValue(encodedAge.charAt(i));
         sum += digit;
     }

     // Kiểm tra tổng có phải là số nguyên tố
     isSumPrime = isPrime(sum);

     System.out.println("Kiểm tra tổng các chữ số thành công.");
 }

 private boolean isPrime(int number) {
     if (number < 2) {
         return false;
     }
     for (int i = 2; i <= Math.sqrt(number); i++) {
         if (number % i == 0) {
             return false;
         }
     }
     return true;
 }
}