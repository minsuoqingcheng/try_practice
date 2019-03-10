package design_pattern.proxy_and_state;

import javax.swing.*;
import java.net.URL;

public class ImageLoadIcon extends ImageIcon {

    private URL url;
    private String description;

    public ImageLoadIcon(URL location, String description) {
        super(location, description);
        this.url = location;
        this.description = description;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
