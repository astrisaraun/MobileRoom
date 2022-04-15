package com.adl.mobileroom

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.mobileroom.adapter.UserAdapter
import com.adl.mobileroom.model.UserModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_user.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK){
            GlobalScope.launch {

                lstUser.clear()
                lstUser.addAll(ArrayList(getAllData()))

                this@MainActivity.runOnUiThread({
                    useradapter.notifyDataSetChanged()
                })
            }
        }
    }
    lateinit var useradapter: UserAdapter
    var lstUser = ArrayList<UserModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {

            lstUser = ArrayList(getAllData())
            this@MainActivity.runOnUiThread({
                useradapter = UserAdapter(lstUser)
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = useradapter
                }
            })
        }
        btnUser.setOnClickListener({
            val intent = Intent(this@MainActivity,AddUser::class.java)
            resultLauncher.launch(intent)
        })
    }
    fun getAllData():List<UserModel>{
        return UserDatabase.getInstance(this@MainActivity).userDao().getAll()
    }
}