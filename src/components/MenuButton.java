/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JButton;



public class MenuButton extends JButton {

    /**
     * @return the iconSimple
     */
    public Icon getIconSimple() {
        return iconSimple;
    }

    /**
     * @param iconSimple the iconSimple to set
     */
    public void setIconSimple(Icon iconSimple) {
        this.iconSimple = iconSimple;
    }

    /**
     * @return the iconSelected
     */
    public Icon getIconSelected() {
        return iconSelected;
    }

    /**
     * @param iconSelected the iconSelected to set
     */
    public void setIconSelected(Icon iconSelected) {
        this.iconSelected = iconSelected;
    }
    private Icon iconSimple;
    private Icon iconSelected;
    public MenuButton(){
        setContentAreaFilled(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    @Override
    public void setSelected(boolean b) {
        super.setSelected(b); 
        if(b){
            setIcon(iconSelected);
        }
        else{
            setIcon(iconSelected);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        if(isSelected()){
            g.setColor(new Color(110,213,255));
            g.fillRect(0, getHeight()-5, getWidth(), getHeight());
        }
    }
    
    
    
}
