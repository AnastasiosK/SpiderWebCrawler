/**
 * Created by Luigi on 13/12/2017.
 */
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.annotation.processing.Filer;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass extends JFrame {
    public static void main(String args[]){
        MainClass a = new MainClass();

    }
            MainClass(){
                JFrame f = new JFrame("Hello");
                JPanel panel = new JPanel();
                JButton button = new JButton("Find text");
                JButton loadText = new JButton("Email button");
                final JTextArea edit = new JTextArea(30, 60);

                f.setLayout(new BorderLayout());
                f.setSize(800, 600);
                f.setVisible(true);
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                button.setSize(50,50);
                button.setVisible(true);
                loadText.setSize(50,50);
                loadText.setVisible(true);
                panel.add(edit);
                f.add(panel);
                panel.add(button);
                panel.add(loadText);

                loadText.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String s = edit.getText();
                        Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(s);
                        while (m.find()) {
                            System.out.println(m.group());
                        }
                    }
                });

                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        JFileChooser fileChooser = new JFileChooser();
                        int returnValue = fileChooser.showOpenDialog(null);
                        File selectedFile = fileChooser.getSelectedFile();
                        String filename = selectedFile.getAbsolutePath();
                        if (returnValue == JFileChooser.APPROVE_OPTION) {
                            try {
                                FileReader reader = new FileReader(filename);
                                BufferedReader br = new BufferedReader(reader);
                                edit.read(br,null);
                                br.close();
                                edit.requestFocus();
                            }
                            catch (Exception e){

                            }
                        }
                    }
                });

            }

}
