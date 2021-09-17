package com.hanan.githubuser3


import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    lateinit var adapter : MainAdapter
    private lateinit var usernameData: Array<String>
    private lateinit var nameData: Array<String>
    private lateinit var locationData: Array<String>
    private lateinit var repoData: Array<String>
    private lateinit var companyData: Array<String>
    private lateinit var followersData: Array<String>
    private lateinit var followingData: Array<String>
    private lateinit var imageData: TypedArray
    private lateinit var gitUsers: ArrayList<GitUser>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepare()

        adapter = MainAdapter(this, addItem())
        lv_item.adapter = adapter

        lv_item.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val listDataUser = GitUser("", "", "", "", "", "", "", 0)
            listDataUser.image = imageData.getResourceId(position, position)
            listDataUser.username = usernameData[position]
            listDataUser.name = nameData[position]
            listDataUser.location = locationData[position]
            listDataUser.repository = repoData[position]
            listDataUser.company = companyData[position]
            listDataUser.followers = followersData[position]
            listDataUser.following = followingData[position]

            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, listDataUser)

            this@MainActivity.startActivity(intent)

        }
    }

    private fun prepare() {
        imageData = resources.obtainTypedArray(R.array.avatar)
        usernameData = resources.getStringArray(R.array.username)
        nameData = resources.getStringArray(R.array.name)
        locationData = resources.getStringArray(R.array.location)
        repoData = resources.getStringArray(R.array.repository)
        companyData = resources.getStringArray(R.array.company)
        followersData = resources.getStringArray(R.array.followers)
        followingData =resources.getStringArray(R.array.following)

    }

    private fun addItem(): ArrayList<GitUser> {
        gitUsers = ArrayList()
        for (i in nameData.indices){
            val gitUser = GitUser()
            gitUser.image = imageData.getResourceId(i, -1)
            gitUser.name = nameData[i]
            gitUser.company = companyData[i]
            gitUser.location = locationData[i]
            gitUsers.add(gitUser)
        }
            return gitUsers
    }
}