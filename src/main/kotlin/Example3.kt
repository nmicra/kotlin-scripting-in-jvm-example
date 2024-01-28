package org.example

import kotlin.script.experimental.api.*
import kotlin.script.experimental.host.StringScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost


val script3 = """
    val a = %s
    val b = %s
    if (a > b) "hi" else "bye"
""".trimIndent()

fun main() {
    val a = 5
    val b = 6

    val scriptSource = StringScriptSource(script3.format(a,b))

    val scriptingHost = BasicJvmScriptingHost()

//    val result = scriptingHost.eval(scriptSource, ScriptCompilationConfiguration(), ScriptEvaluationConfiguration {
//        providedProperties("a" to a, "b" to b)
//    })

    val result = scriptingHost.eval(scriptSource, ScriptCompilationConfiguration(), ScriptEvaluationConfiguration())

    if (result is ResultWithDiagnostics.Success) {
        val scriptResult = result.value.returnValue
        when (scriptResult) {
            is ResultValue.Value -> {
                val hiOrBye : String = scriptResult.value.toString()
                println(">>> script returned: $hiOrBye")
            }
            else -> println(">>>> Script did not return a value")
        }
    } else {
        result.reports.forEach {

            println("Error: [${it.message}] ${it.exception?.stackTraceToString()}")
        }
    }
}

