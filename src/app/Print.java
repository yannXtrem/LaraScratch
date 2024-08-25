/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author yanni
 */
public class Print {
    private static  javax.swing.JTextPane printer;
    public static void setPrinter( javax.swing.JTextPane p){
        printer = p;
    }
    public static void line(String msg){
        System.out.println(msg);
        printer.setText(msg);
    }
    public static void newLine(String msg){
        System.out.println(msg);
        String oldline = printer.getText();
        printer.setText(oldline+ "\n" + msg);
    }
    
}
