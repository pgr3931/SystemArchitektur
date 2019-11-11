package solution;

import pmp.filter.DataTransformationFilter2;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import javax.media.jai.PlanarImage;
import java.awt.image.BufferedImage;
import java.security.InvalidParameterException;

public class ThresholdFilter extends DataTransformationFilter2<PlanarImage, PlanarImage> {
    public ThresholdFilter(Readable<PlanarImage> input) throws InvalidParameterException {
        super(input);
    }

    public ThresholdFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected PlanarImage process(PlanarImage image) {
        Window.show(image);
        BufferedImage bufferedImage = image.getAsBufferedImage();
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int color = bufferedImage.getRGB(x, y);

                int red = (color >>> 16) & 0xFF;
                int green = (color >>> 8) & 0xFF;
                int blue = (color) & 0xFF;

                float brightness = (red * 0.2126f + green * 0.7152f + blue * 0.0722f) / 255;

                if (brightness <= 0.15f) {
                    bufferedImage.setRGB(x, y, 0xFFFFFFFF);
                }
            }
        }
        return PlanarImage.wrapRenderedImage(bufferedImage);

    }
}
