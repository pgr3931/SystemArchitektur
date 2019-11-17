package solution;

import pmp.filter.Source;
import pmp.interfaces.Writeable;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import java.io.StreamCorruptedException;
import java.security.InvalidParameterException;
import java.util.Objects;

public class ImageSource extends Source<PlanarImage> {
    private boolean flag;

    ImageSource(Writeable<PlanarImage> output) throws InvalidParameterException {
        if (output == null) {
            throw new InvalidParameterException("output filter can't be null!");
        }
        m_Output = output;
    }

    ImageSource() {

    }

    @Override
    public PlanarImage read() throws StreamCorruptedException {
        try {
            if (!flag) {
                flag = true;
                return JAI.create("fileload", Objects.requireNonNull(getClass().getClassLoader().getResource("loetstellen.jpg")).getPath());
            } else return null;
        } catch (Exception e) {
            throw new StreamCorruptedException(e.getMessage());
        }
    }
}
