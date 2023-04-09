package Cuerpos


class Planeta: Astro {
    val habitabilidad:Int
    val size:Double

    constructor(id:String, desc:String,masa:Double,habitabilidad:Int,size:Double):super(id, desc, masa){
        this.habitabilidad=habitabilidad
        this.size=size
    }

    override fun toString(): String {
        return "Planeta(${super.toString()}, habitabilidad=$habitabilidad, size=$size)"
    }


}