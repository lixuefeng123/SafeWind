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
 * CopyRright (c)2014-:   ����У���Ƽ����޹�˾ 
 * Project:                                         
 * Module ID: GradeAdd
 * Comments:                                             
 * JDK version used:      JDK1.7                              
 * Author��       ��ѩ��                 
 * Create Date��  2014��11��26�� 
 * Modified By��                                           
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
        //new ���
      	JLabel kemu = new JLabel("�ɼ���ѯ");
      	JLabel xuehao = new JLabel("����ѧ��");

      	JButton btnChart = new JButton("��ѯ");
      	JButton btnPrint = new JButton("������ѯ");	
      	
      	//ע���¼�����
      	btnChart.addActionListener(this);
      	btnPrint.addActionListener(this);
      	
      	//�����������
      	panInput = new JPanel();
      	panInput.setLayout(new GridLayout(6,2));
      	
      	panInput.add(kemu);
      	panInput.add(btnChart);
      	panInput.add(btnPrint);
      	panInput.add(xuehao);
      	panInput.add(tiaojian);
      		
      	//���ô���
      	this.setLayout(new BorderLayout());
      	this.add(panInput,BorderLayout.CENTER);	
    }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("��ѯ")){
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
		if(e.getActionCommand().equals("������ѯ")){
			if(tiaojian.getText().equals("")){
				JOptionPane.showMessageDialog(null, "����д��ѯ����");
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
