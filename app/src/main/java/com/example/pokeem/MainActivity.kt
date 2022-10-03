package com.example.pokeem

import `in`.stcvit.idcard.ui.fragments.ProfileFragment
import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.Settings
import android.transition.Fade
import android.util.Log
import android.view.*
import android.view.ContextMenu.ContextMenuInfo
import android.view.View.OnCreateContextMenuListener
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
//import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
//import com.bumptech.glide.load.engine.DiskCacheStrategy
//import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

//import com.example.pokeem.DbHistoryExecutor.getInstance
//import com.example.pokeem.DbIgnoreExecutor.getInstance
//import com.example.pokeem.FileLogManager.getInstance
import com.example.pokeem.databinding.ActivityMainBinding

import java.text.SimpleDateFormat
import java.util.*

class  MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val groupadd = findViewById(R.id.groupApp) as Button

//        groupadd.setOnClickListener{
//            val intent =Intent(this,AddGroupActivity::class.java)
//            startActivity(intent)
//        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.primBg)
        replaceFragement(HomeFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home ->replaceFragement(HomeFragment())
                R.id.profile -> replaceFragement(ProfileFragment())
                R.id.group -> replaceFragement(GroupFragment())
                R.id.list -> replaceFragement(AppFragment())
                R.id.rank -> replaceFragement(LeaderFragment())

                else ->
                {

                }
            }
            true

        }






    }
    private fun replaceFragement(fragment : Fragment){
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.coordinator,fragment)
        fragmentTransaction.commit()


    }

}


//@Suppress("DEPRECATION")
//class MainActivity : AppCompatActivity() {
//    private var mSort: LinearLayout? = null
//    private var mSwitch: Switch? = null
//    private var mSwitchText: TextView? = null
//    private var mList: RecyclerView? = null
//    private var mAdapter: timeline.lizimumu.com.t.ui.MainActivity.MyAdapter? = null
//    private var mDialog: AlertDialog? = null
//    private var mSwipe: SwipeRefreshLayout? = null
//    private var mSortName: TextView? = null
//    private var mTotal: Long = 0
//    private var mDay = 0
//    private var mPackageManager: PackageManager? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // https://guides.codepath.com/android/Shared-Element-Activity-Transition
//        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
//        window.exitTransition = Fade(Fade.OUT)
//        setContentView(R.layout.activity_main)
//        mPackageManager = packageManager
//        mSort = findViewById(R.id.sort_group)
//        mSortName = findViewById(R.id.sort_name)
//        mSwitch = findViewById(R.id.enable_switch)
//        mSwitchText = findViewById(R.id.enable_text)
//        mAdapter = timeline.lizimumu.com.t.ui.MainActivity.MyAdapter()
//        mList = findViewById(R.id.list)
//        mList.setLayoutManager(LinearLayoutManager(this))
//        val dividerItemDecoration =
//            DividerItemDecoration(mList.getContext(), DividerItemDecoration.VERTICAL)
//        dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.divider, theme))
//        mList.addItemDecoration(dividerItemDecoration)
//        mList.setAdapter(mAdapter)
//        initLayout()
//        initEvents()
//        initSpinner()
//        initSort()
//        if (DataManager.getInstance().hasPermission(applicationContext)) {
//            process()
//            startService(Intent(this, AlarmService::class.java))
//        }
//    }
//
//    private fun initLayout() {
//        mSwipe = findViewById(R.id.swipe_refresh)
//        if (DataManager.getInstance().hasPermission(applicationContext)) {
//            mSwitchText.setText(R.string.enable_apps_monitoring)
//            mSwitch!!.visibility = View.GONE
//            mSort!!.visibility = View.VISIBLE
//            mSwipe.setEnabled(true)
//        } else {
//            mSwitchText.setText(R.string.enable_apps_monitor)
//            mSwitch!!.visibility = View.VISIBLE
//            mSort!!.visibility = View.GONE
//            mSwitch!!.isChecked = false
//            mSwipe.setEnabled(false)
//        }
//    }
//
//    private fun initSort() {
//        if (DataManager.getInstance().hasPermission(applicationContext)) {
//            mSort!!.setOnClickListener { triggerSort() }
//        }
//    }
//
//    private fun triggerSort() {
//        mDialog = AlertDialog.Builder(this@MainActivity)
//            .setTitle(R.string.sort)
//            .setSingleChoiceItems(R.array.sort,
//                PreferenceManager.getInstance().getInt(PreferenceManager.PREF_LIST_SORT),
//                DialogInterface.OnClickListener { dialogInterface, i ->
//                    PreferenceManager.getInstance().putInt(PreferenceManager.PREF_LIST_SORT, i)
//                    process()
//                    mDialog!!.dismiss()
//                })
//            .create()
//        mDialog!!.show()
//    }
//
//    private fun initSpinner() {
//        if (DataManager.getInstance().hasPermission(applicationContext)) {
//            val spinner = findViewById<Spinner>(R.id.spinner)
//            spinner.visibility = View.VISIBLE
//            val adapter = ArrayAdapter.createFromResource(
//                this,
//                R.array.duration, android.R.layout.simple_spinner_item
//            )
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            spinner.adapter = adapter
//            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(
//                    adapterView: AdapterView<*>?,
//                    view: View,
//                    i: Int,
//                    l: Long
//                ) {
//                    if (mDay != i) {
//                        val values = resources.getIntArray(R.array.duration_int)
//                        mDay = values[i]
//                        process()
//                    }
//                }
//
//                override fun onNothingSelected(adapterView: AdapterView<*>?) {}
//            }
//        }
//    }
//
//    private fun initEvents() {
//        if (!DataManager.getInstance().hasPermission(applicationContext)) {
//            mSwitch!!.setOnCheckedChangeListener { compoundButton, b ->
//                if (b) {
//                    val intent = Intent(this@MainActivity, AppService::class.java)
//                    intent.putExtra(AppService.SERVICE_ACTION, AppService.SERVICE_ACTION_CHECK)
//                    startService(intent)
//                }
//            }
//        }
//        mSwipe.setOnRefreshListener(object : OnRefreshListener() {
//            fun onRefresh() {
//                process()
//            }
//        })
//    }
//
//    override fun onResume() {
//        super.onResume()
//        if (!DataManager.getInstance().hasPermission(applicationContext)) {
//            mSwitch!!.isChecked = false
//        }
//    }
//
//    override fun onNewIntent(intent: Intent) {
//        super.onNewIntent(intent)
//        if (DataManager.getInstance().hasPermission(this)) {
//            mSwipe.setEnabled(true)
//            mSort!!.visibility = View.VISIBLE
//            mSwitch!!.visibility = View.GONE
//            initSpinner()
//            initSort()
//            process()
//        }
//    }
//
//    private fun process() {
//        if (DataManager.getInstance().hasPermission(applicationContext)) {
//            mList!!.visibility = View.INVISIBLE
//            val sortInt: Int =
//                PreferenceManager.getInstance().getInt(PreferenceManager.PREF_LIST_SORT)
//            mSortName!!.text = getSortName(sortInt)
//            timeline.lizimumu.com.t.ui.MainActivity.MyAsyncTask().execute(sortInt, mDay)
//        }
//    }
//
//    private fun getSortName(sortInt: Int): String {
////        return getResources().getStringArray(R.array.sort)[sortInt];
//        return resources.getString(R.string.sort_by)
//    }
//
//    override fun onContextItemSelected(item: MenuItem): Boolean {
//        val info: AppItem = mAdapter.getItemInfoByPosition(item.order)
//        return when (item.itemId) {
//            R.id.ignore -> {
//                DbIgnoreExecutor.getInstance().insertItem(info)
//                process()
//                Toast.makeText(this, R.string.ignore_success, Toast.LENGTH_SHORT).show()
//                true
//            }
//            R.id.open -> {
//                startActivity(mPackageManager!!.getLaunchIntentForPackage(info.mPackageName))
//                true
//            }
//            R.id.more -> {
//                val intent = Intent(
//                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
//                    Uri.parse("package:" + info.mPackageName)
//                )
//                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//                startActivity(intent)
//                true
//            }
//            else -> super.onContextItemSelected(item)
//        }
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.settings -> {
//                startActivityForResult(Intent(this@MainActivity, SettingsActivity::class.java), 1)
//                true
//            }
//            R.id.sort -> {
//                triggerSort()
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        Log.d(">>>>>>>>", "result code $requestCode $resultCode")
//        if (resultCode > 0) process()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        if (mDialog != null) mDialog!!.dismiss()
//    }
//
//    internal inner class MyAdapter :
//        RecyclerView.Adapter<timeline.lizimumu.com.t.ui.MainActivity.MyAdapter.MyViewHolder>() {
//        private var mData: List<AppItem>
//
//        init {
//            mData = ArrayList()
//        }
//
//        fun updateData(data: List<AppItem>) {
//            mData = data
//            notifyDataSetChanged()
//        }
//
//        fun getItemInfoByPosition(position: Int): AppItem? {
//            return if (mData.size > position) {
//                mData[position]
//            } else null
//        }
//
//        override fun onCreateViewHolder(
//            parent: ViewGroup,
//            viewType: Int
//        ): timeline.pokeem.MainActivity.MyAdapter.MyViewHolder {
//            val itemView: View =
//                LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
//            return timeline.pokeem.MainActivity.MyAdapter.MyViewHolder(itemView)
//        }
//
//        override fun onBindViewHolder(
//            holder: timeline.lizimumu.com.t.ui.MainActivity.MyAdapter.MyViewHolder,
//            position: Int
//        ) {
//            val item = getItemInfoByPosition(position)
//            holder.mName.setText(item!!.mName)
//            holder.mUsage.setText(AppUtil.formatMilliSeconds(item.mUsageTime))
//            holder.mTime.setText(
//                java.lang.String.format(
//                    Locale.getDefault(),
//                    "%s · %d %s",
//                    SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.getDefault()).format(
//                        Date(
//                            item.mEventTime
//                        )
//                    ),
//                    item.mCount,
//                    resources.getString(R.string.times_only)
//                )
//            )
//            holder.mDataUsage.setText(
//                java.lang.String.format(
//                    Locale.getDefault(), "%s", AppUtil.humanReadableByteCount(
//                        item.mMobile
//                    )
//                )
//            )
//            if (mTotal > 0) {
//                holder.mProgress.setProgress((item.mUsageTime * 100 / mTotal).toInt())
//            } else {
//                holder.mProgress.setProgress(0)
//            }
//            GlideApp.with(this@MainActivity)
//                .load(AppUtil.getPackageIcon(this@MainActivity, item.mPackageName))
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .transition(DrawableTransitionOptions().crossFade())
//                .into(holder.mIcon)
//            holder.setOnClickListener(item)
//        }
//
//        override fun getItemCount(): Int {
//            return mData.size
//        }
//
//        internal inner class MyViewHolder(itemView: View) :
//            RecyclerView.ViewHolder(itemView), OnCreateContextMenuListener {
//            private val mName: TextView
//            private val mUsage: TextView
//            private val mTime: TextView
//            private val mDataUsage: TextView
//            private val mIcon: ImageView
//            private val mProgress: ProgressBar
//
//            init {
//                mName = itemView.findViewById(R.id.app_name)
//                mUsage = itemView.findViewById(R.id.app_usage)
//                mTime = itemView.findViewById(R.id.app_time)
//                mDataUsage = itemView.findViewById(R.id.app_data_usage)
//                mIcon = itemView.findViewById(R.id.app_image)
//                mProgress = itemView.findViewById(R.id.progressBar)
//                itemView.setOnCreateContextMenuListener(this)
//            }
//
//            @SuppressLint("RestrictedApi")
//            fun setOnClickListener(item: AppItem) {
//                itemView.setOnClickListener {
//                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
//                    intent.putExtra(DetailActivity.EXTRA_PACKAGE_NAME, item.mPackageName)
//                    intent.putExtra(DetailActivity.EXTRA_DAY, mDay)
//                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
//                        this@MainActivity,
//                        mIcon,
//                        "profile"
//                    )
//                    startActivityForResult(intent, 1, options.toBundle())
//                }
//            }
//
//            override fun onCreateContextMenu(
//                contextMenu: ContextMenu,
//                view: View,
//                contextMenuInfo: ContextMenuInfo
//            ) {
//                val position = adapterPosition
//                val item = getItemInfoByPosition(position)
//                contextMenu.setHeaderTitle(item!!.mName)
//                contextMenu.add(Menu.NONE, R.id.open, position, resources.getString(R.string.open))
//                if (item.mCanOpen) {
//                    contextMenu.add(
//                        Menu.NONE,
//                        R.id.more,
//                        position,
//                        resources.getString(R.string.app_info)
//                    )
//                }
//                contextMenu.add(
//                    Menu.NONE,
//                    R.id.ignore,
//                    position,
//                    resources.getString(R.string.ignore)
//                )
//            }
//        }
//    }
//
//    @SuppressLint("StaticFieldLeak")
//    internal inner class MyAsyncTask :
//        AsyncTask<Int?, Void?, List<AppItem>>() {
//        override fun onPreExecute() {
//            super.onPreExecute()
//            mSwipe.setRefreshing(true)
//        }
//
//        protected override fun doInBackground(vararg integers: Int): List<AppItem> {
//            return DataManager.getInstance().getApps(applicationContext, integers[0], integers[1])
//        }
//
//        override fun onPostExecute(appItems: List<AppItem>) {
//            mList!!.visibility = View.VISIBLE
//            mTotal = 0
//            for (item in appItems) {
//                if (item.mUsageTime <= 0) continue
//                mTotal += item.mUsageTime
//                item.mCanOpen =
//                    mPackageManager!!.getLaunchIntentForPackage(item.mPackageName) != null
//            }
//            mSwitchText!!.text =
//                java.lang.String.format(
//                    resources.getString(R.string.total),
//                    AppUtil.formatMilliSeconds(mTotal)
//                )
//            mSwipe.setRefreshing(false)
//            mAdapter.updateData(appItems)
//        }
//    }
//}