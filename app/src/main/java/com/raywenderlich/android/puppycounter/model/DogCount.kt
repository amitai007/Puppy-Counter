package com.raywenderlich.android.puppycounter.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
// יורש Parcelize כדי לאפשר שמירה בין מצבי מערכת-
// זה בעצם מאפשר קריאה מהפונקציה  onSaveInstanceState()
// Parcelize  it allows you to store simple data structures in Bundle.

/*
 * Copyright (c) 2021 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify,
 * merge, publish, distribute, sublicense, create a derivative work,
 * and/or sell copies of the Software in any work that is designed,
 * intended, or marketed for pedagogical or instructional purposes
 * related to programming, coding, application development, or
 * information technology. Permission for such use, copying,
 * modification, merger, publication, distribution, sublicensing,
 * creation of derivative works, or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks
 * that are released under various Open-Source licenses. Use of
 * those libraries and frameworks are governed by their own
 * individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

@Parcelize
data class DogCount(
    val smallDogCount: Int = 0,
    val middleDogCount: Int = 0,
    val bigDogCount: Int = 0
) : Parcelable {

  fun decrementSmallDogCount(): DogCount = copy(smallDogCount = decrement(smallDogCount))

  fun decrementMiddleDogCount(): DogCount = copy(middleDogCount = decrement(middleDogCount))

  fun decrementBigDogCount(): DogCount = copy(bigDogCount = decrement(bigDogCount))

  fun incrementSmallDogCount(): DogCount = copy(smallDogCount = smallDogCount.inc())

  fun incrementMiddleDogCount(): DogCount = copy(middleDogCount = middleDogCount.inc())

  fun incrementBigDogCount(): DogCount = copy(bigDogCount = bigDogCount.inc())

  /**
   * Make sure that you can't decrement if value is 0
   */
  private fun decrement(value: Int): Int = if (value > 0) value.dec() else 0
}