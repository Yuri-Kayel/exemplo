package retrofit

import com.example.exemplo.R
import com.example.exemplo.databinding.ItemChamadaBinding
import custom.adapter.ItemViewBuilder
import custom.get
import custom.isOdd
import custom.viewBind

class RetroItemViewBuilder<T> : ItemViewBuilder<T, ItemChamadaBinding>() {

    override val binding: ItemChamadaBinding by viewBind()

    override fun ItemChamadaBinding.onBind(position: Int) {
        root.setBackgroundColor(context.getColor(if (position.isOdd) R.color.amber_50 else R.color.indigo_50))
        chamadaItemNome.text = collection.get(position).toString()
    }
}