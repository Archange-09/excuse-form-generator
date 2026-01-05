import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputForm extends JFrame implements ActionListener {

    private JTextField nm, course, yearSec, id;
    private JComboBox<String> day, mon, yr, day2, mon2, yr2;
    private JTextArea rea;
    private JRadioButton heal, sch, misc;
    private JButton sub, res;
    private ButtonGroup grp;

    private JPanel headerPanel;
    private JLabel headerLabel;

    private String[] date = {"--","1","2","3","4","5","6","7","8","9","10",
            "11","12","13","14","15","16","17","18","19","20",
            "21","22","23","24","25","26","27","28","29","30","31"};

    private String[] month = {"--","Jan","Feb","Mar","Apr","May","Jun",
            "Jul","Aug","Sep","Oct","Nov","Dec"};

    private String[] year = {"--","2023","2024","2025","2026","2027","2028","2029","2030"};

    public InputForm() {
        setTitle("Tarlac State University - Excuse Form Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(900, 850);
        setLocationRelativeTo(null); // Centers the window
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // HEADER
        headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 900, 80);
        headerPanel.setBackground(new Color(252, 186, 3)); // TSU Gold
        headerPanel.setLayout(null);

// --- ADDING THE LOGO ---
        try {
            // Load the image (ensure img.png is in your project root folder)
            ImageIcon originalIcon = new ImageIcon("D:\\OOP\\OOP\\src\\Tarlac_State_University_Seal.png");

            // Scale the image to fit the header (e.g., 60x60 pixels)
            Image scaledImage = originalIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            ImageIcon logoIcon = new ImageIcon(scaledImage);

            JLabel logoLabel = new JLabel(logoIcon);
            // Position it at x=50, y=10 (centered vertically in the 80px header)
            logoLabel.setBounds(50, 10, 60, 60);
            headerPanel.add(logoLabel);
        } catch (Exception e) {
            System.out.println("Logo not found, skipping...");
        }

// Adjust the text position so it doesn't overlap the logo
        headerLabel = new JLabel("TARLAC STATE UNIVERSITY - EXCUSE FORM");
        headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        headerLabel.setForeground(new Color(128, 0, 0)); // TSU Maroon
// Moved X to 120 to make room for the logo at X=50
        headerLabel.setBounds(120, 20, 650, 40);
        headerLabel.setHorizontalAlignment(SwingConstants.LEFT); // Left align next to logo
        headerPanel.add(headerLabel);

        add(headerPanel);

        JLabel titleLabel = new JLabel("Fill In Required Information");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        titleLabel.setBounds(45, 100, 500, 40);
        titleLabel.setForeground(new Color(0, 51, 102));
        add(titleLabel);

        JSeparator sep = new JSeparator();
        sep.setBounds(45, 150, 810, 2);
        sep.setForeground(new Color(0, 51, 102));
        add(sep);

        // FIELDS
        addLabel("Full Name:", 45, 175);
        nm = addTextField(320, 175, 500, 35);

        addLabel("Course:", 45, 225);
        course = addTextField(320, 225, 300, 35);

        addLabel("Year & Section:", 45, 275);
        yearSec = addTextField(320, 275, 180, 35);

        addLabel("Student ID:", 45, 325);
        id = addTextField(320, 325, 180, 35);

        // DURATION OF ABSENCE
        addLabel("Duration of Absence:", 45, 385);

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        fromLabel.setBounds(320, 385, 50, 30);
        add(fromLabel);

        // Adjusted dropdown positions to fit better
        mon  = addCombo(month, 370, 385, 70, 32);
        day  = addCombo(date, 445, 385, 50, 32);
        yr   = addCombo(year, 500, 385, 75, 32);

        JLabel toLabel = new JLabel("To:");
        toLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        toLabel.setBounds(590, 385, 30, 30);
        add(toLabel);

        mon2 = addCombo(month, 625, 385, 70, 32);
        day2 = addCombo(date, 700, 385, 50, 32);
        yr2  = addCombo(year, 755, 385, 75, 32);

        // REASON
        addLabel("Reason for Absence:", 45, 460);
        rea = new JTextArea();
        rea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        rea.setLineWrap(true);
        rea.setWrapStyleWord(true);
        rea.setBorder(BorderFactory.createLineBorder(new Color(0, 51, 102)));

        JScrollPane scrollRea = new JScrollPane(rea);
        scrollRea.setBounds(320, 460, 520, 110);
        add(scrollRea);

        // NATURE OF ABSENCE
        addLabel("Nature of Absence:", 45, 590);

        heal = new JRadioButton("Health Related");
        sch  = new JRadioButton("School / Organization Related");
        misc = new JRadioButton("Miscellaneous (Family, Personal, etc.)");

        JRadioButton[] rbs = {heal, sch, misc};
        grp = new ButtonGroup();
        for (int i = 0; i < rbs.length; i++) {
            rbs[i].setFont(new Font("Times New Roman", Font.PLAIN, 18));
            rbs[i].setBackground(Color.WHITE);
            rbs[i].setBounds(320, 590 + (i * 35), 400, 30);
            grp.add(rbs[i]);
            add(rbs[i]);
        }
        heal.setSelected(true);

        // BUTTONS
        res = new JButton("Reset Form");
        res.setFont(new Font("Times New Roman", Font.BOLD, 18));
        res.setBounds(320, 710, 240, 50);
        res.addActionListener(this);
        add(res);

        sub = new JButton("Generate Official Excuse Form");
        sub.setFont(new Font("Times New Roman", Font.BOLD, 18));
        sub.setBounds(580, 710, 280, 50);
        sub.setBackground(new Color(255, 255, 255)); // Adjusting to match button style
        sub.addActionListener(this);
        add(sub);

        JLabel footerNote = new JLabel("Note: All fields marked with * are required");
        footerNote.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        footerNote.setForeground(Color.RED);
        footerNote.setBounds(320, 770, 400, 20);
        add(footerNote);

        setVisible(true);
    }

    private void addLabel(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lbl.setForeground(new Color(0, 51, 102));
        lbl.setBounds(x, y, 250, 30);
        add(lbl);
    }

    private JTextField addTextField(int x, int y, int w, int h) {
        JTextField tf = new JTextField();
        tf.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        tf.setBounds(x, y, w, h);
        tf.setBorder(BorderFactory.createLineBorder(new Color(0, 51, 102)));
        add(tf);
        return tf;
    }

    private JComboBox<String> addCombo(String[] items, int x, int y, int w, int h) {
        JComboBox<String> cb = new JComboBox<>(items);
        cb.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        cb.setBounds(x, y, w, h);
        cb.setBackground(Color.WHITE);
        add(cb);
        return cb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {
            // Collect data from fields
            String dateFrom = mon.getSelectedItem() + " " + day.getSelectedItem() + ", " + yr.getSelectedItem();
            String dateTo = mon2.getSelectedItem() + " " + day2.getSelectedItem() + ", " + yr2.getSelectedItem();

            String selectedNature = "Miscellaneous";
            if(heal.isSelected()) selectedNature = "Health Related";
            else if(sch.isSelected()) selectedNature = "School/Organization Related";

            StudentInfo info = new StudentInfo(
                    nm.getText(), course.getText(), yearSec.getText(), id.getText(),
                    dateFrom, dateTo, rea.getText(), selectedNature
            );

            // Open the preview
            new OutputForm(info);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new InputForm();
        });
    }
}