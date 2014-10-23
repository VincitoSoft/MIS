/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JOptionPane;

/**
 *
 * @author Malaka
 */
public class ConDB {
    Statement st;
    public void ConnectDB(){
        String dri="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/library_projects";
        try{
        Class.forName(dri);
        Connection con=DriverManager.getConnection(url,"root","dinithi70060622");
        st=con.createStatement();
        }
        catch(ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void LogLib(String reg, String nic) {
        ConnectDB();
        String d=null;
        String t=null;
        String qu1="select curDate(),curTime()";
        String q="select count(*) from Librarian where reg_no='"+reg+"'";
        try {
            ResultSet rs=st.executeQuery(q);
            
            rs.next();
                if(rs.getInt(1)==1){
                String q1="Select nic from librarian where reg_no='"+reg+"'";
                ResultSet rs1=st.executeQuery(q1);
                rs1.next();
                
                        if(rs1.getString(1).equals(nic)){
                        ResultSet r1=st.executeQuery(qu1);
                        while(r1.next()){
                        d=r1.getDate(1).toString();
                        t=r1.getTime(2).toString();
                        }
                        SetMainName(reg);
                        
                       
                        //sve text file in user name in login de..
                        
                    try {
                        File f=new File(nic+" "+d+".txt");
                        BufferedWriter bw= new BufferedWriter(new FileWriter(f)); //creat a writer
                        bw.append("User has Reg-No="+reg+"Loged on "+d+" "+t);//write the login details in a file
                        bw.flush();
                        bw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                        }
                        else{
                        new Incorrect().setVisible(true);
                        }
                    
                }
                else{
                new Incorrect().setVisible(true);
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public Vector setCombo() {
        ConnectDB();
        String qu="select distinct catagory from book";
        Vector v=new Vector();
        try {
            ResultSet rs=st.executeQuery(qu);
            while(rs.next()){
            v.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return v;
    }

    public void BookSea(String cat, String ti, String aut) {
        ConnectDB();
        String q="Select Book_id,Book_Title,Pub_Nam,Author,Catagory,Ava_Cop from book where catagory like '%"+cat+"%'" +
                " and book_title like '%"+ti+"%' and author like '%"+aut+"%' order by book_title"; 
        try {
            ResultSet rs=st.executeQuery(q);
            SearchResult sr=new SearchResult();
            sr.SetResult(rs);
            sr.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void setName(String id) {
        ConnectDB();
        String q="select book_title from Book where book_id="+id;
        try {
            ResultSet rs=st.executeQuery(q);
            Reserve re=new Reserve();
            re.setNam(rs,id);
            re.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void setDate(String id, String car) {
        ConnectDB();
        String d1=null,d2=null;
        String q="select curDate(),date_Add(curDate(),interval 14 day)";
        
        try {
                    ResultSet rs=st.executeQuery(q);
                    while(rs.next()){
                    d1=rs.getObject(1).toString();
                    d2=rs.getObject(2).toString();
                    }
                    setBookLoan(id,car,d1,d2);
                    setAvaCop(id);
                    BookResDet br=new BookResDet();
                    br.setDte(d1,d2);
                    br.setVisible(true);
                
                
               
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void setBookLoan(String id, String car, String d1, String d2) {
        
        String q="Insert into book_loans values('"+id+"','"+car+"','"+d1+"','"+d2+"')";
        try {
          st.executeUpdate(q);  
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void setAvaCop(String id) {
       String q="select ava_cop from book where Book_id="+id;
       int cop=0,cop1=0;
       try {
            ResultSet rs = st.executeQuery(q);
            rs.next();
            cop=rs.getInt(1);
            cop1=cop-1;

            String q1="Update book set ava_cop='"+cop1+"' where book_id="+id;
            st.executeUpdate(q1);
        } catch (SQLException ex) {
            Logger.getLogger(ConDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String chekCar(String car) {
    ConnectDB();
    String s=null;
    String qu3="select count(*) from Borrower where car_no='"+car+"'";
     
        try {
            ResultSet rs1 = st.executeQuery(qu3);
            rs1.next();
            s=rs1.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(ConDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
            
    }

   

    private void SetMainName(String reg) {
        ConnectDB();
         String qu="select name from librarian where reg_no='"+reg+"'";
         String qu1="select curDate()";
         
        try {
            ResultSet rs = st.executeQuery(qu);
            rs.next();
            String nm=rs.getString(1);
            
            ResultSet rs1=st.executeQuery(qu1);
            rs1.next();
            Object dt=rs1.getDate(1);//current date as Object
            
            
            
           Main m=new Main();
           m.stname(dt,nm);
           m.setVisible(true);//pass date and name to loginMain
        } catch (SQLException ex) {
            Logger.getLogger(ConDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    public String chkBor(String car) {
        ConnectDB();
        String q="select count(*) from book_Loans where car_no='"+car+"'";
        String c=null;
        
        try {
            ResultSet rs=st.executeQuery(q);
            rs.next();
            c=rs.getString(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return c;
    }

    public String getDue(String id) {
        ConnectDB();
        String q="select min(due_date) from Book_loans where Book_id='"+id+"'";
        String dt=null;
        int dd=0;
        try {
            ResultSet rs=st.executeQuery(q);
            rs.next();
            dt=rs.getDate(1).toString();
           
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return dt;
    }

    public String UpdteBook(String nam, String pub, String aut, String cat,int cop) {
        ConnectDB();
        String q="select count(*) from book where book_title='"+nam+"' and pub_nam='"+pub+"' and author='"+aut+"'";
        String b=null;
        try {
            ResultSet rs=st.executeQuery(q);
            rs.next();
            b=rs.getString(1);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return b;
    }

    public Vector setCarCombo() {
        ConnectDB();
        String q="select car_no from Borrower";
        Vector v=new Vector();
        try {
            ResultSet rs=st.executeQuery(q);
            while(rs.next()){
            v.addElement(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return v;
    }

    public Vector setBookCombo() {
      ConnectDB();
        String q="select book_id from Book";
        Vector v=new Vector();
        try {
            ResultSet rs=st.executeQuery(q);
            while(rs.next()){
            v.addElement(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return v;  
    }

    public String chkRet(String car, String id) {
      ConnectDB();
      String b=null;
      String q="select count(*) from book_loans where book_id='"+id+"' and car_no='"+car+"'";
        try {
            ResultSet rs=st.executeQuery(q);
            rs.next();
            b=rs.getString(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return b;
    }

    public void bookReturn(String car, String id) {
       ConnectDB();
       String dtout=null,due=null;
       String q3="select Date_Out,Due_Date from book_loans where car_no='"+car+"' and book_id='"+id+"'";
       String q="delete from book_loans where car_no='"+car+"' and book_id='"+id+"'";
       String q1="select ava_cop from book where book_id='"+id+"'";
        try {
            ResultSet rs3=st.executeQuery(q3);
            while(rs3.next()){
            dtout=rs3.getObject(1).toString();
            due=rs3.getObject(2).toString();
            }
            ReturnSucc re=new ReturnSucc();
            re.setDate(dtout, due);
            re.setVisible(true);
            
            st.executeUpdate(q);
            ResultSet rs=st.executeQuery(q1);
            rs.next();
            int cop=rs.getInt(1);
            int co=cop+1;
            String q2="update book set ava_cop='"+co+"' where book_id='"+id+"'";
            st.executeUpdate(q2);
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }

    public String addCop(String nm, String pb, String at, int cp) {
        ConnectDB();
        String id=null;
        int aco=0,aco1=0,co=0,co1=0;
        String q="select no_of_cop,ava_cop from book where book_title='"+nm+"' and pub_nam='"+pb+"' and author='"+at+"'";
        String q2="select book_id from book where book_title='"+nm+"' and pub_nam='"+pb+"' and author='"+at+"'";
        try {
            ResultSet rs=st.executeQuery(q);
            while(rs.next()){
            co=rs.getInt(1);
            aco=rs.getInt(2);
            }
            ResultSet rs1=st.executeQuery(q2);
            while(rs1.next()){
            id=rs1.getString(1);
            
            }
            
            aco1=cp+aco;
            co1=cp+co;
            String q1="update book set no_of_cop='"+co1+"',ava_cop='"+aco1+"' where book_title='"+nm+"' and "
                    + "pub_nam='"+pb+"' and author='"+at+"'";
            st.executeUpdate(q1);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return id;
    }

    public String addBook(String nam, String pub, String aut, String cat, int cop) {
        ConnectDB();
        String q="Insert into Book (Book_title,pub_nam,author,catagory,No_of_cop,Ava_Cop) "
                + "values ('"+nam+"','"+pub+"','"+aut+"','"+cat+"','"+cop+"','"+cop+"')";
        String q1="select Book_id from book where book_title='"+nam+"' and pub_nam='"+pub+"' and author='"+aut+"'";
        String id=null;
        try {
            st.executeUpdate(q);
            ResultSet rs=st.executeQuery(q1);
            rs.next();
            id=rs.getString(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return id;
    }

    public int setFin(String dtd) {
     ConnectDB();
     int fi=0;
     
     String q="select dateDiff(curDate(),'"+dtd+"')";
        try {
            ResultSet rs=st.executeQuery(q);
            rs.next();
            fi=rs.getInt(1);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return fi;
    }

    public int SetDiff(String dd) {
        ConnectDB();
        int d=0;
      
      String q1="select dateDiff(curDate(),'"+dd+"')";
            ResultSet rs1;
        try {
            rs1 = st.executeQuery(q1);
            rs1.next();
            d=rs1.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ConDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
              
    }

    public Vector setLable(String id) {
        ConnectDB();
        Vector v=new Vector();
        String q="select Book_title,pub_nam,author,Ava_Cop,no_of_cop,catagory from Book where book_id='"+id+"'";
        try{
        ResultSet rs=st.executeQuery(q);
        while(rs.next()){
            for(int i=1;i<7;i++)
            v.addElement(rs.getString(i));
        }
        }
        catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return v;
    }

    public void removeCop(int cp, String id) {
        ConnectDB();
        String q="select no_of_cop,Ava_Cop from Book where book_id='"+id+"'";
        int cop=0,ava=0,cop1=0,ava1=0;
        try{
        ResultSet rs=st.executeQuery(q);
            while(rs.next()){
            cop=rs.getInt(1);
            ava=rs.getInt(2);
            }
            cop1=cop-cp;
            ava1=ava-cp;
         String q1="update book set no_of_cop='"+cop1+"',ava_cop='"+ava1+"' where book_id='"+id+"'";
         st.executeUpdate(q1);
         new RemovedSucc().setVisible(true);
        }
        catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void removeBook(String id) {
        ConnectDB();
        String q="Select count(*) from book_loans where book_id='"+id+"'";
        String q1="delete from book where Book_id='"+id+"'";
        String q2="delete from book_loans where Book_id='"+id+"'";
            try{
            st.executeUpdate(q1);
            ResultSet rs=st.executeQuery(q);
            rs.next();
                if(rs.getInt(1)!=0){
                st.executeUpdate(q2);
                }
            }
            catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
            new RemovedSucc().setVisible(true);
    }

    public Vector setBorLab(String car) {
        ConnectDB();
        Vector v=new Vector();
        String q="select bor_nam,bor_nid,bor_tel,bor_add,bor_bdy from borrower where car_no='"+car+"'";
        try{
        ResultSet rs=st.executeQuery(q);
        while(rs.next()){
            for(int i=1;i<6;i++)
            v.addElement(rs.getString(i));
        }
        }
        catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return v;
    }

    public int getId(String car) {
        ConnectDB();
        int b=0;
        String q="select count(*) from book_loans where car_no='"+car+"'";
        try {
            ResultSet rs=st.executeQuery(q);
            rs.next();
            b=rs.getInt(1);
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return b;
    }

    public Vector getDate(String car) {
      ConnectDB();
      Vector v=new Vector();
      String q="select book_id,date_out,Due_date from book_loans where car_no='"+car+"'";
      try {
            ResultSet rs=st.executeQuery(q);
            while(rs.next()){
                for(int i=1;i<4;i++){
                 v.addElement(rs.getObject(i).toString());   
                    
                }
            }    
      }
      catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        
      }
      return v;

    
    
    }

    public String getnam(String text) {
        ConnectDB();
        String nam=null;
        String q="select book_title from book where book_id='"+text+"'";
        try{
            ResultSet rs=st.executeQuery(q);
            rs.next();
            nam=rs.getString(1);
        }
        catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
        }
     return nam;  
    }

    public int chkCar(String id) {
        ConnectDB();
        int b=0;
        String q="select count(*) from book_loans where book_id='"+id+"'";
        try {
            ResultSet rs=st.executeQuery(q);
            rs.next();
            b=rs.getInt(1);
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return b;
    }

    public Vector GetCar(String id) {
        ConnectDB();
        Vector v=new Vector();
        String q="select car_no from book_loans where book_id='"+id+"'";
        try {
            ResultSet rs=st.executeQuery(q);
            while(rs.next()){
                
                 v.addElement(rs.getObject(1).toString());   
                    
               
            }    
      }
      catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        
      }
      return v;
    }

    public int chkNic(String brnid) {
      ConnectDB();
        int b=0;
        String q="select count(*) from borrower where bor_nid='"+brnid+"'";
        try {
            ResultSet rs=st.executeQuery(q);
            rs.next();
            b=rs.getInt(1);
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return b;  
    }

    public String addBor(String brnam, String brnid, String bradd, String brtel, String brbt) {
      ConnectDB();
      String car=null;
      String q="insert into borrower (bor_nam,Bor_add,Bor_tel,bor_nid,bor_bdy)"
              + " values('"+brnam+"','"+bradd+"','"+brtel+"','"+brnid+"','"+brbt+"')";
      String q1="select car_no from borrower where bor_nid='"+brnid+"'";
      
      try{
          st.executeUpdate(q);
          ResultSet rs=st.executeQuery(q1);
          rs.next();
          car=rs.getString(1);
      
      } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return car;
      
    }

    public String getName(String car) {
      ConnectDB();
        String nam=null;
        String q="select bor_nam from borrower where car_no='"+car+"'";
        try{
            ResultSet rs=st.executeQuery(q);
            rs.next();
            nam=rs.getString(1);
        }
        catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
        }
     return nam;   
    }

    void removeBor(String car) {
     ConnectDB();
        
        String q="delete  from borrower where car_no='"+car+"'";
        try{
            st.executeUpdate(q);
        }
        catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
        }   
    }

    public int chkId(String car) {
       ConnectDB();
        int b=0;
        String q="select count(*) from book_loans where car_no='"+car+"'";
        try {
            ResultSet rs=st.executeQuery(q);
            rs.next();
            b=rs.getInt(1);
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return b;    
    }

    void updteBor(String nam, String add, String tel, String id) {
       ConnectDB();
        
        String q="update borrower set bor_nam='"+nam+"',bor_add='"+add+"',bor_tel='"+tel+"' where car_no='"+id+"'";
        try{
            st.executeUpdate(q);
            new UpdateSucc().setVisible(true);
        }
        catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
        }    
    }

    public String setId(String car) {
        ConnectDB();
        String id=null;
        String q="select book_id from book_loans where car_no='"+car+"'";
        try{
            ResultSet rs=st.executeQuery(q);
            rs.next();
            id=rs.getString(1);
        }
        catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
        return id;
    }

    public void LogAdm(String na, String pa) {
      
    }
}
