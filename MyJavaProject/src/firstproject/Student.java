package firstproject;

import java.util.Scanner;

public class Student
{
	private int htno;
	private String name, branch, address,mobile;
	int n;
	Student s[]=new Student[150];
	public void dataEntry()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("How many students data you want to enter ?");
		n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			s[i]=new Student();
			System.out.println("Enter Student H.T.No: ");
			int htno=sc.nextInt();
			System.out.println("Enter Student Name ");
			String name=sc.next();
			System.out.println("Enter Student Branch ");
			String branch=sc.next();
			System.out.println("Enter Student Address ");
			String address=sc.next();
			System.out.println("Enter Student Mobile Number ");
			String mobile=sc.next();
			//System.out.println("Test ");
			s[i].setStudentData(htno, name, branch, address, mobile);
		}
	}
	public void setStudentData(int htno,String name,String branch,String address, String mobile)
	{
		this.htno=htno;
		this.name=name;
		this.branch=branch;
		this.address=address;
		this.mobile=mobile;
	}
	public int getHtno()
	{
		return htno;
	}
	public String getName()
	{
		return name;
	}
	public String getBranch()
	{
		return branch;
	}
	public String getAddress()
	{
		return address;
	}
	public String getMobile()
	{
		return mobile;
	}
}
