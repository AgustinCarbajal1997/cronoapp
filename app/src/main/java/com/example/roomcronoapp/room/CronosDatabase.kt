package com.example.roomcronoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomcronoapp.model.Cronos

//abstract es una superclase que no puede ser instanciada pero sus metodos si
@Database(entities = [Cronos::class], version = 1, exportSchema = false)
abstract class CronosDatabase: RoomDatabase() {
    abstract fun cronosDao(): CronosDatabaseDao
}

// explicacion de inyeccion de dependica ----------------------------------------------
class Login {
    fun log(message: String) {
        println("Log $message")
    }
}

class ClaseConInstancia { // --> tendria que intanciar Login() cada vez que necesite
    private val login = Login()

    fun myFun() {
        login.log("Doing something...")
    }
}

class ClaseConInyeccionDeDependencias(private  val login: Login) { // --> lo instancio una vez sola en un archivo de config y lo paso donde necesito
    fun myFun(){
        login.log("Doing Something...")
    }
}