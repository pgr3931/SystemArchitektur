package solution;

import org.jaitools.media.jai.kernel.KernelFactory;
import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import javax.media.jai.JAI;
import javax.media.jai.KernelJAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.RenderedOp;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.security.InvalidParameterException;

public class BallsFilter extends DataTransformationFilter2<PlanarImage, PlanarImage> {
    BallsFilter(Readable<PlanarImage> input) throws InvalidParameterException {
        super(input);
    }

    BallsFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    private KernelJAI kernel = KernelFactory.createCircle(5);

    @Override
    protected PlanarImage process(PlanarImage image) {
        Window.show(image);
        BufferedImage src = image.getAsBufferedImage();

        PlanarImage ballsImage = PlanarImage.wrapRenderedImage(dilate(erode(src)));
        Window.show(ballsImage);
        return ballsImage;
    }

    private RenderedOp erode(Object src) {
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(src);
        pb.add(kernel);

        return JAI.create("erode", pb);
    }

    private RenderedOp dilate(Object src) {
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(src);
        pb.add(kernel);

        return JAI.create("dilate", pb);
    }
}
