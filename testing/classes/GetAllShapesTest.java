package classes;

import javafx.collections.ObservableList;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetAllShapesTest {

    @Test
    public void getAllShapes() {
        ObservableList list = new GetAllShapes().getAllShapes();
        System.out.println(list.get(0));
        assertNotNull(list.get(0));
    }
}
