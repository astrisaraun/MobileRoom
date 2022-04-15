package com.adl.mobileroom

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adl.mobileroom.model.UserModel
import kotlinx.android.synthetic.main.add_user.*
import kotlinx.android.synthetic.main.item_user.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_user)

        btnAdd.setOnClickListener({
            val userdata = UserModel(0,
                txtNama.text.toString(),
                txtGender.dropDownHorizontalOffset.toString(),
                txtUmur.text.toString(),
                txtStatus.dropDownHorizontalOffset.toString(),
                txtImg.text.toString())

            GlobalScope.launch {
                UserDatabase.getInstance(this@AddUser).userDao().insertUser(userdata)

                val intent = Intent()
                intent.putExtra("data",userdata)
                setResult(Activity.RESULT_OK,intent)
                finish()
            }
        })
    }


}