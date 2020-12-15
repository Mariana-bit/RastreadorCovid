package mx.udg.rastreadorcovid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pais_item.view.*

class PaisesAdapter(paises:ArrayList<Pais>,contexto:Context): RecyclerView.Adapter<PaisesAdapter.VieHolder>(){
    var listaPaises:ArrayList<Pais>?=null
    var contexto:Context?=null

    init {
        this.listaPaises = paises
        this.contexto = contexto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VieHolder {
        val vistaPais:View = LayoutInflater.from(contexto).inflate(R.layout.pais_item,parent,false)
        val paisVieHolder = VieHolder(vistaPais)
        vistaPais.tag = paisVieHolder
        return paisVieHolder
    }

    override fun getItemCount(): Int {
        return listaPaises!!.count()
    }

    override fun onBindViewHolder(holder: VieHolder, position: Int) {
        holder.nombrePais!!.text = listaPaises!![position].nombre
        holder.numeroConfirmados!!.text = "${listaPaises!![position].confirmados}"
        holder.numeroMuertos!!.text = "${listaPaises!![position].muertos}"
        holder.numeroRecuperados!!.text = "${listaPaises!![position].recuperados}"
        Picasso.get().load("https://www.countryflags.io/${listaPaises!![position].codigoPais}/flat/64.png").into(holder.bandera)
    }


    class VieHolder(vista: View):RecyclerView.ViewHolder(vista) {
        var nombrePais: TextView? = null
        var numeroConfirmados: TextView? = null
        var numeroMuertos: TextView? = null
        var numeroRecuperados: TextView? = null
        var bandera:ImageView?=null

        init {
            nombrePais = vista.tvNombrePais
            numeroConfirmados = vista.tvConfirmados
            numeroMuertos = vista.tvMuertos
            numeroRecuperados = vista.tvRecuperados
            bandera = vista.ivBandera
        }

    }

}