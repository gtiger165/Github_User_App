package com.hirarki.personal.githubuserapp.user.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.hirarki.personal.githubuserapp.databinding.ActivityUsersBinding
import com.hirarki.personal.githubuserapp.user.adapter.OnUserAdapterListener
import com.hirarki.personal.githubuserapp.user.adapter.UserAdapter
import com.hirarki.personal.githubuserapp.user.model.User
import com.hirarki.personal.githubuserapp.util.getJsonFromAssets

class UsersActivity : AppCompatActivity(), OnUserAdapterListener {
    private lateinit var binding: ActivityUsersBinding
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Github User's"

        adapter = UserAdapter(this)

        var json = getJsonFromAssets(this, "users.json")
        val data = Gson().fromJson(json, Array<User>::class.java).toList()

        adapter.clear()
        adapter.addItems(ArrayList(data))

        with(binding) {
            rvUsers.layoutManager = LinearLayoutManager(this@UsersActivity)
            rvUsers.adapter = adapter
        }
    }

    override fun onClicked(user: User) {
        val intent = Intent(this, DetailUserActivity::class.java).apply {
            putExtra("user", user)
        }
        startActivity(intent)
    }
}