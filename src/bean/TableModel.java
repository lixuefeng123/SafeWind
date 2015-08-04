package bean;

import javax.swing.table.AbstractTableModel;

/** 
 * CopyRright (c)2014-:   ����У���Ƽ����޹�˾ 
 * Project:                                         
 * Module ID: TableModel
 * Comments:                                             
 * JDK version used:      JDK1.7                              
 * Author��       ��ѩ��                 
 * Create Date��  2014��11��26�� 
 * Modified By��                                           
 * Modified Date:                                      
 * Why & What is modified      
 * Version: 1.0                       
 */

public class TableModel extends AbstractTableModel{
	
	public final static String[] columnHeaders ={
		"ѧ��","����","��Ŀһ","��Ŀ��","��Ŀ��","��Ŀ��"
	};
	private Object[][] datavalues = {
			{" "," "," "," "," ",""}
	};
	

	/**
	 * @return the datavalues
	 */
	public Object[][] getDatavalues() {
		return datavalues;
	}

	/**
	 * @param datavalues the datavalues to set
	 */
	public void setDatavalues(Object[][] datavalues) {
		this.datavalues = datavalues;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datavalues.length;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return datavalues[0].length;
	}
	public String getColumnName(int column){
		return columnHeaders[column];
	}
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return datavalues[rowIndex][columnIndex];
	}

}
