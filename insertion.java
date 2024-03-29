package com.serverside;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.sql.Date;




/**
 * Servlet implementation class Insertion
 */
@WebServlet("/Insertion")
public class Insertion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public Insertion() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
			
			
			PrintWriter out=res.getWriter();
					res.setContentType("text/html");
					PrintWriter pw=res.getWriter();
					
					Cookie[] ck=req.getCookies();
					
					String id=ck[0].getValue();
					
					String fullname=req.getParameter("fullname");
					String  dob=req.getParameter("dob");
					
					Date date=null;
					try {
						date = getDate(dob);
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					
					
					
					String gender=req.getParameter("gender");
					String maritial=req.getParameter("maritial");
					String phone1=req.getParameter("phone");
					int phone = number(phone1);
					String  email=req.getParameter("email");
					String address=req.getParameter("address");
					String path="";
					
				try {
					Personal(id, fullname, date, gender, maritial, phone, email, address, path);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
					String designation=req.getParameter("designation");
					String currentctc1=req.getParameter("currentctc");
					int ctc=number(currentctc1);
					String currentlocation=req.getParameter("currentlocation");
					String requiredlocation =req.getParameter("requiredlocation");
					String experiance=req.getParameter("experience");
					int exp=number(experiance);
					String appliedjob=req.getParameter("appliedjob");
					String skills=req.getParameter("skills");
				
				try {
					work(id, designation, ctc, currentlocation, requiredlocation, exp, appliedjob, skills);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
					
					String projecttitle[]=req.getParameterValues("title[]");
					String startdate[]=req.getParameterValues("startdate[]");
					String enddate[]=req.getParameterValues("enddate[]");
					String projectdesc[]=req.getParameterValues("projects[]");
					String acheivements[]=req.getParameterValues("Acheivements[]");
					
			try {
				projects(id, projecttitle, startdate, enddate, projectdesc);
			} catch (ClassNotFoundException | SQLException | ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
					
					String schoolname=req.getParameter("schoolname");
					String schoolper=req.getParameter("schoolper");
					String schoolpassyear=req.getParameter("schoolpassyear");
					String Board=req.getParameter("Board");
					String stage="10";
					
			try {
				education(id,stage,schoolname,"JL",schoolper,schoolpassyear );
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
					String collegename=req.getParameter("collegename");
					String collegeper=req.getParameter("collegeper");
					String collegepassyear=req.getParameter("collegepassyear");
					stage="12";
			try {
				education(id,stage,collegename,"KL",collegeper,collegepassyear );
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					String gradcoursetype=req.getParameter("Coursetype");
					String gradcollegename=req.getParameter("gradcollegename");
					String gradcollegeper=req.getParameter("gradcollegeper");
					String gradcollegepassyear=req.getParameter("gradcollegepassyear");
					stage="14";
			try {
				education(id,stage,gradcollegename,gradcoursetype,gradcollegeper,gradcollegepassyear );
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					String postCoursetype=req.getParameter("postCoursetype");
					String postgradcollegename=req.getParameter("postgradcollegename");
					String postgradcollegeper=req.getParameter("postgradcollegeper");
					String postgradcollegepassyear=req.getParameter("postgradcollegepassyear");;
					
					stage="18";
			try {
				education(id,stage,postgradcollegename,postCoursetype,postgradcollegeper,postgradcollegepassyear );
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			
					
					pw.println(fullname+" <br>  "+dob+" <br> "+gender+"  <br> "+maritial+"<br> "+phone+"  <br> "
							+ "  <br>"+email+" <br>  "+address+"  <br> "+designation+" <br>  "+" <br>  "+currentlocation+" <br>  "+requiredlocation+"<br>"
									+ "  <br> "+experiance+"  <br> "+appliedjob+" <br>  "+skills+" <br> "
											+ " <br>"+schoolname+"<br>   "+schoolper+" <br>  "+schoolpassyear+"  <br> "+Board+" <br>  "+collegename+" <br>  "+collegeper+"  <br> "+
									collegepassyear+"   "+gradcoursetype+"  <br> "+gradcollegename+" <br> "
											+"<br> "
													+ " <br> "+gradcollegeper+"   <br> "+gradcollegepassyear+"   <br>  "+postCoursetype+"  <br> "+postgradcollegename+"  <br> "+postgradcollegeper+" <br>   "+postgradcollegepassyear+"<br>");
					
					for(int i=0;i<projecttitle.length;i++)
					{
						pw.println(projecttitle[i]+" <br>");
						pw.println(startdate[i]+" <br>");
						pw.println(enddate[i]+" <br>");
						pw.println(projectdesc[i]+" <br>");
					}
					
					for(int i=0;i<acheivements.length;i++)
						pw.println(acheivements[i]+" <br>");
					
					
				}
		
		static int number(String str) {
			int n=Integer.parseInt(str);
			return n;
		}

		static Date getDate(String dob) throws ParseException {
			Date date1=(Date) new SimpleDateFormat("dd/MM/yyyy").parse(dob);
			return date1;
		}
			
			
			
			
			
		
		static void Personal(String id,String fullname,Date date1,String gender,String maritial,int phone,String address,String  email,String path) throws ClassNotFoundException, SQLException {
			Connection con=ForConnection.con();
			Statement st=con.createStatement();
			String url="insert into personal values(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(url);
			ps.setString(1, id);
			ps.setString(2,fullname);
			ps.setDate(3, date1);
			ps.setString(4,gender);
			ps.setString(5,maritial);
			ps.setInt(6, phone);
			ps.setString(7,email);
			ps.setString(8,address);
			ps.setString(9, path);
			
			int row=ps.executeUpdate();
			
			
		}
		
		static void work(String id,String designation,int ctc,String c_loc,String r_loc,int exp,String tier,
				String skills) throws ClassNotFoundException, SQLException {
			Connection con=ForConnection.con();
			Statement st=con.createStatement();
			String url="insert into work values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(url);
			ps.setString(1,id);
			ps.setString(2,designation);
			ps.setInt(3, ctc);
			ps.setString(4,c_loc);
			ps.setString(5,r_loc);
			ps.setInt(6, exp);
			ps.setString(7,tier);
			ps.setString(8,skills);
		
			int row=ps.executeUpdate();
			
			
			
			
		}
		static void projects(String id,String[] projecttitle,String[] startdate,String[] enddate,String[]  desc) throws ClassNotFoundException, SQLException, ParseException {
			
			Connection con=ForConnection.con();
			Statement st=con.createStatement();
			
			for(int  i=0; i<projecttitle.length; i++) {
			String url="insert into projects values(?,?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(url);
			ps.setString(1, id);
			ps.setString(2,projecttitle[i]);
			Date d=getDate(startdate[i]);
			ps.setDate(3, d);
			Date e=getDate(enddate[i]);
			ps.setDate(4, e);
			ps.setString(5, desc[i]);
			ps.executeUpdate();	
			}
		}
		
		
			
			static void education(String id,String stage,String name,String course,String percent,String pass) throws ClassNotFoundException, SQLException {
				
				Connection con=ForConnection.con();
				Statement st=con.createStatement();
				String url="insert into education values(?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(url);
				ps.setString(1, id);
				ps.setString(2,stage);
				ps.setString(3,name);
				ps.setString(4,course);
				ps.setInt(5, number(percent));
				ps.setString(6,pass);
				ps.executeUpdate();
			}
		}










