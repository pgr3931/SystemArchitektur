package solution;

import calcCentroidsFilter.CalcCentroidsFilter;
import dataContainers.Coordinate;
import pmp.interfaces.Readable;
import pmp.pipes.SimplePipe;

import javax.media.jai.PlanarImage;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ImageSource source = new ImageSource();
        SimplePipe<PlanarImage> pipe1 = new SimplePipe<>(source);

        RectangleFilter rectangleFilter = new RectangleFilter((Readable<PlanarImage>) pipe1);
        SimplePipe<PlanarImage> pipe2 = new SimplePipe<>((Readable<PlanarImage>) rectangleFilter);

        ThresholdFilter thresholdFilter = new ThresholdFilter((Readable<PlanarImage>) pipe2);
        SimplePipe<PlanarImage> pipe3 = new SimplePipe<>((Readable<PlanarImage>) thresholdFilter);

        MedianFilter medianFilter = new MedianFilter((Readable<PlanarImage>) pipe3);
        SimplePipe<PlanarImage> pipe4 = new SimplePipe<>((Readable<PlanarImage>) medianFilter);

        BallsFilter ballsFilter = new BallsFilter((Readable<PlanarImage>) pipe4);
        SimplePipe<PlanarImage> pipe5 = new SimplePipe<>((Readable<PlanarImage>) ballsFilter);

        SaveFilter saveFilter = new SaveFilter((Readable<PlanarImage>) pipe5);
        SimplePipe<PlanarImage> pipe6 = new SimplePipe<>((Readable<PlanarImage>) saveFilter);

        CalcCentroidsFilter calcCentroidsFilter = new CalcCentroidsFilter(pipe6);
        SimplePipe<ArrayList<Coordinate>> pipe7 = new SimplePipe<>((Readable<ArrayList<Coordinate>>)calcCentroidsFilter);

        TestSink sink = new TestSink(pipe7);
        sink.run();
    }
}
