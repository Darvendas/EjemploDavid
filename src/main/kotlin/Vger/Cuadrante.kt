package Vger


class Cuadrante {
    lateinit var sectores : Array<Array<Sector>>

    constructor(dim:Int){
        sectores = Array(dim){Array<Sector>(dim){ Sector() } }
    }

    fun getCuadrante(f:Int, c:Int):Sector{
        return this.sectores[f][c]
    }

    fun setCuadrante(f:Int, c:Int, s:Sector){
        this.sectores[f][c] = s
    }

    fun cantFils() = this.sectores.size

    fun cantCols() = this.sectores[0].size

    override fun toString():String{
        var str=""

        for(i in sectores.indices){
            for (j in sectores[i].indices){
                str = str + "--------- Sector [$i][$j] --------------\n"
                str = str + sectores[i][j].toString() + "\n"
            }
        }

        return str
    }
}