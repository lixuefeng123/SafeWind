package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.TableModel;

import bean.Grade;
import bean.GradeDao;

/** 
 * CopyRright (c)2014-:   ����У���Ƽ����޹�˾ 
 * Project:                                         
 * Module ID: Index
 * Comments:                                             
 * JDK version used:      JDK1.7                              
 * Author��       ��ѩ��                 
 * Create Date��  2014��11��26�� 
 * Modified By��                                           
 * Modified Date:                                      
 * Why & What is modified      
 * Version: 1.0                       
 */

public class Index extends JFrame implements ActionListener{
	public Index()
    {
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(300,400);
        this.setLocationRelativeTo(null);
    }
	public static void main(String args[]){
		JFrame w = new JFrame();
		
		w.setSize(300, 400);
		w.setLocationRelativeTo(null);
		w.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//new ���
		JLabel welcome = new JLabel("��ӭʹ�óɼ�����������ɼ���0~100֮�䣩");
		JButton btnAdd = new JButton("�ɼ�¼��");
		JButton btnQuery = new JButton("�ɼ���ѯ");	
		
		//ע���¼�����
		Index e = new Index();
		btnAdd.addActionListener(e);
		btnQuery.addActionListener(e);
		
		//�����������
		JPanel panInput = new JPanel();
		panInput.setLayout(new GridLayout(3, 1));
		panInput.add(welcome);
		panInput.add(btnAdd);
		panInput.add(btnQuery);
		
		//���ô���
		w.setLayout(new BorderLayout());
		w.add(panInput,BorderLayout.CENTER);
		w.setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("�ɼ�¼��")){
			
			GradeAdd w = new GradeAdd();
			w.setVisible(true);
			this.setVisible(false);
		}
		if(e.getActionCommand().equals("�ɼ���ѯ")){
			GradeQuery w = new GradeQuery();
			w.setVisible(true);
			this.setVisible(false);
		}
	}
}
