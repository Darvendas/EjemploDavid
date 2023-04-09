package Cuerpos


open class Astro {
    val id:String
    val desc:String
    val masa:Double
    companion object AstroComun{
        var telescopio:String = "V'ger"
    }

    constructor(id:String,desc:String,masa:Double){
        this.id=id
        this.desc=desc
        this.masa=masa
    }

    open fun ajusteGravedad(gravedad:Int):Double{
        return masa*gravedad
    }

    override fun toString(): String {
        return "id='$id', desc='$desc', masa=$masa"
    }


}