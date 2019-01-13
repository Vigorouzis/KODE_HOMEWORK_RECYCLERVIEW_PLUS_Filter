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


        val Java = Language(
            "Java",
            "Джеймс Гослинг",
            resources.getText(R.string.java) as String,
            1995,
            16.904,
            R.drawable.bitmap_java, "https://ru.wikipedia.org/wiki/Java"
        )
        langList.add(Java)

        val C =
            Language(
                "C",
                "Джеймс Гослинг",
                resources.getText(R.string.c) as String,
                1972,
                13.337,
                R.drawable.bitmap_c,
                "https://ru.wikipedia.org/wiki/Си_(язык_программирования)"
            )
        langList.add(C)

        val Python =
            Language(
                "Python",
                "Гвидо ван Россум",
                resources.getText(R.string.python) as String,
                1991,
                8.294,
                R.drawable.bitmap_python,
                "https://ru.wikipedia.org/wiki/Python"
            )
        langList.add(Python)

        val Cpp = Language(
            "C++",
            "Бьёрн Страуструп",
            resources.getText(R.string.cpp) as String,
            1983,
            8.158,
            R.drawable.bitmap_cpp,
            "https://ru.wikipedia.org/wiki/C%2B%2B"
        )
        langList.add(Cpp)

        val VB =
            Language(
                "Visual Basic.NET",
                "Билл Гейтс",
                resources.getText(R.string.basic) as String,
                1995,
                6.459,
                R.drawable.bitmap_csharp,
                "https://ru.wikipedia.org/wiki/Visual_Basic"
            )
        langList.add(VB)

        val javascript = Language(
            "Javascript",
            "Брендан Эйх",
            resources.getText(R.string.javascript) as String,
            1995,
            3.302,
            R.drawable.bitmap_java_script,
            "https://ru.wikipedia.org/wiki/JavaScript"
        )
        langList.add(javascript)

        val C_sharp =
            Language(
                "C#",
                "Андерс Хейлсберг",
                resources.getText(R.string.c_sharp) as String,
                2000,
                3.284,
                R.drawable.c_sharp,
                "https://ru.wikipedia.org/wiki/C_Sharp"
            )
        langList.add(C_sharp)

        val php = Language(
            "Php",
            "Расмус Лердорф",
            resources.getText(R.string.php) as String,
            1995,
            2.680,
            R.drawable.bitmap_php,
            "https://ru.wikipedia.org/wiki/PHP"
        )
        langList.add(php)

        val SQL = Language(
            "SQL",
            "Дональд Чемберлин,Рэймонд Бойс",
            resources.getText(R.string.sql) as String,
            2008,
            2.277,
            R.drawable.bitmap_sql,
            "https://ru.wikipedia.org/wiki/SQL"
        )
        langList.add(SQL)

        val Objective_C = Language(
            "Objective-C",
            "Бред Кокс",
            resources.getText(R.string.objective_c) as String,
            1983,
            1.781,
            R.drawable.bitmap_objective_c,
            "https://ru.wikipedia.org/wiki/Objective-C"
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
                R.id.only_struct -> {
                    val data: List<Language> =
                        langList.filter { i -> i.paradigms.findAnyOf(listOf("структурный")) != null }
                    updateActivity(data as ArrayList<Language>)
                    true
                }
                R.id.only_component -> {
                    val data: List<Language> =
                        langList.filter { i -> i.paradigms.findAnyOf(listOf("компонентно-ориентированный")) != null }
                    updateActivity(data as ArrayList<Language>)
                    true
                }
                R.id.only_obob -> {
                    val data: List<Language> =
                        langList.filter { i -> i.paradigms.findAnyOf(listOf("обобщённый")) != null }
                    updateActivity(data as ArrayList<Language>)
                    true
                }
                R.id.only_refl -> {
                    val data: List<Language> =
                        langList.filter { i -> i.paradigms.findAnyOf(listOf("рефлективный")) != null }
                    updateActivity(data as ArrayList<Language>)
                    true
                }
                R.id.only_imp -> {
                    val data: List<Language> =
                        langList.filter { i -> i.paradigms.findAnyOf(listOf("императивный")) != null }
                    updateActivity(data as ArrayList<Language>)
                    true
                }
                R.id.only_asp -> {
                    val data: List<Language> =
                        langList.filter { i -> i.paradigms.findAnyOf(listOf("аспектно-ориентированный")) != null }
                    updateActivity(data as ArrayList<Language>)
                    true
                }
                R.id.only_sobit -> {
                    val data: List<Language> =
                        langList.filter { i -> i.paradigms.findAnyOf(listOf("событийно-ориентированный")) != null }
                    updateActivity(data as ArrayList<Language>)
                    true
                }
                R.id.only_sten -> {
                    val data: List<Language> =
                        langList.filter { i -> i.paradigms.findAnyOf(listOf("сценарный")) != null }
                    updateActivity(data as ArrayList<Language>)
                    true
                }
                R.id.only_refl_or -> {
                    val data: List<Language> =
                        langList.filter { i -> i.paradigms.findAnyOf(listOf("рефлексивно-ориентированный")) != null }
                    updateActivity(data as ArrayList<Language>)
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
        }
        return super.onOptionsItemSelected(item)

    }


}

