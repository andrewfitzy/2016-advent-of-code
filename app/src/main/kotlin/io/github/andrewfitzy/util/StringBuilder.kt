package io.github.andrewfitzy.util

fun StringBuilder.appendAll(vararg elements: Char) {
    elements.forEach { append(it) }
}
