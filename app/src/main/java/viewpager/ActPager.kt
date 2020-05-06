package viewpager

import base.ActBind
import com.example.exemplo.databinding.ActPagerBinding
import custom.setupPagerAdapter
import fragment.FragAzul
import fragment.FragVerde
import fragment.FragVermelho

class ActPager : ActBind<ActPagerBinding>(ActPagerBinding::class.java) {

    private val fragmentArray = arrayOf(FragAzul(), FragVermelho(), FragVerde())
    private val nomes = listOf("Xandão", "Rafão", "Peter Henry II")

    override fun ActPagerBinding.onBoundView() {
        tabLayout.setupWithViewPager(viewPager)
        viewPager.setupPagerAdapter(fragmentArray, nomes)
    }
}