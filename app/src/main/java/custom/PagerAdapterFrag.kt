package custom

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

fun ViewPager.setup(frags: Any, titles: Any, tabLayout: TabLayout? = null) {
    tabLayout?.setupWithViewPager(this)
    adapter = PagerAdapterFrag(
        frags, titles, (context as AppCompatActivity).supportFragmentManager
    )
}

class PagerAdapterFrag(
    private val frags: Any,
    private val titles: Any,
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @Suppress("UNCHECKED_CAST")
    override fun getItem(position: Int): Fragment = when (frags) {
        is List<*> -> frags[position] as Fragment
        else       -> (frags as Array<Fragment>)[position]
    }

    override fun getPageTitle(position: Int) = when (titles) {
        is List<*>  -> titles[position] as String
        is Array<*> -> titles[position] as String
        else -> null
    }

    override fun getCount() = when (frags) {
        is List<*> -> frags.size
        is Array<*> -> frags.size
        else -> when (titles) {
            is List<*> -> titles.size
            is Array<*> -> titles.size
            else -> 2
        }
    }
}

