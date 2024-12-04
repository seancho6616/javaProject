import javax.swing.*;
import java.awt.*;

public class StoreMain {
    public StoreMain() {
        JFrame frame = new JFrame("가게 계정 메인 페이지");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel();
        JLabel storeLabel = new JLabel("가게 이름");
        storeLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        topPanel.add(storeLabel);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("메뉴 수정", createMenuEditPanel());
        tabbedPane.addTab("주문 현황", createOrderPanel());
        tabbedPane.addTab("가게 정보", createInfoPanel());

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(tabbedPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private JPanel createMenuEditPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("메뉴 수정 화면", SwingConstants.CENTER), BorderLayout.NORTH);
        return panel;
    }

    private JPanel createOrderPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("주문 현황 화면", SwingConstants.CENTER), BorderLayout.NORTH);
        return panel;
    }

    private JPanel createInfoPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("가게 정보 화면", SwingConstants.CENTER), BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StoreMain::new);
    }
}
