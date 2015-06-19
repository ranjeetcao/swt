package com.cao.app.ui.image;

import java.awt.image.BufferedImage;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.widgets.Composite;

/**
 * Shows BufferedImages in a SWT component.
 * 
 * @author Paul Vorbach
 */
public class ImageView extends org.eclipse.swt.widgets.Composite {
    private BufferedImage awtImage;
    private Image swtImage;

  
    public ImageView(Composite parent, int style) {
        super(parent, style);

        addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent evt) {
                final GC gc = evt.gc;

                final Image img = getImage();
                if (img == null)
                    return;

                gc.drawImage(img, 0, 0);
            }
        });
    }

  
    public BufferedImage getBufferedImage() {
        return awtImage;
    }

 
    public Image getImage() {
        return swtImage;
    }

 
    public void setBufferedImage(BufferedImage image) {
        if (swtImage != null)
            swtImage.dispose();

        awtImage = image;
        final int width = image.getWidth();
        final int height = image.getHeight();

        final PaletteData palette =
                new PaletteData(0xFF0000, 0x00FF00, 0x0000FF); // 24 bit RGB

        final ImageData data = new ImageData(width, height, 24, palette);

        for (int y = 0; y < data.height; y++) {
            for (int x = 0; x < data.width; x++) {
                // set pixel color but filter alpha
                data.setPixel(x, y, image.getRGB(x, y) & 0x00FFFFFF);
            }
        }

        swtImage = new Image(getDisplay(), data);
        System.out.println(data.data.length);

        setSize(width, height);

        redraw();
    }
}