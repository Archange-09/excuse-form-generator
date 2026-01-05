import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OutputForm extends JFrame {
    private JPanel mainPanel;
    private JTextPane doc;
    private JButton printBtn, saveBtn, closeBtn;

    // TSU OFFICIAL COLORS
    private final Color TSU_MAROON = new Color(128, 0, 0);
    private final Color TSU_GOLD = new Color(252, 186, 3);
    private final String MAROON_HEX = "#800000";

    public OutputForm(StudentInfo student) {
        setTitle("TSU Official Excuse Letter - Preview");
        setSize(850, 950);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // ========== HEADER WITH LOGO ==========
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 3, 0, TSU_GOLD),
                BorderFactory.createEmptyBorder(15, 40, 15, 40)
        ));

// 1. Logo Section (Left Side)
// We set a fixed size for this container to ensure the "Sandwich" balance
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        logoPanel.setBackground(Color.WHITE);
        logoPanel.setPreferredSize(new Dimension(100, 100));

        try {
            ImageIcon originalIcon = new ImageIcon("D:\\OOP\\OOP\\src\\Tarlac_State_University_Seal.png");
            // Scaled to match the 1:1 ratio of 316x316
            Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            logoPanel.add(new JLabel(new ImageIcon(scaledImage)));
        } catch (Exception e) {
            JLabel logoText = new JLabel("TSU");
            logoText.setFont(new Font("Times New Roman", Font.BOLD, 40));
            logoText.setForeground(TSU_MAROON);
            logoPanel.add(logoText);
        }

// 2. University Information (Center)
        JPanel uniInfoPanel = new JPanel();
        uniInfoPanel.setLayout(new BoxLayout(uniInfoPanel, BoxLayout.Y_AXIS));
        uniInfoPanel.setBackground(Color.WHITE);

// Vertical alignment: This pushes the text down to align with the logo's mid-point
        uniInfoPanel.add(Box.createVerticalStrut(12));

        JLabel uniName = new JLabel("TARLAC STATE UNIVERSITY");
        uniName.setFont(new Font("Times New Roman", Font.BOLD, 28));
        uniName.setForeground(TSU_MAROON);
        uniName.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel address = new JLabel("Romulo Boulevard, Tarlac City 2300, Philippines");
        address.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        address.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel contact = new JLabel("Tel: (045) 982-0542 | registrar@tsu.edu.ph");
        contact.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        contact.setForeground(Color.DARK_GRAY);
        contact.setAlignmentX(Component.CENTER_ALIGNMENT);

        uniInfoPanel.add(uniName);
        uniInfoPanel.add(Box.createVerticalStrut(2));
        uniInfoPanel.add(address);
        uniInfoPanel.add(contact);

// 3. The Balancing Act
        headerPanel.add(logoPanel, BorderLayout.WEST);
        headerPanel.add(uniInfoPanel, BorderLayout.CENTER);

// Add an invisible strut to the EAST that is the same width as the logo (100px)
// This forces the Center text to be truly centered on the entire window width
        headerPanel.add(Box.createHorizontalStrut(100), BorderLayout.EAST);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // ========== DOCUMENT CONTENT ==========
        String documentType = student.getNature().contains("Health") ? "MEDICAL EXCUSE LETTER" : "OFFICIAL EXCUSE LETTER";

        // CSS matching the TSU Maroon color
        String htmlContent = "<html>"
                + "<head><style>"
                + "body { font-family: 'Times New Roman', serif; font-size: 13pt; line-height: 1.5; padding: 20px; }"
                + ".doc-title { text-align: center; color: " + MAROON_HEX + "; margin-bottom: 25px; text-decoration: underline; }"
                + ".field-label { font-weight: bold; color: " + MAROON_HEX + "; }"
                + ".stamp-area { border: 2px dashed " + MAROON_HEX + "; padding: 10px; margin-top: 15px; text-align: center; font-size: 10pt; color: #555; }"
                + "table { width: 100%; margin: 10px 0; border-collapse: collapse; }"
                + "td { padding: 6px; vertical-align: top; }"
                + "</style></head>"
                + "<body>"
                + "<div class='doc-title'><h1>" + documentType + "</h1></div>"
                + "<p><b>Date:</b> " + new SimpleDateFormat("MMMM dd, yyyy").format(new Date()) + "</p>"
                + "<p><b>TO WHOM IT MAY CONCERN:</b></p>"
                + "<p style='text-indent: 40px;'>This is to officially certify the following information regarding the student mentioned below:</p>"
                + "<table>"
                + "<tr><td class='field-label' width='30%'>Name:</td><td>" + student.getName() + "</td></tr>"
                + "<tr><td class='field-label'>Student ID:</td><td>" + student.getStudentId() + "</td></tr>"
                + "<tr><td class='field-label'>Course/Section:</td><td>" + student.getCourse() + " - " + student.getYearSection() + "</td></tr>"
                + "<tr><td class='field-label'>Period:</td><td>" + student.getStartDate() + " to " + student.getEndDate() + "</td></tr>"
                + "<tr><td class='field-label'>Reason:</td><td>" + student.getReason() + "</td></tr>"
                + "</table>"
                + "<p>This excuse is granted in accordance with existing university policies.</p>"
                + "<div style='margin-top: 30px;'>" // Reduced spacing above signatures
                + "<table style='border:none;'>"
                + "<tr><td align='center'>_______________________<br><b>Student Signature</b></td>"
                + "<td align='center'>_______________________<br><b>Registrar / Dean</b></td></tr>"
                + "</table></div>"
                + "<div class='stamp-area'>OFFICIAL TSU SEAL<br>(Must be stamped for validity)</div>"
                + "</body></html>";

        doc = new JTextPane();
        doc.setContentType("text/html");
        doc.setText(htmlContent);
        doc.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(doc);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // ========== BUTTONS ==========
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));

        printBtn = createStyledButton("Print Document", Color.WHITE, TSU_MAROON);
        printBtn.addActionListener(e -> {
            try { doc.print(); } catch (Exception ex) { ex.printStackTrace(); }
        });

        saveBtn = createStyledButton("Save as PDF", Color.WHITE, TSU_MAROON);

        closeBtn = createStyledButton("Close", new Color(220, 220, 220), Color.BLACK);
        closeBtn.addActionListener(e -> dispose());

        buttonPanel.add(printBtn);
        buttonPanel.add(saveBtn);
        buttonPanel.add(closeBtn);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private JButton createStyledButton(String text, Color bg, Color fg) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setPreferredSize(new Dimension(170, 40));
        btn.setFocusPainted(false);
        // Added TSU Gold border to buttons for contrast
        btn.setBorder(BorderFactory.createLineBorder(TSU_GOLD, 1));
        return btn;
    }
}