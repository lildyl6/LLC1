package com.example.llc1.model

class Model{

    /* =======

    S&P avg: 7.86395833333333



    ========
     */

    private var initialBal : Float = 0f
    private var currYear : Int = 0
    private var deathYear : Int = 0
    private var yearlyDepositAmount : Int = 0
    private var yearlyWithdrawAmount : Int = 0
    private var retireYear : Int = 0
    private var array : Array<Array<Number>>? = null


    constructor(initialBal : Float, currYear : Int, deathYear : Int,
                yearlyDepositAmount : Int, yearlyWithdrawAmount : Int,
                retireYear : Int){
        this.initialBal = initialBal
        this.currYear = currYear
        this.deathYear = deathYear
        this.yearlyDepositAmount = yearlyDepositAmount
        this.yearlyWithdrawAmount = yearlyWithdrawAmount
        this.retireYear = retireYear

        val econHist = EconHist()
        array = econHist.getEconHist()
    }

    fun getInitialBal() : Float{
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

    fun getRetireYear() : Int{
        return retireYear
    }

    fun setInitialBal(x : Float){
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

    fun doCalc(year : Int, month : Int) : Float{
        /*
        steps:
        //start year is 1950
        from curr year to death year
        times bal by roi for each year

         */
        val length = (deathYear - currYear) * 12
        var sum : Float = initialBal
        val start = (year - 1950)*12 + month - 1
        val end = start + length

        for(i in start..end){
            val element : Float? = array?.get(i)?.get(3)?.toFloat()
            sum *= ((element!!/100) + 1)
        }

        println("sum:")
        println(sum)
        return sum
    }
}