package base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class FragBase : Fragment() {

    open val layout: Int = 0

    companion object {
        inline fun <reified T : FragBase> new(bundle: Bundle?): T =
            T::class.java.newInstance().apply { arguments = bundle }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?):
            View? = inflater.inflate(layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.onArguments()
        view.onView()
    }

    open fun Bundle.onArguments() {}

    open fun View.onView() {}
}