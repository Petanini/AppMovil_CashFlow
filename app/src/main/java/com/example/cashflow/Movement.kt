package com.example.cashflow

data class Movement(
    val title: String,
    val date: String,
    val amount: Double,
    val isIncome: Boolean // true para ingreso, false para gasto
)

