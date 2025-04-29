// ✅ Background.java
package Paper_logger;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {
    private final Image backgroundImage;

    public Background() {
        backgroundImage = new ImageIcon("Making library resources/Your favorite Picture").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
