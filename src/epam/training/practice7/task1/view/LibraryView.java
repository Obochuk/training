package view;

import model.entity.Book;

import java.util.List;

public class LibraryView {

    public void printMessage(String message){
        System.out.println(message);
    }

    public void print(List<Book> books){
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println('\n');
    }
}
