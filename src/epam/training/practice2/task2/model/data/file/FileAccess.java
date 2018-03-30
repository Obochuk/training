package model.data.file;

import model.entity.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAccess {
    public static List<Book> readFromFile(String fileName) throws IOException{
        try(ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(fileName))) {
            return readAllBooks(objectInput);
        }
    }

    private static List<Book> readAllBooks(ObjectInputStream objectInputStream){
        List<Book> books = new ArrayList<>();
        while (true){
            try {
                books.add((Book) objectInputStream.readObject());
            } catch (EOFException e){
                return books;
            } catch (ClassNotFoundException e){
                System.err.println("In specified file class of a book object cannot be found");
            } catch (IOException e){
                System.err.println("Wrong file data");
            }
        }
    }

    public static void writeToFile(List<Book> books, String fileName) throws IOException{
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            for (Book book : books) {
                outputStream.writeObject(book);
            }
        }
    }
}
