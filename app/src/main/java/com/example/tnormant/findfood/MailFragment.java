package com.example.tnormant.findfood;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MailFragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText mRecipient , mSubject, mMessage;
    Button mSendEmail;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MailFragment newInstance(String param1, String param2) {
        MailFragment fragment = new MailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private View.OnClickListener buttonMailListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String recipient = mRecipient.getText().toString().trim();
            String subjet = mSubject.getText().toString().trim();
            String message = mMessage.getText().toString().trim();

            sendEmail(recipient,subjet,message);
            ((MainActivity)getActivity()).hide();
        }
    };

    private void sendEmail(String recipient, String subjet, String message) {
        Intent mEmailIntent = new Intent(Intent.ACTION_SEND);
        mEmailIntent.setData(Uri.parse("mailto"));
        mEmailIntent.setType("text/plain");
        mEmailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{recipient});
        mEmailIntent.putExtra(Intent.EXTRA_SUBJECT,subjet);
        mEmailIntent.putExtra(Intent.EXTRA_TEXT,message);
        try{
            startActivity(Intent.createChooser(mEmailIntent,"bonjour"));
        }catch (Exception e){
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_mail, container, false);
        mRecipient = rootView.findViewById(R.id.recipientEt);
        mSubject = rootView.findViewById(R.id.subjectEt);
        mMessage = rootView.findViewById(R.id.messageEt);
        mSendEmail = rootView.findViewById(R.id.SendEmail);
        mSendEmail.setOnClickListener(buttonMailListener);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }




}