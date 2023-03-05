package com.dicoding.dinoapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ActionMenuView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DINO = "extra_dino"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDesc:TextView = findViewById(R.id.tv_detail_description)
        val imgDetail:ImageView = findViewById(R.id.img_detail)
        val tvDataYear: TextView = findViewById(R.id.tv_data_year)
        val tvDataEra: TextView = findViewById(R.id.tv_data_era)
        val tvDataDiet: TextView = findViewById(R.id.tv_data_diet)
        val tvDataType: TextView = findViewById(R.id.tv_data_type)
        val tvDataRegion: TextView = findViewById(R.id.tv_data_region)
        val tvDataWeight: TextView = findViewById(R.id.tv_data_weight)
        val tvDataHeight: TextView = findViewById(R.id.tv_data_height)
        val tvDataLength: TextView = findViewById(R.id.tv_data_length)
        //val shareButton: MenuItem = findViewById(R.id.action_share)

        val dino = intent.getParcelableExtra<Dino>(EXTRA_DINO)


        tvDetailName.text = dino?.name ?: "No Name"
        tvDetailDesc.text = dino?.descDetail
        tvDataYear.text = ":${dino?.year}"
        tvDataEra.text = ": ${dino?.era}"
        tvDataDiet.text = ": ${dino?.diet}"
        tvDataType.text = ": ${dino?.type}"
        tvDataRegion.text = ": ${dino?.region}"
        tvDataWeight.text = ": ${dino?.weight}"
        tvDataHeight.text = ": ${dino?.height}"
        tvDataLength.text = ": ${dino?.lenght}"

        if (dino != null) {
            imgDetail.setImageResource(dino.img)
        }

//        shareButton.setOnClickListener{
//            val shareData = tvDetailName
//            Toast.makeText(this, "Sharing data of ${shareData}", Toast.LENGTH_SHORT).show()
//        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                val shareData = intent.getParcelableExtra<Dino>(EXTRA_DINO)
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Sharing dino data of ${ shareData?.name?.uppercase() }")
                startActivity(Intent.createChooser(shareIntent, "Share Via"))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}