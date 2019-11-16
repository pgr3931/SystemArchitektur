package solution;

import com.sun.media.jai.widget.DisplayJAI;
import dataContainers.Coordinate;
import pmp.filter.Sink;
import pmp.interfaces.Readable;

import javax.imageio.ImageIO;
import javax.media.jai.PlanarImage;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.StreamCorruptedException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class TestSink extends Sink<ArrayList<Coordinate>> {


    public TestSink(Readable<ArrayList<Coordinate>> input) throws InvalidParameterException{
        if (input == null){
            throw new InvalidParameterException("input filter can't be null!");
        }
        m_Input = input;
    }

    public void write(ArrayList<Coordinate> data) throws StreamCorruptedException {
        for (Coordinate coordinate : data) {
            System.out.println("X: " + coordinate._x + " Y: " + coordinate._y);
        }
    }
}
