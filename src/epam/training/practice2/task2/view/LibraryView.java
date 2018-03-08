package epam.training.practice2.task2.view;

import epam.training.practice2.task2.model.entity.Book;

import java.util.List;

public class LibraryView {


    public void printErrorMessage(String message){
        System.err.println(message);
    }

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
