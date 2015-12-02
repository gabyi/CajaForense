/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author jau
 */
public class BotonCentro extends JButton implements Command {
//  JPanel p;
  JFrame p;
   
  Toolkit t = Toolkit.getDefaultToolkit();
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

  public BotonCentro(String caption, JFrame pnl) {
   super(caption);
//   validate();
    p = pnl;
    this.setVisible(true);
  }

    

  public void Execute() {
    p.setBounds(0,0,screenSize.width, screenSize.height);
    
  }


  

//    @Override
//    public void actionPerformed(ActionEvent e) {
//       System.out.println("eveasdasdasntoooooo");
//    }

}