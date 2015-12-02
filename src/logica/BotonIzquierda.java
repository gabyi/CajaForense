/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 *
 * @author jau
 */
public class BotonIzquierda extends JButton implements Command {
//  JPanel p;
  JFrame p;
  Toolkit t = Toolkit.getDefaultToolkit();
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  
  
  
  

  public BotonIzquierda(String caption, JFrame pnl) {
   super(caption);
//   validate();
    p = pnl;
    this.setVisible(true);
    
  }

    

  public void Execute() {
    //p.setBackground(Color.red);
    //this.setBackground(Color.red);
    p.setBounds(0,0,screenSize.width/2, screenSize.height);
    p.requestFocus();
  }


  

//    @Override
//    public void actionPerformed(ActionEvent e) {
//       System.out.println("eveasdasdasntoooooo");
//    }

}