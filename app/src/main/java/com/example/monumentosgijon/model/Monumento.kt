package com.example.monumentosgijon.model


import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

/*
Copyright (c) 2023 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */

@Entity(tableName = "monumento_table")
data class Monumento (

	@PrimaryKey val titulo : String = "",
	val correo_electronico : String = "",
	val codigo_postal : String = "",
	val descripcion : String = "",
	val direccion : String = "",
	val distrito : String = "",
	val facebook : String = "",
	val googleplus : String = "",
	val instagram : String = "",
	val linkedin : String = "",
	val pinterest : String = "",
	val twitter : String = "",
	val youtube : String = "",
	val fax : String = "",
	val horario : String = "",
	val imagen : String = "",
	val kml : String = "",
	val localizacion : String = "",
	val lineas_bus : String = "",
	val materias : String = "",
	val municipio : String = "",
	val observaciones : String = "",
	val pluscode : String = "",
	val provincia : String = "",
	val telefono : String = "",
	val web : String = "",
	val idioma : String = "",
	val preguntas_frecuentes : String ="",
	val etiquetas : String = ""


){

	@Json(ignore = true)
	val idlineaInt get() = codigo_postal.toDouble().toInt()

	companion object DIFF_CALLBACK: DiffUtil.ItemCallback<Monumento>() {
		override fun areItemsTheSame(oldItem: Monumento, newItem: Monumento): Boolean {
			return oldItem.equals(newItem)
        }

		override fun areContentsTheSame(oldItem: Monumento, newItem: Monumento): Boolean {
			return oldItem == newItem
        }

	}
}
