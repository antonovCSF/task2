import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GUI {
    private JPanel space;
    private JTextField inputs;
    private JTextField outputs;
    private JButton fileReadButton;
    private JButton removeButton;


    public GUI() {
        fileReadButton.addActionListener(actionEvent -> {
            JFileChooser jfc = new JFileChooser();
            int ret = jfc.showDialog(null, "Load list");
            File file = null;
            if (ret == JFileChooser.APPROVE_OPTION) {
                file = jfc.getSelectedFile();
            }
            try {
                assert file != null;
                Scanner scn = new Scanner(file);
                inputs.setText(scn.nextLine());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        removeButton.addActionListener(actionEvent -> {
            MyLinkedList list = toList(inputs.getText().split(" "));
            list.removeEven();
            int[] array = list.toArray();
            StringBuilder string = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                string.append(array[i]).append(" ");
            }
            outputs.setText(string.toString());
        });
    }

    private MyLinkedList toList(String[] text){
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < text.length; i++) {
            list.add(Integer.parseInt(text[i]));
        }
        return list;
    }

    public static void main (String[] args){
        JFrame frame = new JFrame("Task 2");
        frame.setContentPane(new GUI().space);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit tkt = Toolkit.getDefaultToolkit();
        Dimension dim = tkt.getScreenSize();
        frame.setBounds(dim.width / 2 - 250, dim.height / 2 - 150, 500, 300);
        frame.setVisible(true);
    }
}
