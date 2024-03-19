import javax.swing.*;
import java.awt.*;

public class GUI {

    private JTextArea textArea;

    public GUI () {
        initFrame();
    }

    private void initFrame() {
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel sideBar = new JPanel();
        JPanel mainArea = new JPanel(new BorderLayout());

        JButton saveButton = new JButton("save");
        saveButton.addActionListener(e -> {
            System.out.println(textArea.getText());
        });
        JButton topButton2 = new JButton("top2");
        JButton topButton3 = new JButton("top3");

        JButton sideButton1 = new JButton("side1");
        JButton sideButton2 = new JButton("side2");
        JButton sideButton3 = new JButton("side3");

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        topBar.add(saveButton);
        topBar.add(topButton2);
        topBar.add(topButton3);
        topBar.setBorder(BorderFactory.createTitledBorder("top bar"));

        Box sideBox = Box.createVerticalBox();
        sideBox.add(sideButton1);
        sideBox.add(sideButton2);
        sideBox.add(sideButton3);
        sideBar.add(sideBox);
        sideBar.setBorder(BorderFactory.createTitledBorder("side bar"));

        mainArea.add(scrollPane, BorderLayout.CENTER);
        mainArea.setBorder(BorderFactory.createTitledBorder("main area"));

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(topBar, BorderLayout.PAGE_START);
        frame.add(sideBar, BorderLayout.LINE_START);
        frame.add(mainArea, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
