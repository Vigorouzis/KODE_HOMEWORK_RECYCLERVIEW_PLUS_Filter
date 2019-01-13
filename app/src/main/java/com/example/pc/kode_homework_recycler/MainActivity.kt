package com.example.pc.kode_homework_recycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val langList = ArrayList<Language>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: RecyclerView.Adapter<*>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addItem()
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        //vertical RecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        val adapter = DataAdapter(langList)


        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter


    }


    private fun addItem() {


        var Java = Language(
            "Java",
            "Джеймс Гослинг",
            resources.getText(R.string.java) as String,
            1995,
            16.904,
            R.drawable.bitmap_java
        )
        langList.add(Java)

        var C =
            Language("C", "Джеймс Гослинг", resources.getText(R.string.c) as String, 1972, 13.337, R.drawable.bitmap_c)
        langList.add(C)

        var Python =
            Language(
                "Python",
                "Гвидо ван Россум",
                resources.getText(R.string.python) as String,
                1991,
                8.294,
                R.drawable.bitmap_python
            )
        langList.add(Python)

        var Cpp = Language(
            "C++",
            "Бьёрн Страуструп",
            resources.getText(R.string.cpp) as String,
            1983,
            8.158,
            R.drawable.bitmap_cpp
        )
        langList.add(Cpp)

        var VB =
            Language(
                "Visual Basic.NET",
                "Билл Гейтс",
                resources.getText(R.string.basic) as String,
                1995,
                6.459,
                        R.drawable.bitmap_csharp
            )
        langList.add(VB)

        var javascript = Language(
            "Javascript",
            "Брендан Эйх",
            resources.getText(R.string.javascript) as String,
            1995,
            3.302,
            R.drawable.bitmap_java_script
        )
        langList.add(javascript)

        var C_sharp =
            Language(
                "C#",
                "Андерс Хейлсберг",
                resources.getText(R.string.c_sharp) as String,
                2000,
                3.284,
                R.drawable.c_sharp
            )
        langList.add(C_sharp)

        var php = Language(
            "Php",
            "Расмус Лердорф",
            resources.getText(R.string.php) as String,
            1995,
            2.680,
            R.drawable.bitmap_php
        )
        langList.add(php)

        var SQL = Language(
            "SQL",
            "Дональд Чемберлин,Рэймонд Бойс",
            resources.getText(R.string.sql) as String,
            2008,
            2.277,
            R.drawable.bitmap_sql
        )
        langList.add(SQL)

        var Objective_C = Language(
            "Objective-C",
            "Бред Кокс",
            resources.getText(R.string.objective_c) as String,
            1983,
            1.781,
            R.drawable.bitmap_objective_c
        )
        langList.add(Objective_C)
    }


    //update cardViews to data array
    private fun updateActivity(data: ArrayList<Language>) {
        viewManager = GridLayoutManager(this, 1)
        viewAdapter = DataAdapter(data)

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {

            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter

        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            return when (item.itemId) {
                R.id.all -> {
                    updateActivity(langList)
                    true
                }
                R.id.only_object -> {
                    val data: List<Language> =
                        langList.filter { i -> i.paradigms.findAnyOf(listOf("объектно-ориентированный")) != null }
                    updateActivity(data as ArrayList<Language>)
                    true
                }
                R.id.only_fun -> {
                    val data: List<Language> =
                        langList.filter { i -> i.paradigms.findAnyOf(listOf("функциональный")) != null }
                    updateActivity(data as ArrayList<Language>)
                    true
                }
                R.id.only_process -> {
                    val data: List<Language> =
                        langList.filter { i -> i.paradigms.findAnyOf(listOf("процедурный")) != null }
                    updateActivity(data as ArrayList<Language>)
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
        }
        return super.onOptionsItemSelected(item)

    }


}

