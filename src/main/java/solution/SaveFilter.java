package solution;

import pmp.filter.DataTransformationFilter1;
import pmp.interfaces.Readable;
import pmp.interfaces.Writeable;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import java.security.InvalidParameterException;
import java.util.Objects;

public class SaveFilter extends DataTransformationFilter1<PlanarImage> {
    SaveFilter(Readable<PlanarImage> input) throws InvalidParameterException {
        super(input);
    }

    SaveFilter(Writeable<PlanarImage> output) throws InvalidParameterException {
        super(output);
    }

    @Override
    protected void process(PlanarImage entity) {
        JAI.create("filestore", entity.getAsBufferedImage(), Objects.requireNonNull(getClass().getClassLoader().getResource("result.jpg")).getPath(), "JPEG");
    }
}
