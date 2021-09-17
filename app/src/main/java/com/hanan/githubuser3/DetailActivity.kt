package com.hanan.githubuser3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object{
        var EXTRA_DATA = "0"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val listUser : GitUser? = intent.getParcelableExtra(EXTRA_DATA)

        detail_Image.setImageResource(listUser?.image!!)
        detail_username.text = getString(R.string.username, listUser.username)
        detail_name.text = getString(R.string.name, listUser.name)
        detail_location.text = getString(R.string.location, listUser.location)
        detail_repo.text = getString(R.string.repository, listUser.repository)
        detail_company.text = getString(R.string.company, listUser.company)
        detail_followers.text = getString(R.string.followers, listUser.followers)
        detail_following.text = getString(R.string.following, listUser.following)
    }
}