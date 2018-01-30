package com.victe.baseadapterrecyclerviewdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.victe.allbaseadapter.BaseAdapterRecyclerView
import com.victe.baseadapterrecyclerviewdemo.bean.MainBean
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recy_item.view.*


class MainActivity : AppCompatActivity() {
    private val list:ArrayList<MainBean> = ArrayList<MainBean>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 1..10){
            var bean = MainBean();
            bean.api = "123"+i
            bean.name="你好"+i
            list.add(bean);
        }
        var adapter = Myadapter(list);
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter;

        addBtn.setOnClickListener {
            var bean = MainBean();
            bean.api = "1231"
            bean.name="你好11"
            list.add(1,bean);
            adapter.insert(bean,1)
            Log.e("TAG","------------->"+list.size)
        }

        delBtn.setOnClickListener {
            list.removeAt(3)
            adapter.delete(3)
        }

        updateBtn.setOnClickListener {
            list.removeAt(1)
            var bean = MainBean();
            bean.api = "12311111"
            bean.name="你好11111"
            list.add(1,bean);
            adapter.update(bean,1)
        }

    }
    inner class Myadapter(mlist:ArrayList<MainBean>): BaseAdapterRecyclerView<MainBean>(mlist,R.layout.recy_item){
        override fun convert(holder: RecyclerHolder, item: MainBean, position: Int, isScrolling: Boolean) {
            with(holder.itemView){
                item_title.text =item.name;
                item_name.text = item.api;
            }
        }
    }


}
