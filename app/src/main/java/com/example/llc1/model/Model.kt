package com.example.llc1.model

class Model {

    /* =======

    S&P avg: 7.86395833333333



    ========
     */

    private var initialBal : Int = 0
    private var val2 : Int = 0
    private var val3 : Int = 0
    private var val4 : Int = 0
    private var val5 : Int = 0

    constructor(initialBal : Int, val2 : Int, val3 : Int, val4 : Int, val5 : Int){
        this.initialBal = initialBal
        this.val2 = val2
        this.val3 = val3
        this.val2 = val4
        this.val3 = val5
    }

    fun getInitialBal() : Int{
        return initialBal
    }

    fun getVal2() : Int{
        return val2
    }

    fun getVal3() : Int{
        return val3
    }

    fun getVal4() : Int{
        return val4
    }

    fun getVal5() : Int{
        return val5
    }

    fun setInitialBal(x : Int){
        initialBal = x
    }

    fun setVal2(x : Int){
        val2 = x
    }

    fun setVal3(x : Int){
        val3 = x
    }

    fun setVal4(x : Int){
        val4 = x
    }

    fun setVal5(x : Int){
        val5 = x
    }
}