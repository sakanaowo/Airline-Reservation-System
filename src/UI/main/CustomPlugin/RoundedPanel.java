package UI.main.CustomPlugin;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RoundedPanel extends JPanel {

    /**
     * Stroke size. it is recommended to set it to 1 for better view
     */
    protected int strokeSize = 1;
    /**
     * Sets if it has a High Quality view
     */
    protected boolean highQuality = true;
    /**
     * Double values for Horizontal and Vertical radius of corner arcs
     */
    protected Dimension arcs = new Dimension(20, 20);

    public RoundedPanel() {
        super();
        setOpaque(false);
    }

    /**
     * Phương thức bo tròn panel hiện tại
     * @param arcWidth độ rộng bo tròn
     * @param arcHeight độ cao bo tròn
     * @return Panel đã được bo tròn
     */
    public JPanel makeRounded(int arcWidth, int arcHeight) {
        // Lưu lại các thuộc tính hiện tại
        Component[] components = getComponents();
        LayoutManager layout = getLayout();
        Color background = getBackground();
        Color foreground = getForeground();
        Border border = getBorder();

        // Tạo panel mới kế thừa các thuộc tính
        RoundedPanel roundedPanel = new RoundedPanel();
        roundedPanel.setLayout(layout);
        roundedPanel.setBackground(background);
        roundedPanel.setForeground(foreground);
        roundedPanel.setBorder(border);
        roundedPanel.arcs = new Dimension(arcWidth, arcHeight);

        // Chuyển các component sang panel mới
        for (Component comp : components) {
            roundedPanel.add(comp);
        }

        // Sao chép các thuộc tính khác (nếu cần)
        roundedPanel.setPreferredSize(getPreferredSize());
        roundedPanel.setMinimumSize(getMinimumSize());
        roundedPanel.setMaximumSize(getMaximumSize());

        return roundedPanel;
    }

    /**
     * Phương thức bo tròn panel hiện tại với độ bo tròn mặc định
     * @return Panel đã được bo tròn
     */
    public JPanel makeRounded() {
        return makeRounded(20, 20);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;

        // Sets antialiasing if HQ
        if (highQuality) {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }

        // Draws the rounded opaque panel with borders
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width, height, arcs.width, arcs.height);
        graphics.setColor(getForeground());
        graphics.setStroke(new BasicStroke(strokeSize));
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);

        // Sets strokes to default
        graphics.setStroke(new BasicStroke());
    }
}