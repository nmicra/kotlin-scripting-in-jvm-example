package org.example

import kotlin.script.experimental.api.ScriptCompilationConfiguration
import kotlin.script.experimental.api.ScriptDiagnostic
import kotlin.script.experimental.api.ScriptEvaluationConfiguration
import kotlin.script.experimental.host.StringScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost


val script2 = """
    println("Hello from Kotlin script Example-2!")
""".trimIndent()


fun main() {


    val scriptSource = StringScriptSource(script2)

    val scriptingHost = BasicJvmScriptingHost()

    val result = scriptingHost.eval(scriptSource, ScriptCompilationConfiguration(), ScriptEvaluationConfiguration())

    result.reports.forEach {
        if (it.severity == ScriptDiagnostic.Severity.ERROR) {
            println("Error executing script: ${it.message}")
        }
    }
}
