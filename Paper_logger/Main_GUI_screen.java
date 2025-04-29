// ✅ Main_GUI_screen.java
package Paper_logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main_GUI_screen extends JFrame {
    private List<Paper> paperList = new ArrayList<>();

    private JTextField titleField = new JTextField(30);
    private JTextField authorField = new JTextField(30);
    private JTextField yearOrDateField = new JTextField(30);
    private JTextField siteField = new JTextField(30);
    private JTextArea commentArea = new JTextArea(5, 30);

    public Main_GUI_screen() {
        setTitle("📄 Paper Logger");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);

        Background background = new Background();
        background.setLayout(new BorderLayout());
        setContentPane(background);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setOpaque(false);

        formPanel.add(createLabeledRow("Title:", titleField));
        formPanel.add(createLabeledRow("Author:", authorField));
        formPanel.add(createLabeledRow("Year or Date (YYYY or YYYY-MM-DD):", yearOrDateField));
        formPanel.add(createLabeledRow("Site:", siteField));

        JPanel commentPanel = new JPanel(new BorderLayout());
        commentPanel.setOpaque(false);
        commentPanel.add(new JLabel("Comment:"), BorderLayout.NORTH);
        commentPanel.add(new JScrollPane(commentArea), BorderLayout.CENTER);
        formPanel.add(commentPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        JButton saveButton = new JButton("SAVE");
        JButton openButton = new JButton("OPEN");
        buttonPanel.add(saveButton);
        buttonPanel.add(openButton);

        background.add(formPanel, BorderLayout.CENTER);
        background.add(buttonPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(e -> {
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();
            String yearOrDate = yearOrDateField.getText().trim();
            String site = siteField.getText().trim();
            String comment = commentArea.getText().trim();

            if (title.isEmpty() || author.isEmpty() || yearOrDate.isEmpty() || site.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields.");
                return;
            }

            if (!yearOrDate.matches("\\d{4}") && !yearOrDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                JOptionPane.showMessageDialog(this, "Year must be in YYYY or YYYY-MM-DD format.");
                return;
            }

            Paper paper = new Paper(title, author, yearOrDate, site, comment);
            paperList.add(paper);

            try {
                Save.saveToFile(paperList, "papers.csv");
                JOptionPane.showMessageDialog(this, "✅ Saved to papers.csv");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "❌ Save failed");
            }

            titleField.setText("");
            authorField.setText("");
            yearOrDateField.setText("");
            siteField.setText("");
            commentArea.setText("");
        });

        openButton.addActionListener(e -> {
            try {
                File file = new File("papers.csv");
                if (!file.exists()) {
                    JOptionPane.showMessageDialog(this, "⚠️ papers.csv does not exist");
                    return;
                }
                Desktop.getDesktop().open(file);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "❌ Failed to open CSV");
            }
        });

        File file = new File("papers.csv");
        if (file.exists()) {
            try {
                paperList = Open.loadFromFile("papers.csv");
            } catch (Exception ignored) {}
        }

        setVisible(true);
    }

    private JPanel createLabeledRow(String labelText, JTextField textField) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        JLabel label = new JLabel(labelText);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel labelPanel = new JPanel(new BorderLayout());
        labelPanel.setOpaque(false);
        labelPanel.add(label, BorderLayout.EAST);
        labelPanel.setPreferredSize(new Dimension(250, 30));

        panel.add(labelPanel, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main_GUI_screen::new);
    }
}