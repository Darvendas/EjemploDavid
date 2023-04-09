import Cuerpos.*
import Vger.*
import kotlin.random.Random

object Factoria {


    fun factoriaPlaneta(filSector: Int, colSector: Int): Planeta {
        val descPlaneta =
            arrayOf("enano", "gigante", "rocoso", "gaseoso", "desertico", "acuatico", "congelado", "selvatico")
        val desc = descPlaneta[Random.nextInt(descPlaneta.size)]
        val masa = Random.nextDouble(10000.0)
        val habitabilidad = Random.nextInt(11)
        val size = Random.nextDouble(10000.0)
        val id = desc + filSector.toString() + colSector.toString() + Random.nextInt(1, 100).toString()
        return Planeta(id, desc, masa, habitabilidad, size)
    }

    fun factoriaCometa(filSector: Int, colSector: Int): Cometa {
        val descCometa = arrayOf("fuego", "hielo", "oro", "plata", "cobre", "hierro")
        val desc = descCometa[Random.nextInt(descCometa.size)]
        val masa = Random.nextDouble(500.0)
        val velocidad = Random.nextDouble(10000.0)
        val id = desc + filSector.toString() + colSector.toString() + Random.nextInt(1, 100).toString()
        return Cometa(id, desc, masa, velocidad)
    }

    fun factoriaGrupoAster(filSector: Int, colSector: Int): GrupoAster {
        val descGrupoAster = arrayOf("grandes", "pequenios", "juntos", "separados")
        val desc = descGrupoAster[Random.nextInt(descGrupoAster.size)]
        val masa = Random.nextDouble(10000.0)
        val cantidad = Random.nextInt(20000)
        val id = desc + filSector.toString() + colSector.toString() + Random.nextInt(1, 100).toString()
        return GrupoAster(id, desc, masa, cantidad)
    }

    fun factoriaCuadrante(): Cuadrante {
        var tam = Random.nextInt(2, 5)
        var cuad = Cuadrante(tam)
        for (f in 0..tam - 1) {
            for (c in 0..tam - 1) {
                cuad.setCuadrante(f, c, factoriaSector(f, c))
            }
        }
        return cuad
    }

    fun factoriaSector(f: Int, c: Int): Sector {
        var sector = Sector()
        var cuantos = Random.nextInt(2, 5) //Cantidad de elementos por sector. Aleatorio.
        for (i in 1..cuantos) {
            var tipoAstro = Random.nextInt(3)
            when (tipoAstro) {
                0 -> {
                    sector.addAstro(factoriaCometa(f, c))
                }
                1 -> {
                    sector.addAstro(factoriaPlaneta(f, c))
                }
                2 -> {
                    sector.addAstro(factoriaGrupoAster(f, c))
                }
            }
        }
        return sector
    }
}