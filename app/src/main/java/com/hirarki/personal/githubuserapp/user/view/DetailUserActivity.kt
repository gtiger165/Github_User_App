package com.hirarki.personal.githubuserapp.user.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hirarki.personal.githubuserapp.R
import com.hirarki.personal.githubuserapp.databinding.ActivityDetailUserBinding
import com.hirarki.personal.githubuserapp.user.model.User

class DetailUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUserBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(supportActionBar!!) {
            title = "Detail User"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        user = intent?.getParcelableExtra<User>("user")!!

        with(binding) {
            if (user != null) {
                Glide.with(this@DetailUserActivity).load(user.avatar).apply(
                    RequestOptions()
                        .placeholder(R.drawable.ic_baseline_account_circle_24)
                        .error(R.drawable.ic_baseline_account_circle_24)
                ).into(civAvatar)

                tvUsername.text = user.username
                tvName.text = user.name
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}