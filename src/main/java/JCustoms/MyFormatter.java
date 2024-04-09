/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JCustoms;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author kaiqu
 */
public class MyFormatter extends JPanel {

    private JFormattedTextField campoCPF;

    public MyFormatter() {
        // Configuração do campo de CPF
        try {
            MaskFormatter formatter = new MaskFormatter("A##-A#A#");
            formatter.setPlaceholderCharacter('_'); // Caractere de preenchimento
            campoCPF = new JFormattedTextField(formatter);
            campoCPF.setValue(""); // Valor inicial (opcional)

            
            campoCPF.setOpaque(false);
            campoCPF.setBorder(new EmptyBorder(0, 2, 3, 4));
            
           
            campoCPF.setColumns(20);
            campoCPF.setFont(new Font("Arial", Font.PLAIN, 16));
           
            colorClick = new Color(152, 184, 144);
            borderColor = new Color(30, 136, 56);

            
            
            //  Add event mouse
            addMouseListener(new MouseAdapter() {

                public void focusGained(FocusEvent fe) {
                setColor(new Color(128, 189, 255));
                repaint();
                }
                
                
                public void focusLost(FocusEvent fe) {
                setColor(new Color(206, 212, 218));
                repaint();
                }
                

            });
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        // Adicionando o campo de CPF ao painel
        this.setLayout(new FlowLayout());
        this.add(campoCPF);
    }
    
        private Shape shape;

    @Override
    protected void paintComponent(Graphics g) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(shape);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getForeground());
        g2.draw(shape);
    }
 
    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    private boolean over;
    private Color colorOver;
    private Color colorClick;
    private Color borderColor;
    private int radius = 0;

    
    private Color focusColor = new Color(128, 189, 255);
    private Color color = new Color(206, 212, 218);
    private int round;
   

// Métodos específicos da classe (se necessário)
// Por exemplo, você pode criar um método para obter o valor do CPF digitado.
    public String getCPF() {
        return campoCPF.getText().replaceAll("[^0-9]", ""); // Remove caracteres não numéricos
    }
}
