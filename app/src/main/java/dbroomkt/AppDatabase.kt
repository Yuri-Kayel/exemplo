package dbroomkt

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [EntityUsuario::class, Cadastro::class, Contato::class, Cupcake::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun accessUsuario(): AccessUsuario

    abstract fun accessCadastro(): AccessCadastro

    abstract fun accessContato(): AccessContato

    abstract fun accessCupcake(): AccessCupcake
}

object DatabaseBuilder {
    private var instance: AppDatabase? = null

    @JvmStatic
    fun getAppDatabase(context: Context) = instance ?: build(context)

    private fun build(context: Context): AppDatabase {
        val database = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, "database"
        )
        database.allowMainThreadQueries()
        val appDatabase = database.build()
        instance = appDatabase
        return appDatabase
    }

    @JvmStatic
    fun destroyInstance() {
        instance = null
    }
}
