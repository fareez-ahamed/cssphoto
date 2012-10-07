
package cssphoto;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import javax.imageio.ImageIO;

/**
 * This program creates a HTML page of the given image with just CSS3
 * 
 * @author Fareez Ahamed K.N.
 * Email - fareez.ahamed@gmail.com
 * Twitter - @fareez_ahamed
 * blog - freeze-cse.blogspot.com
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        // TODO code application logic here
        BufferedImage img;
        img = ImageIO.read(new File("avatar.jpg"));
        PrintStream out = new PrintStream(new FileOutputStream("photo.htm"));
        int blur = 4;
        int spread = 5;
        PhotoSampler ps = new PhotoSampler(spread);
        Vector<Sample> res = ps.getSamples(img);

        out.print("<html><head><style>");
        out.println("#photo { " +
                "position:absolute;" +
                "width:0px;" +
                "height:0px;" +
                "box-shadow:");
        for(int i=0;i<res.size();i++) {
            out.print(res.get(i).getCSSBoxShadowString(blur,spread));
            if(i == (res.size()-1))
                out.println(";");
            else
                out.println(",");
        }
        out.println("}</style>" +
                "</head>" +
                "<body>" +
                "<div id='photo' />" +
                "</body>" +
                "</html>");
        out.close();
    }

}
