package solution;

import pmp.filter.Source;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import java.io.StreamCorruptedException;
import java.util.Objects;

public class ImageSource extends Source<PlanarImage> {
    private boolean flag;

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
