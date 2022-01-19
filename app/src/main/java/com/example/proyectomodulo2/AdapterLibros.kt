package com.example.proyectomodulo2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterLibros: RecyclerView.Adapter<AdapterLibros.ViewHolder>() {
   var libros : MutableList<Libros> = ArrayList()

   lateinit var context :Context

   fun adapteranimal (list :MutableList<Libros>, context: Context){

       this.libros = list
       this.context= context
   }


    override fun onBindViewHolder(holder: AdapterLibros.ViewHolder, position: Int) {
      var libros = libros [ position]
        holder.bind(libros,context)
    }

    override fun getItemCount(): Int {
        return libros.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterLibros.ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

        return ViewHolder(
            layoutInflater.inflate (
                R.layout.elemento_lista_libros,parent , false
                    )
        )

    }




    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
         private val titulo = view.findViewById(R.id.txtTitulo) as TextView
        private val autor = view.findViewById(R.id.txtAutor) as TextView
        private val categoria = view.findViewById(R.id.txtCategoria) as TextView
        private val imagenLibro = view.findViewById(R.id.imageLibros) as ImageView

        fun bind (libros : Libros , context: Context){
             titulo.text= libros.titulo.toString()
            autor.text = libros.autor.toString()
            categoria.text= libros.categoria.toString()
            imagenLibro.setImageResource(libros.img!!)
        }

    }

}


