import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.DecimalFormat;

public class interfaz extends JPanel{
  private JLabel bienvenida, entrada1, entrada2, entrada3, entrada4, entrada5, entrada6, entrada7, entrada8, entrada9, entrada10,entrada11,entrada12;
  private JTextField campo1, campo3;
  private JButton boton1, boton2;
  private JComboBox combo1, combo2;
  private TextArea area1,area2,area3,area4,area5,area6;

  private int mes[] = new int[24];
  private double capital[]= new double[24];
  private double interes[]=new double [24];
  private double suma[]=new double [24];
  private double saldo[] = new double[24];

  public interfaz(){
    setLayout(null);
    bienvenida = new JLabel("Bienvenido a Anexo Broker");
    entrada1 = new JLabel("Inversión");
    entrada2 = new JLabel("Tasa");
    entrada3 = new JLabel("Aportación");
    entrada4 = new JLabel("Plazo");
    entrada5 = new JLabel("Mes");
    entrada6 = new JLabel("Capital");
    entrada7 = new JLabel("Aportación");
    entrada8 = new JLabel("Suma");
    entrada9 = new JLabel("Rendimiento");
    entrada10 = new JLabel("Saldo");
    entrada11 = new JLabel("%");
    entrada12 = new JLabel("mes/es");

    String plazos[]= {"1", "3", "6", "12", "18", "24"};
    String tasas[]= {"8","11"};

    combo1 = new JComboBox(plazos);
    combo2 = new JComboBox(tasas);

    campo1 = new JTextField(15);
    campo3 = new JTextField(15);

    area1 = new TextArea("",24,1,3);
    area2 = new TextArea("",24,1,3);
    area3 = new TextArea("",24,1,3);
    area4 = new TextArea("",24,1,3);
    area5 = new TextArea("",24,1,3);
    area6 = new TextArea("",24,1,3);

    boton1 = new JButton("Calcular :)");
    boton2 = new JButton("Limpiar");
    boton1.addActionListener(new TempListener());
    boton2.addActionListener(new TempListener());

    bienvenida.setFont(new Font("Arial Black",Font.BOLD,20));
    entrada1.setFont(new Font("Arial Black",Font.BOLD,12));
    entrada2.setFont(new Font("Arial Black",Font.BOLD,12));
    entrada3.setFont(new Font("Arial Black",Font.BOLD,12));
    entrada4.setFont(new Font("Arial Black",Font.BOLD,12));
    entrada5.setFont(new Font("Arial Black", Font.BOLD,10));
    entrada6.setFont(new Font("Arial Black", Font.BOLD,10));
    entrada7.setFont(new Font("Arial Black", Font.BOLD,10));
    entrada8.setFont(new Font("Arial Black", Font.BOLD,10));
    entrada9.setFont(new Font("Arial Black", Font.BOLD,10));
    entrada10.setFont(new Font("Arial Black", Font.BOLD,10));
    entrada11.setFont(new Font("Arial Black",Font.BOLD,12));
    entrada12.setFont(new Font("Arial Black",Font.BOLD,12));

    bienvenida.setBounds(100,10,500,30);
    entrada1.setBounds(120,100,100,30);
    campo1.setBounds(190,100,100,30);
    campo3.setBounds(190,300,100,30);
    entrada3.setBounds(110,200,100,30);
    campo3.setBounds(190,200,100,30);
    entrada2.setBounds(152,300,100,30);
    combo2.setBounds(190,300,100,30);
    entrada4.setBounds(150,400,100,30);
    combo1.setBounds(190,400,100,30);

    boton1.setBounds(165,500,150,60);
    boton2.setBounds(190,580,100,30);

    entrada5.setBounds(450,115,100,10);
    entrada6.setBounds(500,115,100,10);
    entrada7.setBounds(650,115,100,10);
    entrada8.setBounds(800,115,100,10);
    entrada9.setBounds(950,115,100,10);
    entrada10.setBounds(1100,115,100,10);
    entrada11.setBounds(295,300,100,30);
    entrada12.setBounds(295,400,100,30);

    area1.setBounds(450,130,50,360);
    area2.setBounds(500,130,150,360);
    area3.setBounds(650,130,150,360);
    area4.setBounds(800,130,150,360);
    area5.setBounds(950,130,150,360);
    area6.setBounds(1100,130,150,360);

    add(bienvenida);
    add(entrada1);
    add(campo1);
    add(entrada2);
    add(entrada3);
    add(campo3);
    add(entrada4);
    add(combo2);
    add(combo1);

    add(boton1);
    add(boton2);

    add(entrada5);
    add(entrada6);
    add(entrada7);
    add(entrada8);
    add(entrada9);
    add(entrada10);
    add(entrada11);
    add(entrada12);

    add(area1);
    add(area2);
    add(area3);
    add(area4);
    add(area5);
    add(area6);

    setPreferredSize(new Dimension(800,800));
    setBackground(new Color(166,220,255));
  }

  private class TempListener implements ActionListener{
    public void actionPerformed(ActionEvent e){

    DecimalFormat df = new DecimalFormat("$###,###,###.00");
    int conteo = Integer.parseInt(combo1.getSelectedItem().toString());
    double tasa = (Double.parseDouble(combo2.getSelectedItem().toString()))/100;

      if(e.getSource() == boton1){
        limpiar1();
        capital[0] = Double.parseDouble(campo1.getText());

        for(int i = 0;i<conteo;i++){
            mes[i] = i+1;
            double aport = Double.parseDouble(campo3.getText());

            suma[i]= capital[i] + aport;
            interes[i] = suma[i]*(tasa/12);
            saldo[i] = suma[i]+interes[i];

            area1.append(String.valueOf(mes[i])+"\n");
            area2.append(df.format((capital[i]))+"\n");
            area3.append(String.valueOf((campo3.getText()))+"\n");
            area4.append(df.format((suma[i]))+"\n");
            area5.append(df.format((interes[i]))+"\n");
            area6.append(df.format((saldo[i]))+"\n");

            capital[i+1]=saldo[i];
        }

      }
      else if(e.getSource() == boton2){
        limpiar2();
      }
    }
  }

  private void limpiar1(){
        area1.setText("");
        area2.setText("");
        area3.setText("");
        area4.setText("");
        area5.setText("");
        area6.setText("");
  }

  private void limpiar2(){
        campo1.setText("");
        campo3.setText("");
        area1.setText("");
        area2.setText("");
        area3.setText("");
        area4.setText("");
        area5.setText("");
        area6.setText("");
  }
} 