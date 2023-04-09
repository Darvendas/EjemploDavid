import Vger.Cuadrante
import Vger.Explorado
import kotlin.random.Random


fun main() {
    var nav:Int
    var gravedadAplicada : Int
    var vertice:Int
    var espacioExplorado = Explorado()

    println("¡Bienvenido al menú de la sonda Voyager VI!")

    do{
        println("1.- Realizar barrido" +
                "\n2.- Mostrar sistemas descubiertos" +
                "\n3.- Simulación de gravedad en un cuadrante determinado" +
                "\n4.- Plegar espacio/tiempo" +
                "\n5.- Volver a casa")
        nav= readln().toInt()

        if((nav<1) or (nav>5)) println("Opción no válida\n")

        when(nav){
            1 -> {
                espacioExplorado.addCuadrante(Factoria.factoriaCuadrante())
            }

            2 -> {
                println(espacioExplorado)
            }

            3 -> {
                gravedadAplicada = Random.nextInt(1,20)
                println(espacioExplorado.ajustarGravedad(gravedadAplicada))
            }

            4 -> {
                var cuad1 = 0
                var cuad2 = 0
                println("Qué cuadrantes quieres plegar?")
                for (i in 0..espacioExplorado.cuantosCuadrantes()-1){
                    var cuad = espacioExplorado.getCuadrante(i)
                    println("Cuadrante $i --> ${cuad!!.cantFils()} X ${cuad!!.cantCols()}")
                }
                do {
                    println("Dame los cuadrantes que quieres plegar (-1 para cancelar)")
                    print("Cuadrante 1? ")
                    cuad1 = readln().toInt()
                    print("Cuadrante 2? ")
                    cuad2 = readln().toInt()
                }while(cuad1!=-1 && espacioExplorado.getCuadrante(cuad1)!!.cantFils() != espacioExplorado.getCuadrante(cuad2)!!.cantFils() )
                if (cuad1!=-1){
                    vertice = Random.nextInt(2)
                    var cuadPlegado :Cuadrante? = null
                    if (vertice == 0){
                        println("Plegando vértice 1 - 3....")
                        cuadPlegado = plegarV1yV3(espacioExplorado.getCuadrante(cuad1)!!, espacioExplorado.getCuadrante(cuad2)!!)
                    }
                    else {
                        println("Plegando vértice 2- 4....")
                        cuadPlegado = plegarV2yV4(espacioExplorado.getCuadrante(cuad1)!!, espacioExplorado.getCuadrante(cuad2)!!)
                    }
                    println("El nuevo cuadrante plegado:")
                    println(cuadPlegado)
                    println("Añadiéndolo al espacio explorado....")
                    espacioExplorado.addCuadrante(cuadPlegado)
                }

            }
        }
    }while(nav!=5)

    println("¡Volviendo a casa!")
}

fun plegarV1yV3(c1 : Cuadrante, c2 : Cuadrante):Cuadrante {
    var cuadFinal = Cuadrante(c1.cantCols())
    for (i in 0..c1.cantFils()-1){
        for (j in 0..c1.cantCols()-1){
            cuadFinal.setCuadrante(i,j,c1.getCuadrante(i,j))
            for (indC2 in 0..c2.getCuadrante(i,j).cantAstros()-1){
                cuadFinal.getCuadrante(i,j).addAstro(c2.getCuadrante(j,i).getAstro(indC2))
            }
//            mFinal[i][j] = m1[i][j] + m2[i][j]
        }
    }
    return cuadFinal
}

fun plegarV2yV4(c1 : Cuadrante, c2 : Cuadrante):Cuadrante {
    var cuadFinal = Cuadrante(c1.cantCols())
    var i2: Int
    var j2 = cuadFinal.cantCols()-1

    for (i in 0..c1.cantFils()-1){
        i2 = cuadFinal.cantCols()-1
        for (j in 0..c1.cantCols()-1){
            cuadFinal.setCuadrante(i,j,c1.getCuadrante(i,j))
            for (indC2 in 0..c2.getCuadrante(i2,j2).cantAstros()-1){
                cuadFinal.getCuadrante(i,j).addAstro(c2.getCuadrante(i2,j2).getAstro(indC2))
            }
//            mFinal[i][j] = m1[i][j] + m2[i2][j2]
            i2--
        }
        j2--
    }
    return cuadFinal
}
