package epam.training.practice2.task2;

import epam.training.practice2.task2.controller.LibraryController;
import epam.training.practice2.task2.model.LibraryModel;
import epam.training.practice2.task2.view.LibraryView;

public class Main {
    public static void main(String[] args) {
        LibraryController controller = new LibraryController(new LibraryModel(),
                                                             new LibraryView());
        controller.process();
    }
}
