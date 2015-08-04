package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tool.DBTool;
import bean.Grade;
import bean.GradeDao;

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

public class GradeAdd extends JFrame implements ActionListener{
	public static JTextField xuehao = new JTextField();
	public static JTextField name = new JTextField();
	public static JTextField class1 = new JTextField();
	public static JTextField class2 = new JTextField();
	public static JTextField class3 = new JTextField();
	public static JTextField class4 = new JTextField();
	GradeAdd()
    {
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(300,400);
        this.setLocationRelativeTo(null);
        //new ���
      	JLabel kemu = new JLabel("��Ŀ");
      	JLabel grade = new JLabel("�ɼ�");
      	JLabel xuehao1 = new JLabel("ѧ��");
      	JLabel name1 = new JLabel("����");
      	JLabel kemu1 = new JLabel("�γ�һ");
      	JLabel kemu2 = new JLabel("�γ̶�");
      	JLabel kemu3 = new JLabel("�γ���");
      	JLabel kemu4 = new JLabel("�γ���");

      	JButton btnSubmit = new JButton("ȷ��");
      	JButton btnReSet = new JButton("����");	
      		
      	//ע���¼�����
      	btnSubmit.addActionListener(this);
      	btnReSet.addActionListener(this);
      		
      	//�����������
      	JPanel panInput = new JPanel();
      	panInput.setLayout(new GridLayout(8, 2));
      	
      	panInput.add(kemu);
      	panInput.add(grade);
      	
      	panInput.add(xuehao1);
      	panInput.add(xuehao);
      	
      	panInput.add(name1);
      	panInput.add(name);
      	
      	panInput.add(kemu1);
      	panInput.add(class1);
      		
      	panInput.add(kemu2);
      	panInput.add(class2);
      		
      	panInput.add(kemu3);
      	panInput.add(class3);
      		
      	panInput.add(kemu4);
      	panInput.add(class4);
      		
      	panInput.add(btnSubmit);
      	panInput.add(btnReSet);
      		
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
		if(e.getActionCommand().equals("ȷ��")){
			if(xuehao.getText().equals("")
				||name.getText().equals("")
				||class1.getText().equals("")
				||class2.getText().equals("")
				||class3.getText().equals("")
				||class4.getText().equals("")){
			JOptionPane.showMessageDialog(null, "����д�����Ϣ");
			}else{
				Grade gr = new Grade();
				gr.setId(xuehao.getText());
				gr.setName(name.getText());
				gr.setClass1(Integer.parseInt(class1.getText()));
				gr.setClass2(Integer.parseInt(class2.getText()));
				gr.setClass3(Integer.parseInt(class3.getText()));
				gr.setClass4(Integer.parseInt(class4.getText()));
				int flag = GradeDao.add(gr);
				if(flag!=-1){
					JOptionPane.showMessageDialog(null, "��ӳɹ���");
				}else{
					JOptionPane.showMessageDialog(null, "���ʧ��");
				}
			}	
		}
		if(e.getActionCommand().equals("����")){
			xuehao.setText("");
			name.setText("");
			class1.setText("");
			class2.setText("");
			class3.setText("");
			class4.setText("");
		}
	}
}
