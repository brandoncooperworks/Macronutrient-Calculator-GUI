import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class myTF extends JTextField{
    Color colLabelBG = new Color(235,94,40);
    Color colExtra = new Color(37,36,34);
    Color colFrameBG = new Color(64,61,57);
    Color colButton = new Color(204,197,185);
    Color colFont = new Color(255,252,242);

    myTF(){
        this.setPreferredSize(new Dimension(100, 15));
        this.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        this.setForeground(Color.black);
        this.setBackground(colFont);
        this.setBorder(BorderFactory.createLineBorder(colExtra, 4));

    }

}
