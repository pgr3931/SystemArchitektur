package solution;

import pmp.filter.DataTransformationFilter1;
import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.security.InvalidParameterException;

public class RectangleFilter extends DataTransformationFilter2<PlanarImage, PlanarImage> {
    public RectangleFilter(Readable<PlanarImage> input) throws InvalidParameterException {
        super(input);
    }

    public RectangleFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected PlanarImage process(PlanarImage image) {
        Window.show(image);
        Rectangle rectangle = new Rectangle(0, 40, image.getWidth(), image.getHeight() - 200);
        image = PlanarImage.wrapRenderedImage(image.getAsBufferedImage(rectangle, image.getColorModel()));
        return image;
    }
}
