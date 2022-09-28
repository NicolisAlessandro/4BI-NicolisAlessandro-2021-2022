package nicolis_A_Provabella.file;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ImageHolder {
    private static final Map<String, Image> imageMap = new HashMap<>();

    private ImageHolder() {
        throw new IllegalAccessError("ImageHolder class must not be initialized");
    }

    static Image getImage(String imageName) {
        return imageMap.get(imageName);
    }

    static void putImage(String imageName, Image image) {
        imageMap.put(imageName, image);
    }
}
