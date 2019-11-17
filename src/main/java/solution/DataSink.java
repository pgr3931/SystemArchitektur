package solution;

import dataContainers.Coordinate;
import pmp.filter.Sink;
import pmp.interfaces.Readable;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Objects;

public class DataSink extends Sink<ArrayList<Coordinate>> {

    private String filePath = Objects.requireNonNull(getClass().getClassLoader().getResource("result.txt")).getPath();
    private int begin;
    private int end;

    DataSink(Readable<ArrayList<Coordinate>> input, int begin, int end) throws InvalidParameterException {
        if (input == null) {
            throw new InvalidParameterException("input filter can't be null!");
        }
        m_Input = input;
        this.begin = begin;
        this.end = end;
    }

    DataSink(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    public void write(ArrayList<Coordinate> data) throws StreamCorruptedException {
        if (data != null) {
            try {
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
                for (Coordinate coordinate : data) {
                    writer.append("Coordinates: ");
                    writer.append("X: ");
                    writer.append(String.valueOf(coordinate._x));
                    writer.append(" Y: ");
                    writer.append(String.valueOf(coordinate._y));
                    writer.append(" Diameter: ");
                    writer.append(String.valueOf(coordinate._diameter));
                    writer.append(" Result: ");
                    if(coordinate._diameter < begin)
                       writer.append("Failed; The diameter is too small.");
                    else if(coordinate._diameter > end)
                       writer.append("Failed; The diameter is too large.");
                    else
                       writer.append("Success");
                    writer.append("\n");
                }
                writer.close();
            }catch (Exception e){
                throw new StreamCorruptedException(e.getMessage());
            }
        }
    }
}
