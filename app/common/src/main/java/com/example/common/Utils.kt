package com.example.common

import android.accounts.NetworkErrorException
import kotlinx.coroutines.delay

/**
 * Methods here is used to simulate a long running work.
 */
object Utils {

    /**
     * Returns a single random number.
     * There is a random delay with each number.
     */
    suspend fun getRandomNumberWithDelay(): Int {
        getRandomExceptionOrNull()?.let { throw it }
        getRandomNumber().apply {
            delay(this * 10L)
        }.run {
            return this
        }
    }

    /**
     * Randomly generate an exception, or just null.
     * If an exception is generated we throw it, else we proceed with whatever work to do.
     */
    private fun getRandomExceptionOrNull(): Exception? {
        return listOf (
            IllegalArgumentException(),
            null,
            null,
            null,
            NumberFormatException(),
            null,
            ArrayIndexOutOfBoundsException(),
            null,
            null,
            null,
            NetworkErrorException(),
            null
        ).random()
    }

    /**
     * Generate a single random number between 0 to 500.
     */
    private fun getRandomNumber(): Int {
        return (0..500).random()
    }
}