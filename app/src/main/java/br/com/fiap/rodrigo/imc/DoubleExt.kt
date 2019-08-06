package br.com.fiap.rodrigo.imc

fun Double.toFixed(digits: Int) = String.format("%.${digits}f", this)