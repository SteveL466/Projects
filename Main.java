import javax.swing.*;
public class Main {

    public static void main (String[] args){
       JFrame miFrame = new JFrame ("Anexo Broker");
       miFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
       interfaz panel = new interfaz();
       miFrame.getContentPane().add(panel);
       miFrame.pack();
       miFrame.setVisible(true);
     } 
   }