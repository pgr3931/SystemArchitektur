package solution;

import pmp.filter.DataTransformationFilter1;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import java.security.InvalidParameterException;

public class SaveFilter extends DataTransformationFilter1<PlanarImage> {
    public SaveFilter(Readable<PlanarImage> input) throws InvalidParameterException {
        super(input);
    }

    public SaveFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected void process(PlanarImage entity) {
        JAI.create("filestore", entity.getAsBufferedImage(), "C:\\Users\\walte\\IdeaProjects\\ImgProcessing\\src\\main\\resources\\test.jpg", "JPEG");
    }
}
