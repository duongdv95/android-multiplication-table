# android-multiplication-table
* Components used
  * SeekBar
  * RecycleView
* Approach
  * Generate an ArrayList that holds an ArrayList of Strings to hold multiplication table data from 1-20
    * e.g. 2 x 2 = 4, 2 x 3 = 6...
  * Use RecyclerView, Adapter, and ViewHolder pattern to create rows with data
  * Use SeekBar to detect changes and set adapter
  
![example](https://github.com/duongdv95/android-multiplication-table/blob/master/app/src/main/res/drawable/timestable.png)
