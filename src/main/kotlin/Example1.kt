package org.example

import java.io.File
import kotlin.script.experimental.api.ScriptCompilationConfiguration
import kotlin.script.experimental.api.ScriptDiagnostic
import kotlin.script.experimental.api.ScriptEvaluationConfiguration
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost

fun main() {

    val scriptFile = File("scripts//simpleScript.kts" )
    val scriptSource = scriptFile.toScriptSource()

    val scriptingHost = BasicJvmScriptingHost()

    val result = scriptingHost.eval(scriptSource, ScriptCompilationConfiguration(), ScriptEvaluationConfiguration())

    result.reports.forEach {
        if (it.severity == ScriptDiagnostic.Severity.ERROR) {
            println("Error executing script: ${it.message}")
        }
    }
}
