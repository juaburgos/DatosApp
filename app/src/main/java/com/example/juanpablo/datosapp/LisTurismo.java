package com.example.juanpablo.datosapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.juanpablo.datosapp.models.GuiaTuristica;

import java.util.ArrayList;

public class LisTurismo  extends RecyclerView.Adapter<LisTurismo.ViewHolder>{
    private ArrayList<GuiaTuristica> dataset;
    private Context context;

    public LisTurismo (Context context)
    {
        this.context=context;
        dataset =new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lis_turism, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       GuiaTuristica g = dataset.get(position);
        holder.establecimento.setText(g.getTipoDeEstablecimiento());
        holder.entidad.setText(g.getEntidadOCargo());
        holder.nombre.setText(g.getNombre());
        holder.direccion.setText(g.getDireccion());
        holder.correo.setText(g.getCorreo());
        holder.telefono.setText(g.getTelefonoDeContacto());
    }

    @Override
    public int getItemCount()
    {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView establecimento;
        private TextView entidad;
        private TextView  nombre;
        private TextView  direccion;
        private TextView  correo;
        private TextView  telefono;

        public ViewHolder(View itemView) {
            super(itemView);

            establecimento = (TextView) itemView.findViewById(R.id.tv_establecimiento);
            entidad=(TextView) itemView.findViewById(R.id.tv_entidad);
            nombre=(TextView) itemView.findViewById(R.id.tv_nombre);
            direccion=(TextView) itemView.findViewById(R.id.tv_direccion);
            correo=(TextView) itemView.findViewById(R.id.tv_correo);
            telefono=(TextView) itemView.findViewById(R.id.tv_telefono);

        }
    }

//

      public void agregar(ArrayList<GuiaTuristica> lista) {
          dataset.addAll(lista);
          notifyDataSetChanged();


      }
}