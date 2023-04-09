package Vger

class Explorado {
    var espacio = ArrayList<Cuadrante>()

    fun addCuadrante(c:Cuadrante){
        espacio.add(c)
    }

    override fun toString(): String {
        var cad = ""
        for (i in espacio.indices){
            cad = cad + "----------   Cuadrante ${i} --------------\n"
            cad = cad + "Este cuadrante es de ${espacio[i].cantFils()} X ${espacio[i].cantCols()}\n\n"
            cad = cad + espacio[i].toString()
        }
        return cad
    }

    fun ajustarGravedad(grav: Int) :String {
        var cad = ""
        for (i in espacio.indices){
            cad += "----- Aplicando el ajuste de gravedad $grav al cuadrante $i de ${espacio[i].cantFils()} X ${espacio[i].cantCols()}\n ----"
            for (f in 0..espacio[i].cantFils()-1){
                for (c in 0..espacio[i].cantCols()-1){
                    cad+="------ Sector $f, $c\n"
                    cad = cad + espacio[i].getCuadrante(f,c).simularGravedad(grav) + "\n"
                }
            }
        }
        return cad
    }

    fun getCuadrante(i:Int):Cuadrante? {
        var cuad: Cuadrante? = null
        if (i >= 0 && i < espacio.size){
            cuad = espacio.get(i)
        }
        return cuad
    }

    fun cuantosCuadrantes():Int = espacio.size

}