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
 * CopyRright (c)2014-:   大连校联科技有限公司 
 * Project:                                         
 * Module ID: Index
 * Comments:                                             
 * JDK version used:      JDK1.7                              
 * Author：       李雪峰                 
 * Create Date：  2014年11月26日 
 * Modified By：                                           
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
		//new 组件
		JLabel welcome = new JLabel("欢迎使用成绩处理软件（成绩在0~100之间）");
		JButton btnAdd = new JButton("成绩录入");
		JButton btnQuery = new JButton("成绩查询");	
		
		//注册事件监听
		Index e = new Index();
		btnAdd.addActionListener(e);
		btnQuery.addActionListener(e);
		
		//布置输入面板
		JPanel panInput = new JPanel();
		panInput.setLayout(new GridLayout(3, 1));
		panInput.add(welcome);
		panInput.add(btnAdd);
		panInput.add(btnQuery);
		
		//布置窗体
		w.setLayout(new BorderLayout());
		w.add(panInput,BorderLayout.CENTER);
		w.setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("成绩录入")){
			
			GradeAdd w = new GradeAdd();
			w.setVisible(true);
			this.setVisible(false);
		}
		if(e.getActionCommand().equals("成绩查询")){
			GradeQuery w = new GradeQuery();
			w.setVisible(true);
			this.setVisible(false);
		}
	}
}
