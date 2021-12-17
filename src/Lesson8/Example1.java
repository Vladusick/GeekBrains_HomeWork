package Lesson8;

import javax.swing.*;
import java.awt.*;

public class Example1 {


    static class MyWindow extends JFrame {
        public MyWindow() {
            setBounds(500,500,500,300);
            setTitle("Test Window");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            JButton button = new JButton("fdfdfdf");
            add(button, BorderLayout.PAGE_START);


            setVisible(true);
          //  setSize(800, 800);
          //  setLocationRelativeTo(null);

         //   JButton button = new JButton("Button 1 (PAGE_START)");
          //  add(button, BorderLayout.PAGE_START);

        //    button = new JButton("Button 2 (CENTER)");
         //   add(button, BorderLayout.CENTER);

     //       button = new JButton("Button 3 (LINE_START)");
      //      button.setSize(new Dimension(200, 200));
         //   add(button, BorderLayout.LINE_START);

       //     button = new JButton("Long-Named Button 4 (PAGE_END)");
        //    add(button, BorderLayout.PAGE_END);

        //    button = new JButton("Long-Named Button 5 (LINE_END)");
          //  add(button, BorderLayout.LINE_END);


            //  JButton[] jbs = new JButton[5];
            // for (int i = 0; i < 5; i++) {
            //    jbs[i] = new JButton("#" + i);
            // }
            // add(jbs[0], BorderLayout.EAST);
            // add(jbs[1], BorderLayout.WEST);
            // add(jbs[2], BorderLayout.SOUTH);
            // add(jbs[3], BorderLayout.NORTH);
            // add(jbs[4], BorderLayout.CENTER);
        //    setVisible(true);


            //  setLocationRelativeTo(null);
            //  setSize(400, 400);
            //   getContentPane().setBackground(new Color(40, 200, 250));

            //  setLocation(300, 150);

            //   setVisible(true);
        }
    }

    private static class WindowRunnable implements Runnable {

        public void run() {
            new MyWindow();
        }
    }

    public static void main(String[] args) {
        //new MyWindow();
        MyWindow mainWindow = new MyWindow();
// String str = "= value"+ 2+2;

 // int e = new int [4][8].length;
     //    System.out.println("llkbyf" + e);


     //   for (int i = 10; i > 0; i++) {

     //   }

     //   System.out.println(str);
        // EventQueue.invokeLater(new WindowRunnable());
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyWindow();
            }
        });

    }


    //   public void run() {new MyWindow()}
}






