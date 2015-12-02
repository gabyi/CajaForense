/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
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
public class BtnRedCommand extends JButton implements Command {
//  JPanel p;
  JFrame p;

  public BtnRedCommand(String caption, JFrame pnl) {
   super(caption);
//   validate();
    p = pnl;
  }

    

  public void Execute() {
    p.setBackground(Color.red);
this.setBackground(Color.red);
    p.setBounds(500, 500,500, 300);
  }


  

//    @Override
//    public void actionPerformed(ActionEvent e) {
//       System.out.println("eveasdasdasntoooooo");
//    }

}