import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UserMain {
    static DTBL d = DTBL();
    static String userid;
    static List<String> userData = new ArrayList<String>();
    public static void main(String[] args) {
        userid = d.getUserid(); // 테스트용 ID
        userData = Select.SelectUser(userid);

        if (userData != null && userData.size() >= 4) {
            d.setUserid(userData.get(0)); // Index 0: userid
            System.out.println("User ID 저장 성공: " + d.getUserid());
        } else {
            System.err.println("User 데이터가 올바르지 않습니다.");
        }
    }

    private static void showLoadingScreen() {
        JFrame loadingFrame = new JFrame("로딩 중...");
        JLabel loadingLabel = new JLabel("메인 화면을 준비 중입니다...", SwingConstants.CENTER);
        loadingLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        loadingFrame.add(loadingLabel);
        loadingFrame.setSize(300, 200);
        loadingFrame.setLocationRelativeTo(null);
        loadingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadingFrame.setVisible(true);

        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                prepareMainPage();
                return null;
            }

            @Override
            protected void done() {
                loadingFrame.dispose();
                SwingUtilities.invokeLater(() -> createMainPage());
            }
        }.execute();
    }

    private static void prepareMainPage() {
        try {
            Thread.sleep(1000); // 예제용 딜레이
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void createMainPage() {
        JFrame frame = new JFrame("사용자 메인 페이지");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("추천 메뉴", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(2, 5, 5, 5));
        menuPanel.setBackground(Color.LIGHT_GRAY);

        String[] menuItems = {"치킨", "피자", "중국집", "찜", "분식", "족발보쌈", "한식", "햄버거"};
        String[] imagePaths = {
            "images/chicken.png", "images/pizza.png", "images/chinese.png",
            "images/stew.png", "images/snack.png", "images/pork.png",
            "images/korean.png", "images/burger.png"
        };

        for (int i = 0; i < menuItems.length; i++) {
            ImageIcon scaledIcon = loadImage(imagePaths[i]);
            JButton button = new JButton(menuItems[i], scaledIcon);
            button.setFont(new Font("SansSerif", Font.PLAIN, 16));
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
            int index = i; // 람다에서 사용할 변수
            button.addActionListener(e -> new StoreList(menuItems[index]));
            menuPanel.add(button);
        }
        frame.add(menuPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 3, 10, 10));
        bottomPanel.setBackground(Color.LIGHT_GRAY);

        String[] bottomButtons = {"구매내역", "장바구니", "내정보"};
        DefaultListModel<String> cartModel = new DefaultListModel<>();
        for (String label : bottomButtons) {
            JButton button = new JButton(label);
            button.setFont(new Font("SansSerif", Font.BOLD, 16));
            button.addActionListener(e -> {
                switch (label) {
                    case "구매내역":
                        new myAccount().showMyAccountWindow(); // 구매내역 창 열기
                        break;
                    case "장바구니":
                        new Cart(cartModel).showCartWindow(); // 장바구니 창 열기
                        break;
                    case "내정보":
                        new MyInfo(userData); // 내정보 창 열기
                        break;
                }
            });
            bottomPanel.add(button);
        }
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private static ImageIcon loadImage(String path) {
        try {
            ImageIcon originalIcon = new ImageIcon(path);
            Image scaledImage = originalIcon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } catch (Exception e) {
            System.err.println("Failed to load image: " + path);
            return new ImageIcon();
        }
    }
}
