import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodGUI implements ActionListener {


    // JButton - performs an action upon being on/pushed

    // GridLayout - places components in a grid of cells.
    //              Each component takes all the available space within its cell
    //              and each cell is the same size.

    public static void main(String[] args) {
        //    String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        //    for(String font:fonts) System.out.println(font);

        new FoodGUI();



    }
    // ################# JFRAME OBJECTS ###################
    // Subdivisions
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();

    // Buttons
    JButton button1 = new JButton();
    JButton button2 = new JButton();


    JLabel title = new JLabel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();

    myTF textField1 = new myTF();
    myTF textField2 = new myTF();
    myTF textField3 = new myTF();
    myTF textField4 = new myTF();

    String [] foodTypes = "fruit, vegetable, legume (beans), nut (and seeds), dairy, red meat, poultry (only chicken), egg, fish, fat (oils/butter/margarine), sugar, grain (flours/cereals), starch (potatoes)".split(", ");
    JComboBox cBox = new JComboBox<>(foodTypes);


    // ################### DESIGN ######################

    // Images / Icons
    ImageIcon diet = new ImageIcon("Icons/diet.png");
    ImageIcon apple = new ImageIcon("Icons/apple.png");



    // APP Color Palette
    //colFrameBG, colButton, colFont, colLabelBG, colExtra
    Color colLabelBG = new Color(235,94,40);
    Color colExtra = new Color(37,36,34);
    Color colFrameBG = new Color(64,61,57);
    Color colButton = new Color(204,197,185);
    Color colFont = new Color(255,252,242);
    Border border = BorderFactory.createLineBorder(colExtra, 5);
    Border border2 = BorderFactory.createLineBorder(colExtra, 2);
    Food ob;




    FoodGUI(){
        frame.setSize(460,550);
        frame.getContentPane().setBackground(colFrameBG);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
        initObjects();

        frame.setVisible(true);
    }

    public void initObjects(){
        setButton1();
        setButton2();
        setLabels();
        setTitle();
        setComboBox();
//        setTextFields();
        setPanel1();
    }

    public void setPanel1(){
        panel1.setLayout(new GridLayout(6,1,0,5 ));
        panel1.setBounds(320, 70, 100, 225);

        panel1.setBackground(colFrameBG);
        panel1.add(textField1);
        panel1.add(cBox);
        panel1.add(textField2);
        panel1.add(textField3);
        panel1.add(textField4);
        panel1.add(button2);



        frame.add(panel1);
    }

    public void setComboBox(){
        cBox.setBackground(colFont);
        cBox.setBorder(BorderFactory.createLineBorder(colFrameBG, 4));
        cBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        cBox.setFocusable(true);
    }

    public void setLabels(){

        label1.setBorder(border);
        label1.setBounds(20,70,275,325);
        label1.setBackground(colFont);
        label1.setOpaque(true);
        label1.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        label1.setVerticalTextPosition(JButton.TOP);
        label1.setHorizontalTextPosition(JButton.CENTER);
        label1.setVerticalAlignment(JButton.TOP);
        label1.setHorizontalAlignment(JButton.CENTER);
        frame.add(label1);

        label2.setBounds(305,70,4,260);
        label2.setBackground(colLabelBG);
        label2.setOpaque(true);
        frame.add(label2);


    }
    public void setTitle(){
        title.setBounds(20,10,400,50);
        title.setForeground(colFont);

        title.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        title.setText("Nutrition Calculator ");
        title.setIcon(diet);
        title.setVerticalTextPosition(JButton.CENTER);
        title.setHorizontalTextPosition(JButton.LEFT);
        title.setVerticalAlignment(JButton.CENTER);
        title.setHorizontalAlignment(JButton.CENTER);
        frame.add(title);

    }


    public void setButton1(){
        button1.setBounds(20,400,400,90);
        button1.addActionListener(this);

        button1.setIcon(apple);
        button1.setFocusable(false);

        button1.setText("Calculate!");
        button1.setFont( new Font("Comic Sans MS", Font.PLAIN, 36) );
        button1.setVerticalTextPosition(JButton.TOP);
        button1.setHorizontalTextPosition(JButton.LEFT);

        button1.setBorder(border);
        button1.setBackground(colButton);
        button1.setForeground(colFrameBG);


        frame.add(button1);

    }

    public void setButton2(){
//        button2.setBounds(20,425,400,90);
        button2.addActionListener(this);

//        button2.setIcon(apple);
        button2.setFocusable(false);

        button2.setText("Reset");
        button2.setFont( new Font("Comic Sans MS", Font.PLAIN, 18) );
        button2.setVerticalTextPosition(JButton.TOP);
        button2.setHorizontalTextPosition(JButton.LEFT);

        button2.setBorder(border2);
        button2.setBackground(colButton);
        button2.setForeground(colFrameBG);


    }


    public String getField(JTextField tF){
        return tF.getText();
    }
    public void clearField(JTextField tF){
        tF.setText("");
    }
    public void clearAll(){
        clearField(textField1);
        cBox.setSelectedIndex(0);
        clearField(textField2);
        clearField(textField3);
        clearField(textField4);
    }

    public void makeFood(){
        String name = getField(textField1);
        String type = foodTypes[cBox.getSelectedIndex()];
        int p = Integer.parseInt(getField(textField2));
        int c = Integer.parseInt(getField(textField3));
        int f = Integer.parseInt(getField(textField4));

        ob = new Food(name, type,p,c,f);
//        System.out.println(ob);
        int cal = ob.getCalories();
        labelMaker(name,type, cal, p,c,f);
    }
    public void labelMaker(String name, String type, int cal, int p, int c, int f){

        String isLean = "";
        if(ob.isIs404020()) isLean+= name+" is lean!";
        else isLean+= name+" is not lean!";

        String newLabel =
                "<html>"+name+
                    "<br/> - Type: "+type+
                    "<br/> - Calories: "+cal+
                    "<br/> - Proteins: "+p+"g"+
                    "<br/> - Carbs: "+c+"g"+
                    "<br/> - Fats: "+f+"g"+
                    "<br/> Ratio: "+
                    "<br/> -"+ob.getPercentString()+
                    "<br/>"+isLean+
                "</html>";


        label1.setText(newLabel);
//        System.out.println(ob);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button1) {
            makeFood();
        }if(e.getSource() == button2) {
            clearAll();
        }
    }
}
