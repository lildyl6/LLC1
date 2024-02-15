package com.example.llc1.model

object Model{

    /* =======

    S&P avg: 7.86395833333333



    ========
     */

    var initialBal : Float = 0f
    var currYear : Int = 0
    var deathYear : Int = 0
    var retireYear : Int = 0
    var yearlyDepositAmount : Int = 0
    var yearlyWithdrawAmount : Int = 0

    var array : Array<Array<Number>> = EconHist.array



    fun doCalc(year : Int, month : Int) : Float{
        /*
        steps:
        //start year is 1950
        from curr year to death year
        times bal by roi for each year

         */
        val length = (deathYear - currYear) * 12
        var sum : Float = initialBal
        println("init sum is: "+ sum)
        val start = (year - 1950)*12 + month - 1
        val end = start + length

        for(i in start..end){
            val element : Float = array[i][3].toFloat()
            sum *= ((element/100) + 1)
        }

        println("sum:")
        println(sum)
        return sum
    }
}