package solution;

import com.sun.media.jai.widget.DisplayJAI;
import pmp.filter.Sink;
import pmp.interfaces.Readable;

import javax.imageio.ImageIO;
import javax.media.jai.PlanarImage;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.StreamCorruptedException;
import java.security.InvalidParameterException;

public class TestSink extends Sink<PlanarImage> {


    public TestSink(Readable<PlanarImage> input) throws InvalidParameterException {
        if (input == null){
            throw new InvalidParameterException("input filter can't be null!");
        }
        m_Input = input;
    }

    public void write(PlanarImage image) throws StreamCorruptedException {
        try {
          Window.show(image);
        }catch (Exception e){
            throw new StreamCorruptedException(e.getMessage());
        }
    }
}
