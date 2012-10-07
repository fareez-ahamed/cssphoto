/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cssphoto;

/**
 *
 * @author Fareez Ahamed K.N.
 * Email - fareez.ahamed@gmail.com
 * Twitter - @fareez_ahamed
 * blog - freeze-cse.blogspot.com
 */
public class Sample {

    private int x;
    private int y;
    private String color;

    public Sample(int x,int y,String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public String getCSSBoxShadowString(int blur, int spread) {
        String s = x+"px "+y+"px "+blur+"px "+spread+"px #"+color;
        return s;
    }
}
