package org.danielcastelao.dam

sealed class Estados {
    object Idle : Estados(){

        fun onEnter(boton: Int){
            println("Entrando al Idle")

            Thread.sleep(2000)

            if (boton == 1 || boton == 0) {

                if (nivel_actual == 0 && boton == 1)
                    estado_actual = MovingUP


                else if (nivel_actual == 1 && boton == 0)
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