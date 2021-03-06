package thread

import base.ActBind
import com.example.exemplo.databinding.ActThreadBinding
import custom.int
import custom.toast
import custom.viewBind

class ActThread : ActBind<ActThreadBinding>() {

    override val binding: ActThreadBinding by viewBind()

    var run = false

    override fun ActThreadBinding.onBoundView() {
        threadChave.setOnCheckedChangeListener { _, isChecked ->
            toast(if (isChecked) "whiskas" else "sache")
        }

        threadStart.setOnClickListener {
            run = true
//            val segundos = threadInput.int
//            val executavel = Runnable { contaOsSegundosNaTela(segundos) }
//            val thread = Thread(executavel)
//            thread.start()
            Thread(runnable(threadInput.int)).start()
        }

        threadStop.setOnClickListener { run = false }

        threadUi.setOnClickListener {
            runOnUiThread { contaOsSegundosNaTela(threadInput.int) }
        }
    }

    private fun runnable(segundos: Int) = Runnable { contaOsSegundosNaTela(segundos) }

    private fun contaOsSegundosNaTela(seconds: Int) {
        for (segundo in 0..seconds + 1) {
            if (run) {
                runOnUiThread {
                    binding.threadStart.text =
                        if (segundo != seconds + 1) segundo.toString() else "start"
                }
                Thread.sleep(1000)
            }
        }
    }
}