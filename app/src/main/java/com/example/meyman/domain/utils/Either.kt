package com.example.meyman.domain.utils


sealed class Either<out L, out R> {

    data class Left<out L>(val message: L? = null) : Either<L, Nothing>()

    data class Right<out R>(val data: R? = null) : Either<Nothing, R>()
}