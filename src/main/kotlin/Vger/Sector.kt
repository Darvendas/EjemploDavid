package Vger

import Cuerpos.Astro

class Sector {
    var astros = ArrayList<Astro>()


    fun addAstro(a : Astro){
        astros.add(a)
    }

    fun getAstro(i:Int):Astro{
        return astros[i]
    }

    fun cantAstros():Int = astros.size

    fun simularGravedad(gravedad:Int):String{
        var str=""

        for(i in astros.indices){
            str = str + astros[i].id+": "+astros[i].ajusteGravedad(gravedad).toString()+" newtons\n"
        }

        return str
    }

    override fun toString(): String {
        var str=""

        for(i in astros.indices){
            str = str + astros[i].toString() + "\n"
        }

        return str
    }
}