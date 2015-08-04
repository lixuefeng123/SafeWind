package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;

import tool.DBTool;
import bean.Grade;
import bean.GradeDao;
import bean.TableModel;

/** 
 * CopyRright (c)2014-:   大连校联科技有限公司 
 * Project:                                         
 * Module ID: GradeAdd
 * Comments:                                             
 * JDK version used:      JDK1.7                              
 * Author：       李雪峰                 
 * Create Date：  2014年11月26日 
 * Modified By：                                           
 * Modified Date:                                      
 * Why & What is modified      
 * Version: 1.0                       
 */

public class GradeQuery extends JFrame implements ActionListener{
	public static JTextField tiaojian = new JTextField();
	private JTable table = null;
	public static JPanel panInput=null;
	TableModel tm = null;
	GradeQuery()
    {
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        //new 组件
      	JLabel kemu = new JLabel("成绩查询");
      	JLabel xuehao = new JLabel("输入学号");

      	JButton btnChart = new JButton("查询");
      	JButton btnPrint = new JButton("条件查询");	
      	
      	//注册事件监听
      	btnChart.addActionListener(this);
      	btnPrint.addActionListener(this);
      	
      	//布置输入面板
      	panInput = new JPanel();
      	panInput.setLayout(new GridLayout(6,2));
      	
      	panInput.add(kemu);
      	panInput.add(btnChart);
      	panInput.add(btnPrint);
      	panInput.add(xuehao);
      	panInput.add(tiaojian);
      		
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
		if(e.getActionCommand().equals("查询")){
			List<Grade> list = GradeDao.selectAll();
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
		if(e.getActionCommand().equals("条件查询")){
			if(tiaojian.getText().equals("")){
				JOptionPane.showMessageDialog(null, "请填写查询条件");
			}else{
				String a = tiaojian.getText();
				GradeTiaojian w = new GradeTiaojian(a);
				w.setVisible(true);
				this.setVisible(false);
			}
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
