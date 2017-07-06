package sdu.mutchima.prisana.wheresdu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sdu.mutchima.prisana.wheresdu.R;

/**
 * Created by prisana on 7/6/2017.
 */

public class MainFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.main_fragment_layout, container, false);
        return view;
    }   // onCreateView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //  Register Controller ทำให้ตัวอักษรคลิกได้
        TextView textView = (TextView) getView().findViewById(R.id.txtNewRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContent, RegisterFragment.registerInstance()).commit();

            }
        });

    }   // onActivityCreated

}   // Main Class
