import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class tianjia extends JFrame{
	private JButton
	b1=new JButton("���"),
	b2=new JButton("ȡ��");
	private JTextField
	b5=new JTextField(),
	b6=new JTextField();
	private ActionListener a=new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String name=((JButton)e.getSource()).getText();
			if (name.equals("���")){
				DatabaseManager s = new DatabaseManager();
				String n = s.addGarbageType(b5.getText());
				String l = s.addGarbageType(b6.getText());
			}else {
				dispose();
			}
		}
	};
	public tianjia() {
		setLayout(new GridLayout(3,1));
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b1);
		add(b2);
		}
	private JLabel b3 = new JLabel("�������ƣ�");
	private JLabel b4 = new JLabel("�������");
	}
