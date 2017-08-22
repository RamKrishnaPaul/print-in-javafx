/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

/**
 *
 * @author Ram Krishna Paul
 */
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextEditFrame extends JFrame {

  private JTextArea textArea = new JTextArea(8, 40);

  private JScrollPane scrollPane = new JScrollPane(textArea);

  private JTextField fromField = new JTextField(8);

  private JTextField toField = new JTextField(8);

  public TextEditFrame() {
    setTitle("TextEditTest");
    setSize(500, 300);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    Container contentPane = getContentPane();

    JPanel panel = new JPanel();

    JButton replaceButton = new JButton("Replace");
    panel.add(replaceButton);
    replaceButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        String from = fromField.getText();
        int start = textArea.getText().indexOf(from);
        if (start >= 0 && from.length() > 0)
          textArea.replaceRange(toField.getText(), start, start
              + from.length());
      }
      
    });

    panel.add(fromField);

    panel.add(new JLabel("with"));

    panel.add(toField);

    contentPane.add(panel, "South");
    contentPane.add(scrollPane, "Center");
  }

  public static void main(String[] args) {
     
    JFrame f = new TextEditFrame();
    
    f.show();
  }
}
