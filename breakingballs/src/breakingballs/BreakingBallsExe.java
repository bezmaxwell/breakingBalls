package breakingballs;


import javax.swing.JFrame;

public class BreakingBallsExe {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		BreakingBalls brball = new BreakingBalls();
		frame.setBounds(10, 10, 700, 600);
		frame.setTitle("Breaking Balls");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(brball);
		
	}
}
