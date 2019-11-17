package solution;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.security.InvalidParameterException;

public class RectangleFilter extends DataTransformationFilter2<PlanarImage, PlanarImage> {

    private boolean showRecatngle;

    RectangleFilter(Readable<PlanarImage> input, boolean showRectangle) throws InvalidParameterException {
        super(input);
        this.showRecatngle = showRectangle;
    }

    RectangleFilter(Writeable<PlanarImage> output, boolean showRectangle) throws InvalidParameterException {
        super(output);
        this.showRecatngle = showRectangle;
    }

    @Override
    protected PlanarImage process(PlanarImage image) {
        Window.show(image);
        Rectangle rectangle = new Rectangle(0, 40, image.getWidth(), image.getHeight() - 200);

        if(showRecatngle) {
            BufferedImage img = image.getAsBufferedImage();
            Graphics2D g2d = img.createGraphics();
            g2d.setColor(Color.WHITE);
            g2d.setStroke(new BasicStroke(4));
            g2d.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            g2d.dispose();
            Window.show(PlanarImage.wrapRenderedImage(img));
        }

        image = PlanarImage.wrapRenderedImage(image.getAsBufferedImage(rectangle, image.getColorModel()));
        return image;
    }
}
