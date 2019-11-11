package solution;

import pmp.interfaces.Readable;
import pmp.pipes.SimplePipe;

import javax.media.jai.PlanarImage;

public class Main {
    public static void main(String[] args) {
        ImageSource source = new ImageSource();
        SimplePipe<PlanarImage> pipe1 = new SimplePipe<>(source);

        RectangleFilter rectangleFilter = new RectangleFilter((Readable<PlanarImage>) pipe1);
        SimplePipe<PlanarImage> pipe2 = new SimplePipe<>((Readable<PlanarImage>) rectangleFilter);

        ThresholdFilter thresholdFilter = new ThresholdFilter((Readable<PlanarImage>) pipe2);
        SimplePipe<PlanarImage> pipe3 = new SimplePipe<>((Readable<PlanarImage>) thresholdFilter);

        TestSink sink = new TestSink(pipe3);
        sink.run();
    }
}
