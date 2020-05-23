package retrofit

import com.example.exemplo.R
import com.example.exemplo.databinding.ItemChamadaBinding
import custom.adapter.RecyclerViewBuilder
import custom.get
import custom.isOdd

class RetroItemViewBuilder<T> : RecyclerViewBuilder<T, ItemChamadaBinding>() {

    override val bindClass = ItemChamadaBinding::class.java

    override fun ItemChamadaBinding.onBind(position: Int) {
        root.setBackgroundColor(context.getColor(if (position.isOdd) R.color.amber_50 else R.color.indigo_50))
        chamadaItemNome.text = collection.get(position).toString()
    }
}