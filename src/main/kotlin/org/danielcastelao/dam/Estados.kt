package org.danielcastelao.dam
import org.danielcastelao.dam.botonera

sealed class Estados {
    object Idle : Estados(){

        fun onEnter(boton: Int){
            println("Entrando al Idle")

            Thread.sleep(2000)

            if (boton == 1 || boton == 0) {

                if (boton == botonera.NIVEL_1.piso)
                    estado_actual = MovingUP



                else if (boton == botonera.NIVEL_0.piso)
                    estado_actual = MovingDOWN

                else{
                    println("ERROR estas intentando subir estando arriba o bajar estando abajo")

                    estado_actual = Error
                }



            }else{
                println("ERROR solo hay 2 botones el 0 (Garcia Barbon)" +
                        " y el 1 (Plaza de Compostela)")

                estado_actual = Error
            }

        }


    }
    object MovingUP : Estados(){

        fun onEnter(){
            println("Subiendo")

            Thread.sleep(3000)

            estado_actual = Idle


        }


    }
    object MovingDOWN : Estados(){

        fun onEnter(){
            println("Bajando")

            Thread.sleep(3000)

            estado_actual = Idle


        }

    }
    object Error : Estados(){

        fun onEnter(){
            println("Error, volviendo a estado Idle")

            estado_actual = Idle



        }


    }
}