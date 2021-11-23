package ni.edu.uca.rentapp.Entidades

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.widget.ImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Blob

@Entity(tableName = "tblUsuario")
data class usuario(
    @PrimaryKey(autoGenerate = true)
    val idUsuario: Int = 0,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "apellido")
    val apellido: String,
    @ColumnInfo(name = "tipoUsuario")
    val tipoUsuario: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "cedula")
    val cedula: String,
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "telefono")
    val telefono: String,
    @ColumnInfo(name = "casaFavorita")
    val casaFav: Int,
    @ColumnInfo(name = "foto")
    val foto: String
)