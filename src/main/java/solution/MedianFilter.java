package solution;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.RenderedOp;
import javax.media.jai.operator.MedianFilterDescriptor;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.security.InvalidParameterException;

public class MedianFilter extends DataTransformationFilter2<PlanarImage, PlanarImage> {
    MedianFilter(Readable<PlanarImage> input) throws InvalidParameterException {
        super(input);
    }

    MedianFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected PlanarImage process(PlanarImage image) {
        Window.show(image);
        BufferedImage src = image.getAsBufferedImage();

        ParameterBlock pb = new ParameterBlock();
        pb.addSource(src);
        pb.add(MedianFilterDescriptor.MEDIAN_MASK_SQUARE);
        pb.add(5);
        RenderedOp result = JAI.create("MedianFilter", pb);

        return PlanarImage.wrapRenderedImage(result);
    }
}
