import java.sql.Connection
import java.sql.DriverManager;
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException;
import java.sql.Statement


class DATABASECONN {
    var conn:Connection?=null;

    fun createconnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance()
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem","root","Aditya@10")
            if(conn!=null) {
                print("Connecting succesfukll")
            }
        }catch (e:SQLException){
        print(e)
        }
    }
    fun closeconnection(){
        if(conn!=null){
            //conn.close();
        }
    }

    fun createtableusingstatement(){
        var stm:Statement?=null;
        try {
            var sql="create table demo10(id int not null auto_increment,name varchar(255),age int not null,primary key(id));"
            stm=conn!!.createStatement();
            stm.execute(sql);
            print("Connection is succesfull")

        }catch (e:SQLException){
            print(e)
        }
    }

    fun createtable(){
        var prestat:PreparedStatement?=null
        var sql="create table demo10(id int not null auto_increment,name varchar(255),age int not null,primary key(id));"

        try {
        prestat=conn!!.prepareStatement(sql);
           var status= prestat.executeUpdate();
            //print(status)
            if(status>0){
                print("Table is created")
            }
        }catch (e:SQLException){
            print(e)
        }
    }
    fun insertdata(){
        var prep:PreparedStatement?=null;
        var sql="insert into demo10(name,age)values(?,?);"

        try {
            prep=conn!!.prepareStatement(sql);
            prep.setString(1, readLine())
            prep.setInt(2, readLine()!!.toInt())
            var status=prep.executeUpdate();
            if(status>0){
                print("HI DATA IS ENTERED")

            }
        }catch (e:SQLException){
            print(e)
        }
    }
    fun selectqurey(){

        var stm:Statement?=null;
        var sql="select * from account;"
        var res:ResultSet?=null;
        try {
            stm=conn!!.createStatement()
            //print(res)
            res=stm!!.executeQuery(sql);
            print(res)
            while (res!!.next()){
                print("${res.getInt("accountid")}\t")
                print("${res.getInt("accountno")}\t")
                print("${res.getFloat("accountbalance")}\t")
                print("${res.getString("accounttype")}\t")
                print("${res.getInt("customerid")}\t")
                print("${res.getInt("bankid")}\t")
            }
        }catch (e:SQLException){
            print(e)
        }
        finally {
            if (res!=null){
                try {
                    res!!.close()
                    conn!!.close()
                }catch (e:SQLException){
                    print(e)
                }
            }
        }

    }

    fun truncatetable() {
        var prep: PreparedStatement? = null;
        var sql = "TRUNCATE table Demo10;"
        try {
            prep = conn!!.prepareStatement(sql);
            var status = prep.executeUpdate();
            if (status == 0) {
                print("TABLE TRUNCATED")
            }
        } catch (e: SQLException) {
            println(e)
        }
    }

    fun drop(){
        var prep:PreparedStatement?=null;
        var sql ="Drop table Demo10;"
        try {
            prep=conn!!.prepareStatement(sql);
            var status=prep.executeUpdate();
            if (status==0){
                print("TABLE DELETED")
            }
        }catch (e:SQLException){
            println(e)
        }

    }
    fun Update(){
        var prep:PreparedStatement?=null;
        var sql="update demo10 SET name=? where id =?";
        try {
            prep=conn!!.prepareStatement(sql)
            var name= readLine()
            prep.setString(1,name)
            var id= readLine()!!.toInt()
            prep.setInt(2,id)
           var status= prep.executeUpdate()
            if(status>0){
                print("UPDATED")
            }
        }catch (e:SQLException){
            println(e)

        }
    }
    fun executeQueuriesofDatabase(){
        var stm:Statement?=null;
        var sql="show tables;"
        var res:ResultSet?=null;
        try {
            stm=conn!!.createStatement()
            //print(res)
           res=stm!!.executeQuery(sql);
            print(res)
            while (res!!.next()){
                print(res.getString("Tables_in_banksystem"))
            }
        }catch (e:SQLException){
        print(e)
        }
        finally {
            if (res!=null){
                try {
                    res!!.close()
                    conn!!.close()
                }catch (e:SQLException){
                    print(e)
                }
            }
        }
    }
}
fun main(){
    var jdbcobj=DATABASECONN();
    jdbcobj.createconnection();
    //jdbcobj.selectqurey();
    //jdbcobj.createtable();
    //jdbcobj.createtableusingstatement();
    //jdbcobj.insertdata();
    //jdbcobj.Update()
    //jdbcobj.drop();
    jdbcobj.truncatetable()


}
