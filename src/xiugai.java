import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class xiugai extends JFrame{
	private JButton
	b1=new JButton("完成"),
	b2=new JButton("取消");
	private ActionListener a=new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String name=((JButton)e.getSource()).getText();
			
			if (name.equals("完成")){
				DatabaseManager s = new DatabaseManager();
				String text = s.updataGarbageType(jtf.getText());
				s.updataGarbageType(jtf,b4.getText());
				JOptionPane.showMessageDialog(null,"修改成功");
			}else {
				dispose();
			}
		}
	};
	public xiugai(String text) {
		b3 = new JLabel("是");
		b4=new JTextField();
		b5 = new JLabel(text);
		setLayout(null);
		b4.setBounds(200,15,120,30);
		b3.setBounds(170,8,100,50);
		b1.setBounds(100,70,80,40);
		b1.addActionListener(a);
		b2.setBounds(220,70,80,40);
		b2.addActionListener(a);
		add(b3);
		add(b4);
		add(b1);
		add(b2);
		
		}
	private JLabel b3 ;
	private JTextField b4;
	private JLabel b5 ;
	}
