package classes;

import Shape.Shape;
import org.junit.Test;

import static org.junit.Assert.*;

//@RunWith(Arquillian.class)
public class GetVolumeTest {
    private Shape shape = new Shape("Shapenaam", 10, 10, 10, 10);

    @Test
    public void volumeBol() {
        double volume = new GetVolume().volumeBol(shape);
        assertNotNull(volume);
    }

    @Test
    public void volumeCilinder() {
        double volume = new GetVolume().volumeCilinder(shape);
        assertNotNull(volume);
    }

    @Test
    public void volumeBlok() {
        double volume = new GetVolume().volumeBlok(shape);
        assertNotNull(volume);
    }

    @Test
    public void volumeKegel() {
        double volume = new GetVolume().volumeKegel(shape);
        assertNotNull(volume);
    }

    @Test
    public void volumePiramide() {
        double volume = new GetVolume().volumePiramide(shape);
        assertNotNull(volume);
    }
}
