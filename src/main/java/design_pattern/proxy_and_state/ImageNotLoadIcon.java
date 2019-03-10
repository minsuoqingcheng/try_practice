package design_pattern.proxy_and_state;

import javax.swing.*;
import java.awt.*;

public class ImageNotLoadIcon extends ImageIcon {

    private ImageProxy imageProxy;

    public ImageNotLoadIcon(ImageProxy imageProxy) {
        this.imageProxy = imageProxy;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.drawString("Loading CD cover, please wait...", x+ 300, y+190);
        Thread fetchThread = new Thread(() -> {
            ImageLoadIcon loadIcon = new ImageLoadIcon(imageProxy.getUrl(), imageProxy.getDescription());
            imageProxy.setImageIcon(loadIcon);
            c.repaint();
        });
        fetchThread.start();
    }

    @Override
    public int getIconWidth() {
        return 800;
    }

    @Override
    public int getIconHeight() {
        return 600;
    }
}
