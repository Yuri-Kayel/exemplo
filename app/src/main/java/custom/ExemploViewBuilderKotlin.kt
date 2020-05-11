package custom

import com.example.exemplo.databinding.ExemploItemBinding
import custom.adapter.RecyclerViewBuilder

class ExemploViewBuilderKotlin : RecyclerViewBuilder<CharSequence, ExemploItemBinding>() {

    override val bindClass = ExemploItemBinding::class.java

    override fun ExemploItemBinding.onBind(position: Int) {
        joaoTextview.text = collection.get(position)
    }
}