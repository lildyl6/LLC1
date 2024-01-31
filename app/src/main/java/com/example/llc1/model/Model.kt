package com.example.llc1.model

class Model {

    /* =======

    S&P avg: 7.86395833333333



    ========
     */

    private var initialBal : Int = 0
    private var currYear : Int = 0
    private var deathYear : Int = 0
    private var yearlyDepositAmount : Int = 0
    private var yearlyWithdrawAmount : Int = 0
    private var retireYear : Int = 0


    constructor(initialBal : Int, currYear : Int, deathYear : Int,
                yearlyDepositAmount : Int, yearlyWithdrawAmount : Int,
                retireYear : Int){
        this.initialBal = initialBal
        this.currYear = currYear
        this.deathYear = deathYear
        this.yearlyDepositAmount = yearlyDepositAmount
        this.yearlyWithdrawAmount = yearlyWithdrawAmount
        this.retireYear = retireYear
    }

    fun getInitialBal() : Int{
        return initialBal
    }

    fun getCurrYear() : Int{
        return currYear
    }

    fun getDeathYear() : Int{
        return deathYear
    }

    fun getYearlyDepositAmount() : Int{
        return yearlyDepositAmount
    }

    fun getYearlyWithdrawAmount() : Int{
        return yearlyWithdrawAmount
    }

    fun getRetireYea() : Int{
        return retireYear
    }

    fun setInitialBal(x : Int){
        initialBal = x
    }

    fun setCurrYear(x : Int){
        currYear = x
    }

    fun setDeathYear(x : Int){
        deathYear = x
    }

    fun setYearlyDepositAmount(x : Int){
        yearlyDepositAmount = x
    }

    fun setYearlyWithdrawAmount(x : Int){
        yearlyWithdrawAmount = x
    }

    fun setRetireYear(x : Int){
        retireYear = x
    }
}