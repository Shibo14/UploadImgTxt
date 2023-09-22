package uz.abbos.firebaseimgtxtupload

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import uz.abbos.firebaseimgtxtupload.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: TechAdapter
    private lateinit var mList: ArrayList<TechData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mList = ArrayList()


        getRewData()

        binding.addFloBtn.setOnClickListener {
            startActivity(Intent(this, AddTechActivity::class.java))
        }
    }

    private fun getRewData() {
        mList = ArrayList()
        val firebaseData = FirebaseDatabase.getInstance().getReference("TechData")
        firebaseData.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                mList.clear()
                for (i in snapshot.children) {
                    val data = i.getValue(TechData::class.java)
                    mList.add(data!!)
                }
                myAdapter = TechAdapter(mList, this@MainActivity)
                binding.rewTech.setHasFixedSize(true)
                binding.rewTech.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.rewTech.adapter = myAdapter

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

}