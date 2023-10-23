package br.dev.kgb.mobile.estoquemp.ui.produto;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import br.dev.kgb.mobile.estoquemp.databinding.FragmentConProdutoFragmenyBinding;
import br.dev.kgb.mobile.estoquemp.model.Produto;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Produto}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ConProdutoRecyclerViewAdapter extends RecyclerView.Adapter<ConProdutoRecyclerViewAdapter.ViewHolder> {

    private final List<Produto> mValues;

    public ConProdutoRecyclerViewAdapter(List<Produto> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentConProdutoFragmenyBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getNomeproduto());
        holder.mIdView.setText(mValues.get(position).getCodigoProduto());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public Produto mItem;

        public ViewHolder(FragmentConProdutoFragmenyBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}