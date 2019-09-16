import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class wrong extends JFrame{
	private JButton
	b1=new JButton("去修改"),
	b2=new JButton("取消");
	String mingcheng;
	private ActionListener a=new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String name=((JButton)e.getSource()).getText();
			if (name.equals("去修改")){
				nodata.run(new xiugai(mingcheng),200,100);
			}else {
				dispose();
			}
		}
	};
	public wrong(String mingcheng,String type) {
		b3 = new JLabel(type,JLabel.CENTER);
		setLayout(null);
		b3.setBounds(140,10,100,50);
		b1.setBounds(100,70,80,40);
		b1.addActionListener(a);
		b2.setBounds(220,70,80,40);
		b2.addActionListener(a);
		add(b3);
		add(b1);
		add(b2);
		}
	private JLabel b3 ;
	}


	