import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class chaxun extends JFrame {
	//�������
	JPanel jp1,jp2;
	JLabel jlb1;
	JTextField jtf;
	JButton jb1,jb2;
    //ActionListener b;
	public static void main(String[] args) {
		chaxun cx =new chaxun();
		
		}
	private ActionListener b=new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String name=((JButton)e.getSource()).getText();
			if (name.equals("��ѯ")){//equals�Ƚ������ַ������ж��Ƿ����
				//�Ƚ�name�����ݿ�����Ƿ����
				DatabaseManager s = new DatabaseManager();
				String result = s.getGarbageType(jtf.getText());
				
				if (result.equals("")){
					//��ʾ��������
					nodata.run(new qutianjia(),200,100);
				}else{
					//��ʾ��������
					//JOptionPane.showMessageDialog(jtf, result);
					nodata.run(new wrong(result),200,100);
					}
				}else{
					dispose();//System.exit(0);
				}
					// 
				}
		};
	
	//����
	public chaxun()  {
		//�������
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jlb1 = new JLabel("�������ƣ�");
		jtf = new JTextField(10);
		
		jb1 = new JButton("��ѯ");
		jb1.addActionListener(b);
		jb2 = new JButton("ȡ��");
		jb2.addActionListener(b);
		
		//���ò���
		this.setLayout(new GridLayout(3,1));
		//�������ӵ�JPanel
		jp1.add(jlb1);
		jp1.add(jtf);
		
		jp2.add(jb1);
		jp2.add(jb2);
		
		//��JPanel��ӵ�JFrame
		this.add(jp1);
		this.add(jp2);
		
		//���ô�������
		this.setTitle("�������࣬�����ҿ�ʼ");
		this.setSize(400, 200);
		this.setLocation(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}


class nodata{
		public static void run(final JFrame f,final int width,final int height) {
			SwingUtilities.invokeLater(new Runnable(){
				public void run() {
					f.setTitle("�������࣬�����ҿ�ʼ");
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f.setSize(400,200);
					f.setLocation(500,300);
					f.setVisible(true);
				}
			});
		}
}

