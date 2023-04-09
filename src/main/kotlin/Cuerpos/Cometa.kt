package Cuerpos

class Cometa: Astro {
    val velocidad:Double

    constructor(id:String,desc:String,masa:Double,velocidad:Double):super(id, desc, masa){
        this.velocidad=velocidad
    }

    override fun toString(): String {
        return "Cometa(${super.toString()}, velocidad=$velocidad)"
    }


}