class College{
    var collageName="NKCOET"
    var collagePlace="SOLAPUR"

    fun displayCollege(){
        println("College Name: $collageName")
        println("College Place: $collagePlace")
    }

    inner class branch{
        var branchName="CSE"
        var branchPlace="1"
        fun displayBranch(){
            println("Branch Name: $branchName")
            println("Branch Place: $branchPlace")
        }
    }
    inner class student{
        var studentName="ADITYA"
        var studentPlace="SOLAPUR"
        fun displayStudent(){
            println("Student Name: $studentName")
            println("Student Place: $studentPlace")
        }
    }
}

fun main() {
    val clgObj = College()
    clgObj.displayCollege()
    clgObj.branch().displayBranch()
    clgObj.student().displayStudent()
}