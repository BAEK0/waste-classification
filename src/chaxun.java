import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class chaxun extends JFrame {
	//定义组件
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
			if (name.equals("查询")){//equals比较两个字符串，判断是否相等
				//比较name和数据库里的是否相等
				DatabaseManager s = new DatabaseManager();
				String result = s.getGarbageType(jtf.getText());
				
				if (result.equals("")){
					//提示暂无数据
					nodata.run(new qutianjia(),200,100);
				}else{
					//显示垃圾类型
					//JOptionPane.showMessageDialog(jtf, result);
					nodata.run(new wrong(result),200,100);
					}
				}else{
					dispose();//System.exit(0);
				}
					// 
				}
		};
	
	//构造
	public chaxun()  {
		//创建组件
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jlb1 = new JLabel("垃圾名称：");
		jtf = new JTextField(10);
		
		jb1 = new JButton("查询");
		jb1.addActionListener(b);
		jb2 = new JButton("取消");
		jb2.addActionListener(b);
		
		//设置布局
		this.setLayout(new GridLayout(3,1));
		//将组件添加到JPanel
		jp1.add(jlb1);
		jp1.add(jtf);
		
		jp2.add(jb1);
		jp2.add(jb2);
		
		//将JPanel添加到JFrame
		this.add(jp1);
		this.add(jp2);
		
		//设置窗体属性
		this.setTitle("垃圾分类，从你我开始");
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
					f.setTitle("垃圾分类，从你我开始");
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f.setSize(400,200);
					f.setLocation(500,300);
					f.setVisible(true);
				}
			});
		}
}

