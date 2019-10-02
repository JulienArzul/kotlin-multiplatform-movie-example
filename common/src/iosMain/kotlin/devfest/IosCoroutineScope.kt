package devfest

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import kotlin.coroutines.CoroutineContext

class IosCoroutineScope(private val mainContext: CoroutineContext = UI()) : CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + mainContext

    fun cancel() {
        job.cancel()
    }
}

class UI : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        val queue = dispatch_get_main_queue()
        dispatch_async(queue) {
            block.run()
        }
    }
}