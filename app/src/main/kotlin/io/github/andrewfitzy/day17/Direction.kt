package io.github.andrewfitzy.day17

import io.github.andrewfitzy.util.Point

enum class Direction(val identifier: Char, val offset: Point) {
    UP('U', Point(0, -1)),
    DOWN('D', Point(0, 1)),
    LEFT('L', Point(-1, 0)),
    RIGHT('R', Point(1, 0)),
}
