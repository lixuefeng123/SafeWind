package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import bean.Grade;
import bean.GradeDao;
import bean.TableModel;

/** 
 * CopyRright (c)2014-:   大连校联科技有限公司 
 * Project:                                         
 * Module ID: GradeTiaojian
 * Comments:                                             
 * JDK version used:      JDK1.7                              
 * Author：       李雪峰                 
 * Create Date：  2014年11月27日 
 * Modified By：                                           
 * Modified Date:                                      
 * Why & What is modified      
 * Version: 1.0                       
 */

public class GradeTiaojian extends JFrame implements ActionListener{
	private JTable table = null;
	public static JPanel panInput=null;
	TableModel tm = null;
	public static String b;
	GradeTiaojian(String a)
    {
		b=a;
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        //new 组件
      	JButton btnChart = new JButton("表格显示");
      	JButton btnPrint = new JButton("打印成绩单");
      	JButton btnAnaly = new JButton("成绩分析");
      	
      	//注册事件监听
      	btnChart.addActionListener(this);
      	btnPrint.addActionListener(this);
      	btnAnaly.addActionListener(this);
      	
      	//布置输入面板
      	panInput = new JPanel();
      	panInput.setLayout(new GridLayout(5,1));
      	
      	panInput.add(btnChart);
      	panInput.add(btnPrint);
      	panInput.add(btnAnaly);
      		
      	//布置窗体
      	this.setLayout(new BorderLayout());
      	this.add(panInput,BorderLayout.CENTER);	
    }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("表格显示")){
			List<Grade> list = GradeDao.selectOne(b);
			if(list.isEmpty()){
				JOptionPane.showMessageDialog(null, "查询失败！！");
			}
			Object[][] datavalues = new Object[list.size()][6];
			for(int i=0;i<list.size();i++){
				Grade co = list.get(i);
				datavalues[i][0] = co.getId();
				datavalues[i][1] = co.getName();
				datavalues[i][2] = co.getClass1();
				datavalues[i][3] = co.getClass2();
				datavalues[i][4] = co.getClass3();
				datavalues[i][5] = co.getClass4();
			}
			tm = new TableModel();
			this.setvalues(datavalues);
			table = new JTable(tm);
			table.updateUI();
			JScrollPane jsp = new JScrollPane(table);
			jsp.setBounds(0, 200, 600, 182);
			panInput.add(jsp);
			
		}
		if(e.getActionCommand().equals("成绩分析")){
			List<Grade> list = GradeDao.selectOne(b);
			if(list.isEmpty()){
				JOptionPane.showMessageDialog(null, "查询失败！！");
			}
			Object[][] datavalues = new Object[list.size()][6];
			for(int i=0;i<list.size();i++){
				Grade co = list.get(i);
				datavalues[i][0] = co.getId();
				datavalues[i][1] = co.getName();
				datavalues[i][2] = co.getClass1();
				datavalues[i][3] = co.getClass2();
				datavalues[i][4] = co.getClass3();
				datavalues[i][5] = co.getClass4();
				int x = Math.max(co.getClass1(),co.getClass2())>Math.max(co.getClass3(), co.getClass4())?Math.max(co.getClass1(),co.getClass2()):Math.max(co.getClass3(),co.getClass4());
				int y = Math.min(co.getClass1(),co.getClass2())<Math.min(co.getClass3(), co.getClass4())?Math.min(co.getClass1(),co.getClass2()):Math.min(co.getClass3(),co.getClass4());
				int z = (co.getClass1()+co.getClass2()+co.getClass3()+co.getClass4())/4;
				JOptionPane.showMessageDialog(null, "成绩最高的为"+x+"成绩最低为"+y+"平均分为"+z);
				
			}
			
		}
		if(e.getActionCommand().equals("打印成绩单")){
			int i = 0;
			List<Grade> list = GradeDao.selectOne(b);
			if(list.isEmpty()){
				JOptionPane.showMessageDialog(null, "打印失败！！");
			}
			Object[][] datavalues = new Object[list.size()][6];
			Grade co = list.get(i);
			try {
				File f = new File("D:/grade.txt");
				
				FileWriter fw = new FileWriter(f);
				PrintWriter pw = new PrintWriter(fw);
				pw.println(list);
				
				pw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			JOptionPane.showMessageDialog(null, "打印成功！");
		}
	}
	/**
		 *  @Description:
		 * 	@param 
		 * 	@param 
		 * 	@return 
		 */
	private void setvalues(Object[][] datavalues) {
		// TODO Auto-generated method stub
		this.tm.setDatavalues(datavalues);
	}
}
