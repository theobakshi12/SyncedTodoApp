import javax.swing.*;
import java.awt.*;

public class GUI {

    private JTextArea textArea;
    private JTextField usernameField;
    private Backend backend;

    public GUI () {
        backend = new Backend();
        initFrame();
    }

    private void initFrame() {
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel sideBar = new JPanel();
        JPanel mainArea = new JPanel(new BorderLayout());

        JButton saveButton = new JButton("save");
        saveButton.addActionListener(e -> {
            backend.save(usernameField.getText(), textArea.getText());
        });
        JButton loadButton = new JButton("load");
        loadButton.addActionListener(e -> {
            textArea.setText(backend.getContent(usernameField.getText()));
        });
        usernameField = new JTextField("theobakshi12");
        usernameField.setEditable(true);

        JButton sideButton1 = new JButton("side1");
        JButton sideButton2 = new JButton("side2");
        JButton sideButton3 = new JButton("side3");

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        textArea.setText(backend.getContent(usernameField.getText())); //load on startup

        topBar.add(saveButton);
        topBar.add(loadButton);
        topBar.add(usernameField);
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
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
