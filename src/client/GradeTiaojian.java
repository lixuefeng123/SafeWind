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
 * CopyRright (c)2014-:   ����У���Ƽ����޹�˾ 
 * Project:                                         
 * Module ID: GradeTiaojian
 * Comments:                                             
 * JDK version used:      JDK1.7                              
 * Author��       ��ѩ��                 
 * Create Date��  2014��11��27�� 
 * Modified By��                                           
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
        //new ���
      	JButton btnChart = new JButton("�����ʾ");
      	JButton btnPrint = new JButton("��ӡ�ɼ���");
      	JButton btnAnaly = new JButton("�ɼ�����");
      	
      	//ע���¼�����
      	btnChart.addActionListener(this);
      	btnPrint.addActionListener(this);
      	btnAnaly.addActionListener(this);
      	
      	//�����������
      	panInput = new JPanel();
      	panInput.setLayout(new GridLayout(5,1));
      	
      	panInput.add(btnChart);
      	panInput.add(btnPrint);
      	panInput.add(btnAnaly);
      		
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
		if(e.getActionCommand().equals("�����ʾ")){
			List<Grade> list = GradeDao.selectOne(b);
			if(list.isEmpty()){
				JOptionPane.showMessageDialog(null, "��ѯʧ�ܣ���");
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
		if(e.getActionCommand().equals("�ɼ�����")){
			List<Grade> list = GradeDao.selectOne(b);
			if(list.isEmpty()){
				JOptionPane.showMessageDialog(null, "��ѯʧ�ܣ���");
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
				JOptionPane.showMessageDialog(null, "�ɼ���ߵ�Ϊ"+x+"�ɼ����Ϊ"+y+"ƽ����Ϊ"+z);
				
			}
			
		}
		if(e.getActionCommand().equals("��ӡ�ɼ���")){
			int i = 0;
			List<Grade> list = GradeDao.selectOne(b);
			if(list.isEmpty()){
				JOptionPane.showMessageDialog(null, "��ӡʧ�ܣ���");
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
			JOptionPane.showMessageDialog(null, "��ӡ�ɹ���");
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
