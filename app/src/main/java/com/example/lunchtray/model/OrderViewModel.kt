/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.lunchtray.model

import android.app.Application
import androidx.lifecycle.*
import com.example.lunchtray.R
import com.example.lunchtray.data.DataSource
import java.text.NumberFormat

class OrderViewModel(application: Application) : AndroidViewModel(application) {

    // Map of menu items
    val menuItems = DataSource.menuItems

    // Default values for item prices
    private var previousEntreePrice = 0.0
    private var previousSidePrice = 0.0
    private var previousAccompanimentPrice = 0.0

    // Default tax rate
    private val taxRate = 0.08

    // Entree for the order
    private val _entree = MutableLiveData<MenuItem?>()
    val entree: LiveData<MenuItem?> = _entree

    // Side for the order
    private val _side = MutableLiveData<MenuItem?>()
    val side: LiveData<MenuItem?> = _side

    // Accompaniment for the order.
    private val _accompaniment = MutableLiveData<MenuItem?>()
    val accompaniment: LiveData<MenuItem?> = _accompaniment

    // Subtotal for the order
    private val _subtotal = MutableLiveData(0.0)
    val subtotal: LiveData<String> =
    Transformations.map(_subtotal) {application.resources.getString(
        R.string.subtotal,
        NumberFormat.getCurrencyInstance().format(it))
    }

    // Total cost of the order
    private val _total = MutableLiveData(0.0)
    val total: LiveData<String> = Transformations.map(_total) {
        application.resources.getString(
            R.string.total,
        NumberFormat.getCurrencyInstance().format(it))
    }

    // Tax for the order
    private val _tax = MutableLiveData(0.0)
    val tax: LiveData<String> = Transformations.map(_tax) {
        application.resources.getString(
            R.string.tax,
        NumberFormat.getCurrencyInstance().format(it))
    }

    /**
     * Set the entree for the order.
     */
    fun setEntree(entree: String) {
        if (_entree.value != null) {
            previousEntreePrice = _entree.value!!.price
        }
        //  if _entree.value is not null, set the previous entree price to the current
        //  entree price.

        if (_subtotal.value != null) {
            _subtotal.value = _subtotal.value!! - previousEntreePrice
        }

        //  if _subtotal.value is not null subtract the previous entree price from the current
        //  subtotal value. This ensures that we only charge for the currently selected entree.

        _entree.value = menuItems[entree]
        //  set the current entree value to the menu item corresponding to the passed in string

        updateSubtotal(_subtotal.value!!.plus(_entree.value!!.price))
        //  update the subtotal to reflect the price of the selected entree.
    }

    /**
     * Set the side for the order.
     */
    fun setSide(side: String) {
        if (_side.value != null) {
            previousSidePrice = _side.value!!.price
        }
        // if _side.value is not null, set the previous side price to the current side price.

        if (_subtotal.value != null) {
            _subtotal.value = _subtotal.value!!.minus(previousSidePrice)
        }

        // if _subtotal.value is not null subtract the previous side price from the current
        //  subtotal value. This ensures that we only charge for the currently selected side.

        _side.value = menuItems[side]
        updateSubtotal(_side.value!!.price)

        //  set the current side value to the menu item corresponding to the passed in string
        //  update the subtotal to reflect the price of the selected side.
    }

    /**
     * Set the accompaniment for the order.
     */
    fun setAccompaniment(accompaniment: String) {
        if (_accompaniment.value != null) {
            previousAccompanimentPrice = _accompaniment.value!!.price
        }
        // if _accompaniment.value is not null, set the previous accompaniment price to the
        //  current accompaniment price.

        if (_accompaniment.value != null) {
            _subtotal.value = _subtotal.value!!.minus(_accompaniment.value!!.price)
        }

        // if _accompaniment.value is not null subtract the previous accompaniment price from
        //  the current subtotal value. This ensures that we only charge for the currently selected
        //  accompaniment.

        _accompaniment.value = menuItems[accompaniment]

        // set the current accompaniment value to the menu item corresponding to the passed in
        //  string
        // update the subtotal to reflect the price of the selected accompaniment.
        updateSubtotal(_accompaniment.value!!.price)
    }

    /**
     * Update subtotal value.
     */
    private fun updateSubtotal(itemPrice: Double) {
        if (_subtotal.value != null) {
            _subtotal.value = _subtotal.value!!.plus(itemPrice)
        } else {
            _subtotal.value = itemPrice
        }
        //  if _subtotal.value is not null, update it to reflect the price of the recently
        //  added item.
        //  Otherwise, set _subtotal.value to equal the price of the item.

        calculateTaxAndTotal()

        // calculate the tax and resulting total
    }

    /**
     * Calculate tax and update total.
     */
    fun calculateTaxAndTotal() {
        _tax.value = _subtotal.value?.times(taxRate)
        // set _tax.value based on the subtotal and the tax rate.

        _total.value = _subtotal.value!!.plus(_tax.value!!)
        // set the total based on the subtotal and _tax.value.
    }

    /**
     * Reset all values pertaining to the order.
     */
    fun resetOrder() {
        _entree.value = null
        _accompaniment.value = null
        _side.value = null
        _subtotal.value = 0.0
        _tax.value = 0.0
        _total.value = 0.0
        // Reset all values associated with an order
    }
}
