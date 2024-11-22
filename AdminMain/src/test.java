import java.awt.*;
import javax.swing.*;

public class test extends JFrame {
	private JLabel title;
	
	public test() {
		setTitle("관리자 계정 페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		title = new JLabel("가게 관리");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("Arial Rounded MT 굵게", Font.BOLD, 30));
		c.add(title, BorderLayout.NORTH);
		
		JTabbedPane pane = createTabbedPane();
		c.add(pane);
		setSize(800,600);
		setVisible(true);
	}
	
	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.BOTTOM);
		pane.addTab("tab1", new JLabel(new ImageIcon("images/img1.jpg")));
		pane.addTab("tab2", new JLabel(new ImageIcon("images/img2.jpg")));
		
		return pane;	

	}
	public static void main(String [] args) {
		new test();
	}

}
