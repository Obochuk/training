import controller.LibraryController;
import model.LibraryModel;
import view.LibraryView;

public class Main {
    public static void main(String[] args) {
        LibraryController controller = new LibraryController(new LibraryModel(),
                                                             new LibraryView());
        controller.process();
    }
}
