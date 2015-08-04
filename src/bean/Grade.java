package bean;

/** 
 * CopyRright (c)2014-:   大连校联科技有限公司 
 * Project:                                         
 * Module ID: Grade
 * Comments:                                             
 * JDK version used:      JDK1.7                              
 * Author：       李雪峰                 
 * Create Date：  2014年11月26日 
 * Modified By：                                           
 * Modified Date:                                      
 * Why & What is modified      
 * Version: 1.0                       
 */

public class Grade {
	private String id;
	private String name;
	private int class1;
	private int class2;
	private int class3;
	private int class4;
	
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * @return the class1
	 */
	public int getClass1() {
		return class1;
	}
	/**
	 * @param class1 the class1 to set
	 */
	public void setClass1(int class1) {
		this.class1 = class1;
	}
	/**
	 * @return the class2
	 */
	public int getClass2() {
		return class2;
	}
	/**
	 * @param class2 the class2 to set
	 */
	public void setClass2(int class2) {
		this.class2 = class2;
	}
	/**
	 * @return the class3
	 */
	public int getClass3() {
		return class3;
	}
	/**
	 * @param class3 the class3 to set
	 */
	public void setClass3(int class3) {
		this.class3 = class3;
	}
	/**
	 * @return the class4
	 */
	public int getClass4() {
		return class4;
	}
	/**
	 * @param class4 the class4 to set
	 */
	public void setClass4(int class4) {
		this.class4 = class4;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Grade [class1=" + class1 + ", class2=" + class2 + ", class3="
				+ class3 + ", class4=" + class4 + ", getClass1()="
				+ getClass1() + ", getClass2()=" + getClass2()
				+ ", getClass3()=" + getClass3() + ", getClass4()="
				+ getClass4() + "]";
	}
	
}
