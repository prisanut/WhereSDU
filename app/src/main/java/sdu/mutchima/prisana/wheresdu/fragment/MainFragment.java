package sdu.mutchima.prisana.wheresdu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import sdu.mutchima.prisana.wheresdu.GetAllUser;
import sdu.mutchima.prisana.wheresdu.MyAlert;
import sdu.mutchima.prisana.wheresdu.R;

/**
 * Created by prisana on 7/6/2017.
 */

public class MainFragment extends Fragment {

    private EditText userEditText, passwordEditText;

    public static MainFragment mainInstance()
    {
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

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

        //  Register Controller
        registerController();

        // Login Controller
        loginController();


    }   // onActivityCreated

    private void loginController() {

        // Initial View
        userEditText =  (EditText) getView().findViewById(R.id.edtUser);
        passwordEditText = (EditText) getView().findViewById(R.id.edtPassword);
        Button button =(Button) getView().findViewById(R.id.btnLogin);

        // Check Space
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUser = userEditText.getText().toString().trim();
                String strPassword = passwordEditText.getText().toString().trim();

                if (strUser.equals("") || strPassword.equals("")) {
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getResources().getString(R.string.title_have),
                            getResources().getString(R.string.please_fill));

                } else {

                    checkUserAndPass(strUser, strPassword);


                }
            }
        });

    }   // LoginController

    private void checkUserAndPass(String strUser, String strPassword) {

        String tag = "7JulyV1";


        try {

            GetAllUser getAllUser = new GetAllUser(getActivity());
            getAllUser.execute();

            String strJSON = getAllUser.get();
            Log.d(tag, "JSON ==> " + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            for (int i=0; i<jsonArray.length(); i+=1) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);


            }   // for



        } catch (Exception e) {
            e.printStackTrace();
        }

    }   // checkUser

    private void registerController() {
        TextView textView = (TextView) getView().findViewById(R.id.txtNewRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContent, RegisterFragment.registerInstance()).commit();

            }
        });
    }

}   // Main Class
