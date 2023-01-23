import java.sql.*
import kotlin.system.exitProcess
import java.sql.Statement

class TASKDEMOCRUD {
    var conn: Connection? = null;

    fun createconnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance()
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "Aditya@10")
            if (conn != null) {
                print("Connecting succesfukll")
            }
        } catch (e: SQLException) {
            print(e)
        }
    }


    fun createtable() {
        var prestat: PreparedStatement? = null
        var sql =
            "create table demo10(id int not null auto_increment,name varchar(255),age int not null,primary key(id));"

        try {
            prestat = conn!!.prepareStatement(sql);
            var status = prestat.executeUpdate();
            //print(status)
            if (status > 0) {
                print("Table is created")
            }
        } catch (e: SQLException) {
            print(e)
        }
    }

    fun searchData() {
        var stm:Statement?= null;
        var res: ResultSet? = null;
        println("ENTER ID TO SEARCH")
        var SearchId= readLine()!!.toInt()


        var sql = "Select * from demo10 where id= $SearchId;"
        try {
            stm= conn!!.createStatement()
            res=stm!!.executeQuery(sql)

            while (res!!.next()) {
                print("${res.getInt("id")}\t")
                print("${res.getString("name")}\t")
                print("${res.getInt("age")}\t")
            }
        } catch (e: SQLException) {
            print(e)
        }
    }


    fun insertdata() {
        var prep: PreparedStatement? = null;
        var sql = "insert into demo10(name,age)values(?,?);"

        try {
            prep = conn!!.prepareStatement(sql);
            prep.setString(1, readLine())
            prep.setInt(2, readLine()!!.toInt())
            var status = prep.executeUpdate();
            if (status > 0) {
                print("HI DATA IS ENTERED")

            }
        } catch (e: SQLException) {
            print(e)
        }
    }
}

    fun main() {
        var obj = TASKDEMOCRUD();
        obj.createconnection();

        println("ENTER YOUR CHOICE  1: Create Table 2: Insert Data 3: Exit 4 : Search")
        var obj2 = readLine()!!.toInt();
        when (obj2) {
            1 -> obj.createtable()
            2 -> obj.insertdata()
            3 -> exitProcess(1)
            4 -> obj.searchData()
        }
    }
