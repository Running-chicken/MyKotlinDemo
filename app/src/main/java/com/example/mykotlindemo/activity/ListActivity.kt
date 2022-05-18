package com.example.mykotlindemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mykotlindemo.utils.Utils

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        testList()
//        testSet()
//        testListN()
//        testToMutableList()
//        testListToArray()

//        var array = arrayOf(1,3,4)
//        testArrayToList(array)

//        testSetToList()

//        testTransform()

//        filterList()

        listHeBing()
    }

    private fun testList(){
        var list = listOf(1,2,3)

        var listStr = listOf<String>("1","2","4")
        var listAny = listOf(1,"2",true)
        for(item in listAny){
            Utils.print("输出list: $item")
        }

        var mutableList = mutableListOf(1,2,3)
        mutableList.add(6)
        for(item in mutableList){
            Utils.print("输出mutablelist: $item")
        }
        mutableList.remove(0)
        Utils.print("输出size: ${mutableList.size}")

        mutableList.clear()
        Utils.print("输出size: ${mutableList.size}")
    }

    private fun testSet(){
        var set = setOf(1,2,3,4,5,1,2,6)
        for(item in set){
            Utils.print("输出set: $item")
        }
    }


    open class Person(val name:String){
        override fun toString(): String {
            return "Person name= $name"
        }
    }

    class Student(name:String) : Person(name){

    }

    private fun testListN(){
        val listStudent = listOf<Student>(Student("cc"), Student("zz"))
        val listPerson = listStudent
        listPerson.forEach{
            Utils.print(it.name)
        }
    }

    private fun testToMutableList(){
        val listPerson: MutableList<Person>
        val listList = listOf<Student>(Student("cc"), Student("zz"))
        listPerson = listList.toMutableList()
        listPerson.forEach {
            Utils.print(it.name)
        }
    }

    private fun testListToArray(){
        var list = listOf<Int>(1,3,5,7,9)
        var listArray = list.toIntArray()
        listArray.forEach {
            Utils.print("输出数组内容： $it")
        }
    }

    private fun testArrayToList(array : Array<Int>){
        var list = array.toList()
        list.forEach{
            Utils.print("输出转化list: $it")
        }
    }

    private fun testSetToList(){
        var set = setOf(1,4,5)
        var list = set.toList()
        list.forEach {
            Utils.print("输出set转list: $it")
        }
    }

    private fun testTransform(){
        var list = listOf<String>("A","B","C","D")
//        list.map {"str".plus(it)}.forEach {
//            Utils.print("输出转化： $it")
//        }

//        list.mapIndexed { index, s ->
//            index.toString().plus("-".plus(s))
//        }.forEach {
//            Utils.print("输出index转化： $it")
//        }


        list.flatMap {
            listOf(it,"-".plus(it))
        }.forEach {
            Utils.print(it)
        }


    }

    private fun filterList(){
        var list = listOf<String>("a","b","v","w","x","y","z","a","b","v")
//        list.take(3).forEach { Utils.print(it) }
        list.distinct().forEach { Utils.print(it) }
    }

    private fun listHeBing(){
        var list = listOf(1,4,5,1)
        var list1 = listOf("a11","111b","c","d","321")
//        Utils.print(list.plus(list1))

//        Utils.print(list.zip(list1))  //合并

        Utils.print(list1.partition {
            it.startsWith("a")
        })
    }

}