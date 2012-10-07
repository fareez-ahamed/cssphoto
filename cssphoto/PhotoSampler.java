
package cssphoto;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 *
 * @author Fareez Ahamed K.N.
 * Email - fareez.ahamed@gmail.com
 * Twitter - @fareez_ahamed
 * blog - freeze-cse.blogspot.com
 */
public class PhotoSampler {

    //Sampling distance
    private int spread=5;

    public PhotoSampler() {

    }

    public PhotoSampler(int spread) {
        this.spread = spread;
    }

    public Vector<Sample> getSamples(BufferedImage img) {
        Vector<Sample> samples = new Vector<Sample>();

        int xn = img.getWidth()/this.spread;
        int yn = img.getHeight()/this.spread;
        int r,g,b;
        Color color,temp;

        for(int x=0;x<xn;x++) {
            for(int y=0;y<yn;y++) {
                r=g=b=0;
                for(int i=x*spread;i<((x*spread)+spread);i++) {
                    for(int j=y*spread;j<((y*spread)+spread);j++) {
                        temp = new Color(img.getRGB(i, j));
                        r += temp.getRed();
                        g += temp.getGreen();
                        b += temp.getBlue();
                    }
                }
                new Color(10,10,10);
                r = r/(spread*spread);
                g = g/(spread*spread);
                b = b/(spread*spread);
                color = new Color(r,g,b);
                StringBuffer strColor = new StringBuffer(Integer.toHexString(color.getRGB() & 0x00FFFFFF));
                while (strColor.length() < 6) {
                    strColor.insert(0, '0');
                }
                samples.add(new Sample(x*spread,y*spread,strColor.toString()));
            }
        }

        return samples;
    }
}
