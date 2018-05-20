package createglobalhotkey;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import com.melloware.jintellitype.Main;

//创建全局快捷键
public class CreateGHKDemo extends JFrame implements ActionListener {
	public JButton jb1, jb2, jb3, jb4, jb5, jb6;
	// 快捷键1,2,3个
	public static final int GLOBAL_HOT_KEY_1 = 0;
	public static final int GLOBAL_HOT_KEY_2 = 1;
	public static final int GLOBAL_HOT_KEY_3 = 2;

	// 初始化
	public CreateGHKDemo() {
		init();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CreateGHKDemo();
			}
		});
	}

	// 初始化
	private void init() {
		JPanel jp1 = new JPanel();
		jp1.setLayout(null);
		jb1 = new JButton("注册快捷键(D):跳出弹框");
		jb1.setBounds(20, 20, 260, 30);
		jb1.addActionListener(this);
		jp1.add(jb1);

		jb2 = new JButton("注册快捷键(Shift+D):跳出弹框");
		jb2.setBounds(20, 60, 260, 30);
		jb2.addActionListener(this);
		jp1.add(jb2);

		jb3 = new JButton("注册快捷键(Shift+Ctrl+D):跳出弹框");
		jb3.setBounds(20, 100, 260, 30);
		jb3.addActionListener(this);
		jp1.add(jb3);

		jb4 = new JButton("删除快捷键(D):跳出弹框");
		jb4.setBounds(20, 140, 260, 30);
		jb4.addActionListener(this);
		jp1.add(jb4);

		jb5 = new JButton("删除快捷键(Shift+D):跳出弹框");
		jb5.setBounds(20, 180, 260, 30);
		jb5.addActionListener(this);
		jp1.add(jb5);

		jb6 = new JButton("删除快捷键(Shift+Ctrl+D):跳出弹框");
		jb6.setBounds(20, 220, 260, 30);
		jb6.addActionListener(this);
		jp1.add(jb6);

		// 添加热键监听器
		// 第二步：添加热键监听器
		JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
			public void onHotKey(int markCode) {
				switch (markCode) {
				case GLOBAL_HOT_KEY_1:
					JOptionPane.showMessageDialog(null, "注册快捷键(D):跳出弹框！", "提示消息", JOptionPane.WARNING_MESSAGE);
					break;
				case GLOBAL_HOT_KEY_2:
					JOptionPane.showMessageDialog(null, "注册快捷键(Shift+D):跳出弹框！", "提示消息", JOptionPane.WARNING_MESSAGE);
					break;
				case GLOBAL_HOT_KEY_3:
					JOptionPane.showMessageDialog(null, "注册快捷键(Shift+Ctrl+D):跳出弹框！", "提示消息",
							JOptionPane.WARNING_MESSAGE);
					break;
				}
			}
		});

		this.add(jp1);
		this.setTitle("注册全局快捷键");
		this.setSize(310, 310);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 事件监听
	@Override
	public void actionPerformed(ActionEvent e) {
		// 监听注册全局快捷键
		if (e.getSource().equals(jb1)) {
			// 第一步：注册热键，热键标识，组合键（shift），主要热键D
			JIntellitype.getInstance().registerHotKey(GLOBAL_HOT_KEY_1, 0, (int) 'D');
			JOptionPane.showMessageDialog(null, "注册快捷键(D):跳出弹框！", "提示消息", JOptionPane.WARNING_MESSAGE);
		}
		// 监听注册全局快捷键
		if (e.getSource().equals(jb2)) {
			JIntellitype.getInstance().registerHotKey(GLOBAL_HOT_KEY_2, JIntellitype.MOD_SHIFT, (int) 'D');
			JOptionPane.showMessageDialog(null, "注册快捷键(Shift+D):跳出弹框！", "提示消息", JOptionPane.WARNING_MESSAGE);
		}
		// 监听注册全局快捷键
		if (e.getSource().equals(jb3)) {
			JIntellitype.getInstance().registerHotKey(GLOBAL_HOT_KEY_3,
					JIntellitype.MOD_SHIFT + JIntellitype.MOD_CONTROL, (int) 'D');
			JOptionPane.showMessageDialog(null, "注册快捷键(Shift+Ctrl+D):跳出弹框！", "提示消息", JOptionPane.WARNING_MESSAGE);
		}
		// 监听删除全局快捷键
		if (e.getSource().equals(jb4)) {
			JIntellitype.getInstance().unregisterHotKey(GLOBAL_HOT_KEY_1);
			JOptionPane.showMessageDialog(null, "删除快捷键(D):跳出弹框！", "提示消息", JOptionPane.WARNING_MESSAGE);
		}
		// 监听删除全局快捷键
		if (e.getSource().equals(jb5)) {
			JIntellitype.getInstance().unregisterHotKey(GLOBAL_HOT_KEY_2);
			JOptionPane.showMessageDialog(null, "删除快捷键(Shift+D):跳出弹框！", "提示消息", JOptionPane.WARNING_MESSAGE);
		}
		// 监听删除全局快捷键
		if (e.getSource().equals(jb6)) {
			JIntellitype.getInstance().unregisterHotKey(GLOBAL_HOT_KEY_3);
			JOptionPane.showMessageDialog(null, "删除快捷键(Shift+Ctrl+D):跳出弹框！", "提示消息", JOptionPane.WARNING_MESSAGE);
		}
	}

}
