import javax.swing.*;
import java.awt.*;

public class LoginSingup {
    public static void main(String[] args) {
        // 메인 프레임 생성
        JFrame frame = new JFrame("로그인 및 회원가입");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE); // 배경색 설정

        // 상단 로그인 패널
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(4, 2, 10, 10));
        loginPanel.setBorder(BorderFactory.createTitledBorder("로그인"));
        loginPanel.setBackground(Color.GRAY); // 패널 배경색 설정

        JLabel idLabel = new JLabel("아이디");
        JTextField idField = new JTextField();
        JLabel pwLabel = new JLabel("비밀번호");
        JPasswordField pwField = new JPasswordField();

        JButton loginButton = new JButton("로그인");

        loginPanel.add(idLabel);
        loginPanel.add(idField);
        loginPanel.add(pwLabel);
        loginPanel.add(pwField);
        loginPanel.add(new JLabel()); // 빈 공간
        loginPanel.add(loginButton);

        frame.add(loginPanel, BorderLayout.NORTH);

        // 하단 패널 (로그인 및 회원가입)
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 20, 20));
        bottomPanel.setBackground(Color.GRAY);

        // 사용자 및 가게 로그인 섹션
        JPanel userLoginPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        userLoginPanel.setBorder(BorderFactory.createTitledBorder("로그인"));
        userLoginPanel.setBackground(Color.GRAY);

        JButton userLoginButton = new JButton("사용자 로그인");
        JButton storeLoginButton = new JButton("가게 로그인");

        userLoginPanel.add(userLoginButton);
        userLoginPanel.add(storeLoginButton);

        // 사용자 및 가게 회원가입 섹션
        JPanel userSignupPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        userSignupPanel.setBorder(BorderFactory.createTitledBorder("회원가입"));
        userSignupPanel.setBackground(Color.GRAY);

        JButton userSignupButton = new JButton("사용자 회원가입");
        JButton storeSignupButton = new JButton("가게 회원가입");

        userSignupPanel.add(userSignupButton);
        userSignupPanel.add(storeSignupButton);

        // 하단 패널에 로그인 및 회원가입 섹션 추가
        bottomPanel.add(userLoginPanel);
        bottomPanel.add(userSignupPanel);

        frame.add(bottomPanel, BorderLayout.CENTER);

        // 프레임 표시
        frame.setVisible(true);
    }
}
