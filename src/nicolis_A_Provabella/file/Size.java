package nicolis_A_Provabella.file;

import java.awt.Dimension;

/**
 * An immutable class to replace Dimension
 * @author Henri
 *
 */
public class Size {
    public static final Size MOUSECLICK = new Size(0,0);
    public final int width;
    public final int height;

    public Size(int width, int height){
        this.width = width;
        this.height = height;
    }

    public Size(Size size){
        width = size.width;
        height = size.height;
    }

    public Size(Dimension dimension){
        Dimension dim = new Dimension(dimension);
        width = dim.width;
        height = dim.height;
    }

    @Override
    public String toString() {
        return "Size [width=" + width + ", height=" + height + "]";
    }
}
