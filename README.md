## RecyclerView万能适配器
### 使用指南
#### 第 1 步 在存储库的 build.gradle 中添加︰
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
#### 第 2 步 添加依赖项
  	dependencies {
	    compile 'com.github.victe2010:BaseAdapterRecyclerView:1.0.0'
	}
	
#### 第 3 步 新建一个类（Myadapter）继承 BaseAdapterRecyclerView<T>
	 inner class Myadapter(mlist:ArrayList<MainBean>): BaseAdapterRecyclerView<MainBean>(mlist,R.layout.recy_item){
            override fun convert(holder: RecyclerHolder, item: MainBean, position: Int, isScrolling: Boolean) {
                with(holder.itemView){
                    item_title.text =item.name;
                    item_name.text = item.api;
                }
            }
        }
        
##### 注意
   * mlist: 数据源<T>
   * R.layout.recy_item:recyclerview item的布局文件
   * convert:重写的方法，绘制每行item时回调方法
   * item_title：R.layout.recy_item布局文件里面的控件id,通过kotlin语法获取
   * item_name：同上
   
##### BaseAdapterRecyclerView 扩展接口
   * 适配器提供了两个接口，item的单击和长按事件
   * recyclerView.setOnItemClickListener(parent: RecyclerView, view: View, position: Int)//设置单击事件
   * recyclerView.setOnItemLongClickListener(parent: RecyclerView, view: View, position: Int)//设置长按事件回调
   
##### 提供局部刷新
   *  adapter.insert(T,1) // 插入
   *  adapter.delete(3) // 删除
   *  adapter.update(T,1) //更新
   
   
   