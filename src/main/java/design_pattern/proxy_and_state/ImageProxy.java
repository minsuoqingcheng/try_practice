package design_pattern.proxy_and_state;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageProxy extends ImageIcon {

    private URL url;
    private String description;
    private ImageIcon imageIcon;


    public ImageProxy(URL url, String description) {
        this.url = url;
        this.description = description;
        imageIcon = new ImageNotLoadIcon(this);
    }

    public int getIconWidth() {
        return imageIcon.getIconWidth();
    }

    public int getIconHeight() {
        return imageIcon.getIconHeight();
    }


    public void paintIcon(final Component c, Graphics  g, int x, int y) {
        imageIcon.paintIcon(c, g, x, y);
    }



    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
}
