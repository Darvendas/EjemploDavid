package Cuerpos


class GrupoAster: Astro {
    val cantidad:Int

    constructor(id:String,desc:String,masa:Double,cantidad:Int):super(id, desc, masa){
        this.cantidad=cantidad
    }

    override fun toString(): String {
        return "GrupoAster(${super.toString()}, cantidad=$cantidad)"
    }


}